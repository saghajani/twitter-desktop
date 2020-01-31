
package twitter;

import javax.swing.ImageIcon;

/**
 *
 * @author Saeed
 */
public class User {
    
    public String name;
    public String userName;
    public String password;
    public String gender;//male or female
    public String bio;
    public String[] followers;
    public String[] followings;
    public String[] tweet;
    public int numOfTweets = 0;
    public int numOfFollowings = 0;
    public int numOfFollowers = 0;
    public ImageIcon profImage;
    
    public User(String name, String userName, String password, String gender, String bio){
        this.name = name;
        this.userName = userName;
        this.password = password;
        this.gender = gender;
        this.bio = bio;
        followers = new String[15];
        followings = new String[15];
        tweet = new String[20];        
    }
    
}
