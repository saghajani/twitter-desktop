
package twitter;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;
import java.io.File;
import javax.swing.*;

/**
 *
 * @author Saeed
 */
public class UserAccount extends JFrame{
    JTabbedPane accountTabs;
    JPanel homePanel;
    JPanel comPanel;
    JTextField searchField;
    JButton searchButton;    
    JLabel tweetLabel;
    JLabel followingLabel;
    JLabel followerLabel;
    JLabel comLabel;
    JScrollPane jScrollPane1;
    JTextArea comArea;
    JButton tweetButton;
    JButton signOutButton;
    JPanel tweetPanel;
    JPanel profilePanel;
    JPanel bioPanel;
    JButton editButton;
    JLabel bioTweetLabel;
    JLabel bioFollowingLabel;
    JLabel bioFollowerLabel;
    JLabel bioNameLabel;
    JLabel bioUserLabel;
    JLabel bioBioLabel;
    JPanel profSignOutPanel;
    JLabel profTweetLabel;
    JLabel profFollowingLabel;
    JLabel profFollowerLabel;
    JButton profSignOutButton;
    JPanel profTweetPanel;
    
    public UserAccount(){
        super("User Account");
        setLayout(new FlowLayout());
        
        accountTabs = new JTabbedPane();
        homePanel = new JPanel();//1
        comPanel = new JPanel();//4
        searchField = new JTextField();
        searchButton = new JButton();        
        tweetLabel = new JLabel();//1
        followingLabel = new JLabel();
        followerLabel = new JLabel();
        comLabel = new JLabel();
        jScrollPane1 = new JScrollPane();
        comArea = new JTextArea();
        tweetButton = new JButton();
        signOutButton = new JButton();
        tweetPanel = new JPanel();
        profilePanel = new JPanel();
        bioPanel = new JPanel();
        editButton = new JButton();
        bioTweetLabel = new JLabel();
        bioFollowingLabel = new JLabel();
        bioFollowerLabel = new JLabel();
        bioNameLabel = new JLabel();
        bioUserLabel = new JLabel();
        bioBioLabel = new JLabel();
        profSignOutPanel = new JPanel();
        profTweetLabel = new JLabel();
        profFollowingLabel = new JLabel();
        profFollowerLabel = new JLabel();
        profSignOutButton = new JButton();
        profTweetPanel = new JPanel();


        //searchField.setText("Enter Username or Name");
        
        comPanel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        tweetLabel.setText("Tweets: "+Twitter.user[Twitter.thisUserIndex].numOfTweets);

        followingLabel.setText("Followings: "+Twitter.user[Twitter.thisUserIndex].numOfFollowings);

        followerLabel.setText("Followers: "+Twitter.user[Twitter.thisUserIndex].numOfFollowers);

        comLabel.setText("Compose new Tweet:");

        comArea.setColumns(20);
        comArea.setRows(5);
        jScrollPane1.setViewportView(comArea);
        comArea.setLineWrap(true);


        searchButton.setText("Search");
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if(searchField.getText().isEmpty()) 
                    JOptionPane.showMessageDialog(comPanel, "Who are you looking for?", "Error!", JOptionPane.ERROR_MESSAGE);
                else if(Twitter.searchUser(searchField.getText()) == -1)//first if
                    if(Twitter.nameSearch(searchField.getText()) == -1)//second if
                    JOptionPane.showMessageDialog(comPanel, "This User not Founds!", "Error!", JOptionPane.ERROR_MESSAGE);
                    else{//second else
                        Twitter.targetUserIndex = Twitter.nameSearch(searchField.getText());
                        Profile targetProfile = new Profile();
                       // targetProfile.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        targetProfile.setBounds(100, 50, 800, 670);
                        targetProfile.setVisible(true);
                    }
                else{//first else
                    Twitter.targetUserIndex = Twitter.searchUser(searchField.getText());
                    Profile targetProfile = new Profile();
                    //targetProfile.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    targetProfile.setBounds(100, 50, 800, 670);
                    targetProfile.setVisible(true);
                }
          
                    
                
                
            }
        });

        tweetButton.setText("tweet");
        tweetButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                //throw new UnsupportedOperationException("Not supported yet.");
                if(comArea.getText().isEmpty())
                    JOptionPane.showMessageDialog(UserAccount.this, "Tweet Something!", "Empty Tweet!", JOptionPane.ERROR_MESSAGE);
                else{
                    Twitter.tweets[Twitter.numOfTweets] = new Tweet(Twitter.user[Twitter.thisUserIndex].name, comArea.getText());
                    Twitter.numOfTweets++;
                    Twitter.user[Twitter.thisUserIndex].tweet[Twitter.user[Twitter.thisUserIndex].numOfTweets] = comArea.getText();
                    Twitter.user[Twitter.thisUserIndex].numOfTweets++;
                    JOptionPane.showMessageDialog(UserAccount.this, "Tweeting done and after you Sign In again It'll be added!", "Tweet", JOptionPane.INFORMATION_MESSAGE);
                    comArea.setText("");
                    //tweetPanel.repaint();

                }
            }
        });

        signOutButton.setText("Sign Out");
        signOutButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                //throw new UnsupportedOperationException("Not supported yet.");
                if(JOptionPane.showConfirmDialog(UserAccount.this, "Are you sure to Sign Out?", "Sign Out!", JOptionPane.OK_CANCEL_OPTION)==JOptionPane.OK_OPTION){
                setVisible(false);
                SignIn signIn = new SignIn();
                signIn.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                signIn.setSize(800, 700);
                signIn.setVisible(true);
                }
            }
        });
        
        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(comPanel);
        comPanel.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(comLabel)
                        .addContainerGap())
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addComponent(searchButton)
                            .addContainerGap(180, Short.MAX_VALUE))
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                            .addGap(89, 89, 89))
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addComponent(followerLabel)
                            .addContainerGap(193, Short.MAX_VALUE))
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addComponent(followingLabel)
                            .addContainerGap(189, Short.MAX_VALUE))
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addComponent(tweetLabel)
                            .addContainerGap(203, Short.MAX_VALUE))
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addComponent(tweetButton)
                            .addContainerGap(184, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                            .addComponent(signOutButton)
                            .addGap(21, 21, 21))
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(88, Short.MAX_VALUE)))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchButton)
                .addGap(13, 13, 13)
                .addComponent(tweetLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(followingLabel)
                .addGap(15, 15, 15)
                .addComponent(followerLabel)
                .addGap(18, 18, 18)
                .addComponent(comLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(tweetButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(signOutButton)
                .addGap(20, 20, 20))
        );

        tweetPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Tweets"));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(tweetPanel);
        tweetPanel.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 373, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 331, Short.MAX_VALUE)
        );
        
        GridLayout gridLayout = new GridLayout(Twitter.numOfTweets*2, 1);
        tweetPanel.setLayout(gridLayout);
        if(Twitter.numOfTweets > 0){
            for(int i =(Twitter.numOfTweets); i>0; i--){
                if(Twitter.tweets[i-1].writerLabel.getText().equals(Twitter.user[Twitter.thisUserIndex].name))
                    tweetPanel.add(Twitter.tweets[i-1]);
                else{
                    for(int j=0; j<Twitter.user[Twitter.thisUserIndex].numOfFollowings; j++){
                        if(Twitter.tweets[i-1].writerLabel.getText().equals(Twitter.user[Twitter.thisUserIndex].followings[j]))
                            tweetPanel.add(Twitter.tweets[i-1]);
                    }//end of for
                }//end of else
            }//end of for
        }//end of if
        
        

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(homePanel);
        homePanel.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(comPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(tweetPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tweetPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        accountTabs.addTab("Home", homePanel);
 
 //Creating Profile Image
        
        if(Twitter.user[Twitter.thisUserIndex].profImage != null){
            bioPanel = new JPanel(){
               public void paint(Graphics g){
               super.paint(g);
               g.drawImage(Twitter.user[Twitter.thisUserIndex].profImage.getImage(), 10, 10, 100, 128,this);
               }
           };
        }
        else{
            bioPanel = new JPanel(){
                public void paint(Graphics g){
                    super.paint(g);
                    g.drawImage(new ImageIcon("egg.png").getImage(), 10, 10, 100, 128, this);
                }
            };
        }
        bioPanel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        
        editButton.setText("Edit Profile");
        editButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                //throw new UnsupportedOperationException("Not supported yet.");
                EditProfile editProfile = new EditProfile();
                editProfile.setBounds(100, 50, 600, 600);
                editProfile.setVisible(true);
            }
        });

        bioTweetLabel.setText(Twitter.user[Twitter.thisUserIndex].numOfTweets+" tweets");

        bioFollowingLabel.setText(Twitter.user[Twitter.thisUserIndex].numOfFollowings+" followings");

        bioFollowerLabel.setText(Twitter.user[Twitter.thisUserIndex].numOfFollowers+" followers");

        bioNameLabel.setFont(new java.awt.Font("Tahoma", 0, 16));
        bioNameLabel.setText(Twitter.user[Twitter.thisUserIndex].name);

        bioUserLabel.setText(Twitter.user[Twitter.thisUserIndex].userName);

        bioBioLabel.setText(Twitter.user[Twitter.thisUserIndex].bio);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(bioPanel);
        bioPanel.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(115, 115, 115)
                        .addComponent(bioNameLabel))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(129, 129, 129)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bioBioLabel)
                            .addComponent(bioUserLabel))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 316, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bioTweetLabel)
                            .addComponent(bioFollowerLabel)
                            .addComponent(bioFollowingLabel))
                        .addGap(60, 60, 60))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(editButton)
                        .addGap(47, 47, 47))))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(editButton)
                    .addComponent(bioNameLabel))
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(bioTweetLabel)
                        .addGap(13, 13, 13)
                        .addComponent(bioFollowingLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bioFollowerLabel))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(bioUserLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bioBioLabel)))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        profSignOutPanel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        profTweetLabel.setText("Tweets");
        
        profFollowingLabel.setText("Followings");
        profFollowingLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        profFollowingLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt){
                JFrame followingsFrame = new JFrame("Followings");
                final GridLayout gridLayout = new GridLayout(/*Twitter.user[Twitter.thisUserIndex].numOfFollowings*/20, 2, 200, 5);
                followingsFrame.setLayout(gridLayout);
                final JLabel[] followingsLabel =new JLabel[Twitter.user[Twitter.thisUserIndex].numOfFollowings];
                final JButton[] unFollow = new JButton[Twitter.user[Twitter.thisUserIndex].numOfFollowings];
                for(int i=0; i< (Twitter.user[Twitter.thisUserIndex].numOfFollowings); i++){
                    followingsLabel[i] = new JLabel((i+1)+"- "+Twitter.user[Twitter.thisUserIndex].followings[i]);
                    followingsFrame.add(followingsLabel[i]);
                    unFollow[i] = new JButton("UnFollow");
                    final int t = i;
                    unFollow[i].addActionListener(new ActionListener() {

                        @Override
                        public void actionPerformed(ActionEvent e) {
                            //throw new UnsupportedOperationException("Not supported yet.");
                            
                            gridLayout.removeLayoutComponent(followingsLabel[t]);
                            gridLayout.removeLayoutComponent(unFollow[t]);
                            for(int i=t; i<(Twitter.user[Twitter.thisUserIndex].numOfFollowings)-1; i++){
                                Twitter.user[Twitter.thisUserIndex].followings[i] = Twitter.user[Twitter.thisUserIndex].followings[i+1];
                            }
                            (Twitter.user[Twitter.thisUserIndex].numOfFollowings)--;
                            
                            Twitter.targetUserIndex = Twitter.nameSearch(Twitter.user[Twitter.thisUserIndex].followings[t]);  
                            for(int s=0; s<Twitter.user[Twitter.targetUserIndex].numOfFollowers; s++){
                                if((Twitter.user[Twitter.targetUserIndex].followers[s]).equals(Twitter.user[Twitter.thisUserIndex].name)){
                                    for(int g=s; g<(Twitter.user[Twitter.targetUserIndex].numOfFollowers)-1; g++)
                                        Twitter.user[Twitter.targetUserIndex].followers[g] = Twitter.user[Twitter.targetUserIndex].followers[g+1];
                                    
                                    break;
                                }//end of if       
                            }//end of for     
                            (Twitter.user[Twitter.targetUserIndex].numOfFollowers)--;
                            JOptionPane.showMessageDialog(UserAccount.this, "This person has been removed from your followings.", "remove following!", JOptionPane.INFORMATION_MESSAGE);
                            
                        }
                    });
                    followingsFrame.add(unFollow[i]);
                }
                followingsFrame.setBounds(200, 100, 500, 600);
                followingsFrame.setVisible(true);
                
            }
        });
        


        profFollowerLabel.setText("Followers");
        profFollowerLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        profFollowerLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt){
                JFrame followersFrame = new JFrame("Followers");
                final GridLayout gridLayout = new GridLayout(/*Twitter.user[Twitter.thisUserIndex].numOfFollowers*/20, 2, 200, 5);
                followersFrame.setLayout(gridLayout);
                final JLabel[] followersLabel = new JLabel[Twitter.user[Twitter.thisUserIndex].numOfFollowers];
                final JButton[] block = new JButton[Twitter.user[Twitter.thisUserIndex].numOfFollowers];
                for(int i=0; i< (Twitter.user[Twitter.thisUserIndex].numOfFollowers); i++){
                    followersLabel[i] = new JLabel((i+1)+"- "+Twitter.user[Twitter.thisUserIndex].followers[i]);
                    followersFrame.add(followersLabel[i]);
                    block[i] = new JButton("Block");
                    final int t = i; 
                    block[i].addActionListener(new ActionListener() {

                        @Override
                        public void actionPerformed(ActionEvent e) {
                            //throw new UnsupportedOperationException("Not supported yet.");
                            gridLayout.removeLayoutComponent(followersLabel[t]);
                            gridLayout.removeLayoutComponent(block[t]);
                            for(int i=t; i<(Twitter.user[Twitter.thisUserIndex].numOfFollowers)-1; i++){
                                Twitter.user[Twitter.thisUserIndex].followers[i] = Twitter.user[Twitter.thisUserIndex].followers[i+1];
                            }
                            (Twitter.user[Twitter.thisUserIndex].numOfFollowers)--;
                            
                            Twitter.targetUserIndex = Twitter.nameSearch(Twitter.user[Twitter.thisUserIndex].followers[t]);  
                            for(int s=0; s<Twitter.user[Twitter.targetUserIndex].numOfFollowings; s++){
                                if((Twitter.user[Twitter.targetUserIndex].followings[s]).equals(Twitter.user[Twitter.thisUserIndex].name)){
                                    for(int g=s; g<(Twitter.user[Twitter.targetUserIndex].numOfFollowings)-1; g++)
                                        Twitter.user[Twitter.targetUserIndex].followings[g] = Twitter.user[Twitter.targetUserIndex].followings[g+1];
                                    
                                    break;
                                }//end of if       
                            }//end of for     
                            (Twitter.user[Twitter.targetUserIndex].numOfFollowings)--;
                            JOptionPane.showMessageDialog(UserAccount.this, "This person has been blocked from your followers.", "block follower!", JOptionPane.INFORMATION_MESSAGE);
                            
                        }
                    });
                    followersFrame.add(block[i]);
                }
                followersFrame.setBounds(200, 100, 500, 600);
                followersFrame.setVisible(true);
                
            }
        });


        profSignOutButton.setText("Sign Out");
        profSignOutButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                //throw new UnsupportedOperationException("Not supported yet.");
                if(JOptionPane.showConfirmDialog(UserAccount.this, "Are you sure to Sign Out?", "Sign Out!", JOptionPane.OK_CANCEL_OPTION)==JOptionPane.OK_OPTION){
                setVisible(false);
                SignIn signIn = new SignIn();
                signIn.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                signIn.setSize(800, 700);
                signIn.setVisible(true);
                }
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(profSignOutPanel);
        profSignOutPanel.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(profSignOutButton)
                    .addComponent(profFollowerLabel)
                    .addComponent(profFollowingLabel)
                    .addComponent(profTweetLabel))
                .addContainerGap(128, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(profTweetLabel)
                .addGap(31, 31, 31)
                .addComponent(profFollowingLabel)
                .addGap(29, 29, 29)
                .addComponent(profFollowerLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(profSignOutButton)
                .addContainerGap())
        );

        
        profTweetPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Tweets"));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(profTweetPanel);
        profTweetPanel.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 395, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 379, Short.MAX_VALUE)
        );
        
        GridLayout gridLayout2 = new GridLayout(Twitter.user[Twitter.thisUserIndex].numOfTweets*2, 1);
        profTweetPanel.setLayout(gridLayout2);
        if(Twitter.user[Twitter.thisUserIndex].numOfTweets > 0){
            for(int i=Twitter.user[Twitter.thisUserIndex].numOfTweets; i>0; i--)
            profTweetPanel.add(new Tweet(Twitter.user[Twitter.thisUserIndex].name , Twitter.user[Twitter.thisUserIndex].tweet[i-1]));
        }
         
        
//        MouseMotionListener doScrollRectToVisible = new MouseMotionAdapter() {           
//            public void mouseDragged(MouseEvent e) {
//            Rectangle r = new Rectangle(e.getX(), e.getY(), 100, 100);
//            ((JPanel)e.getSource()).scrollRectToVisible(r);
//            }
//       };
       //JScrollPane js2 = new JScrollPane();
       //profTweetPanel.addMouseMotionListener(doScrollRectToVisible);
       //profTweetPanel.setAutoscrolls(true);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(profilePanel);
        profilePanel.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(bioPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addComponent(profSignOutPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(profTweetPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bioPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(profSignOutPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(profTweetPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
        );
       
        accountTabs.addTab("Profile", profilePanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(accountTabs, javax.swing.GroupLayout.DEFAULT_SIZE, 679, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(accountTabs, javax.swing.GroupLayout.DEFAULT_SIZE, 408, Short.MAX_VALUE)
        );

        pack();        
    }
    
    
}
