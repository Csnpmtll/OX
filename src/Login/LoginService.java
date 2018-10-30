/**
 *
 * @author Mai
 */
package Login;

import static Connect.ConnectDB.connectDB;
import Lobby.FormLobby;

import User.UserDao;
import User.User;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import javax.swing.JOptionPane;

public class LoginService {

    public static User user;
    UserDao dao;

    public boolean checkInput(String username,String pwd) {
        if (username.length() >= 6 && username.length() <= 16) {
            if (pwd.length() >= 6 && pwd.length() <= 16) {
                return true;
            }else{
                JOptionPane.showMessageDialog(null, "กรุณากรอกข้อมูลให้ถูกต้อง");
                return false;
            }
        }else{
            JOptionPane.showMessageDialog(null, "กรุณากรอกข้อมูลให้ถูกต้อง");
            return false;
        }
        
    }

    public boolean checkLogin(String username,String pwd) {
        boolean flag = false;
        try {
//            MongoClientURI uri = new MongoClientURI("mongodb://admin:admin1234@ds251622.mlab.com:51622/oxgame");
//            MongoClient mongoClient = new MongoClient(uri);
            dao = new UserDao();
            DB database = connectDB();   
            DBCollection collection = database.getCollection("user");
            BasicDBObject query = new BasicDBObject();
            query.put("username", username);
            query.put("password", pwd);
            int num = collection.find(query).count();
            System.out.println(num);
            if (num > 0) {
                flag = true;
                user = dao.getUser(username,pwd);
                dao.updateLogin(user);
                FormLobby form = new FormLobby();
                form.show();
            } else {
                JOptionPane.showMessageDialog(null, "ไม่มีUsernameนี้อยู่ในระบบหรือPasswordไม่ถูกต้อง");
                flag = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    
    
}
