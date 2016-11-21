package br.com.senac.cantinaclientcustumer.controller;

import static br.com.senac.cantinaclientcustumer.ws.ServiceContants.URL_PEDIDO_CREATE;
import br.com.senac.cantinaclientcustumer.model.Pedido;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;
import javax.ws.rs.core.MediaType;
import org.apache.http.HttpStatus;

public class PedidoController {

    public void sendPedido(Pedido pedido) {

        try {
            ClientConfig clientConfig = new DefaultClientConfig();
            clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
            Client client = Client.create(clientConfig);
            WebResource webResource = client.resource(URL_PEDIDO_CREATE);
            ClientResponse clientReponse = webResource.type(MediaType.APPLICATION_JSON)
                    .accept(MediaType.APPLICATION_JSON)
                    .post(ClientResponse.class, pedido);

                       
        } catch (Exception ex) {
            System.out.print(ex.getMessage());
        }
    }
}
