
import Dao.UserDAO;
import Dto.UserDTO;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.ImageIcon;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

public class MainFrame extends javax.swing.JFrame {
    public static UserDTO userinfo; // 유저 정보
    public static Timer turnTimer = new Timer(); // 인게임 턴용 타이머
    public static Timer AllTimer = new Timer(); // 인게임 전체 제한 시간 타이머
    public static TimerTask turnTask; // 턴용 타이머테스크
    public static TimerTask allTask; // 제한 시간용 타이머테스크
    public static int turnCount; // 턴용 타이머 카운트
    public static int allCount; // 제한 시간용 타이머 카운트
    ImageIcon imgicon;
    Image img;
    int xx; // 이전 x좌표 기억
    int yy; // 이전 y좌표 기억
    
    public MainFrame() {
        initComponents();
        // 나가기 이미지
        imgicon = new ImageIcon(MainFrame.class.getResource("./image/settings.png"));
        img = imgicon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        lbllogoMain.setIcon(new ImageIcon(img));
        //openGame();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        InGame = new javax.swing.JFrame();
        jPanel1 = new javax.swing.JPanel();
        pnlYour = new javax.swing.JPanel();
        lblYourProfile = new javax.swing.JLabel();
        lblYourNickname1 = new javax.swing.JLabel();
        lblMyNickname2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
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
        jLabel6 = new javax.swing.JLabel();
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
        jPanel12 = new javax.swing.JPanel();
        lblState1 = new javax.swing.JLabel();
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

        lblYourNickname1.setFont(new java.awt.Font("맑은 고딕", 1, 18)); // NOI18N
        lblYourNickname1.setText("닉네임");

        lblMyNickname2.setFont(new java.awt.Font("맑은 고딕", 1, 16)); // NOI18N
        lblMyNickname2.setText("남은 카드 : ");

        jLabel7.setFont(new java.awt.Font("맑은 고딕", 0, 18)); // NOI18N
        jLabel7.setText("0");

        javax.swing.GroupLayout pnlYourLayout = new javax.swing.GroupLayout(pnlYour);
        pnlYour.setLayout(pnlYourLayout);
        pnlYourLayout.setHorizontalGroup(
            pnlYourLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlYourLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(lblYourProfile, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnlYourLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblYourNickname1)
                    .addGroup(pnlYourLayout.createSequentialGroup()
                        .addComponent(lblMyNickname2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel7)))
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
                .addComponent(lblYourNickname1)
                .addGap(18, 18, 18)
                .addGroup(pnlYourLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMyNickname2)
                    .addComponent(jLabel7))
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

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        lblBlueClick.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        lblBlue.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

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

