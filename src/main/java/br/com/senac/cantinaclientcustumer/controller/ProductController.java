/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.cantinaclientcustumer.controller;

import br.com.senac.cantinaclientcustumer.model.Product;
import static br.com.senac.cantinaclientcustumer.ws.ServiceContants.URL_PRODUCT_LIST;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import java.lang.reflect.Type;
import java.util.ArrayList;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author antonio jr
 */
public class ProductController {

    public ArrayList<Product> listAll() {

        try {

            Client client = Client.create();
            WebResource webResource = client.resource(URL_PRODUCT_LIST);
            ClientResponse response = webResource.type(MediaType.APPLICATION_JSON).post(ClientResponse.class);
            Type listType = new TypeToken<ArrayList<Product>>(){}.getType();
            ArrayList<Product> produtos = new Gson().fromJson(response.getEntity(String.class), listType);

            return produtos;

        } catch (Exception ex) {
            return null;
        }
    }
}
