package product;

//import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
 
@Entity
@Table(name = "product")
public class Product {
     
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    
    @Column(name = "p_name")
    private String name;

    @Column(name = "p_description")
    private String description;

    @Column(unique = true)
    private Integer count;
    
    @Column(unique = true)
    private Float cost;
    
    @Column(name = "FKseller")
    private String seller;
    
    public Product() {
    	
    }
    
    public Product(String name, String description, Integer count, Float cost, String seller) {
        //this.id = id;
        this.name = name;
        this.description = description;
        this.count = count;
        this.cost = cost;
        this.seller = seller;
    }
    
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public Integer getCount() {
        return this.count;
    }
    
    public void setCount(Integer count) {
        this.count = count;
    }
    
    public Float getCost() {
        return this.cost;
    }
    
    public void setCost(Float cost) {
        this.cost = cost;
    }
    
    
    public String getSeller() {
        return this.seller;
    }
    
    public void setSeller(String seller) {
        this.seller = seller;
    }
    
    @Override
    public String toString() {
        return "Product:\n" +
                "id: " + id + "\n" + 
                "name: " + name + "\n" +
                "description: " + description + "\n" +
                "count: " + count + "\n" +
                "cost: " + cost + "\n" +
                "seller: " + seller + "\n";
    }
}