package entities;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author codeholic
 */
@Entity
@Table(name = "saved_address")
@NamedQueries({
    @NamedQuery(name = "SavedAddress.findAll", query = "SELECT s FROM SavedAddress s"),
    @NamedQuery(name = "SavedAddress.findByAddressId", query = "SELECT s FROM SavedAddress s WHERE s.savedAddressPK.addressId = :addressId"),
    @NamedQuery(name = "SavedAddress.findByCustomerId", query = "SELECT s FROM SavedAddress s WHERE s.savedAddressPK.customerId = :customerId")})
public class SavedAddress implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SavedAddressPK savedAddressPK;
    @JoinColumn(name = "address_id", referencedColumnName = "address_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Address address;
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Customer customer;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "deliveryAddressId")
    private Collection<OrderInfo> orderInfoCollection;

    public SavedAddress() {
    }

    public SavedAddress(SavedAddressPK savedAddressPK) {
        this.savedAddressPK = savedAddressPK;
    }

    public SavedAddress(int addressId, String customerId) {
        this.savedAddressPK = new SavedAddressPK(addressId, customerId);
    }

    public SavedAddressPK getSavedAddressPK() {
        return savedAddressPK;
    }

    public void setSavedAddressPK(SavedAddressPK savedAddressPK) {
        this.savedAddressPK = savedAddressPK;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
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
        hash += (savedAddressPK != null ? savedAddressPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SavedAddress)) {
            return false;
        }
        SavedAddress other = (SavedAddress) object;
        if ((this.savedAddressPK == null && other.savedAddressPK != null) || (this.savedAddressPK != null && !this.savedAddressPK.equals(other.savedAddressPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.marutiffin.entities.SavedAddress[ savedAddressPK=" + savedAddressPK + " ]";
    }
    
}