        jLabel6.setFont(new java.awt.Font("맑은 고딕", 0, 18)); // NOI18N
        jLabel6.setText("0");

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
                        .addComponent(jLabel6)))
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
                    .addComponent(jLabel6))
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
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Project HG");
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
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblState2, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblState2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
        );

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblState1, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblState1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
        );

        lblReady.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblReady.addMouseListener(new java.awt.event.MouseAdapter() {
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
                .addGap(14, 14, 14)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Project HG");
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
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Project HG");
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
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        jPanel17.setBackground(new java.awt.Color(255, 255, 255));
        jPanel17.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblNickSelect.setFont(new java.awt.Font("맑은 고딕", 1, 18)); // NOI18N
        lblNickSelect.setText("닉네임");

        lblMyPage2.setFont(new java.awt.Font("맑은 고딕", 1, 18)); // NOI18N
        lblMyPage2.setForeground(new java.awt.Color(51, 51, 255));
        lblMyPage2.setText("마이페이지");
        lblMyPage2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

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

        lblSelectRoomExit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblSelectRoomExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblSelectRoomExitMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 589, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCreateRoom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnRefresh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblSelectRoomExit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18))
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
                        .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblSelectRoomExit, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12))
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
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Project HG");
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
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        imgicon = new ImageIcon(MainFrame.class.getResource("./image/btn2.png"));
        img = imgicon.getImage().getScaledInstance(lblReady.getWidth(), lblReady.getHeight(), Image.SCALE_SMOOTH);
        lblReady.setIcon(new ImageIcon(img));
    }//GEN-LAST:event_lblReadyMouseEntered

    private void lblReadyMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblReadyMouseExited
        // 시작 버튼
        ImageIcon imgicon;
        Image img;
        imgicon = new ImageIcon(MainFrame.class.getResource("./image/btn.png"));
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
    }//GEN-LAST:event_btnWaitRoomExitMouseClicked

    private void WaitRoomTitleMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_WaitRoomTitleMouseDragged
        WaitRoom.setLocation(evt.getXOnScreen()-xx , evt.getYOnScreen()-yy);
    }//GEN-LAST:event_WaitRoomTitleMouseDragged

    private void WaitRoomTitleMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_WaitRoomTitleMousePressed
        xx = evt.getX();
        yy= evt.getY();
    }//GEN-LAST:event_WaitRoomTitleMousePressed

    private void btnInGameExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInGameExitMouseClicked
        InGame.hide();
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
    }//GEN-LAST:event_btnSignUpActionPerformed

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        UserDAO userDB = new UserDAO();
        if(userDB.login(txtLoginID.getText(), String.valueOf(txtLoginPW.getPassword()))){
            userinfo = userDB.getUserData(txtLoginID.getText());
            SelectRoom.setLocation(MainFrame.this.getLocation().x, MainFrame.this.getLocation().y);
            MainFrame.this.hide();
            showSelectRoom();
        }else{
            showMessageDialog(null, "아이디 또는 비밀번호가 올바르지 않습니다.");
        }
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
        //////////////////// 테스트용//////////////////////
        WaitRoom.setLocation(SelectRoom.getLocation().x, SelectRoom.getLocation().y);
        SelectRoom.hide();
        showWaitRoom();
        //////////////////////////////////////////////////
        /*
        MainFrame.this.setLocation(SelectRoom.getLocation().x, SelectRoom.getLocation().y);
        SelectRoom.hide();
        MainFrame.this.show();*/
    }//GEN-LAST:event_lblSelectRoomExitMouseClicked

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
    
    /////////////////////////////////////////////////////Sign Up////////////////////////////////////////////////////
    public void showSignUp(){
        SignUp.setSize(555, 592);
        SignUp.setLocation(MainFrame.this.getLocation().x+MainFrame.this.getSize().width, MainFrame.this.getLocation().y);
        SignUp.setResizable(false);
        SignUp.show();
        // 로고 이미지
        imgicon = new ImageIcon(MainFrame.class.getResource("./image/settings.png"));
        img = imgicon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        lbllogoSignUp.setIcon(new ImageIcon(img));
    }
    ///////////////////////////////////////////////////Select Room///////////////////////////////////////////////////
    public void showSelectRoom(){
        SelectRoom.setSize(947, 515);
        //SelectRoom.setLocation(MainFrame.this.getLocation().x, MainFrame.this.getLocation().y);
        SelectRoom.setResizable(false);
        SelectRoom.show();
        // 로고 이미지
        imgicon = new ImageIcon(MainFrame.class.getResource("./image/settings.png"));
        img = imgicon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        lbllogoSelectRoom.setIcon(new ImageIcon(img));
        // 나가기 이미지
        imgicon = new ImageIcon(MainFrame.class.getResource("./image/exit.png"));
        img = imgicon.getImage().getScaledInstance(lblSelectRoomExit.getWidth(), lblSelectRoomExit.getHeight(), Image.SCALE_SMOOTH);
        lblSelectRoomExit.setIcon(new ImageIcon(img));
        // 나의 프로필 이미지
        imgicon = new ImageIcon(MainFrame.class.getResource("./image/profile.png"));
        img = imgicon.getImage().getScaledInstance(lblMyProfileSelectRoom.getWidth(), lblMyProfileSelectRoom.getHeight(), Image.SCALE_SMOOTH);
        lblMyProfileSelectRoom.setIcon(new ImageIcon(img));
        // 유저 정보 세팅
        lblNickSelect.setText(userinfo.getNickname());
        lblPointSelect.setText("포인트 : "+userinfo.getPoint()+"P");
        lblMyWinLoseSelect.setText(userinfo.getWin()+"승 "+userinfo.getLose()+"패");
        //
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
        jTable1.getColumnModel().getColumn(0).setMaxWidth(50);
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTable1.getColumnModel().getColumn(1).setMaxWidth(350);
        jTable1.getColumnModel().getColumn(1).setPreferredWidth(350);
        jTable1.getColumnModel().getColumn(2).setMaxWidth(100);
        jTable1.getColumnModel().getColumn(2).setPreferredWidth(100);
        jTable1.getColumnModel().getColumn(3).setMaxWidth(100);
        jTable1.getColumnModel().getColumn(3).setPreferredWidth(100);
    }
    /////////////////////////////////////////////////////Wait Room/////////////////////////////////////////////////////
    public void showWaitRoom(){
        WaitRoom.setSize(962, 395);
        //WaitRoom.setLocation(MainFrame.this.getLocation().x, MainFrame.this.getLocation().y);
        WaitRoom.setResizable(false);
        WaitRoom.show();
        // 로고 이미지
        imgicon = new ImageIcon(MainFrame.class.getResource("./image/settings.png"));
        img = imgicon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        lbllogoWaitRoom.setIcon(new ImageIcon(img));
        // 시작 버튼
        imgicon = new ImageIcon(MainFrame.class.getResource("./image/btn.png"));
        img = imgicon.getImage().getScaledInstance(lblReady.getWidth(), lblReady.getHeight(), Image.SCALE_SMOOTH);
        lblReady.setIcon(new ImageIcon(img));
        // 나의 프로필 이미지
        imgicon = new ImageIcon(MainFrame.class.getResource("./image/profile.png"));
        img = imgicon.getImage().getScaledInstance(lblMyProfileInWait.getWidth(), lblMyProfileInWait.getHeight(), Image.SCALE_SMOOTH);
        lblMyProfileInWait.setIcon(new ImageIcon(img));
        // 준비 상태 이미지
        imgicon = new ImageIcon(MainFrame.class.getResource("./image/prepare.png"));
        img = imgicon.getImage().getScaledInstance(lblState1.getWidth(), lblState1.getHeight(), Image.SCALE_SMOOTH);
        lblState1.setIcon(new ImageIcon(img));
        img = imgicon.getImage().getScaledInstance(lblState1.getWidth(), lblState2.getHeight(), Image.SCALE_SMOOTH);
        lblState2.setIcon(new ImageIcon(img));
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
        imgicon = new ImageIcon(MainFrame.class.getResource("./image/settings.png"));
        img = imgicon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        lbllogoInGame.setIcon(new ImageIcon(img));
        // 왼쪽 상대(빨강) 카드
        imgicon = new ImageIcon(MainFrame.class.getResource("./image/red.png"));
        img = imgicon.getImage().getScaledInstance(lblRed.getWidth(), lblRed.getHeight(), Image.SCALE_SMOOTH);
        lblRed.setIcon(new ImageIcon(img));
        // 왼쪽 상대(빨강)가 클릭한 카드
        imgicon = new ImageIcon(MainFrame.class.getResource("./image/emptycard.png"));
        img = imgicon.getImage().getScaledInstance(lblRedClick.getWidth(), lblRedClick.getHeight(), Image.SCALE_SMOOTH);
        lblRedClick.setIcon(new ImageIcon(img));
        // 오른쪽 내(파랑) 카드
        imgicon = new ImageIcon(MainFrame.class.getResource("./image/blue.png"));
        img = imgicon.getImage().getScaledInstance(lblBlue.getWidth(), lblBlue.getHeight(), Image.SCALE_SMOOTH);
        lblBlue.setIcon(new ImageIcon(img));
        // 오른쪽 내(파랑)가 클릭한 카드
        imgicon = new ImageIcon(MainFrame.class.getResource("./image/emptycard.png"));
        img = imgicon.getImage().getScaledInstance(lblBlueClick.getWidth(), lblBlueClick.getHeight(), Image.SCALE_SMOOTH);
        lblBlueClick.setIcon(new ImageIcon(img));
        // 벨 이미지
        imgicon = new ImageIcon(MainFrame.class.getResource("./image/bell.png"));
        img = imgicon.getImage().getScaledInstance(lblBell.getWidth(), lblBell.getHeight(), Image.SCALE_SMOOTH);
        lblBell.setIcon(new ImageIcon(img));
        // 나가기 이미지
        imgicon = new ImageIcon(MainFrame.class.getResource("./image/exit.png"));
        img = imgicon.getImage().getScaledInstance(lblExit.getWidth(), lblExit.getHeight(), Image.SCALE_SMOOTH);
        lblExit.setIcon(new ImageIcon(img));
        // 프로필 이미지
        imgicon = new ImageIcon(MainFrame.class.getResource("./image/profile.png"));
        img = imgicon.getImage().getScaledInstance(lblProfile.getWidth(), lblProfile.getHeight(), Image.SCALE_SMOOTH);
        lblProfile.setIcon(new ImageIcon(img));
        // 나의 프로필 이미지
        imgicon = new ImageIcon(MainFrame.class.getResource("./image/profile.png"));
        img = imgicon.getImage().getScaledInstance(lblMyProfile.getWidth(), lblMyProfile.getHeight(), Image.SCALE_SMOOTH);
        lblMyProfile.setIcon(new ImageIcon(img));
        // 상대의 프로필 이미지
        imgicon = new ImageIcon(MainFrame.class.getResource("./image/profile.png"));
        img = imgicon.getImage().getScaledInstance(lblYourProfile.getWidth(), lblYourProfile.getHeight(), Image.SCALE_SMOOTH);
        lblYourProfile.setIcon(new ImageIcon(img));
        // 유저 정보 세팅
        lblMyNickInGame.setText(userinfo.getNickname());
        lblMyPointInGame.setText("포인트 : "+userinfo.getPoint()+"P");
        lblMyWinLoseInGame.setText(userinfo.getWin()+"승 "+userinfo.getLose()+"패");
    }
    
    public void GameStart(){
        allCount = 1200;
        allTask = new TimerTask(){
            @Override
            public void run() {
                if(allCount >= 0){
                    int minute = allCount / 60;
                    int sec = allCount % 60;
                    lblAllCount.setText(minute+"분 "+sec+"초");
                    allCount--;
                }else{AllTimer.cancel();}
            }
        };
        AllTimer.schedule(allTask, 0, 1000);
    }
    
    public void showMyturn(){
        LineBorder lb = new LineBorder(Color.RED, 2, true);
        pnlMy.setBorder(lb);
        lb = new LineBorder(Color.BLACK, 2, true);
        pnlYour.setBorder(lb);
    }
    
    public void showYourturn(){
        LineBorder lb = new LineBorder(Color.RED, 2, true);
        pnlYour.setBorder(lb);
        lb = new LineBorder(Color.BLACK, 2, true);
        pnlMy.setBorder(lb);
    }
    
    public void showBellturn(){
        LineBorder lb = new LineBorder(Color.BLACK, 2, true);
        pnlMy.setBorder(lb);
        pnlYour.setBorder(lb);
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
                }else{turnTimer.cancel();}
            }
        };
        turnTimer.schedule(turnTask, 0, 1000);
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFrame InGame;
    private javax.swing.JPanel InGameTitle;
    private javax.swing.JPanel MainTitle;
    private javax.swing.JFrame SelectRoom;
    private javax.swing.JPanel SelectRoomTitle;
    private javax.swing.JFrame SignUp;
    private javax.swing.JPanel SignUpTitle;
    private javax.swing.JFrame WaitRoom;
    private javax.swing.JPanel WaitRoomTitle;
    private javax.swing.JButton btnCreateRoom;
    private javax.swing.JButton btnIDcheck;
    private javax.swing.JLabel btnInGameExit;
    private javax.swing.JButton btnLogin;
    private javax.swing.JLabel btnMainExit;
    private javax.swing.JButton btnNicknameCheck;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JLabel btnSelectRoomExit;
    private javax.swing.JButton btnSignUp;
    private javax.swing.JLabel btnSignUpExit;
    private javax.swing.JLabel btnWaitRoomExit;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
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
    private javax.swing.JPanel jPanel2;
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
    private javax.swing.JLabel lblMyNickInGame;
    private javax.swing.JLabel lblMyNickWait;
    private javax.swing.JLabel lblMyNickname;
    private javax.swing.JLabel lblMyNickname1;
    private javax.swing.JLabel lblMyNickname2;
    private javax.swing.JLabel lblMyPage;
    private javax.swing.JLabel lblMyPage1;
    private javax.swing.JLabel lblMyPage2;
    private javax.swing.JLabel lblMyPointInGame;
    private javax.swing.JLabel lblMyPointWait;
    private javax.swing.JLabel lblMyProfile;
    private javax.swing.JLabel lblMyProfileInWait;
    private javax.swing.JLabel lblMyProfileSelectRoom;
    private javax.swing.JLabel lblMyWinLoseInGame;
    private javax.swing.JLabel lblMyWinLoseSelect;
    private javax.swing.JLabel lblMyWinLoseWait;
    private javax.swing.JLabel lblNickSelect;
    private javax.swing.JLabel lblPW;
    private javax.swing.JLabel lblPWCheck;
    private javax.swing.JLabel lblPWResult;
    private javax.swing.JLabel lblPointSelect;
    private javax.swing.JLabel lblProfile;
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
    private javax.swing.JLabel lblYourNickname1;
    private javax.swing.JLabel lblYourProfile;
    private javax.swing.JLabel lbllogoInGame;
    private javax.swing.JLabel lbllogoMain;
    private javax.swing.JLabel lbllogoSelectRoom;
    private javax.swing.JLabel lbllogoSignUp;
    private javax.swing.JLabel lbllogoWaitRoom;
    private javax.swing.JPanel pnlMy;
    private javax.swing.JPanel pnlYour;
    private javax.swing.JTextField txtChat;
    private javax.swing.JTextField txtLoginID;
    private javax.swing.JPasswordField txtLoginPW;
    private javax.swing.JPasswordField txtPW;
    private javax.swing.JPasswordField txtPWCheck;
    private javax.swing.JTextField txtSignUpID;
    private javax.swing.JTextField txtSignUpNickname;
    // End of variables declaration//GEN-END:variables
}
