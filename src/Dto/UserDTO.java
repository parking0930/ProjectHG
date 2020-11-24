package Dto;

public class UserDTO {

    private String id;
    private String password;
    private String nickname;
    private int point;
    private int win;
    private int lose;
    private String date;

    public UserDTO() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
    
    public int getLose() {
        return lose;
    }

    public void setLose(int lose) {
        this.lose = lose;
    }
    
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    
    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }
}
