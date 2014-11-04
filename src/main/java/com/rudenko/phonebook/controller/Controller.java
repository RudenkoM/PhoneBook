/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rudenko.phonebook.controller;

import com.rudenko.phonebook.bean.Contact;
import com.rudenko.phonebook.bean.Response;
import com.rudenko.phonebook.bean.Status;
import com.rudenko.phonebook.db.DBProcessor;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controller
 * @author masha
 */
@Path("/")
public class Controller {

    private DBProcessor db;

    public void setDb(DBProcessor db) {
        this.db = db;
    }

    @POST
    @Path("/createContact")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createContact(Contact contact) {
        if (contact != null && contact.getName() != null && !contact.getName().isEmpty()) {
            contact.generateId();
            db.insert(contact);
            return new Response(Status.OK);
        } else {
            return new Response(Status.ERR, "Empty id or name parameter");
        }
    }

    @POST
    @Path("/updateContact")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateContactById(Contact contact) {
        if (contact.getId() != null && (contact.getName() != null ||
                contact.getAddress() != null ||
                contact.getLocalPhone() != null ||
                contact.getIntPhone() != null)) {
            db.updateContactById(contact);
            return new Response(Status.OK);
        } else {
            return new Response(Status.ERR, "Empty parameters");
        }
    }

    @GET
    @Path("/deleteContact")
    @Produces(MediaType.APPLICATION_JSON)
    public Response DeleteContactById(@QueryParam("id") Integer id) {
        if (id != null) {
            db.deleteContactById(id);
            return new Response(Status.OK);
        } else {
            return new Response(Status.ERR, "Empty id parameter");
        }
    }

    @GET
    @Path("/getAll")
    @Produces(MediaType.APPLICATION_JSON)
    public Response GetAllContacts() {
        return new Response(db.getAllContacts(), Status.OK);
    }

    @GET
    @Path("/getByName")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.TEXT_PLAIN)
    public Response GetContactByName(@QueryParam("name") String name) {
        if (name != null) {
            return new Response(db.getContactByName(name), Status.OK);
        } else {
            return new Response(Status.ERR, "Empty name parameter");
        }
    }
}
