/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author LSH
 */
import java.awt.Image;
import javax.swing.ImageIcon;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;

public class ClientBackground {
 
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;
    private JTable gui;
    private String msg;
    private String nickName;
    private MainFrame main;
 
    private int num;
 
    public final void setGui(JTable gui) {//, JLabel txt2
        this.gui = gui;
        //this.txt2 = txt2;
    }
 
    public final void setFrame(MainFrame main) {//, JLabel txt2
        this.main = main;
        //this.txt2 = txt2;
    }
    
    public void connet() {
        try {
            socket = new Socket("localhost", 7777);
            System.out.println("서버 연결됨.");
 
            out = new DataOutputStream(socket.getOutputStream());
            in = new DataInputStream(socket.getInputStream());
 
            // 접속하자마자 닉네임 전송하면. 서버가 이걸 닉네임으로 인식을 하고서 맵에 집어넣겠지요?
            out.writeUTF(nickName);
            System.out.println(nickName + " : 클라이언트 : 메시지 전송완료");
            
            //while (in != null) {
            //    msg = in.readUTF();
            //    gui.appendMsg(msg);
            //}
            Receiver receiver = new Receiver(socket);
            receiver.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
 
    
    public static void main(String[] args) {
        ClientBackground clientBackground = new ClientBackground();
        clientBackground.connet();
    }
 
    public void sendMessage(String msg2) {
        try {
            out.writeUTF(msg2+","+nickName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
    public void setNickname(String nickName) {
        this.nickName = nickName;
    }
    
    ImageIcon imgicon;
    Image img;
    
    public void Ready(String r1, String r2){
        main.Ready(r1, r2);
    }
    
    public void GameStart(String nick){
        // Game Start();
        System.out.println("게임시작");
        if(num == 1){

        }else if(num == 2){

        }     
    }
 
    
    class Receiver extends Thread {
        private DataInputStream in;
        private DataOutputStream out;
 
        /** XXX 2. ���ù��� ������ �ڱ� ȥ�ڼ� ��Ʈ��ũ ó�� ���..���.. ó�����ִ� ��. */
        public Receiver(Socket socket) throws IOException {
            out = new DataOutputStream(socket.getOutputStream());
            in = new DataInputStream(socket.getInputStream());
            //System.out.println(nick);
        }

        public void run() {
            try {// ��� ��⸸!!
                while (in != null) {
                    msg = in.readUTF();
                    
                    msg.trim();
                    String a[] = msg.split(",");
                    if(a[0].equals("start")){
                        GameStart(a[1]);
                    }else if(a[0].equals("num")){
                        num = Integer.parseInt(a[1]);
                    }else if(a[0].equals("Readyrefresh")){
                        Ready(a[1],a[2]);
                    }else if(a[0].equals("roominfo")){
                        main.userSet(a[1],a[2]);
                    }else if(a[0].equals("exitInGame")){
                        main.ExitInGame();
                    }else{
                        for(int i=0; i<(a.length-4)/4; i++){
                            gui.setValueAt(a[4+(i*4)], i, 0);
                            gui.setValueAt(a[5+(i*4)], i, 1);
                            gui.setValueAt(a[6+(i*4)], i, 2);
                            gui.setValueAt(a[7+(i*4)], i, 3);
                        }
                    }
                    System.out.println(msg);
                }
            } catch (IOException e) {
                
                // ������������ ���⼭ ���� �߻�. �׷������ſ�//��.. ���⼭ ������ Ŭ���̾�Ʈ ó�� ���ݴϴ�.
                   System.out.println(e);
            }
        }
    }
}
