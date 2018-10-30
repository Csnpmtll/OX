/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import User.UserDao;
import Register.RegisterService;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 *
 * @author Boss
 */
public class RegisterTest {
    RegisterService register=new RegisterService();
    public RegisterTest() {
        
    }
    @Test
    public void checkUsernameLength(){
        assertTrue(register.checkUsernameLength("123456"));
        assertFalse(register.checkUsernameLength("12345"));
    }
    @Test
    public void checkPasswordLength() {
        assertTrue(register.checkUsernameLength("123456"));
        assertFalse(register.checkUsernameLength("12345"));
    }
    @Test
    public void PasswordVerify() {
        assertTrue(register.PasswordVerify("123456","123456"));
        assertFalse(register.PasswordVerify("123456","12345"));
    }
    @Test
    public void isNameExist() {
        assertTrue(register.isNameExist("123456"));
        assertFalse(register.isNameExist("12121"));
    }
    @Test
    public void isUsernameExist() {
        assertTrue(register.isUsernameExist("123456"));
        assertFalse(register.isUsernameExist("a123456"));
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
