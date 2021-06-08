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
@Table(name = "order_info")
@NamedQueries({
    @NamedQuery(name = "OrderInfo.findAll", query = "SELECT o FROM OrderInfo o"),
    @NamedQuery(name = "OrderInfo.findByOrderId", query = "SELECT o FROM OrderInfo o WHERE o.orderId = :orderId"),
    @NamedQuery(name = "OrderInfo.findByDeliveryPersonId", query = "SELECT o FROM OrderInfo o WHERE o.deliveryPersonId = :deliveryPersonId"),
    @NamedQuery(name = "OrderInfo.findByOrderedOn", query = "SELECT o FROM OrderInfo o WHERE o.orderedOn = :orderedOn"),
    @NamedQuery(name = "OrderInfo.findByEstiPrepTime", query = "SELECT o FROM OrderInfo o WHERE o.estiPrepTime = :estiPrepTime"),
    @NamedQuery(name = "OrderInfo.findByEstiDeliveryTime", query = "SELECT o FROM OrderInfo o WHERE o.estiDeliveryTime = :estiDeliveryTime"),
    @NamedQuery(name = "OrderInfo.findByStatus", query = "SELECT o FROM OrderInfo o WHERE o.status = :status"),
    @NamedQuery(name = "OrderInfo.findByFeedback", query = "SELECT o FROM OrderInfo o WHERE o.feedback = :feedback"),
    @NamedQuery(name = "OrderInfo.findByDeliveredOn", query = "SELECT o FROM OrderInfo o WHERE o.deliveredOn = :deliveredOn")})
public class OrderInfo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "order_id")
    private Integer orderId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "delivery_person_id")
    private String deliveryPersonId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ordered_on")
    @Temporal(TemporalType.TIMESTAMP)
    private Date orderedOn;
    @Basic(optional = false)
    @NotNull
    @Column(name = "esti_prep_time")
    @Temporal(TemporalType.TIME)
    private Date estiPrepTime;
    @Basic(optional = false)
    @NotNull
    @Column(name = "esti_delivery_time")
    @Temporal(TemporalType.TIME)
    private Date estiDeliveryTime;
    @Basic(optional = false)
    @NotNull
    @Column(name = "status")
    private Character status;
    @Size(max = 50)
    @Column(name = "feedback")
    private String feedback;
    @Basic(optional = false)
    @NotNull
    @Column(name = "delivered_on")
    @Temporal(TemporalType.TIMESTAMP)
    private Date deliveredOn;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orderId")
    private Collection<ScheduledOrder> scheduledOrderCollection;
    @JoinColumn(name = "cart_id", referencedColumnName = "cart_id")
    @ManyToOne(optional = false)
    private Cart cartId;
    @JoinColumn(name = "offer_code", referencedColumnName = "offer_code")
    @ManyToOne
    private Offer offerCode;
    @JoinColumn(name = "delivery_address_id", referencedColumnName = "address_id")
    @ManyToOne(optional = false)
    private SavedAddress deliveryAddressId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orderId")
    private Collection<OrderIssue> orderIssueCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orderId")
    private Collection<Payment> paymentCollection;

    public OrderInfo() {
    }

    public OrderInfo(Integer orderId) {
        this.orderId = orderId;
    }

    public OrderInfo(Integer orderId, String deliveryPersonId, Date orderedOn, Date estiPrepTime, Date estiDeliveryTime, Character status, Date deliveredOn) {
        this.orderId = orderId;
        this.deliveryPersonId = deliveryPersonId;
        this.orderedOn = orderedOn;
        this.estiPrepTime = estiPrepTime;
        this.estiDeliveryTime = estiDeliveryTime;
        this.status = status;
        this.deliveredOn = deliveredOn;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getDeliveryPersonId() {
        return deliveryPersonId;
    }

    public void setDeliveryPersonId(String deliveryPersonId) {
        this.deliveryPersonId = deliveryPersonId;
    }

    public Date getOrderedOn() {
        return orderedOn;
    }

    public void setOrderedOn(Date orderedOn) {
        this.orderedOn = orderedOn;
    }

    public Date getEstiPrepTime() {
        return estiPrepTime;
    }

    public void setEstiPrepTime(Date estiPrepTime) {
        this.estiPrepTime = estiPrepTime;
    }

    public Date getEstiDeliveryTime() {
        return estiDeliveryTime;
    }

    public void setEstiDeliveryTime(Date estiDeliveryTime) {
        this.estiDeliveryTime = estiDeliveryTime;
    }

    public Character getStatus() {
        return status;
    }

    public void setStatus(Character status) {
        this.status = status;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public Date getDeliveredOn() {
        return deliveredOn;
    }

    public void setDeliveredOn(Date deliveredOn) {
        this.deliveredOn = deliveredOn;
    }

    public Collection<ScheduledOrder> getScheduledOrderCollection() {
        return scheduledOrderCollection;
    }

    public void setScheduledOrderCollection(Collection<ScheduledOrder> scheduledOrderCollection) {
        this.scheduledOrderCollection = scheduledOrderCollection;
    }

    public Cart getCartId() {
        return cartId;
    }

    public void setCartId(Cart cartId) {
        this.cartId = cartId;
    }

    public Offer getOfferCode() {
        return offerCode;
    }

    public void setOfferCode(Offer offerCode) {
        this.offerCode = offerCode;
    }

    public SavedAddress getDeliveryAddressId() {
        return deliveryAddressId;
    }

    public void setDeliveryAddressId(SavedAddress deliveryAddressId) {
        this.deliveryAddressId = deliveryAddressId;
    }

    public Collection<OrderIssue> getOrderIssueCollection() {
        return orderIssueCollection;
    }

    public void setOrderIssueCollection(Collection<OrderIssue> orderIssueCollection) {
        this.orderIssueCollection = orderIssueCollection;
    }

    public Collection<Payment> getPaymentCollection() {
        return paymentCollection;
    }

    public void setPaymentCollection(Collection<Payment> paymentCollection) {
        this.paymentCollection = paymentCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orderId != null ? orderId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrderInfo)) {
            return false;
        }
        OrderInfo other = (OrderInfo) object;
        if ((this.orderId == null && other.orderId != null) || (this.orderId != null && !this.orderId.equals(other.orderId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.marutiffin.entities.OrderInfo[ orderId=" + orderId + " ]";
    }
    
}
