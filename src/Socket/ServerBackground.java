package Socket;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Dao.UserDAO;
import Dto.UserDTO;
import Info.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;
 
public class ServerBackground {
 
    // ���ݱ��� ����. GUi������Ű�鼭 ����Gui�� �޽������.
    // ���� �̽�. Gui �󿡼� �ϴ� 1:1 ä���� �ϰ� �ʹ�.
    private ServerSocket serverSocket;
    private Socket socket;
    private String msg;
    private Player player;
    private GameRoom gameroom;
    private RoomManage manage = new RoomManage();
 
    /** XXX 03. ����° �߿��Ѱ�. ����ڵ��� ������ �����ϴ� ���Դϴ�. */
    private Map<String, DataOutputStream> clientsMap = new HashMap<String, DataOutputStream>();
    private Map<String, Player> playerMap = new HashMap<String, Player>();
 
 
    public void setting() throws IOException {
        Collections.synchronizedMap(clientsMap); // �̰� �������� ���ݴϴ�^^
        serverSocket = new ServerSocket(7777);
        
        gameroom = new GameRoom();
        gameroom.setMaxIn(10);
        gameroom.setRoomId("0");
        gameroom.setRoomName("looby");
        manage.AddRoom(gameroom);
        
        while (true) {
            /** XXX 01. ù��°. ������ ���� �д�. ��� ���ӹ޴°�. */
            System.out.println("���� �����...");
            socket = serverSocket.accept(); // ���� ������ ������ ��� �ݺ��ؼ� ����ڸ� �޴´�.
            System.out.println(socket.getInetAddress() + "���� �����߽��ϴ�.");
            // ���⼭ ���ο� ����� ������ Ŭ���� �����ؼ� ���������� �־���߰���?!
            Receiver receiver = new Receiver(socket);
            
            
            
            receiver.start();
        }
    }
 
    public static void main(String[] args) throws IOException {
        ServerBackground serverBackground = new ServerBackground();
        serverBackground.setting();
    }
 
    // ���ǳ���(Ŭ���̾�Ʈ) ����� ����
    public void addClient(String id, DataOutputStream out) throws IOException {
        //sendMessage(id + "���� �����ϼ̽��ϴ�.\n");
        clientsMap.put(id, out);
        System.out.println(id + " : 추가");
        
        Player player = new Player();
        UserDAO userDB = new UserDAO();
        UserDTO user = new UserDTO();
        user = userDB.getUserData(id);
        
        player.setId(user.getId());
        player.setNickname(user.getNickname());
        player.setWin(user.getWin());
        player.setLose(user.getLose());
        
        playerMap.put(id, player);
        
        System.out.println(player.getId()+player.getNickname());
        //sendMessage(nick+": 보낸다");
    }
 
    public void removeClient(String id) {
        //sendMessage(id + "���� �����̽��ϴ�.\n");
        clientsMap.remove(id);
        playerMap.remove(id);
    }
 
