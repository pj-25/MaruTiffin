package entities;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "kitchen")
@NamedQueries({
    @NamedQuery(name = "Kitchen.findAll", query = "SELECT k FROM Kitchen k"),
    @NamedQuery(name = "Kitchen.findByKitchenId", query = "SELECT k FROM Kitchen k WHERE k.kitchenId = :kitchenId"),
    @NamedQuery(name = "Kitchen.findByKitchenName", query = "SELECT k FROM Kitchen k WHERE k.kitchenName = :kitchenName"),
    @NamedQuery(name = "Kitchen.findByDescription", query = "SELECT k FROM Kitchen k WHERE k.description = :description"),
    @NamedQuery(name = "Kitchen.findByType", query = "SELECT k FROM Kitchen k WHERE k.type = :type"),
    @NamedQuery(name = "Kitchen.findByOpeningTime", query = "SELECT k FROM Kitchen k WHERE k.openingTime = :openingTime"),
    @NamedQuery(name = "Kitchen.findByClosingTime", query = "SELECT k FROM Kitchen k WHERE k.closingTime = :closingTime"),
    @NamedQuery(name = "Kitchen.findByStatus", query = "SELECT k FROM Kitchen k WHERE k.status = :status")})
public class Kitchen implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "kitchen_id")
    private Integer kitchenId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "kitchen_name")
    private String kitchenName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Column(name = "type")
    private Character type;
    @Basic(optional = false)
    @NotNull
    @Column(name = "opening_time")
    @Temporal(TemporalType.TIME)
    private Date openingTime;
    @Basic(optional = false)
    @NotNull
    @Column(name = "closing_time")
    @Temporal(TemporalType.TIME)
    private Date closingTime;
    @Basic(optional = false)
    @NotNull
    @Column(name = "status")
    private Character status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "kitchenId")
    private Collection<KitchenReview> kitchenReviewCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "kitchenId")
    private Collection<Menu> menuCollection;
    @JoinColumn(name = "address_id", referencedColumnName = "address_id")
    @ManyToOne(optional = false)
    private Address addressId;

    public Kitchen() {
    }

    public Kitchen(Integer kitchenId) {
        this.kitchenId = kitchenId;
    }

    public Kitchen(Integer kitchenId, String kitchenName, String description, Character type, Date openingTime, Date closingTime, Character status) {
        this.kitchenId = kitchenId;
        this.kitchenName = kitchenName;
        this.description = description;
        this.type = type;
        this.openingTime = openingTime;
        this.closingTime = closingTime;
        this.status = status;
    }

    public Integer getKitchenId() {
        return kitchenId;
    }

    public void setKitchenId(Integer kitchenId) {
        this.kitchenId = kitchenId;
    }

    public String getKitchenName() {
        return kitchenName;
    }

    public void setKitchenName(String kitchenName) {
        this.kitchenName = kitchenName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Character getType() {
        return type;
    }

    public void setType(Character type) {
        this.type = type;
    }

    public Date getOpeningTime() {
        return openingTime;
    }

    public void setOpeningTime(Date openingTime) {
        this.openingTime = openingTime;
    }

    public Date getClosingTime() {
        return closingTime;
    }

    public void setClosingTime(Date closingTime) {
        this.closingTime = closingTime;
    }

    public Character getStatus() {
        return status;
    }

    public void setStatus(Character status) {
        this.status = status;
    }

    public Collection<KitchenReview> getKitchenReviewCollection() {
        return kitchenReviewCollection;
    }

    public void setKitchenReviewCollection(Collection<KitchenReview> kitchenReviewCollection) {
        this.kitchenReviewCollection = kitchenReviewCollection;
    }

    public Collection<Menu> getMenuCollection() {
        return menuCollection;
    }

    public void setMenuCollection(Collection<Menu> menuCollection) {
        this.menuCollection = menuCollection;
    }

    public Address getAddressId() {
        return addressId;
    }

    public void setAddressId(Address addressId) {
        this.addressId = addressId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (kitchenId != null ? kitchenId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Kitchen)) {
            return false;
        }
        Kitchen other = (Kitchen) object;
        if ((this.kitchenId == null && other.kitchenId != null) || (this.kitchenId != null && !this.kitchenId.equals(other.kitchenId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.marutiffin.entities.Kitchen[ kitchenId=" + kitchenId + " ]";
    }
    
}
