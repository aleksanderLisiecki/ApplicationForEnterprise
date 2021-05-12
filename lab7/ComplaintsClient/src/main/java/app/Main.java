/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author alili
 */
public class Main {

    public static void main(String[] args) {
        Client client = ClientBuilder.newClient();

        //===== count =====
        String count = client.target("http://localhost:8080/Complaints/resources/complaints/count")
                .request(MediaType.TEXT_PLAIN)
                .get(String.class);

        System.out.println("Count: " + count);

        //===== all complaints =====
        String all = client.target("http://localhost:8080/Complaints/resources/complaints/")
                .request(MediaType.APPLICATION_JSON)
                .get(String.class);

        System.out.println("All complaints: " + all);

        //===== open complaint =====
        Complaint openComplaint = openComplaints(client).get(0);
        
        System.out.println("First open complaint: " + openComplaint);
        
        
        //===== update that complaint =====
        openComplaint.setStatus("closed");
        
        client.target("http://localhost:8080/Complaints/resources/complaints/"
                + openComplaint.getId().toString())
                .request()
                .put(Entity.entity(openComplaint, MediaType.APPLICATION_JSON));

        //===== all complaints =====
        all = client.target("http://localhost:8080/Complaints/resources/complaints/")
                .request(MediaType.APPLICATION_JSON)
                .get(String.class);

        System.out.println("All complaints: " + all);
        
        client.close();
    }

    private static List<Complaint> openComplaints(Client client) {
        return client.target("http://localhost:8080/Complaints/resources/complaints/?status=open")
                .request(MediaType.APPLICATION_JSON)
                .get(Response.class)
                .readEntity(new GenericType<List<Complaint>>(){});
    }

}
