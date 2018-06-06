/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ipc.ui.sendChatMessage;

import javax.swing.ImageIcon;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Sara Ramos
 */
public class UserChatProfileTest {
    
    private UserChatProfile userChat;
    
    public UserChatProfileTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        this.userChat = new UserChatProfile(1l, "sararamos", true, 0, new ImageIcon());
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getId method, of class UserChatProfile.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");

        Long expResult = 1l;
        Long result = this.userChat.getId();
        assertEquals(expResult, result);

    }
    
    /**
     * Test of getId method, of class UserChatProfile.
     */
    @Test
    public void testGetIdNotEquals() {
        System.out.println("getId");

        Long expResult = 2l;
        Long result = this.userChat.getId();
        assertNotEquals(expResult, result);

    }

    /**
     * Test of getNick method, of class UserChatProfile.
     */
    @Test
    public void testGetNick() {
        System.out.println("getNick");

        String expResult = "sararamos";
        String result = this.userChat.getNick();
        assertEquals(expResult, result);

    }
    
    /**
     * Test of getNick method, of class UserChatProfile.
     */
    @Test
    public void testGetNickNotEquals() {
        System.out.println("getNick");

        String expResult = "sara";
        String result = this.userChat.getNick();
        assertNotEquals(expResult, result);

    }

    /**
     * Test of isOnline method, of class UserChatProfile.
     */
    @Test
    public void testIsOnline() {
        System.out.println("isOnline");

        boolean expResult = true;
        boolean result = this.userChat.isOnline();
        assertEquals(expResult, result);

    }
    
    /**
     * Test of isOnline method, of class UserChatProfile.
     */
    @Test
    public void testIsNotOnline() {
        System.out.println("isNotOnline");

        boolean expResult = false;
        boolean result = this.userChat.isOnline();
        assertNotEquals(expResult, result);

    }

    /**
     * Test of getParentId method, of class UserChatProfile.
     */
    @Test
    public void testGetParentId() {
        System.out.println("getParentId");
        int expResult = 0;
        int result = this.userChat.getParentId();
        assertEquals(expResult, result);

    }
    
    /**
     * Test of getParentId method, of class UserChatProfile.
     */
    @Test
    public void testGetParentIdNotEquals() {
        System.out.println("getParentId");
        int expResult = 1;
        int result = this.userChat.getParentId();
        assertNotEquals(expResult, result);

    }

    /**
     * Test of getUsername method, of class UserChatProfile.
     */
    @Test
    public void testGetUsername() {
        System.out.println("getUsername");

        String expResult = System.getProperty("user.name");
        String result = this.userChat.getUsername();
        assertEquals(expResult, result);

    }
    
    /**
     * Test of getUsername method, of class UserChatProfile.
     */
    @Test
    public void testGetUsernameNotEquals() {
        System.out.println("getUsername");

        String expResult = "user";
        String result = this.userChat.getUsername();
        assertNotEquals(expResult, result);

    }

    /**
     * Test of setParentId method, of class UserChatProfile.
     */
    @Test
    public void testSetParentId() {
        System.out.println("setParentId");
        int parentId = 0;
        UserChatProfile instance = new UserChatProfile(1l, "sara", true, parentId, new ImageIcon());
        instance.setParentId(parentId);
        
        int otherParent = instance.getParentId();
        
        assertEquals(parentId, otherParent);

    }
    
}
