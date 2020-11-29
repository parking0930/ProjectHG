/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Info;


/**
 *
 * @author LSH
 */
public class Player {
        private String roomId;
	private String nickname;
        private String id;
        private int win;
        private int lose;
        private int point;
	
	public Player() {
		
	}
        
        public String getRoomId() {
		return roomId;
	}

	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}

        public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
        
	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public int getWin() {
		return win;
	}

	public void setWin(int win) {
		this.win = win;
	}

	public int getProfile() {
		return lose;
	}

	public void setLose(int lose) {
		this.lose = lose;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}
}
