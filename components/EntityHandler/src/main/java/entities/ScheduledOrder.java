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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author codeholic
 */
@Entity
@Table(name = "scheduled_order")
@NamedQueries({
    @NamedQuery(name = "ScheduledOrder.findAll", query = "SELECT s FROM ScheduledOrder s"),
    @NamedQuery(name = "ScheduledOrder.findByScheduledOrderId", query = "SELECT s FROM ScheduledOrder s WHERE s.scheduledOrderId = :scheduledOrderId"),
    @NamedQuery(name = "ScheduledOrder.findByStatus", query = "SELECT s FROM ScheduledOrder s WHERE s.status = :status"),
    @NamedQuery(name = "ScheduledOrder.findByScheduledTime", query = "SELECT s FROM ScheduledOrder s WHERE s.scheduledTime = :scheduledTime")})
public class ScheduledOrder implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "scheduled_order_id")
    private Integer scheduledOrderId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "status")
    private Character status;
    @Basic(optional = false)
    @NotNull
    @Column(name = "scheduled_time")
    @Temporal(TemporalType.TIME)
    private Date scheduledTime;
    @JoinColumn(name = "order_id", referencedColumnName = "order_id")
    @ManyToOne(optional = false)
    private OrderInfo orderId;
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id")
    @ManyToOne(optional = false)
    private Customer customerId;

    public ScheduledOrder() {
    }

    public ScheduledOrder(Integer scheduledOrderId) {
        this.scheduledOrderId = scheduledOrderId;
    }

    public ScheduledOrder(Integer scheduledOrderId, Character status, Date scheduledTime) {
        this.scheduledOrderId = scheduledOrderId;
        this.status = status;
        this.scheduledTime = scheduledTime;
    }

    public Integer getScheduledOrderId() {
        return scheduledOrderId;
    }

    public void setScheduledOrderId(Integer scheduledOrderId) {
        this.scheduledOrderId = scheduledOrderId;
    }

    public Character getStatus() {
        return status;
    }

    public void setStatus(Character status) {
        this.status = status;
    }

    public Date getScheduledTime() {
        return scheduledTime;
    }

    public void setScheduledTime(Date scheduledTime) {
        this.scheduledTime = scheduledTime;
    }

    public OrderInfo getOrderId() {
        return orderId;
    }

    public void setOrderId(OrderInfo orderId) {
        this.orderId = orderId;
    }

    public Customer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Customer customerId) {
        this.customerId = customerId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (scheduledOrderId != null ? scheduledOrderId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ScheduledOrder)) {
            return false;
        }
        ScheduledOrder other = (ScheduledOrder) object;
        if ((this.scheduledOrderId == null && other.scheduledOrderId != null) || (this.scheduledOrderId != null && !this.scheduledOrderId.equals(other.scheduledOrderId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.marutiffin.entities.ScheduledOrder[ scheduledOrderId=" + scheduledOrderId + " ]";
    }
    
}