    // �޽��� ���� ����
    public void sendMessage(String msg) {
        Iterator<String> it = clientsMap.keySet().iterator();
        String key = "";
        System.out.println("");
        while (it.hasNext()) {
            key = it.next();
            try {
                clientsMap.get(key).writeUTF(msg);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    public void createRoom(String gameName, String id){
        System.out.println("방생성");
        gameroom = new GameRoom();
        gameroom.setRoomName(gameName);
        gameroom.setRoomId(manage.setRoomId());
        gameroom.setRoomMake(playerMap.get(id).getNickname());
        manage.AddRoom(gameroom);
        manage.AddPlayer(gameroom.getRoomId(), playerMap.get(id));
        playerMap.get(id).setRoomId(gameroom.getRoomId());
        System.out.println(gameroom.getRoomId());
        try {
            clientsMap.get(id).writeUTF("num,1");
        } catch (IOException e) {
            e.printStackTrace();
        }
        sendRoomInfo(gameroom.getRoomId());
    }
 
    public void roomjoin(String room_id, Player player){    
        player.setRoomId(room_id);
        manage.AddPlayer(room_id, player);
        for(GameRoom room : manage.getRoomlist()){
            if(room.getRoomId().equals(room_id)){
                for(Player user : room.getPlayerlist()){
                    System.out.println(user.getId());
                    try {
                        clientsMap.get(player.getId()).writeUTF("num,2");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        sendRoomInfo(room_id);
    }
    
    public void sendRoomInfo(String room_id){
        GameRoom room = manage.getRoomById(room_id);
        try {
            for(int i=0;i<room.getPlayerlist().size();i++){
                if(room.getPlayerlist().size()==1){
                        clientsMap.get(room.getPlayerlist().get(i).getId()).writeUTF("roominfo,"+room.getPlayerlist().get(0).getId()+",X");
                }else{
                        clientsMap.get(room.getPlayerlist().get(i).getId()).writeUTF("roominfo,"+room.getPlayerlist().get(0).getId()+","+room.getPlayerlist().get(1).getId());
                }
            }
            for(int i=0; i< room.getPlayerlist().size();i++){
                Player player = room.getPlayerlist().get(i);
                System.out.println(room.getPlayerlist().size());
                if(room.getPlayerlist().size()==1){
                    clientsMap.get(player.getId()).writeUTF("Readyrefresh,"+room.getReadylist().get(0)+",X");
                }else{
                    clientsMap.get(player.getId()).writeUTF("Readyrefresh,"+room.getReadylist().get(0)+","+room.getReadylist().get(1));
                }
            }
        } catch (IOException ex) {
                    Logger.getLogger(ServerBackground.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void roomExit(String id){
      Player player = playerMap.get(id);
      GameRoom room = manage.getRoomById(player.getRoomId());
      manage.playerOut(player);
      manage.deleteRoom();
    }
    
    public void ready(String id){
        GameRoom room = manage.getRoomById(playerMap.get(id).getRoomId());
        room.Ready();

        try {
            for(int i=0; i< room.getPlayerlist().size();i++){
                Player player = room.getPlayerlist().get(i);
                if(player.getId().equals(id))
                    room.getReadylist().set(i, (room.getReadylist().get(i)+1)%2);
                
            }
            for(int i=0; i< room.getPlayerlist().size();i++){
                Player player = room.getPlayerlist().get(i);
                System.out.println(room.getPlayerlist().size());
                if(room.getPlayerlist().size()==1){
                    clientsMap.get(player.getId()).writeUTF("Readyrefresh,"+room.getReadylist().get(0)+",X");
                }else{
                    clientsMap.get(player.getId()).writeUTF("Readyrefresh,"+room.getReadylist().get(0)+","+room.getReadylist().get(1));
                }
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        for(Player player : room.getPlayerlist()){
            String nickname = "";
            for(Player name : room.getPlayerlist()){
                nickname = name.getNickname();
                if(!nickname.equals(player.getNickname()))
                    break;
             }
            if(room.getReady() == 2){
                try {
                    clientsMap.get(player.getId()).writeUTF("start,"+nickname);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void refresh(String id){
        try {
            Iterator<String> it = clientsMap.keySet().iterator();
            String key = "";
            String a = "";
            for(GameRoom room : manage.getRoomlist()){
                a += room.getRoomId();
                a += ",";
                a += room.getRoomName();
                a += ",";
                a += room.getRoomMaker();
                a += ",";
                a += room.getNowIn();
                a += ",";
            }
            while (it.hasNext()) {
                key = it.next();
                clientsMap.get(key).writeUTF(a);
            }
            System.out.println(a);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
    // -----------------------------------------------------------------------------
    class Receiver extends Thread {
        private DataInputStream in;
        private DataOutputStream out;
        private String nick;
 
        /** XXX 2. ���ù��� ������ �ڱ� ȥ�ڼ� ��Ʈ��ũ ó�� ���..���.. ó�����ִ� ��. */
        public Receiver(Socket socket) throws IOException {
            out = new DataOutputStream(socket.getOutputStream());
            in = new DataInputStream(socket.getInputStream());
            nick = in.readUTF();
            //System.out.println(nick);
            addClient(nick, out);
        }
 
        public void run() {
            try {// ��� ��⸸!!
                while (in != null) {
                    msg = in.readUTF().trim();
                    String[] a = msg.split(",");
                    //System.out.println(msg);
                    if(a[0].equals("f5")){
                        refresh(a[1]);
                    }
                    if(a[0].equals("create")){
                        createRoom(a[1], a[2]);
                    }
                    if(a[0].equals("join")){
                        Player player = playerMap.get(a[2]);
                        roomjoin(a[1], player);
                    }
                    if(a[0].equals("ready")){
                        ready(a[1]);
                    }
                    if(a[0].equals("exitroom")){
                        roomExit(a[1]);
                    
                        if(a[0].equals("eixt"))
                            removeClient(a[1]);
                    }
                    if(a[0].equals("endGame")){
                        GameRoom room = manage.getRoomById(playerMap.get(a[1]).getRoomId());
                        for(Player tmp:room.getPlayerlist()){
                            clientsMap.get(tmp.getId()).writeUTF("exitInGame,");
                        }
                    }
                    //sendMessage(msg);
                    System.out.println(msg);
                }
            } catch (IOException e) {
                removeClient(nick);
            }
        }
    }
}