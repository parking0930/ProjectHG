package Client;



import Dao.UserDAO;
import Dto.UserDTO;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;

public class MainFrame extends javax.swing.JFrame {
    public static ClientBackground client;
    public static UserDTO userinfo; // 유저 정보
    public static Timer turnTimer = new Timer(); // 인게임 턴용 타이머
    public static Timer allTimer = new Timer(); // 인게임 전체 제한 시간 타이머
    public static TimerTask turnTask; // 턴용 타이머테스크
    public static TimerTask allTask; // 제한 시간용 타이머테스크
    public static int turnCount; // 턴용 타이머 카운트
    public static int allCount; // 제한 시간용 타이머 카운트
    public static String whoseTurn;
    public static ArrayList<String> mycards;
    public static ArrayList<String> yourcards;
    public static ArrayList<String> cardlist; // 놓여진 카드 목록
    public static int startState = 0;
    public static UserDTO myinfo;
    public static UserDTO yourinfo;
    public static int bellState = 0;
    public static String lastMyCard;
    public static String lastYourCard;
    ImageIcon imgicon;
    Image img;
    int xx; // 이전 x좌표 기억
    int yy; // 이전 y좌표 기억
    
    public static boolean isReady;
    
    public MainFrame() {
        initComponents();
        // 나가기 이미지
        imgicon = new ImageIcon(MainFrame.class.getResource("../image/settings.png"));
        img = imgicon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        lbllogoMain.setIcon(new ImageIcon(img));
    }

    public void Ready(String r1, String r2){
        if(r1.equals("1")){
            imgicon = new ImageIcon(MainFrame.class.getResource("../image/complete.png"));
            img = imgicon.getImage().getScaledInstance(lblState1.getWidth(), lblState1.getHeight(), Image.SCALE_SMOOTH);
            lblState1.setIcon(new ImageIcon(img));
        }else if(r1.equals("0")){
            imgicon = new ImageIcon(MainFrame.class.getResource("../image/prepare.png"));
            img = imgicon.getImage().getScaledInstance(lblState1.getWidth(), lblState1.getHeight(), Image.SCALE_SMOOTH);
            lblState1.setIcon(new ImageIcon(img));
        }
        if(r2.equals("1")){
            imgicon = new ImageIcon(MainFrame.class.getResource("../image/complete.png"));
            img = imgicon.getImage().getScaledInstance(lblState2.getWidth(), lblState2.getHeight(), Image.SCALE_SMOOTH);
            lblState2.setIcon(new ImageIcon(img));
        }else if(r2.equals("0")){
            imgicon = new ImageIcon(MainFrame.class.getResource("../image/prepare.png"));
            img = imgicon.getImage().getScaledInstance(lblState2.getWidth(), lblState2.getHeight(), Image.SCALE_SMOOTH);
            lblState2.setIcon(new ImageIcon(img));
        }
        if(r1.equals("1")&&r2.equals("1")){ // 둘 다 준비 상태면..
            InGame.setLocation(WaitRoom.getLocation().x, WaitRoom.getLocation().y);
            openGame();
            WaitRoom.hide();
        }
    }

    public void userSet(String u1, String u2){
        client.sendMessage("f5");
        // 나의 프로필 이미지
        UserDAO userDB = new UserDAO();
        UserDTO tmpData;
        if(userinfo.getId().equals(u1)){
            myinfo = userDB.getUserData(u1);
            yourinfo = userDB.getUserData(u2);
        }else{
            myinfo = userDB.getUserData(u2);
            yourinfo = userDB.getUserData(u1);
        }
        System.out.println(u1+"@"+u2);
        if(!u1.equals("X")){
            imgicon = new ImageIcon(MainFrame.class.getResource("../image/profile.png"));
            img = imgicon.getImage().getScaledInstance(lblProfile1.getWidth(), lblProfile1.getHeight(), Image.SCALE_SMOOTH);
            lblProfile1.setIcon(new ImageIcon(img));
            imgicon = new ImageIcon(MainFrame.class.getResource("../image/prepare.png"));
            img = imgicon.getImage().getScaledInstance(lblState1.getWidth(), lblState1.getHeight(), Image.SCALE_SMOOTH);
            lblState1.setIcon(new ImageIcon(img));
            tmpData = userDB.getUserData(u1);
            lblNick1.setText(tmpData.getNickname());
            lblPoint1.setText("포인트 : "+tmpData.getPoint()+"P");
            lblwl1.setText(tmpData.getWin()+"승 "+tmpData.getLose()+"패");
        }
        if(!u2.equals("X")){
            imgicon = new ImageIcon(MainFrame.class.getResource("../image/profile.png"));
            img = imgicon.getImage().getScaledInstance(lblProfile2.getWidth(), lblProfile2.getHeight(), Image.SCALE_SMOOTH);
            lblProfile2.setIcon(new ImageIcon(img));
            imgicon = new ImageIcon(MainFrame.class.getResource("../image/prepare.png"));
            img = imgicon.getImage().getScaledInstance(lblState2.getWidth(), lblState2.getHeight(), Image.SCALE_SMOOTH);
            lblState2.setIcon(new ImageIcon(img));
            tmpData = userDB.getUserData(u2);
            lblNick2.setText(tmpData.getNickname());
            lblPoint2.setText("포인트 : "+tmpData.getPoint()+"P");
            lblwl2.setText(tmpData.getWin()+"승 "+tmpData.getLose()+"패");
        }
        userDB.close();
    }
    
