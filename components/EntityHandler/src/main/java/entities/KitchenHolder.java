/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.marutiffin.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author codeholic
 */
@Entity
@Table(name = "kitchen_holder")
@NamedQueries({
    @NamedQuery(name = "KitchenHolder.findAll", query = "SELECT k FROM KitchenHolder k"),
    @NamedQuery(name = "KitchenHolder.findByKitchenHolderId", query = "SELECT k FROM KitchenHolder k WHERE k.kitchenHolderId = :kitchenHolderId"),
    @NamedQuery(name = "KitchenHolder.findByKitchenId", query = "SELECT k FROM KitchenHolder k WHERE k.kitchenId = :kitchenId"),
    @NamedQuery(name = "KitchenHolder.findByFssaiRegNumber", query = "SELECT k FROM KitchenHolder k WHERE k.fssaiRegNumber = :fssaiRegNumber"),
    @NamedQuery(name = "KitchenHolder.findByFoodLicenseValidTill", query = "SELECT k FROM KitchenHolder k WHERE k.foodLicenseValidTill = :foodLicenseValidTill")})
public class KitchenHolder implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "kitchen_holder_id")
    private String kitchenHolderId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "kitchen_id")
    private int kitchenId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 14)
    @Column(name = "fssai_reg_number")
    private String fssaiRegNumber;
    @Basic(optional = false)
    @NotNull
    @Column(name = "food_license_valid_till")
    @Temporal(TemporalType.DATE)
    private Date foodLicenseValidTill;
    @JoinColumn(name = "kitchen_holder_id", referencedColumnName = "user_id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private User user;

    public KitchenHolder() {
    }

    public KitchenHolder(String kitchenHolderId) {
        this.kitchenHolderId = kitchenHolderId;
    }

    public KitchenHolder(String kitchenHolderId, int kitchenId, String fssaiRegNumber, Date foodLicenseValidTill) {
        this.kitchenHolderId = kitchenHolderId;
        this.kitchenId = kitchenId;
        this.fssaiRegNumber = fssaiRegNumber;
        this.foodLicenseValidTill = foodLicenseValidTill;
    }

    public String getKitchenHolderId() {
        return kitchenHolderId;
    }

    public void setKitchenHolderId(String kitchenHolderId) {
        this.kitchenHolderId = kitchenHolderId;
    }

    public int getKitchenId() {
        return kitchenId;
    }

    public void setKitchenId(int kitchenId) {
        this.kitchenId = kitchenId;
    }

    public String getFssaiRegNumber() {
        return fssaiRegNumber;
    }

    public void setFssaiRegNumber(String fssaiRegNumber) {
        this.fssaiRegNumber = fssaiRegNumber;
    }

    public Date getFoodLicenseValidTill() {
        return foodLicenseValidTill;
    }

    public void setFoodLicenseValidTill(Date foodLicenseValidTill) {
        this.foodLicenseValidTill = foodLicenseValidTill;
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
        hash += (kitchenHolderId != null ? kitchenHolderId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof KitchenHolder)) {
            return false;
        }
        KitchenHolder other = (KitchenHolder) object;
        if ((this.kitchenHolderId == null && other.kitchenHolderId != null) || (this.kitchenHolderId != null && !this.kitchenHolderId.equals(other.kitchenHolderId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.marutiffin.entities.KitchenHolder[ kitchenHolderId=" + kitchenHolderId + " ]";
    }
    
}
