/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.marutiffin.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "offer")
@NamedQueries({
    @NamedQuery(name = "Offer.findAll", query = "SELECT o FROM Offer o"),
    @NamedQuery(name = "Offer.findByOfferCode", query = "SELECT o FROM Offer o WHERE o.offerCode = :offerCode"),
    @NamedQuery(name = "Offer.findByDescription", query = "SELECT o FROM Offer o WHERE o.description = :description"),
    @NamedQuery(name = "Offer.findByOfferType", query = "SELECT o FROM Offer o WHERE o.offerType = :offerType"),
    @NamedQuery(name = "Offer.findByValidTill", query = "SELECT o FROM Offer o WHERE o.validTill = :validTill"),
    @NamedQuery(name = "Offer.findByDiscount", query = "SELECT o FROM Offer o WHERE o.discount = :discount")})
public class Offer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "offer_code")
    private String offerCode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Column(name = "offer_type")
    private int offerType;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valid_till")
    @Temporal(TemporalType.DATE)
    private Date validTill;
    @Basic(optional = false)
    @NotNull
    @Column(name = "discount")
    private int discount;
    @OneToMany(mappedBy = "offerCode")
    private Collection<OrderInfo> orderInfoCollection;

    public Offer() {
    }

    public Offer(String offerCode) {
        this.offerCode = offerCode;
    }

    public Offer(String offerCode, String description, int offerType, Date validTill, int discount) {
        this.offerCode = offerCode;
        this.description = description;
        this.offerType = offerType;
        this.validTill = validTill;
        this.discount = discount;
    }

    public String getOfferCode() {
        return offerCode;
    }

    public void setOfferCode(String offerCode) {
        this.offerCode = offerCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getOfferType() {
        return offerType;
    }

    public void setOfferType(int offerType) {
        this.offerType = offerType;
    }

    public Date getValidTill() {
        return validTill;
    }

    public void setValidTill(Date validTill) {
        this.validTill = validTill;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
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
        hash += (offerCode != null ? offerCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Offer)) {
            return false;
        }
        Offer other = (Offer) object;
        if ((this.offerCode == null && other.offerCode != null) || (this.offerCode != null && !this.offerCode.equals(other.offerCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.marutiffin.entities.Offer[ offerCode=" + offerCode + " ]";
    }
    
}
