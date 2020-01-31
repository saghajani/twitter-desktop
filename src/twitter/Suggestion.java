
package twitter;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.plaf.basic.BasicOptionPaneUI.ButtonAreaLayout;

/**
 *
 * @author Saeed
 */
public class Suggestion extends JFrame {
    JButton b;
    
    public Suggestion(final int Index){
        setLayout(new BorderLayout(20, 20));
        b = new JButton(Twitter.user[Index].name+" / "+Twitter.user[Index].userName+" / "+Twitter.user[Index].bio);
        b.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    //throw new UnsupportedOperationException("Not supported yet.");
                    setVisible(false);
                    Twitter.targetUserIndex = Index;
                    Profile targetProfile = new Profile();
                    // targetProfile.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    targetProfile.setBounds(100, 50, 800, 670);
                    targetProfile.setVisible(true);
                    
                }
            });
            add(b);
    }
}
//    JButton b1, b2, b3;
//    //JButton button;
//    
//    public Suggestion(final int s1, final int s2, final int s3){
//        setLayout(new GridLayout(1, 3, 30, 30));
//        
//        if(s1 != -1){
//            b1 = new JButton(Twitter.user[s1].name+" / "+Twitter.user[s1].userName+" / "+Twitter.user[s1].bio);
//            b1.addActionListener(new ActionListener() {
//
//                @Override
//                public void actionPerformed(ActionEvent e) {
//                    //throw new UnsupportedOperationException("Not supported yet.");
//                    Twitter.targetUserIndex = s1;
//                    Profile targetProfile = new Profile();
//                    // targetProfile.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//                    targetProfile.setBounds(100, 50, 800, 670);
//                    targetProfile.setVisible(true);
//                    
//                }
//            });
//            add(b1);
//        }
//        
//        if(s2 != s1){
//        if(s2 != -1){
//            b2 = new JButton(Twitter.user[s2].name+" / "+Twitter.user[s2].userName+" / "+Twitter.user[s2].bio);
//            b2.addActionListener(new ActionListener() {
//
//                @Override
//                public void actionPerformed(ActionEvent e) {
//                    //throw new UnsupportedOperationException("Not supported yet.");
//                    Twitter.targetUserIndex = s2;
//                    Profile targetProfile = new Profile();
//                    // targetProfile.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//                    targetProfile.setBounds(100, 50, 800, 670);
//                    targetProfile.setVisible(true);
//                    
//                }
//            });            
//            add(b2);
//        }
//        }
//        if((s3 != s1) && (s3 != s2)){
//        if(s3 != -1){
//            b3 = new JButton(Twitter.user[s3].name+" / "+Twitter.user[s3].userName+" / "+Twitter.user[s3].bio);
//            b3.addActionListener(new ActionListener() {
//
//                @Override
//                public void actionPerformed(ActionEvent e) {
//                    //throw new UnsupportedOperationException("Not supported yet.");
//                    Twitter.targetUserIndex = s3;
//                    Profile targetProfile = new Profile();
//                    // targetProfile.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//                    targetProfile.setBounds(100, 50, 800, 670);
//                    targetProfile.setVisible(true);
//                    
//                }
//            });            
//            add(b3);
//        }
//        }
//        
//    }
//    
    

