package User;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Boss
 */
public class User {
    private static String username;
    private static String password;
    private static String confirmpassword;
    private static String name;
    private static Byte[] image;
    private static int win;
    private static int lose;
    private static int draw;
    private static int match;
    public User(String user,String pwd,String confirmPwd,String name,int win,int lose,int draw,int match){
        this.username=user;
        this.password=pwd;
        this.confirmpassword=confirmPwd;
        this.name=name;
        this.win=win;
        this.lose=lose;
        this.draw=draw;
        this.match=match;
    }
    public String getUsername(){
        return username;
    }public String getName(){
        return name;
    }public String getPassword(){
        return password;
    }public String getConfirmPassword(){
        return confirmpassword;
    }public int getWin(){
        return win;
    }public int getLose(){
        return lose;
    }public int getDraw(){
        return draw;
    }public int getMatch(){
        return match;
    }public void print(){
        System.out.println(username+" "+password+" "+name+" "+win+" "+lose+" "+draw+" "+match);
    }
}
