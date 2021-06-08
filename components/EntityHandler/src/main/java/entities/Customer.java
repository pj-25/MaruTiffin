package entities;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author codeholic
 */
@Entity
@Table(name = "customer")
@NamedQueries({
    @NamedQuery(name = "Customer.findAll", query = "SELECT c FROM Customer c"),
    @NamedQuery(name = "Customer.findByCustomerId", query = "SELECT c FROM Customer c WHERE c.customerId = :customerId"),
    @NamedQuery(name = "Customer.findByPendingCartId", query = "SELECT c FROM Customer c WHERE c.pendingCartId = :pendingCartId")})
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "customer_id")
    private String customerId;
    @Column(name = "pending_cart_id")
    private Integer pendingCartId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customerId")
    private Collection<ScheduledOrder> scheduledOrderCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customerId")
    private Collection<KitchenReview> kitchenReviewCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customerId")
    private Collection<Cart> cartCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
    private Collection<SavedAddress> savedAddressCollection;
    @JoinColumn(name = "customer_id", referencedColumnName = "user_id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private User user;

    public Customer() {
    }

    public Customer(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public Integer getPendingCartId() {
        return pendingCartId;
    }

    public void setPendingCartId(Integer pendingCartId) {
        this.pendingCartId = pendingCartId;
    }

    public Collection<ScheduledOrder> getScheduledOrderCollection() {
        return scheduledOrderCollection;
    }

    public void setScheduledOrderCollection(Collection<ScheduledOrder> scheduledOrderCollection) {
        this.scheduledOrderCollection = scheduledOrderCollection;
    }

    public Collection<KitchenReview> getKitchenReviewCollection() {
        return kitchenReviewCollection;
    }

    public void setKitchenReviewCollection(Collection<KitchenReview> kitchenReviewCollection) {
        this.kitchenReviewCollection = kitchenReviewCollection;
    }

    public Collection<Cart> getCartCollection() {
        return cartCollection;
    }

    public void setCartCollection(Collection<Cart> cartCollection) {
        this.cartCollection = cartCollection;
    }

    public Collection<SavedAddress> getSavedAddressCollection() {
        return savedAddressCollection;
    }

    public void setSavedAddressCollection(Collection<SavedAddress> savedAddressCollection) {
        this.savedAddressCollection = savedAddressCollection;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (customerId != null ? customerId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Customer)) {
            return false;
        }
        Customer other = (Customer) object;
        if ((this.customerId == null && other.customerId != null) || (this.customerId != null && !this.customerId.equals(other.customerId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.marutiffin.entities.Customer[ customerId=" + customerId + " ]";
    }
    
}
