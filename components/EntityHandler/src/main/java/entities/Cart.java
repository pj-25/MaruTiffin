/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.marutiffin.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author codeholic
 */
@Entity
@Table(name = "cart")
@NamedQueries({
    @NamedQuery(name = "Cart.findAll", query = "SELECT c FROM Cart c"),
    @NamedQuery(name = "Cart.findByCartId", query = "SELECT c FROM Cart c WHERE c.cartId = :cartId"),
    @NamedQuery(name = "Cart.findByTotalAmount", query = "SELECT c FROM Cart c WHERE c.totalAmount = :totalAmount"),
    @NamedQuery(name = "Cart.findByCookInstruction", query = "SELECT c FROM Cart c WHERE c.cookInstruction = :cookInstruction")})
public class Cart implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cart_id")
    private Integer cartId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "total_amount")
    private float totalAmount;
    @Size(max = 100)
    @Column(name = "cook_instruction")
    private String cookInstruction;
    @JoinTable(name = "cart_item_list", joinColumns = {
        @JoinColumn(name = "cart_id", referencedColumnName = "cart_id")}, inverseJoinColumns = {
        @JoinColumn(name = "cart_item_id", referencedColumnName = "cart_item_id")})
    @ManyToMany
    private Collection<CartItem> cartItemCollection;
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id")
    @ManyToOne(optional = false)
    private Customer customerId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cartId")
    private Collection<OrderInfo> orderInfoCollection;

    public Cart() {
    }

    public Cart(Integer cartId) {
        this.cartId = cartId;
    }

    public Cart(Integer cartId, float totalAmount) {
        this.cartId = cartId;
        this.totalAmount = totalAmount;
    }

    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    public float getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(float totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getCookInstruction() {
        return cookInstruction;
    }

    public void setCookInstruction(String cookInstruction) {
        this.cookInstruction = cookInstruction;
    }

    public Collection<CartItem> getCartItemCollection() {
        return cartItemCollection;
    }

    public void setCartItemCollection(Collection<CartItem> cartItemCollection) {
        this.cartItemCollection = cartItemCollection;
    }

    public Customer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Customer customerId) {
        this.customerId = customerId;
    }

    public Collection<OrderInfo> getOrderInfoCollection() {
        return orderInfoCollection;
    }

    public void setOrderInfoCollection(Collection<OrderInfo> orderInfoCollection) {
        this.orderInfoCollection = orderInfoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cartId != null ? cartId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cart)) {
            return false;
        }
        Cart other = (Cart) object;
        if ((this.cartId == null && other.cartId != null) || (this.cartId != null && !this.cartId.equals(other.cartId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.marutiffin.entities.Cart[ cartId=" + cartId + " ]";
    }
    
}
