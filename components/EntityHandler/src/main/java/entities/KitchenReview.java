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
import javax.validation.constraints.Size;

/**
 *
 * @author codeholic
 */
@Entity
@Table(name = "kitchen_review")
@NamedQueries({
    @NamedQuery(name = "KitchenReview.findAll", query = "SELECT k FROM KitchenReview k"),
    @NamedQuery(name = "KitchenReview.findByReviewId", query = "SELECT k FROM KitchenReview k WHERE k.reviewId = :reviewId"),
    @NamedQuery(name = "KitchenReview.findByReview", query = "SELECT k FROM KitchenReview k WHERE k.review = :review"),
    @NamedQuery(name = "KitchenReview.findByRatings", query = "SELECT k FROM KitchenReview k WHERE k.ratings = :ratings"),
    @NamedQuery(name = "KitchenReview.findByReviewedOn", query = "SELECT k FROM KitchenReview k WHERE k.reviewedOn = :reviewedOn")})
public class KitchenReview implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "review_id")
    private Integer reviewId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "review")
    private String review;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ratings")
    private int ratings;
    @Basic(optional = false)
    @NotNull
    @Column(name = "reviewed_on")
    @Temporal(TemporalType.TIMESTAMP)
    private Date reviewedOn;
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id")
    @ManyToOne(optional = false)
    private Customer customerId;
    @JoinColumn(name = "kitchen_id", referencedColumnName = "kitchen_id")
    @ManyToOne(optional = false)
    private Kitchen kitchenId;

    public KitchenReview() {
    }

    public KitchenReview(Integer reviewId) {
        this.reviewId = reviewId;
    }

    public KitchenReview(Integer reviewId, String review, int ratings, Date reviewedOn) {
        this.reviewId = reviewId;
        this.review = review;
        this.ratings = ratings;
        this.reviewedOn = reviewedOn;
    }

    public Integer getReviewId() {
        return reviewId;
    }

    public void setReviewId(Integer reviewId) {
        this.reviewId = reviewId;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public int getRatings() {
        return ratings;
    }

    public void setRatings(int ratings) {
        this.ratings = ratings;
    }

    public Date getReviewedOn() {
        return reviewedOn;
    }

    public void setReviewedOn(Date reviewedOn) {
        this.reviewedOn = reviewedOn;
    }

    public Customer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Customer customerId) {
        this.customerId = customerId;
    }

    public Kitchen getKitchenId() {
        return kitchenId;
    }

    public void setKitchenId(Kitchen kitchenId) {
        this.kitchenId = kitchenId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (reviewId != null ? reviewId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof KitchenReview)) {
            return false;
        }
        KitchenReview other = (KitchenReview) object;
        if ((this.reviewId == null && other.reviewId != null) || (this.reviewId != null && !this.reviewId.equals(other.reviewId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.marutiffin.entities.KitchenReview[ reviewId=" + reviewId + " ]";
    }
    
}
