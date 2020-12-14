/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Info;

import java.util.ArrayList;

/**
 *
 * @author LSH
 */
public class GameRoom {
        private String roomId;
	private String roomName;
	private String roomMaker;
	private int nowIn;
	private int maxIn;
        private int ready;
	
	private ArrayList<Player> playerlist;
        private ArrayList<Integer> readylist;
	
	public GameRoom() {
		playerlist = new ArrayList<Player>();
		readylist = new ArrayList<Integer>();
                readylist.add(0);
                readylist.add(0);
                
		nowIn = 0;
		maxIn = 2;
                ready = 0;
	}

	public String getRoomId() {
		return roomId;
	}

	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	
	public String getRoomMaker() {
		return roomMaker;
	}

	public void setRoomMaker(String roomMaker) {
		this.roomMaker = roomMaker;
	}
	
	public int getNowIn() {
		return nowIn;
	}

	public void setNowIn(int nowIn) {
		this.nowIn = nowIn;
	}

	public int getMaxIn() {
		return maxIn;
	}
        
	public void setMaxIn(int maxIn) {
		this.maxIn = maxIn;
	}
        
        public int getReady(){
            return ready;
        }
        
        public void Ready(){
            this.ready++;
        }

        public void Cancle(){
            this.ready--;
        }
        
        public ArrayList<Integer> getReadylist() {
		return readylist;
	}

	public void setReadylist(ArrayList<Integer> readylist) {
		this.readylist = readylist;
	}
        
        public ArrayList<Player> getPlayerlist() {
		return playerlist;
	}

	public void setPlayerlist(ArrayList<Player> playerlist) {
		this.playerlist = playerlist;
	}
        
        public void RoomOut(Player player) {
		for(int i=0;i<playerlist.size();i++) {
			if(playerlist.get(i).getId().equals(player.getId())) { // 해당 플레이어를 찾으면
				playerlist.remove(i);
                                readylist.remove(i);
                                nowIn--;
				return;
			}
		}
		System.out.println("Error: Player is not exist - RoomOut()");
	}
}
