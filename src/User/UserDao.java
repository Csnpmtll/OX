/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package User;

import static Connect.ConnectDB.connectDB;
import Login.FormLogin;
import Register.FormRegister;
import static Register.FormRegister.LoadImage;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.gridfs.GridFS;
import com.mongodb.gridfs.GridFSDBFile;
import com.mongodb.gridfs.GridFSInputFile;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import org.bson.Document;
import org.bson.conversions.Bson;

/**
 *
 * @author Boss
 */
public class UserDao {
    User user;
    FormLogin form = new FormLogin();
    DB database = connectDB();
    public void updateLogout(User user) {
        try {
            MongoClientURI uri = new MongoClientURI("mongodb://admin:admin1234@ds251622.mlab.com:51622/oxgame");
            MongoClient mongoClient = new MongoClient(uri);
            MongoDatabase database1 = mongoClient.getDatabase("oxgame");
            MongoCollection<Document> collection = database1.getCollection("user");
            Bson filter = new Document("username", user.getUsername());
            Bson newValue = new Document("status", "offline");
            Bson updateOperationDocument = new Document("$set", newValue);
            collection.updateOne(filter, updateOperationDocument);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public DefaultTableModel roomlist(){
        try{
            
            DBCollection collection = database.getCollection("room");
            DBCursor cursor = collection.find();
            String[] columnname={"No.","Status","Player"};
            DefaultTableModel model = new DefaultTableModel(columnname,0);
            while(cursor.hasNext()){
                DBObject obj = cursor.next();
                String no=(String) obj.get("_id").toString();
                String status=(String) obj.get("status");
                String player=(String) obj.get("player");
                model.addRow(new Object[] {no,status,player});
            }
            return model;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
    public boolean getUserByUsername(String user) {
        try {
            DBCollection collection = database.getCollection("user");
            BasicDBObject query = new BasicDBObject();
            query.put("name", user);
            int num = collection.find(query).count();
            if (num == 1) {
                return true;
            } else {
                return false;
            }
        } catch (MongoException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            Logger.getLogger(FormRegister.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    public boolean getUserByName(String name) {
        try {
            DBCollection collection = database.getCollection("user");
            BasicDBObject query = new BasicDBObject();
            query.put("username", name);
            int num = collection.find(query).count();
            if (num == 1) {
                return true;
            } else {
                return false;
            }
        } catch (MongoException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            Logger.getLogger(FormRegister.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    public void insert(User user) {
        try {
            FormRegister register=new FormRegister();
            MongoClientURI uri = new MongoClientURI("mongodb://admin:admin1234@ds251622.mlab.com:51622/oxgame");
            MongoClient mongoClient = new MongoClient(uri);
            DB database = mongoClient.getDB("oxgame");
            DBCollection collection = database.getCollection("user");
            //Load our image
            byte[] imageBytes = LoadImage(register.getPath());
            //Connect to database
            //Create GridFS object
            GridFS fs = new GridFS(database, "photo");
            //Save image into database
            GridFSInputFile in = fs.createFile(imageBytes);
            in.setFilename(user.getUsername());
            in.save();
            //Find saved image
            GridFSDBFile out = fs.findOne(new BasicDBObject("_id", in.getId()));
            //Save loaded image from database into new image file
            FileOutputStream outputImage = new FileOutputStream(register.getPath());
            out.writeTo(outputImage);
            outputImage.close();
            BasicDBObject document = new BasicDBObject();
            document.put("username", user.getUsername());
            document.put("password", user.getPassword());
            document.put("name", user.getName());
            document.put("win", user.getWin());
            document.put("lose", user.getLose());
            document.put("draw", user.getDraw());
            document.put("match", user.getMatch());
            BasicDBObject imagedetail = new BasicDBObject();
            imagedetail.put("image", in);
            document.put("image", imagedetail);
            document.put("status", "offline");
            collection.insert(document);
            form.show();
        } catch (IOException ex) {
            Logger.getLogger(FormRegister.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(FormRegister.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public User getUser(String username,String pwd) {
        try {
            DBCollection collection = database.getCollection("user");
            BasicDBObject query = new BasicDBObject();
            query.put("username", username);
            query.put("password", pwd);
            DBCursor cursor = collection.find(query);
            String name = (String) cursor.one().get("name");
            int win = (int) cursor.one().get("win");
            int lose = (int) cursor.one().get("lose");
            int draw = (int) cursor.one().get("draw");
            int match = (int) cursor.one().get("match");
            user = new User(username, pwd, pwd, name,
                    win, lose, draw, match);
            return user;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void updateLogin(User user) {
        try {
            MongoClientURI uri = new MongoClientURI("mongodb://admin:admin1234@ds251622.mlab.com:51622/oxgame");
            MongoClient mongoClient = new MongoClient(uri);
            MongoDatabase database = mongoClient.getDatabase("oxgame");
            MongoCollection<Document> collection = database.getCollection("user");
            Bson filter = new Document("username", user.getUsername());
            Bson newValue = new Document("status", "online");
            Bson updateOperationDocument = new Document("$set", newValue);
            collection.updateOne(filter, updateOperationDocument);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
