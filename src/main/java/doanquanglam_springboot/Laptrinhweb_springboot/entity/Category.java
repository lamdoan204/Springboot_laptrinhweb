package doanquanglam_springboot.Laptrinhweb_springboot.entity;


import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "categories")
public class Category implements  Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer categoryId;
    @Column(name= "categoryName", columnDefinition=" nvarchar(100) not null ")
    private String categoryName;
    @Column(name="categoryStatus", columnDefinition="int default 1")
    private int categoryStatus;
    @Column(name = "categoryQuantity", columnDefinition="int default 0")
    private int categoryQuantity;


    public Category(String categoryName, int categoryQuantity, int categoryStatus ) {
        this.categoryName = categoryName;
        this.categoryStatus = categoryStatus;
        this.categoryQuantity = categoryQuantity;
    }
    public Category() {
    }
    public int getCategoryQuantity() {
        return categoryQuantity;
    }
    public void setCategoryQuantity(int categoryQuantity) {
        this.categoryQuantity = categoryQuantity;
    }
    public Integer getCategoryId() {
        return categoryId;
    }
    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }
    public String getCategoryName() {
        return categoryName;
    }
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
    public int getCategoryStatus() {
        return categoryStatus;
    }
    public void setCategoryStatus(int categoryStatus) {
        this.categoryStatus = categoryStatus;
    }
   
    
   
}
