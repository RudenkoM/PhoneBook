/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rudenko.phonebook.bean;

import java.util.List;

/**
 * Represents a response to the client
 * @author masha
 */
public class Response {
    List<Contact> contacts;
    Status status;
    String errorText;

    public Response(List<Contact> contacts, Status status) {
        this.contacts = contacts;
        this.status = status;
    }

    public Response(Status status) {
        this.status = status;
    }

    public Response(Status status, String errorText) {
        this.status = status;
        this.errorText = errorText;
    }
       
    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getErrorText() {
        return errorText;
    }

    public void setErrorText(String errorText) {
        this.errorText = errorText;
    }      
}
