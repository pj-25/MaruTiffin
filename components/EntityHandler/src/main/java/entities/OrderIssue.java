package entities;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
import javax.validation.constraints.Size;

/**
 *
 * @author codeholic
 */
@Entity
@Table(name = "order_issue")
@NamedQueries({
    @NamedQuery(name = "OrderIssue.findAll", query = "SELECT o FROM OrderIssue o"),
    @NamedQuery(name = "OrderIssue.findByOrderIssueId", query = "SELECT o FROM OrderIssue o WHERE o.orderIssueId = :orderIssueId"),
    @NamedQuery(name = "OrderIssue.findByAppliedOn", query = "SELECT o FROM OrderIssue o WHERE o.appliedOn = :appliedOn"),
    @NamedQuery(name = "OrderIssue.findByDescription", query = "SELECT o FROM OrderIssue o WHERE o.description = :description"),
    @NamedQuery(name = "OrderIssue.findByStatus", query = "SELECT o FROM OrderIssue o WHERE o.status = :status")})
public class OrderIssue implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "order_issue_id")
    private Integer orderIssueId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "applied_on")
    @Temporal(TemporalType.TIME)
    private Date appliedOn;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Column(name = "status")
    private Character status;
    @JoinColumn(name = "order_id", referencedColumnName = "order_id")
    @ManyToOne(optional = false)
    private OrderInfo orderId;

    public OrderIssue() {
    }

    public OrderIssue(Integer orderIssueId) {
        this.orderIssueId = orderIssueId;
    }

    public OrderIssue(Integer orderIssueId, Date appliedOn, String description, Character status) {
        this.orderIssueId = orderIssueId;
        this.appliedOn = appliedOn;
        this.description = description;
        this.status = status;
    }

    public Integer getOrderIssueId() {
        return orderIssueId;
    }

    public void setOrderIssueId(Integer orderIssueId) {
        this.orderIssueId = orderIssueId;
    }

    public Date getAppliedOn() {
        return appliedOn;
    }

    public void setAppliedOn(Date appliedOn) {
        this.appliedOn = appliedOn;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Character getStatus() {
        return status;
    }

    public void setStatus(Character status) {
        this.status = status;
    }

    public OrderInfo getOrderId() {
        return orderId;
    }

    public void setOrderId(OrderInfo orderId) {
        this.orderId = orderId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orderIssueId != null ? orderIssueId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrderIssue)) {
            return false;
        }
        OrderIssue other = (OrderIssue) object;
        if ((this.orderIssueId == null && other.orderIssueId != null) || (this.orderIssueId != null && !this.orderIssueId.equals(other.orderIssueId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.marutiffin.entities.OrderIssue[ orderIssueId=" + orderIssueId + " ]";
    }
    
}
