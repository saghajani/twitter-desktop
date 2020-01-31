
package twitter;

import javax.swing.*;

/**
 *
 * @author Saeed
 */
public class Tweet extends JPanel {
    JLabel writerLabel;
    JTextArea tweetArea;
    JScrollPane jScrollPane1;
    
    public Tweet(String writer, String tweet){
        
        writerLabel = new JLabel();
        jScrollPane1 = new JScrollPane();
        tweetArea = new JTextArea(tweet);
        tweetArea.setEditable(false);

        writerLabel.setText(writer);

        tweetArea.setColumns(20);
        tweetArea.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        tweetArea.setRows(5);
        jScrollPane1.setViewportView(tweetArea);
        tweetArea.setLineWrap(true);
        

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                    .addComponent(writerLabel))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(writerLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
                .addContainerGap())
        );
        
    }
    
    
}
