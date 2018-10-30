package Lobby;

import Login.FormLogin;
import User.User;
import User.UserDao;
import javax.swing.table.DefaultTableModel;

public class LobbyService {
    User user;
    UserDao dao = new UserDao();
    
    public void logout(){
        dao.updateLogout(user);
    }
    public DefaultTableModel getRoom(){
        return dao.roomlist();
    }
}
