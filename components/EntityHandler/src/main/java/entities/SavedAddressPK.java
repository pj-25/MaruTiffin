/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.marutiffin.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author codeholic
 */
@Embeddable
public class SavedAddressPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "address_id")
    private int addressId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "customer_id")
    private String customerId;

    public SavedAddressPK() {
    }

    public SavedAddressPK(int addressId, String customerId) {
        this.addressId = addressId;
        this.customerId = customerId;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) addressId;
        hash += (customerId != null ? customerId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SavedAddressPK)) {
            return false;
        }
        SavedAddressPK other = (SavedAddressPK) object;
        if (this.addressId != other.addressId) {
            return false;
        }
        if ((this.customerId == null && other.customerId != null) || (this.customerId != null && !this.customerId.equals(other.customerId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.marutiffin.entities.SavedAddressPK[ addressId=" + addressId + ", customerId=" + customerId + " ]";
    }
    
}
