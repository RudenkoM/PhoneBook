/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rudenko.phonebook.db;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.WriteResult;
import com.rudenko.phonebook.bean.Contact;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

/**
 * DataBase processor, provides all metods for working with data
 * @author masha
 */
public class DBProcessor {
    DBCollection table;
    

    public DBProcessor(String host, int port) throws UnknownHostException {
        MongoClient mongo = new MongoClient(host, port);
        DB db = mongo.getDB("phonebook");
        table = db.getCollection("book");
    }

    /**
     * Inserts new contact to database
     * @param contact
     */
    public void insert(Contact contact) {
        table.insert(contact.toDBObject());
    }

    /**
     * Updates contact, specified by id 
     * @param contact 
     */
    public void updateContactById(Contact contact) {
        BasicDBObject query = new BasicDBObject();
        query.put("id", contact.getId());

        BasicDBObject newDocument = new BasicDBObject();
        if (contact.getName() != null) {
            newDocument.put("name", contact.getName());
        }
        if (contact.getAddress() != null) {
            newDocument.put("address", contact.getAddress());
        }
        if (contact.getLocalPhone() != null) {
            newDocument.put("localPhone", contact.getLocalPhone());
        }
        if (contact.getIntPhone() != null) {
            newDocument.put("intPhone", contact.getIntPhone());
        }

        BasicDBObject updateObj = new BasicDBObject();
        updateObj.put("$set", newDocument);

        table.update(query, updateObj);

    }

    /**
     * Deletes contact, specified by id
     * @param id 
     */
    public void deleteContactById(int id) {
        BasicDBObject searchQuery = new BasicDBObject();
        searchQuery.put("id", id);

        WriteResult res = table.remove(searchQuery);
    }

    /**
     * Returns all contacts from database
     * @return List<Contact> a list of contacts
     */
    public List<Contact> getAllContacts() {
        List<Contact> result = new ArrayList<Contact>();

        BasicDBObject searchQuery = new BasicDBObject();

        DBCursor cursor = table.find(searchQuery);

        while (cursor.hasNext()) {
            result.add(new Contact((BasicDBObject) cursor.next()));
        }
        return result;
    }

    /**
     * Returns all contacts from database, specified by name
     * @param name name of a contact
     * @return List<Contact> a list of contacts
     */
    public List<Contact> getContactByName(String name) {
        List<Contact> result = new ArrayList<Contact>();

        BasicDBObject searchQuery = new BasicDBObject();
        searchQuery.put("name", name);

        DBCursor cursor = table.find(searchQuery);

        while (cursor.hasNext()) {
            result.add(new Contact((BasicDBObject) cursor.next()));
        }
        return result;
    }
}
