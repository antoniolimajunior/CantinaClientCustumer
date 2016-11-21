/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.cantinaclientcustumer.controller;

import br.com.senac.cantinaclientcustumer.model.User;
import static br.com.senac.cantinaclientcustumer.ws.ServiceContants.URL_LOGIN;
import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import javax.swing.JOptionPane;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;

/**
 *
 * @author antonio jr
 */
public class UserController {

    public User login(String matricula, String senha) {

        try {
            
            Client client = Client.create();
            WebResource webResource = client.resource(URL_LOGIN);

            MultivaluedMap<String, String> formData = new MultivaluedHashMap<String, String>();
            formData.add("matricula", matricula);
            formData.add("senha", senha);

            ClientResponse response = webResource.queryParams(formData)
                    .type(MediaType.APPLICATION_JSON).post(ClientResponse.class);

            User user = new Gson().fromJson(response.getEntity(String.class), User.class);

            JOptionPane.showMessageDialog(null, "Seja bem vindo, " + user.getNome() + "!");
            
            return user;
            
        } catch (Exception ex) {
            return null;
        }
    }
}
