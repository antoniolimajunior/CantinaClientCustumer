/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.cantinaclientcustumer.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author antonio jr
 */
public class Pedido {

    private long id;

    private List<PedidoItem> pedidosItem = new ArrayList<>();

    private User user;
    
    private BigDecimal valorTotal;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    public List<PedidoItem> getPedidosItem() {
        return pedidosItem;
    }

    public void setPedidosItem(List<PedidoItem> pedidosItem) {
        this.pedidosItem = pedidosItem;
    }

    public void addPedidoItem(PedidoItem pedidoItem) {
        pedidosItem.add(pedidoItem);
        pedidoItem.setPedido(this);
    }

    public void removeFone(PedidoItem pedidoItem) {
        pedidoItem.setPedido(null);
        this.pedidosItem.remove(pedidoItem);
    }
}
