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
@Table(name = "food_item")
@NamedQueries({
    @NamedQuery(name = "FoodItem.findAll", query = "SELECT f FROM FoodItem f"),
    @NamedQuery(name = "FoodItem.findByFoodItemId", query = "SELECT f FROM FoodItem f WHERE f.foodItemId = :foodItemId"),
    @NamedQuery(name = "FoodItem.findByDescription", query = "SELECT f FROM FoodItem f WHERE f.description = :description"),
    @NamedQuery(name = "FoodItem.findByQuantity", query = "SELECT f FROM FoodItem f WHERE f.quantity = :quantity"),
    @NamedQuery(name = "FoodItem.findByPrice", query = "SELECT f FROM FoodItem f WHERE f.price = :price"),
    @NamedQuery(name = "FoodItem.findByStatus", query = "SELECT f FROM FoodItem f WHERE f.status = :status"),
    @NamedQuery(name = "FoodItem.findByType", query = "SELECT f FROM FoodItem f WHERE f.type = :type"),
    @NamedQuery(name = "FoodItem.findByAvgPrepTime", query = "SELECT f FROM FoodItem f WHERE f.avgPrepTime = :avgPrepTime")})
public class FoodItem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "food_item_id")
    private Integer foodItemId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "quantity")
    private String quantity;
    @Basic(optional = false)
    @NotNull
    @Column(name = "price")
    private float price;
    @Basic(optional = false)
    @NotNull
    @Column(name = "status")
    private int status;
    @Basic(optional = false)
    @NotNull
    @Column(name = "type")
    private int type;
    @Basic(optional = false)
    @NotNull
    @Column(name = "avg_prep_time")
    @Temporal(TemporalType.TIME)
    private Date avgPrepTime;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "foodItemId")
    private Collection<CartItem> cartItemCollection;
    @JoinColumn(name = "menu_item_id", referencedColumnName = "menu_item_id")
    @ManyToOne(optional = false)
    private MenuItem menuItemId;

    public FoodItem() {
    }

    public FoodItem(Integer foodItemId) {
        this.foodItemId = foodItemId;
    }

    public FoodItem(Integer foodItemId, String description, String quantity, float price, int status, int type, Date avgPrepTime) {
        this.foodItemId = foodItemId;
        this.description = description;
        this.quantity = quantity;
        this.price = price;
        this.status = status;
        this.type = type;
        this.avgPrepTime = avgPrepTime;
    }

    public Integer getFoodItemId() {
        return foodItemId;
    }

    public void setFoodItemId(Integer foodItemId) {
        this.foodItemId = foodItemId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Date getAvgPrepTime() {
        return avgPrepTime;
    }

    public void setAvgPrepTime(Date avgPrepTime) {
        this.avgPrepTime = avgPrepTime;
    }

    public Collection<CartItem> getCartItemCollection() {
        return cartItemCollection;
    }

    public void setCartItemCollection(Collection<CartItem> cartItemCollection) {
        this.cartItemCollection = cartItemCollection;
    }

    public MenuItem getMenuItemId() {
        return menuItemId;
    }

    public void setMenuItemId(MenuItem menuItemId) {
        this.menuItemId = menuItemId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (foodItemId != null ? foodItemId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FoodItem)) {
            return false;
        }
        FoodItem other = (FoodItem) object;
        if ((this.foodItemId == null && other.foodItemId != null) || (this.foodItemId != null && !this.foodItemId.equals(other.foodItemId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.marutiffin.entities.FoodItem[ foodItemId=" + foodItemId + " ]";
    }
    
}
