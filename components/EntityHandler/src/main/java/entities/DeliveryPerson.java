package entities;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author codeholic
 */
@Entity
@Table(name = "delivery_person")
@NamedQueries({
    @NamedQuery(name = "DeliveryPerson.findAll", query = "SELECT d FROM DeliveryPerson d"),
    @NamedQuery(name = "DeliveryPerson.findByDeliveryPersonId", query = "SELECT d FROM DeliveryPerson d WHERE d.deliveryPersonId = :deliveryPersonId"),
    @NamedQuery(name = "DeliveryPerson.findByStatus", query = "SELECT d FROM DeliveryPerson d WHERE d.status = :status"),
    @NamedQuery(name = "DeliveryPerson.findByCurrentOrderId", query = "SELECT d FROM DeliveryPerson d WHERE d.currentOrderId = :currentOrderId"),
    @NamedQuery(name = "DeliveryPerson.findByWeeklyPayout", query = "SELECT d FROM DeliveryPerson d WHERE d.weeklyPayout = :weeklyPayout"),
    @NamedQuery(name = "DeliveryPerson.findByOrderCount", query = "SELECT d FROM DeliveryPerson d WHERE d.orderCount = :orderCount")})
public class DeliveryPerson implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "delivery_person_id")
    private String deliveryPersonId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "status")
    private Character status;
    @Column(name = "current_order_id")
    private Integer currentOrderId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "weekly_payout")
    private float weeklyPayout;
    @Basic(optional = false)
    @NotNull
    @Column(name = "order_count")
    private int orderCount;
    @JoinColumn(name = "address_id", referencedColumnName = "address_id")
    @ManyToOne(optional = false)
    private Address addressId;
    @JoinColumn(name = "delivery_person_id", referencedColumnName = "user_id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private User user;

    public DeliveryPerson() {
    }

    public DeliveryPerson(String deliveryPersonId) {
        this.deliveryPersonId = deliveryPersonId;
    }

    public DeliveryPerson(String deliveryPersonId, Character status, float weeklyPayout, int orderCount) {
        this.deliveryPersonId = deliveryPersonId;
        this.status = status;
        this.weeklyPayout = weeklyPayout;
        this.orderCount = orderCount;
    }

    public String getDeliveryPersonId() {
        return deliveryPersonId;
    }

    public void setDeliveryPersonId(String deliveryPersonId) {
        this.deliveryPersonId = deliveryPersonId;
    }

    public Character getStatus() {
        return status;
    }

    public void setStatus(Character status) {
        this.status = status;
    }

    public Integer getCurrentOrderId() {
        return currentOrderId;
    }

    public void setCurrentOrderId(Integer currentOrderId) {
        this.currentOrderId = currentOrderId;
    }

    public float getWeeklyPayout() {
        return weeklyPayout;
    }

    public void setWeeklyPayout(float weeklyPayout) {
        this.weeklyPayout = weeklyPayout;
    }

    public int getOrderCount() {
        return orderCount;
    }

    public void setOrderCount(int orderCount) {
        this.orderCount = orderCount;
    }

    public Address getAddressId() {
        return addressId;
    }

    public void setAddressId(Address addressId) {
        this.addressId = addressId;
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
        hash += (deliveryPersonId != null ? deliveryPersonId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DeliveryPerson)) {
            return false;
        }
        DeliveryPerson other = (DeliveryPerson) object;
        if ((this.deliveryPersonId == null && other.deliveryPersonId != null) || (this.deliveryPersonId != null && !this.deliveryPersonId.equals(other.deliveryPersonId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.marutiffin.entities.DeliveryPerson[ deliveryPersonId=" + deliveryPersonId + " ]";
    }
    
}
