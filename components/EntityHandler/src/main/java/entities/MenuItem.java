/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.marutiffin.entities;

import java.io.Serializable;
import java.util.Collection;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author codeholic
 */
@Entity
@Table(name = "menu_item")
@NamedQueries({
    @NamedQuery(name = "MenuItem.findAll", query = "SELECT m FROM MenuItem m"),
    @NamedQuery(name = "MenuItem.findByMenuItemId", query = "SELECT m FROM MenuItem m WHERE m.menuItemId = :menuItemId"),
    @NamedQuery(name = "MenuItem.findByItemType", query = "SELECT m FROM MenuItem m WHERE m.itemType = :itemType"),
    @NamedQuery(name = "MenuItem.findByDescription", query = "SELECT m FROM MenuItem m WHERE m.description = :description"),
    @NamedQuery(name = "MenuItem.findByStatus", query = "SELECT m FROM MenuItem m WHERE m.status = :status"),
    @NamedQuery(name = "MenuItem.findByTotalCost", query = "SELECT m FROM MenuItem m WHERE m.totalCost = :totalCost")})
public class MenuItem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "menu_item_id")
    private Integer menuItemId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "item_type")
    private int itemType;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Column(name = "status")
    private Character status;
    @Basic(optional = false)
    @NotNull
    @Column(name = "total_cost")
    private float totalCost;
    @JoinColumn(name = "menu_id", referencedColumnName = "menu_id")
    @ManyToOne(optional = false)
    private Menu menuId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "menuItemId")
    private Collection<FoodItem> foodItemCollection;

    public MenuItem() {
    }

    public MenuItem(Integer menuItemId) {
        this.menuItemId = menuItemId;
    }

    public MenuItem(Integer menuItemId, int itemType, String description, Character status, float totalCost) {
        this.menuItemId = menuItemId;
        this.itemType = itemType;
        this.description = description;
        this.status = status;
        this.totalCost = totalCost;
    }

    public Integer getMenuItemId() {
        return menuItemId;
    }

    public void setMenuItemId(Integer menuItemId) {
        this.menuItemId = menuItemId;
    }

    public int getItemType() {
        return itemType;
    }

    public void setItemType(int itemType) {
        this.itemType = itemType;
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

    public float getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(float totalCost) {
        this.totalCost = totalCost;
    }

    public Menu getMenuId() {
        return menuId;
    }

    public void setMenuId(Menu menuId) {
        this.menuId = menuId;
    }

    public Collection<FoodItem> getFoodItemCollection() {
        return foodItemCollection;
    }

    public void setFoodItemCollection(Collection<FoodItem> foodItemCollection) {
        this.foodItemCollection = foodItemCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (menuItemId != null ? menuItemId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MenuItem)) {
            return false;
        }
        MenuItem other = (MenuItem) object;
        if ((this.menuItemId == null && other.menuItemId != null) || (this.menuItemId != null && !this.menuItemId.equals(other.menuItemId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.marutiffin.entities.MenuItem[ menuItemId=" + menuItemId + " ]";
    }
    
}
