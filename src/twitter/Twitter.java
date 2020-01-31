
package twitter;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Saeed
 */
public class Twitter extends JFrame{
    public static User[] user = new User[20];
    public static int numberOfUsers = 0;
    public static int thisUserIndex = -1;
    public static int targetUserIndex = -1;
    public static Tweet[] tweets = new Tweet[100];
    public static int numOfTweets = 0;
   
   
      
    public static void createAccount(String name, String userName, String password, String gender, String bio ){
        user[numberOfUsers] = new User(name, userName, password, gender, bio);
        numberOfUsers++;
    }
    
    public static int nameSearch(String name){
        for(int i=0; i<numberOfUsers; i++){
            if(user[i].name.equals(name)) return i;
        }
        return -1;
    }
    public static int searchUser(String userName){
        for(int i=0; i < numberOfUsers; i++){
            if((user[i].userName).equals(userName)) return i;  
        }
        return -1;
    }
    public static int searchUser(String userName, String password){
        for(int i=0; i < numberOfUsers; i++){
            if((user[i].userName).equals(userName) && (user[i].password).equals(password)) return i;
        }
        return -1;
    }
    
    
    public static void main(String[] args) {
       SignIn signIn = new SignIn();
       signIn.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       signIn.setSize(800,600);
       signIn.setVisible(true);
       
    } 
}
