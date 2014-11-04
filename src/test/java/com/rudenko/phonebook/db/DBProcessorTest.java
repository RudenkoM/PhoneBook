/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rudenko.phonebook.db;

import com.rudenko.phonebook.bean.Contact;
import java.net.UnknownHostException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author masha
 */
@Ignore
public class DBProcessorTest {

    public DBProcessorTest() {
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

    /**
     * Test of insert method, of class DBProcessor.
     */
    @Test
    public void testInsert() throws UnknownHostException {
        System.out.println("insert");
        Contact contact = new Contact("Nataliia", "Dnepropetrovsk", "+380933423403", "+995595080080");
        DBProcessor instance = new DBProcessor("localhost",27017);
        instance.insert(contact);
    }

    @Test
    public void testGetAllContacts() throws UnknownHostException {
        System.out.println("getAll");
        DBProcessor instance = new DBProcessor("localhost",27017);        
        System.out.println(instance.getAllContacts().toString());
    }

    @Test
    public void testGetContactByName() throws UnknownHostException {
        System.out.println("GetContactByName");
        DBProcessor instance = new DBProcessor("localhost",27017);
        System.out.println(instance.getContactByName("Mariia").toString());
    }

    @Test
    public void testUpdateContactById() throws UnknownHostException {
        System.out.println("UpdateContactById");
        DBProcessor instance = new DBProcessor("localhost",27017);
        Contact contact = new Contact();
        contact.setId(1985299767);
        contact.setAddress("123");
        contact.setIntPhone("123");
        contact.setLocalPhone("123");
        contact.setName("Nataliia");
        instance.updateContactById(contact);
    }

    @Test
    public void testDeleteContactById() throws UnknownHostException {
        System.out.println("DeleteContactById");
        DBProcessor instance = new DBProcessor("localhost",27017);
        instance.deleteContactById(1985299767);
    }
}
