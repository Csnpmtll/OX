/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Register;
import User.User;
import User.UserDao;
import javax.swing.JOptionPane;

/**
 *
 * @author Boss
 */
public class RegisterService {
    UserDao dao=new UserDao();
    public boolean checkUsernameLength(String user) {
        if (user.length() < 6) {
            JOptionPane.showMessageDialog(null, "Username must have 6 characters or more.");
            return false;
        }else{
            return true;
        }
    }
    public boolean checkPasswordLength(String pwd) {
        if (pwd.length() < 6) {
            JOptionPane.showMessageDialog(null, "Password must have 6 characters or more.");
            return false;
        }else{ 
            return true;
        }
    }
    public boolean PasswordVerify(String pwd1,String pwd2) {
        if (pwd1.equals(pwd2)) {
            return true;
        }else{
            JOptionPane.showMessageDialog(null, "Password must be the same.");
            return false;
        }
    }
    public boolean isNameExist(String name) {
        if(dao.getUserByUsername(name)==true){
            JOptionPane.showMessageDialog(null, "This name is already exist.");
            return true;
        }else{
            return false;
        }
    }
    public boolean isUsernameExist(String user) {
       if(dao.getUserByName(user)==true){
           JOptionPane.showMessageDialog(null, "This username is already exist.");
           return true;
       }else{
           return false;
       }
    }
    public void putData(User user){
        if(checkUsernameLength(user.getUsername()) && isUsernameExist(user.getUsername())==false && checkPasswordLength(user.getPassword()) &&
           PasswordVerify(user.getPassword(),user.getConfirmPassword()) &&  isNameExist(user.getName())==false){
            dao.insert(user);
        }
    }
}
