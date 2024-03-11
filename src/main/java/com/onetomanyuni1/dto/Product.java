package com.onetomanyuni1.dto;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
   

    private String name;
    private String desc; // Assuming desc is a String, not Text
    private String sku;
    private Long category_id; // Corrected spelling
    private Long inventory_id;
    private Double price;
    private long discount_id;
    private Timestamp createdAt; // Corrected naming to follow conventions
    private Timestamp modifiedAt; // Corrected naming to follow conventions
    private Timestamp deletedAt; // Corrected naming to follow conventions

    @OneToMany(mappedBy = "product")
    private List<Product_category> categoryList;

    @OneToMany(mappedBy = "product")
    private List<Product_inventory> inventoryList;

    @OneToMany(mappedBy = "product")
    private List<Discount> discountList;

    // Constructors, if needed

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public Long getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Long category_id) {
        this.category_id = category_id;
    }

    public Long getInventory_id() {
        return inventory_id;
    }

    public void setInventory_id(Long inventory_id) {
        this.inventory_id = inventory_id;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public long getDiscount_id() {
        return discount_id;
    }

    public void setDiscount_id(long discount_id) {
        this.discount_id = discount_id;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getModifiedAt() {
        return modifiedAt;
    }

    public void setModifiedAt(Timestamp modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    public Timestamp getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Timestamp deletedAt) {
        this.deletedAt = deletedAt;
    }

    public List<Product_category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Product_category> categoryList) {
        this.categoryList = categoryList;
    }

    public List<Product_inventory> getInventoryList() {
        return inventoryList;
    }

    public void setInventoryList(List<Product_inventory> inventoryList) {
        this.inventoryList = inventoryList;
    }

    public List<Discount> getDiscountList() {
        return discountList;
    }

    public void setDiscountList(List<Discount> discountList) {
        this.discountList = discountList;
    }

	public Object getList() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setList(Object list) {
		// TODO Auto-generated method stub
		
	}
}