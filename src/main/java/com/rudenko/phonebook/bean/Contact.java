/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rudenko.phonebook.bean;

import com.mongodb.BasicDBObject;

/**
 * Represents the entity of a contact
 * @author masha
 */
public class Contact {
    
 private Integer id;
 private String name;
 private String address;
 private String localPhone;
 private String intPhone;

    public Contact() {
    }

    public Contact(String name, String address, String localPhone, String intPhone) {              
        this.name = name;
        this.address = address;
        this.localPhone = localPhone;
        this.intPhone = intPhone;
        generateId();
    } 
    
    public Contact(BasicDBObject dbObject) {
        this.id = dbObject.getInt("id");
        this.name = dbObject.getString("name");
        this.address = dbObject.getString("address");
        this.localPhone = dbObject.getString("localPhone");
        this.intPhone = dbObject.getString("intPhone");
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLocalPhone() {
        return localPhone;
    }

    public void setLocalPhone(String localPhone) {
        this.localPhone = localPhone;
    }

    public String getIntPhone() {
        return intPhone;
    }

    public void setIntPhone(String intPhone) {
        this.intPhone = intPhone;
    }

    public BasicDBObject toDBObject(){
        BasicDBObject result = new BasicDBObject();
	result.put("id", id);
	result.put("name", name);
	result.put("address", address);
        result.put("localPhone", localPhone);
        result.put("intPhone", intPhone);
        return result;
    }
    
    public final void generateId(){
       this.id = (int)System.currentTimeMillis();
    }
    
}
