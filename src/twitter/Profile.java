
package twitter;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

/**
 *
 * @author Saeed
 */
public class Profile extends JFrame {
    JPanel bioPanel;
    JLabel nameLabel;
    JLabel userLabel;
    JLabel bioLabel;
    JLabel genderLabel;
    JButton followButton;
    JLabel bioTweetLabel;
    JLabel bioFollowingLabel;
    JLabel bioFollowerLabel;
    JPanel listPanel;
    JLabel listTweetLabel;
    JLabel listFollowingLabel;
    JLabel listFollowerLabel;
    JPanel tweetPanel;
    
    public Profile(){
        super("Profile");
        setLayout(new FlowLayout());
        
        bioPanel = new JPanel();
        nameLabel = new JLabel();
        userLabel = new JLabel();
        bioLabel = new JLabel();
        genderLabel = new JLabel();
        bioTweetLabel = new JLabel();
        bioFollowingLabel = new JLabel();
        bioFollowerLabel = new JLabel();
        followButton = new JButton();
        listPanel = new JPanel();
        listTweetLabel = new JLabel();
        listFollowingLabel = new JLabel();
        listFollowerLabel = new JLabel();
        tweetPanel = new JPanel();

      //  setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        if(Twitter.user[Twitter.targetUserIndex].profImage != null){
            bioPanel= new JPanel(){
               public void paint(Graphics g){
               super.paint(g);
               g.drawImage(Twitter.user[Twitter.targetUserIndex].profImage.getImage(), 10, 10, 100, 128,this);
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

        nameLabel.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        nameLabel.setText(Twitter.user[Twitter.targetUserIndex].name);

        userLabel.setText(Twitter.user[Twitter.targetUserIndex].userName);

        bioLabel.setText(Twitter.user[Twitter.targetUserIndex].bio);
        
        genderLabel.setText(Twitter.user[Twitter.targetUserIndex].gender);

        bioTweetLabel.setText(Twitter.user[Twitter.targetUserIndex].numOfTweets+" tweets");

        bioFollowingLabel.setText(Twitter.user[Twitter.targetUserIndex].numOfFollowings+" followings");

        bioFollowerLabel.setText(Twitter.user[Twitter.targetUserIndex].numOfFollowers+" followers");

        followButton.setText("Follow");
        followButton.addActionListener(new  ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
               // throw new UnsupportedOperationException("Not supported yet.");
                if(!(Twitter.user[Twitter.thisUserIndex].name.equals(Twitter.user[Twitter.targetUserIndex].name))){
                    boolean followable = true;
                    for(int i=0; i<Twitter.user[Twitter.thisUserIndex].numOfFollowings; i++){
                        if(Twitter.user[Twitter.thisUserIndex].followings[i].equals(Twitter.user[Twitter.targetUserIndex].name)){
                            followable = false;
                            break;
                        }
                    }
                    for(int i=0; i<Twitter.user[Twitter.thisUserIndex].numOfFollowers; i++){
                        if(Twitter.user[Twitter.thisUserIndex].followers[i].equals(Twitter.user[Twitter.targetUserIndex].name)){
                            followable = false;
                            break;
                        }
                    }
                    if(followable){
                       Twitter.user[Twitter.thisUserIndex].followings[Twitter.user[Twitter.thisUserIndex].numOfFollowings] = Twitter.user[Twitter.targetUserIndex].name;
                       (Twitter.user[Twitter.thisUserIndex].numOfFollowings)++;
                
                       Twitter.user[Twitter.targetUserIndex].followers[Twitter.user[Twitter.targetUserIndex].numOfFollowers] = Twitter.user[Twitter.thisUserIndex].name;
                       (Twitter.user[Twitter.targetUserIndex].numOfFollowers)++;
                
                       JOptionPane.showMessageDialog(Profile.this, "This person has been added to your followings.", "add following", JOptionPane.INFORMATION_MESSAGE);
                       }
                    else
                        JOptionPane.showMessageDialog(Profile.this, "This person is one of your Followings or Followers!", "Error!", JOptionPane.ERROR_MESSAGE);
                }
                else
                    JOptionPane.showMessageDialog(Profile.this, "This is Yourself!", "Error", JOptionPane.ERROR_MESSAGE);
                }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(bioPanel);
        bioPanel.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(bioFollowerLabel))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(154, 154, 154)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(userLabel)
                                .addComponent(bioLabel))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 308, Short.MAX_VALUE)
                                    .addComponent(bioTweetLabel))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(bioFollowingLabel))))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(130, 130, 130)
                            .addComponent(nameLabel)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 272, Short.MAX_VALUE)
                            .addComponent(followButton))))
                .addGap(39, 39, 39))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(nameLabel)
                        .addGap(18, 18, 18)
                        .addComponent(userLabel))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(followButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bioTweetLabel)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bioLabel)
                    .addComponent(bioFollowingLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bioFollowerLabel)
                .addContainerGap(46, Short.MAX_VALUE))
        );
        bioPanel.add(genderLabel);
        genderLabel.setBounds(160, 115, 50, 20);

        listPanel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        listTweetLabel.setText("Tweets");

        listFollowingLabel.setText("Followings");
        listFollowingLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        listFollowingLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt){
                JFrame followingsFrame = new JFrame("Followings");
                GridLayout gridLayout = new GridLayout(/*Twitter.user[Twitter.targetUserIndex].numOfFollowings*/20, 1, 20, 20);
                followingsFrame.setLayout(gridLayout);
                JLabel[] followingsLabel =new JLabel[Twitter.user[Twitter.targetUserIndex].numOfFollowings];
        
                for(int i=0; i< (Twitter.user[Twitter.targetUserIndex].numOfFollowings); i++){
                    followingsLabel[i] = new JLabel((i+1)+"- "+Twitter.user[Twitter.targetUserIndex].followings[i]);
                    followingsFrame.add(followingsLabel[i]);
                }
                followingsFrame.setBounds(200, 100, 500, 600);
                followingsFrame.setVisible(true);
                
            }
        });        

        listFollowerLabel.setText("Followers");
        listFollowerLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        listFollowerLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt){
                JFrame followersFrame = new JFrame("Followers");
                GridLayout gridLayout = new GridLayout(/*Twitter.user[Twitter.targetUserIndex].numOfFollowers*/20, 1, 20, 20);
                followersFrame.setLayout(gridLayout);
                JLabel[] followersLabel =new JLabel[Twitter.user[Twitter.targetUserIndex].numOfFollowers];
        
                for(int i=0; i< (Twitter.user[Twitter.targetUserIndex].numOfFollowers); i++){
                    followersLabel[i] = new JLabel((i+1)+"- "+Twitter.user[Twitter.targetUserIndex].followers[i]);
                    followersFrame.add(followersLabel[i]);
                }
                followersFrame.setBounds(200, 100, 500, 600);
                followersFrame.setVisible(true);
                
            }
        });        


        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(listPanel);
        listPanel.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(listTweetLabel)
                    .addComponent(listFollowingLabel)
                    .addComponent(listFollowerLabel))
                .addContainerGap(127, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(listTweetLabel)
                .addGap(33, 33, 33)
                .addComponent(listFollowingLabel)
                .addGap(28, 28, 28)
                .addComponent(listFollowerLabel)
                .addContainerGap(47, Short.MAX_VALUE))
        );

        tweetPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Tweets"));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(tweetPanel);
        tweetPanel.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 376, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 195, Short.MAX_VALUE)
        );
        
        GridLayout gridLayout = new GridLayout(Twitter.user[Twitter.targetUserIndex].numOfTweets, 1);
        tweetPanel.setLayout(gridLayout);
        if(Twitter.user[Twitter.targetUserIndex].numOfTweets > 0){
            for(int i=Twitter.user[Twitter.targetUserIndex].numOfTweets; i>0; i--)
            tweetPanel.add(new Tweet(Twitter.user[Twitter.targetUserIndex].name , Twitter.user[Twitter.targetUserIndex].tweet[i-1]));
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(listPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tweetPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(bioPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bioPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tweetPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(listPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }
    
}