    public void ExitInGame(){
        WaitRoom.setLocation(InGame.getLocation().x,InGame.getLocation().y);
        showWaitRoom();
        InGame.hide();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        InGame = new javax.swing.JFrame();
        jPanel1 = new javax.swing.JPanel();
        pnlYour = new javax.swing.JPanel();
        lblYourProfile = new javax.swing.JLabel();
        lblYourNickname = new javax.swing.JLabel();
        lblMyNickname2 = new javax.swing.JLabel();
        lblYourCard = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        lblRed = new javax.swing.JLabel();
        lblRedClick = new javax.swing.JLabel();
        lblBell = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        lblBlueClick = new javax.swing.JLabel();
        lblBlue = new javax.swing.JLabel();
        pnlMy = new javax.swing.JPanel();
        lblMyProfile = new javax.swing.JLabel();
        lblMyNickname = new javax.swing.JLabel();
        lblMyNickname1 = new javax.swing.JLabel();
        lblMyCard = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        txtChat = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        lblExit = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        lblProfile = new javax.swing.JLabel();
        lblMyNickInGame = new javax.swing.JLabel();
        lblMyPage = new javax.swing.JLabel();
        lblMyWinLoseInGame = new javax.swing.JLabel();
        lblMyPointInGame = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        lblAllCount = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        lblTurnName = new javax.swing.JLabel();
        lblTurnCount = new javax.swing.JLabel();
        InGameTitle = new javax.swing.JPanel();
        btnInGameExit = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        lbllogoInGame = new javax.swing.JLabel();
        WaitRoom = new javax.swing.JFrame();
        jPanel5 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        lblState2 = new javax.swing.JLabel();
        lblProfile2 = new javax.swing.JLabel();
        lblwl2 = new javax.swing.JLabel();
        lblPoint2 = new javax.swing.JLabel();
        lblNick2 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        lblState1 = new javax.swing.JLabel();
        lblProfile1 = new javax.swing.JLabel();
        lblNick1 = new javax.swing.JLabel();
        lblPoint1 = new javax.swing.JLabel();
        lblwl1 = new javax.swing.JLabel();
        lblReady = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        lblMyProfileInWait = new javax.swing.JLabel();
        lblMyNickWait = new javax.swing.JLabel();
        lblMyPage1 = new javax.swing.JLabel();
        lblMyPointWait = new javax.swing.JLabel();
        lblMyWinLoseWait = new javax.swing.JLabel();
        WaitRoomTitle = new javax.swing.JPanel();
        btnWaitRoomExit = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lbllogoWaitRoom = new javax.swing.JLabel();
        SignUp = new javax.swing.JFrame();
        SignUpTitle = new javax.swing.JPanel();
        btnSignUpExit = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        lbllogoSignUp = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        btnNicknameCheck = new javax.swing.JButton();
        lblPWCheck = new javax.swing.JLabel();
        lblSignUpNickname = new javax.swing.JLabel();
        txtSignUpNickname = new javax.swing.JTextField();
        btnSignUp = new javax.swing.JButton();
        lblSignUpLogo = new javax.swing.JLabel();
        txtPWCheck = new javax.swing.JPasswordField();
        txtSignUpID = new javax.swing.JTextField();
        btnIDcheck = new javax.swing.JButton();
        lblSignUpID = new javax.swing.JLabel();
        lblPWResult = new javax.swing.JLabel();
        lblPW = new javax.swing.JLabel();
        txtPW = new javax.swing.JPasswordField();
        SelectRoom = new javax.swing.JFrame();
        SelectRoomTitle = new javax.swing.JPanel();
        btnSelectRoomExit = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lbllogoSelectRoom = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnCreateRoom = new javax.swing.JButton();
        jPanel17 = new javax.swing.JPanel();
        lblMyProfileSelectRoom = new javax.swing.JLabel();
        lblNickSelect = new javax.swing.JLabel();
        lblMyPage2 = new javax.swing.JLabel();
        lblPointSelect = new javax.swing.JLabel();
        lblMyWinLoseSelect = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        btnRefresh = new javax.swing.JButton();
        lblSelectRoomExit = new javax.swing.JLabel();
        btnJoin = new javax.swing.JButton();
        CreateRoom = new javax.swing.JFrame();
        CreateTitle = new javax.swing.JPanel();
        btnCreateExit = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        lbllogoCreate = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        txtCreateRoom = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        btnCreate = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        MyPage = new javax.swing.JFrame();
        MyPageTitle = new javax.swing.JPanel();
        btnMyPageExit = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        lbllogoMyPage = new javax.swing.JLabel();
        MyPageInfo = new javax.swing.JPanel();
        lblMyPageNick = new javax.swing.JLabel();
        lblMyPageLose = new javax.swing.JLabel();
        lblMyPageWin = new javax.swing.JLabel();
        lblMyPageDate = new javax.swing.JLabel();
        lblMyPagePoint = new javax.swing.JLabel();
        lblMyPageId = new javax.swing.JLabel();
        lblMyPagePWD = new javax.swing.JLabel();
        lblMyPagePWDchk = new javax.swing.JLabel();
        txtMyPageWin = new javax.swing.JTextField();
        txtMyPageNick = new javax.swing.JTextField();
        txtMyPageDate = new javax.swing.JTextField();
        txtMyPagePoint = new javax.swing.JTextField();
        txtMyPageLose = new javax.swing.JTextField();
        txtMyPageId = new javax.swing.JTextField();
        txtMyPagePWD = new javax.swing.JPasswordField();
        txtMyPagePWDchk = new javax.swing.JPasswordField();
        btnMyPageApply = new javax.swing.JButton();
        lblPWDchkResult = new javax.swing.JLabel();
        Winner = new javax.swing.JDialog();
        WinnerTitle = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        lbllogoWinner = new javax.swing.JLabel();
        jPanel20 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnWinnerOK = new javax.swing.JButton();
        Loser = new javax.swing.JDialog();
        LoserTitle = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        lbllogoLoser = new javax.swing.JLabel();
        jPanel21 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        btnLoserOK = new javax.swing.JButton();
        MainTitle = new javax.swing.JPanel();
        btnMainExit = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lbllogoMain = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtLoginID = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        btnLogin = new javax.swing.JButton();
        lblRegister = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtLoginPW = new javax.swing.JPasswordField();

        InGame.setTitle("할리갈리 - 인게임");
        InGame.setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        pnlYour.setBackground(new java.awt.Color(255, 255, 255));
        pnlYour.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        lblYourNickname.setFont(new java.awt.Font("맑은 고딕", 1, 18)); // NOI18N
        lblYourNickname.setText("닉네임");

        lblMyNickname2.setFont(new java.awt.Font("맑은 고딕", 1, 16)); // NOI18N
        lblMyNickname2.setText("남은 카드 : ");

        lblYourCard.setFont(new java.awt.Font("맑은 고딕", 0, 18)); // NOI18N
        lblYourCard.setText("0");

        javax.swing.GroupLayout pnlYourLayout = new javax.swing.GroupLayout(pnlYour);
        pnlYour.setLayout(pnlYourLayout);
        pnlYourLayout.setHorizontalGroup(
            pnlYourLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlYourLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(lblYourProfile, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnlYourLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblYourNickname)
                    .addGroup(pnlYourLayout.createSequentialGroup()
                        .addComponent(lblMyNickname2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblYourCard)))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        pnlYourLayout.setVerticalGroup(
            pnlYourLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlYourLayout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(lblYourProfile, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
            .addGroup(pnlYourLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(lblYourNickname)
                .addGap(18, 18, 18)
                .addGroup(pnlYourLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMyNickname2)
                    .addComponent(lblYourCard))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        lblRed.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        lblRedClick.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblRed, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblRedClick, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblRedClick, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblRed, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblBell.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lblBell.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblBellMouseClicked(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        lblBlueClick.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        lblBlue.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lblBlue.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblBlueMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblBlueClick, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblBlue, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblBlue, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblBlueClick, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlMy.setBackground(new java.awt.Color(255, 255, 255));
        pnlMy.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        lblMyNickname.setFont(new java.awt.Font("맑은 고딕", 1, 18)); // NOI18N
        lblMyNickname.setText("닉네임");

        lblMyNickname1.setFont(new java.awt.Font("맑은 고딕", 1, 16)); // NOI18N
        lblMyNickname1.setText("남은 카드 : ");

        lblMyCard.setFont(new java.awt.Font("맑은 고딕", 0, 18)); // NOI18N
        lblMyCard.setText("0");

        javax.swing.GroupLayout pnlMyLayout = new javax.swing.GroupLayout(pnlMy);
        pnlMy.setLayout(pnlMyLayout);
        pnlMyLayout.setHorizontalGroup(
            pnlMyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMyLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(lblMyProfile, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnlMyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblMyNickname)
                    .addGroup(pnlMyLayout.createSequentialGroup()
                        .addComponent(lblMyNickname1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblMyCard)))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        pnlMyLayout.setVerticalGroup(
            pnlMyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMyLayout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(lblMyProfile, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
            .addGroup(pnlMyLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(lblMyNickname)
                .addGap(18, 18, 18)
                .addGroup(pnlMyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblMyNickname1)
                    .addComponent(lblMyCard))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel7.setBackground(new java.awt.Color(0, 0, 0));

        jLabel1.setFont(new java.awt.Font("맑은 고딕", 1, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("# 채팅방");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("굴림", 0, 13)); // NOI18N
        jTextArea1.setRows(5);
        jTextArea1.setToolTipText("");
        jTextArea1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTextArea1.setFocusable(false);
        jTextArea1.setPreferredSize(new java.awt.Dimension(211, 84));
        jScrollPane1.setViewportView(jTextArea1);

        txtChat.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtChat.setFocusable(false);
        txtChat.setSelectionColor(new java.awt.Color(255, 255, 255));
        txtChat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtChatMouseClicked(evt);
            }
        });

        jButton1.setText("보내기");
        jButton1.setFocusPainted(false);

        lblExit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblExitMouseClicked(evt);
            }
        });

        jPanel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        lblMyNickInGame.setFont(new java.awt.Font("맑은 고딕", 1, 18)); // NOI18N
        lblMyNickInGame.setText("닉네임");

        lblMyPage.setFont(new java.awt.Font("맑은 고딕", 1, 18)); // NOI18N
        lblMyPage.setForeground(new java.awt.Color(51, 51, 255));
        lblMyPage.setText("마이페이지");
        lblMyPage.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblMyPage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblMyPageMouseClicked(evt);
            }
        });

        lblMyWinLoseInGame.setFont(new java.awt.Font("맑은 고딕", 1, 18)); // NOI18N
        lblMyWinLoseInGame.setText("0승 0패");

        lblMyPointInGame.setFont(new java.awt.Font("맑은 고딕", 1, 18)); // NOI18N
        lblMyPointInGame.setText("포인트 : 0P");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(lblProfile, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblMyNickInGame)
                    .addComponent(lblMyPage)
                    .addComponent(lblMyWinLoseInGame)
                    .addComponent(lblMyPointInGame))
                .addContainerGap(68, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(lblProfile, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(lblMyNickInGame)
                        .addGap(6, 6, 6)
                        .addComponent(lblMyPage)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblMyPointInGame)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblMyWinLoseInGame)))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        jLabel2.setFont(new java.awt.Font("맑은 고딕", 1, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("남은 시간");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        lblAllCount.setFont(new java.awt.Font("맑은 고딕", 1, 18)); // NOI18N
        lblAllCount.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAllCount.setText("-분 -초");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
            .addComponent(lblAllCount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(lblAllCount)
                .addContainerGap())
        );

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 102, 255), 2, true));

        lblTurnName.setFont(new java.awt.Font("맑은 고딕", 1, 20)); // NOI18N
        lblTurnName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTurnName.setText("?님의 턴입니다.");

        lblTurnCount.setFont(new java.awt.Font("맑은 고딕", 1, 18)); // NOI18N
        lblTurnCount.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTurnCount.setText("-초 남음");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTurnName, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
            .addComponent(lblTurnCount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTurnName)
                .addGap(18, 18, 18)
                .addComponent(lblTurnCount)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(324, 324, 324)
                        .addComponent(pnlMy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pnlYour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblBell, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(lblExit, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE))
                            .addComponent(txtChat, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(14, 14, 14))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(pnlYour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(lblBell, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(pnlMy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(25, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtChat, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblExit, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        InGameTitle.setBackground(new java.awt.Color(0, 0, 0));
        InGameTitle.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                InGameTitleMouseDragged(evt);
            }
        });
        InGameTitle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                InGameTitleMousePressed(evt);
            }
        });

        btnInGameExit.setFont(new java.awt.Font("맑은 고딕", 1, 18)); // NOI18N
        btnInGameExit.setForeground(new java.awt.Color(255, 255, 255));
        btnInGameExit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnInGameExit.setText("X");
        btnInGameExit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnInGameExit.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnInGameExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnInGameExitMouseClicked(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("맑은 고딕", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel14.setText("Project HG - InGame");
        jLabel14.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        lbllogoInGame.setFont(new java.awt.Font("맑은 고딕", 1, 18)); // NOI18N
        lbllogoInGame.setForeground(new java.awt.Color(255, 255, 255));
        lbllogoInGame.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbllogoInGame.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout InGameTitleLayout = new javax.swing.GroupLayout(InGameTitle);
        InGameTitle.setLayout(InGameTitleLayout);
        InGameTitleLayout.setHorizontalGroup(
            InGameTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, InGameTitleLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(lbllogoInGame, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnInGameExit, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        InGameTitleLayout.setVerticalGroup(
            InGameTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbllogoInGame, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(InGameTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(btnInGameExit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout InGameLayout = new javax.swing.GroupLayout(InGame.getContentPane());
        InGame.getContentPane().setLayout(InGameLayout);
        InGameLayout.setHorizontalGroup(
            InGameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(InGameTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        InGameLayout.setVerticalGroup(
            InGameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, InGameLayout.createSequentialGroup()
                .addComponent(InGameTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        WaitRoom.setTitle("할리갈리 - 대기방");
        WaitRoom.setUndecorated(true);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        lblwl2.setFont(new java.awt.Font("맑은 고딕", 1, 18)); // NOI18N
        lblwl2.setText("　");
        lblwl2.setToolTipText("");

        lblPoint2.setFont(new java.awt.Font("맑은 고딕", 1, 18)); // NOI18N
        lblPoint2.setText("　");

        lblNick2.setFont(new java.awt.Font("맑은 고딕", 1, 18)); // NOI18N
        lblNick2.setText("　");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblState2, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(lblProfile2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNick2)
                    .addComponent(lblwl2)
                    .addComponent(lblPoint2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblProfile2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(lblNick2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblPoint2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblwl2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblState2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
        );

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        lblNick1.setFont(new java.awt.Font("맑은 고딕", 1, 18)); // NOI18N
        lblNick1.setText("닉네임");

        lblPoint1.setFont(new java.awt.Font("맑은 고딕", 1, 18)); // NOI18N
        lblPoint1.setText("포인트 : 0P");

        lblwl1.setFont(new java.awt.Font("맑은 고딕", 1, 18)); // NOI18N
        lblwl1.setText("0승 0패");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblState1, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(lblProfile1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNick1)
                    .addComponent(lblwl1)
                    .addComponent(lblPoint1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblProfile1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(lblNick1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblPoint1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblwl1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblState1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
        );

        lblReady.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblReady.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblReadyMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblReadyMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblReadyMouseExited(evt);
            }
        });

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));
        jPanel13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));

        jLabel3.setFont(new java.awt.Font("맑은 고딕", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("# 내 정보");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel3)
                .addContainerGap(213, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblMyNickWait.setFont(new java.awt.Font("맑은 고딕", 1, 18)); // NOI18N
        lblMyNickWait.setText("닉네임");

        lblMyPage1.setFont(new java.awt.Font("맑은 고딕", 1, 18)); // NOI18N
        lblMyPage1.setForeground(new java.awt.Color(51, 51, 255));
        lblMyPage1.setText("마이페이지");
        lblMyPage1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblMyPage1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblMyPage1MouseClicked(evt);
            }
        });

        lblMyPointWait.setFont(new java.awt.Font("맑은 고딕", 1, 18)); // NOI18N
        lblMyPointWait.setText("포인트 : 0P");

        lblMyWinLoseWait.setFont(new java.awt.Font("맑은 고딕", 1, 18)); // NOI18N
        lblMyWinLoseWait.setText("0승 0패");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lblMyProfileInWait, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblMyNickWait)
                    .addComponent(lblMyPage1)
                    .addComponent(lblMyWinLoseWait)
                    .addComponent(lblMyPointWait))
                .addGap(46, 46, 46))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblMyProfileInWait, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(lblMyNickWait)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblMyPage1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblMyPointWait)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblMyWinLoseWait)))
                .addGap(0, 14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblReady, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblReady, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(23, 23, 23))
        );

        WaitRoomTitle.setBackground(new java.awt.Color(0, 0, 0));
        WaitRoomTitle.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                WaitRoomTitleMouseDragged(evt);
            }
        });
        WaitRoomTitle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                WaitRoomTitleMousePressed(evt);
            }
        });

        btnWaitRoomExit.setFont(new java.awt.Font("맑은 고딕", 1, 18)); // NOI18N
        btnWaitRoomExit.setForeground(new java.awt.Color(255, 255, 255));
        btnWaitRoomExit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnWaitRoomExit.setText("X");
        btnWaitRoomExit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnWaitRoomExit.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnWaitRoomExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnWaitRoomExitMouseClicked(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("맑은 고딕", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel10.setText("Project HG - WaitRoom");
        jLabel10.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        lbllogoWaitRoom.setFont(new java.awt.Font("맑은 고딕", 1, 18)); // NOI18N
        lbllogoWaitRoom.setForeground(new java.awt.Color(255, 255, 255));
        lbllogoWaitRoom.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbllogoWaitRoom.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout WaitRoomTitleLayout = new javax.swing.GroupLayout(WaitRoomTitle);
        WaitRoomTitle.setLayout(WaitRoomTitleLayout);
        WaitRoomTitleLayout.setHorizontalGroup(
            WaitRoomTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, WaitRoomTitleLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(lbllogoWaitRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnWaitRoomExit, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        WaitRoomTitleLayout.setVerticalGroup(
            WaitRoomTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbllogoWaitRoom, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(WaitRoomTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(btnWaitRoomExit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout WaitRoomLayout = new javax.swing.GroupLayout(WaitRoom.getContentPane());
        WaitRoom.getContentPane().setLayout(WaitRoomLayout);
        WaitRoomLayout.setHorizontalGroup(
            WaitRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(WaitRoomTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        WaitRoomLayout.setVerticalGroup(
            WaitRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, WaitRoomLayout.createSequentialGroup()
                .addComponent(WaitRoomTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        SignUp.setUndecorated(true);

        SignUpTitle.setBackground(new java.awt.Color(0, 0, 0));
        SignUpTitle.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                SignUpTitleMouseDragged(evt);
            }
        });
        SignUpTitle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                SignUpTitleMousePressed(evt);
            }
        });

        btnSignUpExit.setFont(new java.awt.Font("맑은 고딕", 1, 18)); // NOI18N
        btnSignUpExit.setForeground(new java.awt.Color(255, 255, 255));
        btnSignUpExit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnSignUpExit.setText("X");
        btnSignUpExit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSignUpExit.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSignUpExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSignUpExitMouseClicked(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("맑은 고딕", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Project HG");
        jLabel12.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        lbllogoSignUp.setFont(new java.awt.Font("맑은 고딕", 1, 18)); // NOI18N
        lbllogoSignUp.setForeground(new java.awt.Color(255, 255, 255));
        lbllogoSignUp.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbllogoSignUp.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout SignUpTitleLayout = new javax.swing.GroupLayout(SignUpTitle);
        SignUpTitle.setLayout(SignUpTitleLayout);
        SignUpTitleLayout.setHorizontalGroup(
            SignUpTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SignUpTitleLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(lbllogoSignUp, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSignUpExit, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        SignUpTitleLayout.setVerticalGroup(
            SignUpTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbllogoSignUp, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(SignUpTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(btnSignUpExit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel16.setBackground(new java.awt.Color(255, 255, 255));
        jPanel16.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnNicknameCheck.setFont(new java.awt.Font("맑은 고딕", 0, 18)); // NOI18N
        btnNicknameCheck.setText("중복확인");
        btnNicknameCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNicknameCheckActionPerformed(evt);
            }
        });

        lblPWCheck.setFont(new java.awt.Font("맑은 고딕", 1, 18)); // NOI18N
        lblPWCheck.setText("비밀번호 재확인");

        lblSignUpNickname.setFont(new java.awt.Font("맑은 고딕", 1, 18)); // NOI18N
        lblSignUpNickname.setText("닉네임");

        txtSignUpNickname.setFont(new java.awt.Font("맑은 고딕", 0, 15)); // NOI18N

        btnSignUp.setFont(new java.awt.Font("맑은 고딕", 0, 18)); // NOI18N
        btnSignUp.setText("회원가입");
        btnSignUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSignUpActionPerformed(evt);
            }
        });

        lblSignUpLogo.setFont(new java.awt.Font("맑은 고딕", 1, 36)); // NOI18N
        lblSignUpLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSignUpLogo.setText("회원가입");

        txtPWCheck.setFont(new java.awt.Font("맑은 고딕", 0, 15)); // NOI18N
        txtPWCheck.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPWCheckKeyReleased(evt);
            }
        });

        txtSignUpID.setFont(new java.awt.Font("맑은 고딕", 0, 15)); // NOI18N

        btnIDcheck.setFont(new java.awt.Font("맑은 고딕", 0, 18)); // NOI18N
        btnIDcheck.setText("중복확인");
        btnIDcheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIDcheckActionPerformed(evt);
            }
        });

        lblSignUpID.setFont(new java.awt.Font("맑은 고딕", 1, 18)); // NOI18N
        lblSignUpID.setText("아이디");

        lblPWResult.setFont(new java.awt.Font("맑은 고딕", 0, 18)); // NOI18N
        lblPWResult.setForeground(new java.awt.Color(255, 0, 0));

        lblPW.setFont(new java.awt.Font("맑은 고딕", 1, 18)); // NOI18N
        lblPW.setText("비밀번호");

        txtPW.setFont(new java.awt.Font("맑은 고딕", 0, 15)); // NOI18N

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(119, 119, 119)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addComponent(lblSignUpNickname)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnNicknameCheck, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtSignUpNickname)
                    .addComponent(txtPWCheck)
                    .addComponent(lblPW)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addComponent(lblSignUpID)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnIDcheck, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtSignUpID)
                    .addComponent(lblPWCheck)
                    .addComponent(btnSignUp, javax.swing.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)
                    .addComponent(lblPWResult, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtPW))
                .addContainerGap(119, Short.MAX_VALUE))
            .addComponent(lblSignUpLogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(lblSignUpLogo)
                .addGap(22, 22, 22)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSignUpID)
                    .addComponent(btnIDcheck, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSignUpID, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblPW)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtPW, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(lblPWCheck)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPWCheck, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(lblPWResult, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSignUpNickname)
                    .addComponent(btnNicknameCheck, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addComponent(txtSignUpNickname, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSignUp, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(47, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout SignUpLayout = new javax.swing.GroupLayout(SignUp.getContentPane());
        SignUp.getContentPane().setLayout(SignUpLayout);
        SignUpLayout.setHorizontalGroup(
            SignUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(SignUpTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        SignUpLayout.setVerticalGroup(
            SignUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SignUpLayout.createSequentialGroup()
                .addComponent(SignUpTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        SelectRoom.setUndecorated(true);

        SelectRoomTitle.setBackground(new java.awt.Color(0, 0, 0));
        SelectRoomTitle.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                SelectRoomTitleMouseDragged(evt);
            }
        });
        SelectRoomTitle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                SelectRoomTitleMousePressed(evt);
            }
        });

        btnSelectRoomExit.setFont(new java.awt.Font("맑은 고딕", 1, 18)); // NOI18N
        btnSelectRoomExit.setForeground(new java.awt.Color(255, 255, 255));
        btnSelectRoomExit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnSelectRoomExit.setText("X");
        btnSelectRoomExit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSelectRoomExit.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSelectRoomExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSelectRoomExitMouseClicked(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("맑은 고딕", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel13.setText("Project HG - Lobby");
        jLabel13.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        lbllogoSelectRoom.setFont(new java.awt.Font("맑은 고딕", 1, 18)); // NOI18N
        lbllogoSelectRoom.setForeground(new java.awt.Color(255, 255, 255));
        lbllogoSelectRoom.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbllogoSelectRoom.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout SelectRoomTitleLayout = new javax.swing.GroupLayout(SelectRoomTitle);
        SelectRoomTitle.setLayout(SelectRoomTitleLayout);
        SelectRoomTitleLayout.setHorizontalGroup(
            SelectRoomTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SelectRoomTitleLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(lbllogoSelectRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSelectRoomExit, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        SelectRoomTitleLayout.setVerticalGroup(
            SelectRoomTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbllogoSelectRoom, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(SelectRoomTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(btnSelectRoomExit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));
        jPanel14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTable1.setFont(new java.awt.Font("맑은 고딕", 0, 18)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "번호", "제목", "방장", "인원"
            }
        ));
        jTable1.setRowHeight(40);
        jScrollPane2.setViewportView(jTable1);

        btnCreateRoom.setBackground(new java.awt.Color(0, 0, 0));
        btnCreateRoom.setFont(new java.awt.Font("맑은 고딕", 1, 25)); // NOI18N
        btnCreateRoom.setForeground(new java.awt.Color(255, 255, 255));
        btnCreateRoom.setText("방 만들기");
        btnCreateRoom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateRoomActionPerformed(evt);
            }
        });

        jPanel17.setBackground(new java.awt.Color(255, 255, 255));
        jPanel17.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblNickSelect.setFont(new java.awt.Font("맑은 고딕", 1, 18)); // NOI18N
        lblNickSelect.setText("닉네임");

        lblMyPage2.setFont(new java.awt.Font("맑은 고딕", 1, 18)); // NOI18N
        lblMyPage2.setForeground(new java.awt.Color(51, 51, 255));
        lblMyPage2.setText("마이페이지");
        lblMyPage2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblMyPage2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblMyPage2MouseClicked(evt);
            }
        });

        lblPointSelect.setFont(new java.awt.Font("맑은 고딕", 1, 18)); // NOI18N
        lblPointSelect.setText("포인트 : 0P");

        lblMyWinLoseSelect.setFont(new java.awt.Font("맑은 고딕", 1, 18)); // NOI18N
        lblMyWinLoseSelect.setText("0승 0패");

        jPanel18.setBackground(new java.awt.Color(0, 0, 0));

        jLabel15.setFont(new java.awt.Font("맑은 고딕", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("# 내 정보");

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel15)
                .addContainerGap(215, Short.MAX_VALUE))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel15)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lblMyProfileSelectRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNickSelect)
                    .addComponent(lblMyPage2)
                    .addComponent(lblMyWinLoseSelect)
                    .addComponent(lblPointSelect))
                .addGap(46, 46, 46))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblMyProfileSelectRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addComponent(lblNickSelect)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblMyPage2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblPointSelect)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblMyWinLoseSelect)))
                .addGap(0, 14, Short.MAX_VALUE))
        );

        btnRefresh.setBackground(new java.awt.Color(0, 0, 0));
        btnRefresh.setFont(new java.awt.Font("맑은 고딕", 1, 25)); // NOI18N
        btnRefresh.setForeground(new java.awt.Color(255, 255, 255));
        btnRefresh.setText("새로고침");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        lblSelectRoomExit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblSelectRoomExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblSelectRoomExitMouseClicked(evt);
            }
        });

        btnJoin.setBackground(new java.awt.Color(0, 0, 0));
        btnJoin.setFont(new java.awt.Font("맑은 고딕", 1, 25)); // NOI18N
        btnJoin.setForeground(new java.awt.Color(255, 255, 255));
        btnJoin.setText("참여");
        btnJoin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnJoinActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 589, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnCreateRoom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                                .addComponent(btnJoin, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(lblSelectRoomExit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(14, 14, 14))))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCreateRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnJoin, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(lblSelectRoomExit, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout SelectRoomLayout = new javax.swing.GroupLayout(SelectRoom.getContentPane());
        SelectRoom.getContentPane().setLayout(SelectRoomLayout);
        SelectRoomLayout.setHorizontalGroup(
            SelectRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(SelectRoomTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        SelectRoomLayout.setVerticalGroup(
            SelectRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SelectRoomLayout.createSequentialGroup()
                .addComponent(SelectRoomTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        CreateRoom.setUndecorated(true);

        CreateTitle.setBackground(new java.awt.Color(0, 0, 0));
        CreateTitle.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                CreateTitleMouseDragged(evt);
            }
        });
        CreateTitle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                CreateTitleMousePressed(evt);
            }
        });

        btnCreateExit.setFont(new java.awt.Font("맑은 고딕", 1, 18)); // NOI18N
        btnCreateExit.setForeground(new java.awt.Color(255, 255, 255));
        btnCreateExit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnCreateExit.setText("X");
        btnCreateExit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCreateExit.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCreateExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCreateExitMouseClicked(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("맑은 고딕", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel17.setText("Create Room");
        jLabel17.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        lbllogoCreate.setFont(new java.awt.Font("맑은 고딕", 1, 18)); // NOI18N
        lbllogoCreate.setForeground(new java.awt.Color(255, 255, 255));
        lbllogoCreate.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbllogoCreate.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout CreateTitleLayout = new javax.swing.GroupLayout(CreateTitle);
        CreateTitle.setLayout(CreateTitleLayout);
        CreateTitleLayout.setHorizontalGroup(
            CreateTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CreateTitleLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(lbllogoCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCreateExit, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        CreateTitleLayout.setVerticalGroup(
            CreateTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbllogoCreate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(CreateTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(btnCreateExit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel19.setBackground(new java.awt.Color(255, 255, 255));
        jPanel19.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel16.setFont(new java.awt.Font("맑은 고딕", 1, 18)); // NOI18N
        jLabel16.setText("Room : ");

        btnCreate.setBackground(new java.awt.Color(0, 0, 0));
        btnCreate.setFont(new java.awt.Font("맑은 고딕", 1, 25)); // NOI18N
        btnCreate.setForeground(new java.awt.Color(255, 255, 255));
        btnCreate.setText("생성");
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });

        btnBack.setBackground(new java.awt.Color(0, 0, 0));
        btnBack.setFont(new java.awt.Font("맑은 고딕", 1, 25)); // NOI18N
        btnBack.setForeground(new java.awt.Color(255, 255, 255));
        btnBack.setText("취소");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addComponent(btnCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6))
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCreateRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(40, 40, 40))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCreateRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40))
        );

        javax.swing.GroupLayout CreateRoomLayout = new javax.swing.GroupLayout(CreateRoom.getContentPane());
        CreateRoom.getContentPane().setLayout(CreateRoomLayout);
        CreateRoomLayout.setHorizontalGroup(
            CreateRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(CreateTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        CreateRoomLayout.setVerticalGroup(
            CreateRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CreateRoomLayout.createSequentialGroup()
                .addComponent(CreateTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        MyPage.setUndecorated(true);

        MyPageTitle.setBackground(new java.awt.Color(0, 0, 0));
        MyPageTitle.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                MyPageTitleMouseDragged(evt);
            }
        });
        MyPageTitle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                MyPageTitleMousePressed(evt);
            }
        });

        btnMyPageExit.setFont(new java.awt.Font("맑은 고딕", 1, 18)); // NOI18N
        btnMyPageExit.setForeground(new java.awt.Color(255, 255, 255));
        btnMyPageExit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnMyPageExit.setText("X");
        btnMyPageExit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMyPageExit.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMyPageExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMyPageExitMouseClicked(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("맑은 고딕", 1, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel18.setText("Project HG - My Page");
        jLabel18.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        lbllogoMyPage.setFont(new java.awt.Font("맑은 고딕", 1, 18)); // NOI18N
        lbllogoMyPage.setForeground(new java.awt.Color(255, 255, 255));
        lbllogoMyPage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbllogoMyPage.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout MyPageTitleLayout = new javax.swing.GroupLayout(MyPageTitle);
        MyPageTitle.setLayout(MyPageTitleLayout);
        MyPageTitleLayout.setHorizontalGroup(
            MyPageTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MyPageTitleLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(lbllogoMyPage, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnMyPageExit, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        MyPageTitleLayout.setVerticalGroup(
            MyPageTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbllogoMyPage, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(MyPageTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(btnMyPageExit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        MyPageInfo.setBackground(new java.awt.Color(255, 255, 255));
        MyPageInfo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        lblMyPageNick.setFont(new java.awt.Font("맑은 고딕", 1, 18)); // NOI18N
        lblMyPageNick.setText("닉네임");

        lblMyPageLose.setFont(new java.awt.Font("맑은 고딕", 1, 18)); // NOI18N
        lblMyPageLose.setText("패배수");

        lblMyPageWin.setFont(new java.awt.Font("맑은 고딕", 1, 18)); // NOI18N
        lblMyPageWin.setText("승리수");

        lblMyPageDate.setFont(new java.awt.Font("맑은 고딕", 1, 18)); // NOI18N
        lblMyPageDate.setText("가입일");

        lblMyPagePoint.setFont(new java.awt.Font("맑은 고딕", 1, 18)); // NOI18N
        lblMyPagePoint.setText("포인트");

        lblMyPageId.setFont(new java.awt.Font("맑은 고딕", 1, 18)); // NOI18N
        lblMyPageId.setText("아이디");

        lblMyPagePWD.setFont(new java.awt.Font("맑은 고딕", 1, 18)); // NOI18N
        lblMyPagePWD.setText("비밀번호체크");

        lblMyPagePWDchk.setFont(new java.awt.Font("맑은 고딕", 1, 18)); // NOI18N
        lblMyPagePWDchk.setText("비밀번호");

        txtMyPageWin.setEditable(false);
        txtMyPageWin.setFont(new java.awt.Font("맑은 고딕", 0, 15)); // NOI18N
        txtMyPageWin.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtMyPageWin.setEnabled(false);

        txtMyPageNick.setEditable(false);
        txtMyPageNick.setFont(new java.awt.Font("맑은 고딕", 0, 15)); // NOI18N
        txtMyPageNick.setEnabled(false);

        txtMyPageDate.setEditable(false);
        txtMyPageDate.setFont(new java.awt.Font("맑은 고딕", 0, 15)); // NOI18N
        txtMyPageDate.setEnabled(false);

        txtMyPagePoint.setEditable(false);
        txtMyPagePoint.setFont(new java.awt.Font("맑은 고딕", 0, 15)); // NOI18N
        txtMyPagePoint.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtMyPagePoint.setEnabled(false);

        txtMyPageLose.setEditable(false);
        txtMyPageLose.setFont(new java.awt.Font("맑은 고딕", 0, 15)); // NOI18N
        txtMyPageLose.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtMyPageLose.setEnabled(false);

        txtMyPageId.setEditable(false);
        txtMyPageId.setFont(new java.awt.Font("맑은 고딕", 0, 15)); // NOI18N
        txtMyPageId.setEnabled(false);

        txtMyPagePWD.setFont(new java.awt.Font("맑은 고딕", 0, 15)); // NOI18N

        txtMyPagePWDchk.setFont(new java.awt.Font("맑은 고딕", 0, 15)); // NOI18N
        txtMyPagePWDchk.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtMyPagePWDchkKeyReleased(evt);
            }
        });

        btnMyPageApply.setText("적용하기");
        btnMyPageApply.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMyPageApplyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout MyPageInfoLayout = new javax.swing.GroupLayout(MyPageInfo);
        MyPageInfo.setLayout(MyPageInfoLayout);
        MyPageInfoLayout.setHorizontalGroup(
            MyPageInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MyPageInfoLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(MyPageInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnMyPageApply, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(MyPageInfoLayout.createSequentialGroup()
                        .addGroup(MyPageInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtMyPageWin)
                            .addComponent(lblMyPageWin))
                        .addGap(60, 60, 60)
                        .addGroup(MyPageInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(MyPageInfoLayout.createSequentialGroup()
                                .addComponent(lblMyPageLose)
                                .addGap(60, 60, 60)
                                .addComponent(lblMyPagePoint))
                            .addGroup(MyPageInfoLayout.createSequentialGroup()
                                .addComponent(txtMyPageLose, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtMyPagePoint, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(lblMyPageId)
                    .addComponent(lblMyPageNick)
                    .addComponent(lblMyPageDate)
                    .addComponent(lblMyPagePWDchk)
                    .addComponent(lblMyPagePWD)
                    .addComponent(txtMyPageDate)
                    .addComponent(txtMyPageNick)
                    .addComponent(txtMyPageId)
                    .addComponent(txtMyPagePWD)
                    .addComponent(txtMyPagePWDchk)
                    .addComponent(lblPWDchkResult, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        MyPageInfoLayout.setVerticalGroup(
            MyPageInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MyPageInfoLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lblMyPageId)
                .addGap(10, 10, 10)
                .addComponent(txtMyPageId, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(lblMyPagePWDchk)
                .addGap(10, 10, 10)
                .addComponent(txtMyPagePWD, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(lblMyPagePWD)
                .addGap(10, 10, 10)
                .addComponent(txtMyPagePWDchk, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(lblPWDchkResult, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(lblMyPageNick)
                .addGap(10, 10, 10)
                .addComponent(txtMyPageNick, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(lblMyPageDate)
                .addGap(10, 10, 10)
                .addComponent(txtMyPageDate, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(MyPageInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMyPageWin)
                    .addComponent(lblMyPageLose)
                    .addComponent(lblMyPagePoint))
                .addGap(10, 10, 10)
                .addGroup(MyPageInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMyPageWin, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMyPagePoint, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMyPageLose, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(btnMyPageApply, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout MyPageLayout = new javax.swing.GroupLayout(MyPage.getContentPane());
        MyPage.getContentPane().setLayout(MyPageLayout);
        MyPageLayout.setHorizontalGroup(
            MyPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MyPageTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(MyPageInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        MyPageLayout.setVerticalGroup(
            MyPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MyPageLayout.createSequentialGroup()
                .addComponent(MyPageTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(MyPageInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Winner.setModal(true);
        Winner.setUndecorated(true);

        WinnerTitle.setBackground(new java.awt.Color(0, 0, 0));
        WinnerTitle.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                WinnerTitleMouseDragged(evt);
            }
        });
        WinnerTitle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                WinnerTitleMousePressed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("맑은 고딕", 1, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel19.setText("Project HG");
        jLabel19.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        lbllogoWinner.setFont(new java.awt.Font("맑은 고딕", 1, 18)); // NOI18N
        lbllogoWinner.setForeground(new java.awt.Color(255, 255, 255));
        lbllogoWinner.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbllogoWinner.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout WinnerTitleLayout = new javax.swing.GroupLayout(WinnerTitle);
        WinnerTitle.setLayout(WinnerTitleLayout);
        WinnerTitleLayout.setHorizontalGroup(
            WinnerTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, WinnerTitleLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(lbllogoWinner, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        WinnerTitleLayout.setVerticalGroup(
            WinnerTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbllogoWinner, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel20.setBackground(new java.awt.Color(255, 255, 255));
        jPanel20.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel6.setFont(new java.awt.Font("맑은 고딕", 1, 48)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("You Win!");

        jLabel7.setFont(new java.awt.Font("맑은 고딕", 1, 18)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("게임에서 승리하여 100포인트가 지급되었습니다.");

        btnWinnerOK.setFont(new java.awt.Font("맑은 고딕", 1, 24)); // NOI18N
        btnWinnerOK.setText("확인");
        btnWinnerOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnWinnerOKActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel20Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(btnWinnerOK, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48))
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(btnWinnerOK, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addContainerGap())
        );

        javax.swing.GroupLayout WinnerLayout = new javax.swing.GroupLayout(Winner.getContentPane());
        Winner.getContentPane().setLayout(WinnerLayout);
        WinnerLayout.setHorizontalGroup(
            WinnerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(WinnerTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        WinnerLayout.setVerticalGroup(
            WinnerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(WinnerLayout.createSequentialGroup()
                .addComponent(WinnerTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Loser.setModal(true);
        Loser.setUndecorated(true);

        LoserTitle.setBackground(new java.awt.Color(0, 0, 0));
        LoserTitle.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                LoserTitleMouseDragged(evt);
            }
        });
        LoserTitle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                LoserTitleMousePressed(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("맑은 고딕", 1, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel20.setText("Project HG");
        jLabel20.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        lbllogoLoser.setFont(new java.awt.Font("맑은 고딕", 1, 18)); // NOI18N
        lbllogoLoser.setForeground(new java.awt.Color(255, 255, 255));
        lbllogoLoser.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbllogoLoser.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout LoserTitleLayout = new javax.swing.GroupLayout(LoserTitle);
        LoserTitle.setLayout(LoserTitleLayout);
        LoserTitleLayout.setHorizontalGroup(
            LoserTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LoserTitleLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(lbllogoLoser, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        LoserTitleLayout.setVerticalGroup(
            LoserTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbllogoLoser, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel21.setBackground(new java.awt.Color(255, 255, 255));
        jPanel21.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel21.setFont(new java.awt.Font("맑은 고딕", 1, 48)); // NOI18N
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("You Lose...");

        jLabel22.setFont(new java.awt.Font("맑은 고딕", 1, 18)); // NOI18N
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("게임에서 패배하여 50포인트가 지급되었습니다.");

        btnLoserOK.setFont(new java.awt.Font("맑은 고딕", 1, 24)); // NOI18N
        btnLoserOK.setText("확인");
        btnLoserOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoserOKActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel21Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(btnLoserOK, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel21)
                .addGap(18, 18, 18)
                .addComponent(btnLoserOK, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel22)
                .addContainerGap())
        );

        javax.swing.GroupLayout LoserLayout = new javax.swing.GroupLayout(Loser.getContentPane());
        Loser.getContentPane().setLayout(LoserLayout);
        LoserLayout.setHorizontalGroup(
            LoserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(LoserTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        LoserLayout.setVerticalGroup(
            LoserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LoserLayout.createSequentialGroup()
                .addComponent(LoserTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("할리갈리");
        setUndecorated(true);
        setResizable(false);

        MainTitle.setBackground(new java.awt.Color(0, 0, 0));
        MainTitle.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                MainTitleMouseDragged(evt);
            }
        });
        MainTitle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                MainTitleMousePressed(evt);
            }
        });

        btnMainExit.setFont(new java.awt.Font("맑은 고딕", 1, 18)); // NOI18N
        btnMainExit.setForeground(new java.awt.Color(255, 255, 255));
        btnMainExit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnMainExit.setText("X");
        btnMainExit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMainExit.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMainExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMainExitMouseClicked(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("맑은 고딕", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel9.setText("Project HG - Login");
        jLabel9.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        lbllogoMain.setFont(new java.awt.Font("맑은 고딕", 1, 18)); // NOI18N
        lbllogoMain.setForeground(new java.awt.Color(255, 255, 255));
        lbllogoMain.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbllogoMain.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout MainTitleLayout = new javax.swing.GroupLayout(MainTitle);
        MainTitle.setLayout(MainTitleLayout);
        MainTitleLayout.setHorizontalGroup(
            MainTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MainTitleLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(lbllogoMain, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnMainExit, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        MainTitleLayout.setVerticalGroup(
            MainTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbllogoMain, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(MainTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(btnMainExit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel15.setBackground(new java.awt.Color(255, 255, 255));
        jPanel15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel4.setFont(new java.awt.Font("맑은 고딕", 1, 36)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Welcome");

        jLabel5.setFont(new java.awt.Font("맑은 고딕", 1, 18)); // NOI18N
        jLabel5.setText("ID : ");

        jLabel8.setFont(new java.awt.Font("맑은 고딕", 1, 18)); // NOI18N
        jLabel8.setText("PW : ");

        btnLogin.setFont(new java.awt.Font("맑은 고딕", 1, 18)); // NOI18N
        btnLogin.setText("로그인");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        lblRegister.setFont(new java.awt.Font("맑은 고딕", 1, 18)); // NOI18N
        lblRegister.setText("회원가입");
        lblRegister.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblRegister.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblRegisterMouseClicked(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("맑은 고딕", 1, 18)); // NOI18N
        jLabel11.setText("아이디/비밀번호 찾기");
        jLabel11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        txtLoginPW.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLoginPWActionPerformed(evt);
            }
        });
        txtLoginPW.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtLoginPWKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                        .addComponent(lblRegister)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel11)
                        .addGap(58, 58, 58))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtLoginPW, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(12, 12, 12)
                                .addComponent(txtLoginID, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnLogin, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(40, 40, 40))))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtLoginID, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtLoginPW, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRegister)
                    .addComponent(jLabel11))
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MainTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(MainTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblExitMouseClicked
        InGame.hide();
    }//GEN-LAST:event_lblExitMouseClicked

    private void txtChatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtChatMouseClicked
        txtChat.setFocusable(true);
    }//GEN-LAST:event_txtChatMouseClicked

    private void lblReadyMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblReadyMouseEntered
        // 시작 버튼
        ImageIcon imgicon;
        Image img;
        imgicon = new ImageIcon(MainFrame.class.getResource("../image/btn2.png"));
        img = imgicon.getImage().getScaledInstance(lblReady.getWidth(), lblReady.getHeight(), Image.SCALE_SMOOTH);
        lblReady.setIcon(new ImageIcon(img));
    }//GEN-LAST:event_lblReadyMouseEntered

    private void lblReadyMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblReadyMouseExited
        // 시작 버튼
        ImageIcon imgicon;
        Image img;
        imgicon = new ImageIcon(MainFrame.class.getResource("../image/btn.png"));
        img = imgicon.getImage().getScaledInstance(lblReady.getWidth(), lblReady.getHeight(), Image.SCALE_SMOOTH);
        lblReady.setIcon(new ImageIcon(img));
    }//GEN-LAST:event_lblReadyMouseExited

    private void MainTitleMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MainTitleMouseDragged
        MainFrame.this.setLocation(evt.getXOnScreen()-xx , evt.getYOnScreen()-yy);
    }//GEN-LAST:event_MainTitleMouseDragged

    private void MainTitleMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MainTitleMousePressed
        xx = evt.getX();
        yy= evt.getY();
    }//GEN-LAST:event_MainTitleMousePressed

    private void btnMainExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMainExitMouseClicked
        System.exit(0);
    }//GEN-LAST:event_btnMainExitMouseClicked

    private void btnSignUpExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSignUpExitMouseClicked
        SignUp.hide();
    }//GEN-LAST:event_btnSignUpExitMouseClicked

    private void SignUpTitleMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SignUpTitleMouseDragged
        SignUp.setLocation(evt.getXOnScreen()-xx , evt.getYOnScreen()-yy);
    }//GEN-LAST:event_SignUpTitleMouseDragged

    private void SignUpTitleMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SignUpTitleMousePressed
        xx = evt.getX();
        yy= evt.getY();
    }//GEN-LAST:event_SignUpTitleMousePressed

    private void lblRegisterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRegisterMouseClicked
        showSignUp();
    }//GEN-LAST:event_lblRegisterMouseClicked

    private void btnWaitRoomExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnWaitRoomExitMouseClicked
        SelectRoom.setLocation(WaitRoom.getLocation().x, WaitRoom.getLocation().y);
        WaitRoom.hide();
        showSelectRoom();
        client.sendMessage("exitroom");
    }//GEN-LAST:event_btnWaitRoomExitMouseClicked

    private void WaitRoomTitleMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_WaitRoomTitleMouseDragged
        WaitRoom.setLocation(evt.getXOnScreen()-xx , evt.getYOnScreen()-yy);
    }//GEN-LAST:event_WaitRoomTitleMouseDragged

    private void WaitRoomTitleMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_WaitRoomTitleMousePressed
        xx = evt.getX();
        yy= evt.getY();
    }//GEN-LAST:event_WaitRoomTitleMousePressed

    private void btnInGameExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInGameExitMouseClicked
        client.sendMessage("endGame");
    }//GEN-LAST:event_btnInGameExitMouseClicked

    private void InGameTitleMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_InGameTitleMouseDragged
        InGame.setLocation(evt.getXOnScreen()-xx , evt.getYOnScreen()-yy);
    }//GEN-LAST:event_InGameTitleMouseDragged

    private void InGameTitleMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_InGameTitleMousePressed
        xx = evt.getX();
        yy= evt.getY();
    }//GEN-LAST:event_InGameTitleMousePressed

    private void btnIDcheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIDcheckActionPerformed
        if(txtSignUpID.getText().equals("")){
            showMessageDialog(null, "아이디를 입력하세요.");
        }
        else{
            UserDAO userDB = new UserDAO();
            if(userDB.getIDExist(txtSignUpID.getText())){ //아이디가 존재하면
                showMessageDialog(null, "이미 존재하는 아이디입니다.");
            }else{
                showMessageDialog(null, "사용 가능한 아이디입니다.");
            }
            userDB.close();
        }
    }//GEN-LAST:event_btnIDcheckActionPerformed

    private void txtPWCheckKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPWCheckKeyReleased
        if(String.valueOf(txtPWCheck.getPassword()).equals("")){
            lblPWResult.setText("올바르지 않은 비밀번호입니다.");
        }else{
            if(String.valueOf(txtPW.getPassword()).equals(String.valueOf(txtPWCheck.getPassword()))){
                lblPWResult.setText("사용 가능한 비밀번호입니다..");
            }else{
                lblPWResult.setText("비밀번호가 올바르지 않습니다..");
            }
        }
    }//GEN-LAST:event_txtPWCheckKeyReleased

    private void btnNicknameCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNicknameCheckActionPerformed
        if(txtSignUpNickname.getText().equals("")){
            showMessageDialog(null, "닉네임을 입력하세요.");
        }
        else{
            UserDAO userDB = new UserDAO();
            if(userDB.getNicknameExist(txtSignUpNickname.getText())){ //아이디가 존재하면
                showMessageDialog(null, "이미 존재하는 닉네임입니다.");
            }else{
                showMessageDialog(null, "사용 가능한 닉네임입니다.");
            }
            userDB.close();
        }
    }//GEN-LAST:event_btnNicknameCheckActionPerformed

    private void btnSignUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSignUpActionPerformed
        if(txtSignUpID.getText().equals("")||String.valueOf(txtPW.getPassword()).equals("")||String.valueOf(txtPWCheck.getPassword()).equals("")||txtSignUpNickname.equals("")){
            showMessageDialog(null, "입력하지 않은 항목이 있습니다.");
            return;
        }
        int state = 0; // 1이면 실패
        UserDAO userDB = new UserDAO();
        // 아이디 검증
        if(userDB.getIDExist(txtSignUpID.getText())) state = 1;
        // 비밀번호 검증
        if(!String.valueOf(txtPW.getPassword()).equals(String.valueOf(txtPWCheck.getPassword()))) state = 1;
        // 닉네임 검증
        if(userDB.getNicknameExist(txtSignUpNickname.getText())) state = 1;
        
        if(state==1){
            showMessageDialog(null, "유효하지 않은 값을 입력하였습니다.");
            return;
        }
        
        userDB.singUpInsert(txtSignUpID.getText(), String.valueOf(txtPW.getPassword()), txtSignUpNickname.getText());
        showMessageDialog(null, "가입이 완료되었습니다.");
        SignUp.hide();
        userDB.close();
    }//GEN-LAST:event_btnSignUpActionPerformed

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        UserDAO userDB = new UserDAO();
        if(userDB.login(txtLoginID.getText(), String.valueOf(txtLoginPW.getPassword()))){
            userinfo = userDB.getUserData(txtLoginID.getText());
            SelectRoom.setLocation(MainFrame.this.getLocation().x, MainFrame.this.getLocation().y);
            
            client = new ClientBackground();
            client.setGui(jTable1);
            client.setFrame(this);
            client.setNickname(txtLoginID.getText());
            client.connet();
            
            MainFrame.this.hide();
            showSelectRoom();
            client.sendMessage("f5");
        }else{
            showMessageDialog(null, "아이디 또는 비밀번호가 올바르지 않습니다.");
        }
        userDB.close();
    }//GEN-LAST:event_btnLoginActionPerformed

    private void btnSelectRoomExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSelectRoomExitMouseClicked
        MainFrame.this.setLocation(SelectRoom.getLocation().x, SelectRoom.getLocation().y);
        SelectRoom.hide();
        MainFrame.this.show();
    }//GEN-LAST:event_btnSelectRoomExitMouseClicked

    private void SelectRoomTitleMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SelectRoomTitleMouseDragged
        SelectRoom.setLocation(evt.getXOnScreen()-xx , evt.getYOnScreen()-yy);
    }//GEN-LAST:event_SelectRoomTitleMouseDragged

    private void SelectRoomTitleMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SelectRoomTitleMousePressed
        xx = evt.getX();
        yy= evt.getY();
    }//GEN-LAST:event_SelectRoomTitleMousePressed

    private void txtLoginPWKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLoginPWKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER)
            btnLogin.doClick();
    }//GEN-LAST:event_txtLoginPWKeyPressed

    private void lblSelectRoomExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSelectRoomExitMouseClicked
        MainFrame.this.setLocation(SelectRoom.getLocation().x, SelectRoom.getLocation().y);
        SelectRoom.hide();
        MainFrame.this.show();
        client.sendMessage("exitroom");
    }//GEN-LAST:event_lblSelectRoomExitMouseClicked

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        client.sendMessage("f5");
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void btnCreateRoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateRoomActionPerformed
        showCreateRoom();
    }//GEN-LAST:event_btnCreateRoomActionPerformed

    private void btnCreateExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCreateExitMouseClicked
        CreateRoom.hide();
    }//GEN-LAST:event_btnCreateExitMouseClicked

    private void CreateTitleMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CreateTitleMouseDragged
        CreateRoom.setLocation(evt.getXOnScreen()-xx , evt.getYOnScreen()-yy);
    }//GEN-LAST:event_CreateTitleMouseDragged

    private void CreateTitleMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CreateTitleMousePressed
        xx = evt.getX();
        yy= evt.getY();
    }//GEN-LAST:event_CreateTitleMousePressed

    private void txtLoginPWActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLoginPWActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLoginPWActionPerformed

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
        String name = txtCreateRoom.getText().trim();
        if(name.equals("")){
            return;
        }
        WaitRoom.setLocation(CreateRoom.getLocation().x, CreateRoom.getLocation().y);
        showWaitRoom();
        SelectRoom.dispose();
        CreateRoom.dispose();
        client.sendMessage("create,"+name);
    }//GEN-LAST:event_btnCreateActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        CreateRoom.dispose();
        showSelectRoom();
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnJoinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnJoinActionPerformed
        int a =jTable1.getSelectedRow();  //no
        
        if(jTable1.getModel().getValueAt(a,0).toString() == null)
            return;
        
        if(jTable1.getValueAt(a, 3).equals("1")){
            WaitRoom.setLocation(SelectRoom.getLocation().x,SelectRoom.getLocation().y);
            showWaitRoom();
            client.sendMessage("join,"+(String) jTable1.getValueAt(a, 0));
            SelectRoom.dispose();
            CreateRoom.dispose();
        }
    }//GEN-LAST:event_btnJoinActionPerformed

    private void lblReadyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblReadyMouseClicked
       client.sendMessage("ready");
    }//GEN-LAST:event_lblReadyMouseClicked

    private void btnMyPageExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMyPageExitMouseClicked
        MyPage.hide();
    }//GEN-LAST:event_btnMyPageExitMouseClicked

    private void MyPageTitleMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MyPageTitleMouseDragged
        // TODO add your handling code here:
        MyPage.setLocation(evt.getXOnScreen()-xx , evt.getYOnScreen()-yy);
    }//GEN-LAST:event_MyPageTitleMouseDragged

    private void MyPageTitleMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MyPageTitleMousePressed
        // TODO add your handling code here:
        xx = evt.getX();
        yy= evt.getY();
    }//GEN-LAST:event_MyPageTitleMousePressed

    private void txtMyPagePWDchkKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMyPagePWDchkKeyReleased
        // TODO add your handling code here:
        if(String.valueOf(txtMyPagePWDchk.getPassword()).equals("")){
            lblPWDchkResult.setText("올바르지 않은 비밀번호입니다.");
        }else{
            if(String.valueOf(txtMyPagePWD.getPassword()).equals(String.valueOf(txtMyPagePWDchk.getPassword()))){
                lblPWDchkResult.setText("사용 가능한 비밀번호입니다..");
            }else{
                lblPWDchkResult.setText("비밀번호가 올바르지 않습니다..");
            }
        }
    }//GEN-LAST:event_txtMyPagePWDchkKeyReleased

    private void btnMyPageApplyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMyPageApplyActionPerformed
        // TODO add your handling code here:
        if(String.valueOf(txtMyPagePWDchk.getPassword()).equals("")){
            showMessageDialog(null, "올바르지 않은 비밀번호 입니다.");
            return;
        }else{
            if(!String.valueOf(txtMyPagePWD.getPassword()).equals(String.valueOf(txtMyPagePWDchk.getPassword()))){
                showMessageDialog(null, "올바르지 않은 비밀번호 입니다.");
                return;
            }
        }
        UserDAO userDB = new UserDAO();
        userDB.myPagePwdUpdate(userinfo.getId(), String.valueOf(txtMyPagePWD.getPassword()));
        showMessageDialog(null, "비밀번호가 변경 되었습니다.");
        userDB.close();
    }//GEN-LAST:event_btnMyPageApplyActionPerformed

    private void lblMyPage1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMyPage1MouseClicked
        // 로고 이미지
        imgicon = new ImageIcon(MainFrame.class.getResource("../image/settings.png"));
        img = imgicon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        lbllogoMyPage.setIcon(new ImageIcon(img));
        MyPage.setLocation(WaitRoom.getLocation().x, WaitRoom.getLocation().y);
        MyPage.setSize(312,620);
        MyPage.show();
        txtMyPageId.setText(userinfo.getId());
        txtMyPageNick.setText(userinfo.getNickname());
        txtMyPageDate.setText(userinfo.getDate());
        txtMyPageWin.setText(Integer.toString(userinfo.getWin()));
        txtMyPageLose.setText(Integer.toString(userinfo.getLose()));
        txtMyPagePoint.setText(Integer.toString(userinfo.getPoint()));
    }//GEN-LAST:event_lblMyPage1MouseClicked

    private void lblMyPage2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMyPage2MouseClicked
        // 로고 이미지
        imgicon = new ImageIcon(MainFrame.class.getResource("../image/settings.png"));
        img = imgicon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        lbllogoMyPage.setIcon(new ImageIcon(img));
        MyPage.setLocation(SelectRoom.getLocation().x, SelectRoom.getLocation().y);
        MyPage.setSize(312,620);
        MyPage.show();
        txtMyPageId.setText(userinfo.getId());
        txtMyPageNick.setText(userinfo.getNickname());
        txtMyPageDate.setText(userinfo.getDate());
        txtMyPageWin.setText(Integer.toString(userinfo.getWin()));
        txtMyPageLose.setText(Integer.toString(userinfo.getLose()));
        txtMyPagePoint.setText(Integer.toString(userinfo.getPoint()));
    }//GEN-LAST:event_lblMyPage2MouseClicked

    private void lblMyPageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMyPageMouseClicked
        // 로고 이미지
        imgicon = new ImageIcon(MainFrame.class.getResource("../image/settings.png"));
        img = imgicon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        lbllogoMyPage.setIcon(new ImageIcon(img));
        MyPage.setLocation(InGame.getLocation().x, InGame.getLocation().y);
        MyPage.setSize(312,620);
        MyPage.show();
        txtMyPageId.setText(userinfo.getId());
        txtMyPageNick.setText(userinfo.getNickname());
        txtMyPageDate.setText(userinfo.getDate());
        txtMyPageWin.setText(Integer.toString(userinfo.getWin()));
        txtMyPageLose.setText(Integer.toString(userinfo.getLose()));
        txtMyPagePoint.setText(Integer.toString(userinfo.getPoint()));
    }//GEN-LAST:event_lblMyPageMouseClicked

    private void lblBlueMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBlueMouseClicked
        if(whoseTurn.equals("my")&&bellState==1){
            lastMyCard = mycards.get(mycards.size()-1);
            cardlist.add(lastMyCard);
            // 오른쪽 내(파랑)가 클릭한 카드
            imgicon = new ImageIcon(MainFrame.class.getResource("../image/cards/"+lastMyCard+".png"));
            img = imgicon.getImage().getScaledInstance(lblBlueClick.getWidth(), lblBlueClick.getHeight(), Image.SCALE_SMOOTH);
            lblBlueClick.setIcon(new ImageIcon(img));
            mycards.remove(mycards.size()-1);
            refreshCardNum();
            client.sendMessage("sendmycard");
        }
    }//GEN-LAST:event_lblBlueMouseClicked

    private void lblBellMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBellMouseClicked
        if(bellState==0){
            client.sendMessage("bellClick,"+lastMyCard+"#"+lastYourCard);
        }
    }//GEN-LAST:event_lblBellMouseClicked

    private void WinnerTitleMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_WinnerTitleMouseDragged
        Winner.setLocation(evt.getXOnScreen()-xx , evt.getYOnScreen()-yy);
    }//GEN-LAST:event_WinnerTitleMouseDragged

    private void WinnerTitleMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_WinnerTitleMousePressed
        xx = evt.getX();
        yy= evt.getY();
    }//GEN-LAST:event_WinnerTitleMousePressed

    private void LoserTitleMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LoserTitleMouseDragged
        Loser.setLocation(evt.getXOnScreen()-xx , evt.getYOnScreen()-yy);
    }//GEN-LAST:event_LoserTitleMouseDragged

    private void LoserTitleMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LoserTitleMousePressed
        xx = evt.getX();
        yy= evt.getY();
    }//GEN-LAST:event_LoserTitleMousePressed

    private void btnWinnerOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnWinnerOKActionPerformed
        UserDAO user = new UserDAO();
        user.winUpdate(userinfo.getId());
        userinfo = user.getUserData(userinfo.getId());
        user.close();
        Winner.hide();
        WaitRoom.setLocation(InGame.getLocation().x, InGame.getLocation().y);
        InGame.hide();
        showWaitRoom();
        Ready("0", "0");
    }//GEN-LAST:event_btnWinnerOKActionPerformed

    private void btnLoserOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoserOKActionPerformed
        UserDAO user = new UserDAO();
        user.loseUpdate(userinfo.getId());
        userinfo = user.getUserData(userinfo.getId());
        user.close();
        Loser.hide();
        WaitRoom.setLocation(InGame.getLocation().x, InGame.getLocation().y);
        InGame.hide();
        showWaitRoom();
        Ready("0", "0");
    }//GEN-LAST:event_btnLoserOKActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }
    /////////////////////////////////////////////////////Pop Up////////////////////////////////////////////////////
    public void showWinner(){
        Winner.setSize(467, 258);
        Winner.setLocation(InGame.getLocation().x+InGame.getWidth()/2, InGame.getLocation().y+InGame.getHeight()/2);
        Winner.show();
        // 로고 이미지
        imgicon = new ImageIcon(MainFrame.class.getResource("../image/settings.png"));
        img = imgicon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        lbllogoWinner.setIcon(new ImageIcon(img));
    }
    public void showLoser(){
        Loser.setSize(467, 258);
        Loser.setLocation(InGame.getLocation().x+InGame.getWidth()/2, InGame.getLocation().y+InGame.getHeight()/2);
        Loser.show();
        // 로고 이미지
        imgicon = new ImageIcon(MainFrame.class.getResource("../image/settings.png"));
        img = imgicon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        lbllogoWinner.setIcon(new ImageIcon(img));
    }
    /////////////////////////////////////////////////////Sign Up////////////////////////////////////////////////////
    public void showSignUp(){
        SignUp.setSize(555, 592);
        SignUp.setLocation(MainFrame.this.getLocation().x+MainFrame.this.getSize().width, MainFrame.this.getLocation().y);
        SignUp.setResizable(false);
        SignUp.show();
        // 로고 이미지
        imgicon = new ImageIcon(MainFrame.class.getResource("../image/settings.png"));
        img = imgicon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        lbllogoSignUp.setIcon(new ImageIcon(img));
    }
    ///////////////////////////////////////////////////Select Room///////////////////////////////////////////////////
    public void showSelectRoom(){
        SelectRoom.setSize(947, 534);
        //SelectRoom.setLocation(MainFrame.this.getLocation().x, MainFrame.this.getLocation().y);
        SelectRoom.setResizable(false);
        SelectRoom.show();
        // 로고 이미지
        imgicon = new ImageIcon(MainFrame.class.getResource("../image/settings.png"));
        img = imgicon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        lbllogoSelectRoom.setIcon(new ImageIcon(img));
        // 나가기 이미지
        imgicon = new ImageIcon(MainFrame.class.getResource("../image/exit.png"));
        img = imgicon.getImage().getScaledInstance(lblSelectRoomExit.getWidth(), lblSelectRoomExit.getHeight(), Image.SCALE_SMOOTH);
        lblSelectRoomExit.setIcon(new ImageIcon(img));
        // 나의 프로필 이미지
        imgicon = new ImageIcon(MainFrame.class.getResource("../image/profile.png"));
        img = imgicon.getImage().getScaledInstance(lblMyProfileSelectRoom.getWidth(), lblMyProfileSelectRoom.getHeight(), Image.SCALE_SMOOTH);
        lblMyProfileSelectRoom.setIcon(new ImageIcon(img));
        // 유저 정보 세팅
        lblNickSelect.setText(userinfo.getNickname());
        lblPointSelect.setText("포인트 : "+userinfo.getPoint()+"P");
        lblMyWinLoseSelect.setText(userinfo.getWin()+"승 "+userinfo.getLose()+"패");
        // 테이블 세팅
        jTable1.setModel(new javax.swing.table.DefaultTableModel(new Object [][] {
                {null, null, null, null}, {null, null, null, null}, {null, null, null, null}, {null, null, null, null}, {null, null, null, null}, {null, null, null, null},
                {null, null, null, null}, {null, null, null, null}, {null, null, null, null}, {null, null, null, null}, {null, null, null, null}, {null, null, null, null},
                {null, null, null, null}, {null, null, null, null}, {null, null, null, null}, {null, null, null, null}, {null, null, null, null}, {null, null, null, null},
                {null, null, null, null}, {null, null, null, null}, {null, null, null, null}, {null, null, null, null}, {null, null, null, null}, {null, null, null, null},
                {null, null, null, null}, {null, null, null, null}, {null, null, null, null}, {null, null, null, null}, {null, null, null, null}, {null, null, null, null},
                {null, null, null, null}, {null, null, null, null}, {null, null, null, null}, {null, null, null, null}, {null, null, null, null}, {null, null, null, null},
                {null, null, null, null}, {null, null, null, null}, {null, null, null, null}, {null, null, null, null}
            }, new String [] { "번호", "제목", "방장", "인원"}){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        });
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        JTableHeader Theader = jTable1.getTableHeader();
        Theader.setForeground(Color.BLACK);
        ((DefaultTableCellRenderer)Theader.getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
        jTable1.setTableHeader(Theader);
        jTable1.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        jTable1.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        jTable1.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        jTable1.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
        jTable1.getColumnModel().getColumn(0).setMaxWidth(50);
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTable1.getColumnModel().getColumn(1).setMaxWidth(350);
        jTable1.getColumnModel().getColumn(1).setPreferredWidth(350);
        jTable1.getColumnModel().getColumn(2).setMaxWidth(100);
        jTable1.getColumnModel().getColumn(2).setPreferredWidth(100);
        jTable1.getColumnModel().getColumn(3).setMaxWidth(100);
        jTable1.getColumnModel().getColumn(3).setPreferredWidth(100);
    }
    /////////////////////////////////////////////////////Create Room/////////////////////////////////////////////////////
    public void showCreateRoom(){
        CreateRoom.setSize(466, 268);
        CreateRoom.setLocation(SelectRoom.getLocation().x,SelectRoom.getLocation().y);
        CreateRoom.show();
        // 로고 이미지
        imgicon = new ImageIcon(MainFrame.class.getResource("../image/settings.png"));
        img = imgicon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        lbllogoCreate.setIcon(new ImageIcon(img));
    }
    /////////////////////////////////////////////////////Wait Room/////////////////////////////////////////////////////
    public void showWaitRoom(){
        WaitRoom.setSize(978, 395);
        //WaitRoom.setLocation(MainFrame.this.getLocation().x, MainFrame.this.getLocation().y);
        WaitRoom.setResizable(false);
        WaitRoom.show();
        // 준비 상태 이미지
        imgicon = new ImageIcon(MainFrame.class.getResource("../image/white.png"));
        img = imgicon.getImage().getScaledInstance(lblState1.getWidth(), lblState1.getHeight(), Image.SCALE_SMOOTH);
        lblState1.setIcon(new ImageIcon(img));
        img = imgicon.getImage().getScaledInstance(lblState1.getWidth(), lblState2.getHeight(), Image.SCALE_SMOOTH);
        lblState2.setIcon(new ImageIcon(img));
        // 로고 이미지
        imgicon = new ImageIcon(MainFrame.class.getResource("../image/settings.png"));
        img = imgicon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        lbllogoWaitRoom.setIcon(new ImageIcon(img));
        // 시작 버튼
        imgicon = new ImageIcon(MainFrame.class.getResource("../image/btn.png"));
        img = imgicon.getImage().getScaledInstance(lblReady.getWidth(), lblReady.getHeight(), Image.SCALE_SMOOTH);
        lblReady.setIcon(new ImageIcon(img));
        // 나의 프로필 이미지
        imgicon = new ImageIcon(MainFrame.class.getResource("../image/profile.png"));
        img = imgicon.getImage().getScaledInstance(lblMyProfileInWait.getWidth(), lblMyProfileInWait.getHeight(), Image.SCALE_SMOOTH);
        lblMyProfileInWait.setIcon(new ImageIcon(img));
        // 유저 정보 세팅
        lblMyNickWait.setText(userinfo.getNickname());
        lblMyPointWait.setText("포인트 : "+userinfo.getPoint()+"P");
        lblMyWinLoseWait.setText(userinfo.getWin()+"승 "+userinfo.getLose()+"패");
    }
    //////////////////////////////////////////////////////IN GAME//////////////////////////////////////////////////////
    public void openGame(){
        InGame.setSize(1880, 775);
        //InGame.setLocation(MainFrame.this.getLocation().x, MainFrame.this.getLocation().y);
        InGame.setResizable(false);
        InGame.show();
        // 로고 이미지
        imgicon = new ImageIcon(MainFrame.class.getResource("../image/settings.png"));
        img = imgicon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        lbllogoInGame.setIcon(new ImageIcon(img));
        // 왼쪽 상대(빨강) 카드
        imgicon = new ImageIcon(MainFrame.class.getResource("../image/red.png"));
        img = imgicon.getImage().getScaledInstance(lblRed.getWidth(), lblRed.getHeight(), Image.SCALE_SMOOTH);
        lblRed.setIcon(new ImageIcon(img));
        // 왼쪽 상대(빨강)가 클릭한 카드
        imgicon = new ImageIcon(MainFrame.class.getResource("../image/emptycard.png"));
        img = imgicon.getImage().getScaledInstance(lblRedClick.getWidth(), lblRedClick.getHeight(), Image.SCALE_SMOOTH);
        lblRedClick.setIcon(new ImageIcon(img));
        // 오른쪽 내(파랑) 카드
        imgicon = new ImageIcon(MainFrame.class.getResource("../image/blue.png"));
        img = imgicon.getImage().getScaledInstance(lblBlue.getWidth(), lblBlue.getHeight(), Image.SCALE_SMOOTH);
        lblBlue.setIcon(new ImageIcon(img));
        // 오른쪽 내(파랑)가 클릭한 카드
        imgicon = new ImageIcon(MainFrame.class.getResource("../image/emptycard.png"));
        img = imgicon.getImage().getScaledInstance(lblBlueClick.getWidth(), lblBlueClick.getHeight(), Image.SCALE_SMOOTH);
        lblBlueClick.setIcon(new ImageIcon(img));
        // 벨 이미지
        imgicon = new ImageIcon(MainFrame.class.getResource("../image/bell.png"));
        img = imgicon.getImage().getScaledInstance(lblBell.getWidth(), lblBell.getHeight(), Image.SCALE_SMOOTH);
        lblBell.setIcon(new ImageIcon(img));
        // 나가기 이미지
        imgicon = new ImageIcon(MainFrame.class.getResource("../image/exit.png"));
        img = imgicon.getImage().getScaledInstance(lblExit.getWidth(), lblExit.getHeight(), Image.SCALE_SMOOTH);
        lblExit.setIcon(new ImageIcon(img));
        // 프로필 이미지
        imgicon = new ImageIcon(MainFrame.class.getResource("../image/profile.png"));
        img = imgicon.getImage().getScaledInstance(lblProfile.getWidth(), lblProfile.getHeight(), Image.SCALE_SMOOTH);
        lblProfile.setIcon(new ImageIcon(img));
        // 나의 프로필 이미지
        imgicon = new ImageIcon(MainFrame.class.getResource("../image/profile.png"));
        img = imgicon.getImage().getScaledInstance(lblMyProfile.getWidth(), lblMyProfile.getHeight(), Image.SCALE_SMOOTH);
        lblMyProfile.setIcon(new ImageIcon(img));
        // 상대의 프로필 이미지
        imgicon = new ImageIcon(MainFrame.class.getResource("../image/profile.png"));
        img = imgicon.getImage().getScaledInstance(lblYourProfile.getWidth(), lblYourProfile.getHeight(), Image.SCALE_SMOOTH);
        lblYourProfile.setIcon(new ImageIcon(img));
        // 유저 정보 세팅
        lblMyNickInGame.setText(userinfo.getNickname());
        lblMyPointInGame.setText("포인트 : "+userinfo.getPoint()+"P");
        lblMyWinLoseInGame.setText(userinfo.getWin()+"승 "+userinfo.getLose()+"패");
        
        lblMyNickname.setText(myinfo.getNickname());
        lblYourNickname.setText(yourinfo.getNickname());
    }
    
    public void initialGameSet(String turn, String mycard, String yourcard){
        mycards = new ArrayList<String>();
        yourcards = new ArrayList<String>();
        cardlist = new ArrayList<String>();
        whoseTurn = turn;
        String[] mytmp = mycard.substring(1, mycard.length()-1).split("#");
        String[] yourtmp = yourcard.substring(1, yourcard.length()-1).split("#");
        for(int i=0; i<mytmp.length;i++){
            mycards.add(mytmp[i].trim());
            yourcards.add(yourtmp[i].trim());
        }
        System.out.println(mycards.toString());
        System.out.println(yourcards.toString());
        startState = 1;
        bellState = 0;
        lastMyCard = "00";//empty card
        lastYourCard = "00";//empty card
        allTimer = new Timer();
        turnTimer = new Timer();
        AllTimer();
        TurnChange();
    }
    
    public void TurnChange(){
        if(startState==1){ // 첫 턴이면
            startState = 0;
            if(whoseTurn.equals("my")){
                showMyturn();
            }else if(whoseTurn.equals("your")){
                showYourturn();
            }
        }else{
            turnTimer.cancel();
            turnTimer = new Timer();
            if(bellState==1){
                showBellturn();
                return;
            }
            if(whoseTurn.equals("my")){
                if(yourcards.size()==0){
                    showWinner();
                    turnTimer.cancel();
                    allTimer.cancel();
                    return;
                }
                whoseTurn = "your";
                showYourturn();
            }else if(whoseTurn.equals("your")){
                if(mycards.size()==0){
                    showLoser();
                    turnTimer.cancel();
                    allTimer.cancel();
                    return;
                }
                whoseTurn = "my";
                showMyturn();
            }
        }
    }
    
    public void showMyturn(){
        bellState = 1;
        TurnTimer(myinfo.getNickname()+"님의 턴입니다.", 10);
        LineBorder lb = new LineBorder(Color.RED, 2, true);
        pnlMy.setBorder(lb);
        lb = new LineBorder(Color.BLACK, 2, true);
        pnlYour.setBorder(lb);
        //lblBlue
        // 오른쪽 내(파랑) 카드 세팅
        imgicon = new ImageIcon(MainFrame.class.getResource("../image/cards/blueb2.png"));
        img = imgicon.getImage().getScaledInstance(lblBlue.getWidth(), lblBlue.getHeight(), Image.SCALE_SMOOTH);
        lblBlue.setIcon(new ImageIcon(img));
        lblBlue.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        // 벨 이미지
        imgicon = new ImageIcon(MainFrame.class.getResource("../image/bell.png"));
        img = imgicon.getImage().getScaledInstance(lblBell.getWidth(), lblBell.getHeight(), Image.SCALE_SMOOTH);
        lblBell.setIcon(new ImageIcon(img));
        lblBell.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
    }
    
    public void showYourturn(){
        bellState = 1;
        TurnTimer(yourinfo.getNickname()+"님의 턴입니다.", 10);
        LineBorder lb = new LineBorder(Color.RED, 2, true);
        pnlYour.setBorder(lb);
        lb = new LineBorder(Color.BLACK, 2, true);
        pnlMy.setBorder(lb);
        // 오른쪽 내(파랑) 카드 세팅
        imgicon = new ImageIcon(MainFrame.class.getResource("../image/cards/blueb.png"));
        img = imgicon.getImage().getScaledInstance(lblBlue.getWidth(), lblBlue.getHeight(), Image.SCALE_SMOOTH);
        lblBlue.setIcon(new ImageIcon(img));
        lblBlue.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        // 벨 이미지
        imgicon = new ImageIcon(MainFrame.class.getResource("../image/bell.png"));
        img = imgicon.getImage().getScaledInstance(lblBell.getWidth(), lblBell.getHeight(), Image.SCALE_SMOOTH);
        lblBell.setIcon(new ImageIcon(img));
        lblBell.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
    }
    
    public void showBellturn(){
        bellState = 0;
        TurnTimer("종을 칠 수 있습니다.", 3);
        LineBorder lb = new LineBorder(Color.BLACK, 2, true);
        pnlMy.setBorder(lb);
        pnlYour.setBorder(lb);
        // 오른쪽 내(파랑) 카드 세팅
        imgicon = new ImageIcon(MainFrame.class.getResource("../image/cards/blueb.png"));
        img = imgicon.getImage().getScaledInstance(lblBlue.getWidth(), lblBlue.getHeight(), Image.SCALE_SMOOTH);
        lblBlue.setIcon(new ImageIcon(img));
        lblBlue.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        // 벨 이미지
        imgicon = new ImageIcon(MainFrame.class.getResource("../image/bell2.png"));
        img = imgicon.getImage().getScaledInstance(lblBell.getWidth(), lblBell.getHeight(), Image.SCALE_SMOOTH);
        lblBell.setIcon(new ImageIcon(img));
        lblBell.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    }
    
    public void receiveCard(){
        lastYourCard = yourcards.get(yourcards.size()-1);
        cardlist.add(lastYourCard);
        // 왼쪽 상대(빨강)가 클릭한 카드
        imgicon = new ImageIcon(MainFrame.class.getResource("../image/cards/"+lastYourCard+".png"));
        img = imgicon.getImage().getScaledInstance(lblRedClick.getWidth(), lblRedClick.getHeight(), Image.SCALE_SMOOTH);
        lblRedClick.setIcon(new ImageIcon(img));
        yourcards.remove(yourcards.size()-1);
        refreshCardNum();
    }
    
    public void refreshCardNum(){
        lblMyCard.setText(Integer.toString(mycards.size()));
        lblYourCard.setText(Integer.toString(yourcards.size()));
    }
     
    public void getAllCard(){
        for(int i=0;i<cardlist.size();i++){
            mycards.add(cardlist.get(i));
        }
        cardlist.clear();
        lastMyCard = "00";//empty card
        lastYourCard = "00";//empty card
        // 오른쪽 내(파랑)가 클릭한 카드
        imgicon = new ImageIcon(MainFrame.class.getResource("../image/emptycard.png"));
        img = imgicon.getImage().getScaledInstance(lblBlueClick.getWidth(), lblBlueClick.getHeight(), Image.SCALE_SMOOTH);
        lblBlueClick.setIcon(new ImageIcon(img));
        // 왼쪽 상대(빨강)가 클릭한 카드
        imgicon = new ImageIcon(MainFrame.class.getResource("../image/emptycard.png"));
        img = imgicon.getImage().getScaledInstance(lblRedClick.getWidth(), lblRedClick.getHeight(), Image.SCALE_SMOOTH);
        lblRedClick.setIcon(new ImageIcon(img));
        refreshCardNum();
        TurnChange();
    }
    
    public void loseAllCard(){
        for(int i=0;i<cardlist.size();i++){
            yourcards.add(cardlist.get(i));
        }
        cardlist.clear();
        lastMyCard = "00";//empty card
        lastYourCard = "00";//empty card
        // 오른쪽 내(파랑)가 클릭한 카드
        imgicon = new ImageIcon(MainFrame.class.getResource("../image/emptycard.png"));
        img = imgicon.getImage().getScaledInstance(lblBlueClick.getWidth(), lblBlueClick.getHeight(), Image.SCALE_SMOOTH);
        lblBlueClick.setIcon(new ImageIcon(img));
        // 왼쪽 상대(빨강)가 클릭한 카드
        imgicon = new ImageIcon(MainFrame.class.getResource("../image/emptycard.png"));
        img = imgicon.getImage().getScaledInstance(lblRedClick.getWidth(), lblRedClick.getHeight(), Image.SCALE_SMOOTH);
        lblRedClick.setIcon(new ImageIcon(img));
        refreshCardNum();
        TurnChange();
    }
    
    public void giveMycard(){
        if(mycards.size()>0){
            yourcards.add(mycards.get(mycards.size()-1));
            mycards.remove(mycards.size()-1);
        }
        refreshCardNum();
        TurnChange();
    }
    
    public void getYourcard(){
        if(yourcards.size()>0){
            mycards.add(yourcards.get(yourcards.size()-1));
            yourcards.remove(yourcards.size()-1);
        }
        refreshCardNum();
        TurnChange();
    }
    
    public void AllTimer(){
        allCount = 1200;
        allTask = new TimerTask(){
            @Override
            public void run() {
                if(allCount >= 0){
                    int minute = allCount / 60;
                    int sec = allCount % 60;
                    lblAllCount.setText(minute+"분 "+sec+"초");
                    allCount--;
                }else{
                    allTimer.cancel();
                }
            }
        };
        allTimer.schedule(allTask, 0, 1000);
    }
    
    public void TurnTimer(String nickname, int count){
        lblTurnName.setText(nickname);
        turnCount = count;
        turnTask = new TimerTask(){
            @Override
            public void run() {
                if(turnCount >= 0){
                    lblTurnCount.setText(turnCount+"초 남았습니다.");
                    turnCount--;
                }else{
                    if(bellState==0){// 벨 턴이면
                        client.sendMessage("BellNotClick");
                    }else if(whoseTurn.equals("my")){
                        if(whoseTurn.equals("my")&&bellState==1){
                            lastMyCard = mycards.get(mycards.size()-1);
                            cardlist.add(lastMyCard);
                            // 오른쪽 내(파랑)가 클릭한 카드
                            imgicon = new ImageIcon(MainFrame.class.getResource("../image/cards/"+lastMyCard+".png"));
                            img = imgicon.getImage().getScaledInstance(lblBlueClick.getWidth(), lblBlueClick.getHeight(), Image.SCALE_SMOOTH);
                            lblBlueClick.setIcon(new ImageIcon(img));
                            mycards.remove(mycards.size()-1);
                            refreshCardNum();
                            client.sendMessage("sendmycard");
                        }
                    }
                }
            }
        };
        turnTimer.schedule(turnTask, 0, 1000);
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFrame CreateRoom;
    private javax.swing.JPanel CreateTitle;
    private javax.swing.JFrame InGame;
    private javax.swing.JPanel InGameTitle;
    private javax.swing.JDialog Loser;
    private javax.swing.JPanel LoserTitle;
    private javax.swing.JPanel MainTitle;
    private javax.swing.JFrame MyPage;
    private javax.swing.JPanel MyPageInfo;
    private javax.swing.JPanel MyPageTitle;
    private javax.swing.JFrame SelectRoom;
    private javax.swing.JPanel SelectRoomTitle;
    private javax.swing.JFrame SignUp;
    private javax.swing.JPanel SignUpTitle;
    private javax.swing.JFrame WaitRoom;
    private javax.swing.JPanel WaitRoomTitle;
    private javax.swing.JDialog Winner;
    private javax.swing.JPanel WinnerTitle;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnCreate;
    private javax.swing.JLabel btnCreateExit;
    private javax.swing.JButton btnCreateRoom;
    private javax.swing.JButton btnIDcheck;
    private javax.swing.JLabel btnInGameExit;
    private javax.swing.JButton btnJoin;
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnLoserOK;
    private javax.swing.JLabel btnMainExit;
    private javax.swing.JButton btnMyPageApply;
    private javax.swing.JLabel btnMyPageExit;
    private javax.swing.JButton btnNicknameCheck;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JLabel btnSelectRoomExit;
    private javax.swing.JButton btnSignUp;
    private javax.swing.JLabel btnSignUpExit;
    private javax.swing.JLabel btnWaitRoomExit;
    private javax.swing.JButton btnWinnerOK;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel lblAllCount;
    private javax.swing.JLabel lblBell;
    private javax.swing.JLabel lblBlue;
    private javax.swing.JLabel lblBlueClick;
    private javax.swing.JLabel lblExit;
    private javax.swing.JLabel lblMyCard;
    private javax.swing.JLabel lblMyNickInGame;
    private javax.swing.JLabel lblMyNickWait;
    private javax.swing.JLabel lblMyNickname;
    private javax.swing.JLabel lblMyNickname1;
    private javax.swing.JLabel lblMyNickname2;
    private javax.swing.JLabel lblMyPage;
    private javax.swing.JLabel lblMyPage1;
    private javax.swing.JLabel lblMyPage2;
    private javax.swing.JLabel lblMyPageDate;
    private javax.swing.JLabel lblMyPageId;
    private javax.swing.JLabel lblMyPageLose;
    private javax.swing.JLabel lblMyPageNick;
    private javax.swing.JLabel lblMyPagePWD;
    private javax.swing.JLabel lblMyPagePWDchk;
    private javax.swing.JLabel lblMyPagePoint;
    private javax.swing.JLabel lblMyPageWin;
    private javax.swing.JLabel lblMyPointInGame;
    private javax.swing.JLabel lblMyPointWait;
    private javax.swing.JLabel lblMyProfile;
    private javax.swing.JLabel lblMyProfileInWait;
    private javax.swing.JLabel lblMyProfileSelectRoom;
    private javax.swing.JLabel lblMyWinLoseInGame;
    private javax.swing.JLabel lblMyWinLoseSelect;
    private javax.swing.JLabel lblMyWinLoseWait;
    private javax.swing.JLabel lblNick1;
    private javax.swing.JLabel lblNick2;
    private javax.swing.JLabel lblNickSelect;
    private javax.swing.JLabel lblPW;
    private javax.swing.JLabel lblPWCheck;
    private javax.swing.JLabel lblPWDchkResult;
    private javax.swing.JLabel lblPWResult;
    private javax.swing.JLabel lblPoint1;
    private javax.swing.JLabel lblPoint2;
    private javax.swing.JLabel lblPointSelect;
    private javax.swing.JLabel lblProfile;
    private javax.swing.JLabel lblProfile1;
    private javax.swing.JLabel lblProfile2;
    private javax.swing.JLabel lblReady;
    private javax.swing.JLabel lblRed;
    private javax.swing.JLabel lblRedClick;
    private javax.swing.JLabel lblRegister;
    private javax.swing.JLabel lblSelectRoomExit;
    private javax.swing.JLabel lblSignUpID;
    private javax.swing.JLabel lblSignUpLogo;
    private javax.swing.JLabel lblSignUpNickname;
    private javax.swing.JLabel lblState1;
    private javax.swing.JLabel lblState2;
    private javax.swing.JLabel lblTurnCount;
    private javax.swing.JLabel lblTurnName;
    private javax.swing.JLabel lblYourCard;
    private javax.swing.JLabel lblYourNickname;
    private javax.swing.JLabel lblYourProfile;
    private javax.swing.JLabel lbllogoCreate;
    private javax.swing.JLabel lbllogoInGame;
    private javax.swing.JLabel lbllogoLoser;
    private javax.swing.JLabel lbllogoMain;
    private javax.swing.JLabel lbllogoMyPage;
    private javax.swing.JLabel lbllogoSelectRoom;
    private javax.swing.JLabel lbllogoSignUp;
    private javax.swing.JLabel lbllogoWaitRoom;
    private javax.swing.JLabel lbllogoWinner;
    private javax.swing.JLabel lblwl1;
    private javax.swing.JLabel lblwl2;
    private javax.swing.JPanel pnlMy;
    private javax.swing.JPanel pnlYour;
    private javax.swing.JTextField txtChat;
    private javax.swing.JTextField txtCreateRoom;
    private javax.swing.JTextField txtLoginID;
    private javax.swing.JPasswordField txtLoginPW;
    private javax.swing.JTextField txtMyPageDate;
    private javax.swing.JTextField txtMyPageId;
    private javax.swing.JTextField txtMyPageLose;
    private javax.swing.JTextField txtMyPageNick;
    private javax.swing.JPasswordField txtMyPagePWD;
    private javax.swing.JPasswordField txtMyPagePWDchk;
    private javax.swing.JTextField txtMyPagePoint;
    private javax.swing.JTextField txtMyPageWin;
    private javax.swing.JPasswordField txtPW;
    private javax.swing.JPasswordField txtPWCheck;
    private javax.swing.JTextField txtSignUpID;
    private javax.swing.JTextField txtSignUpNickname;
    // End of variables declaration//GEN-END:variables
}
