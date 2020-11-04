package Coditation.Model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Product 
{
	@Id
	@Column(name="Product_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Product_ID;
	
	@Column(name="Product_Name")
	private String Product_Name;
	
	@Column(name="Product_Price")
	private String Product_Price;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL) 
	@JoinTable(name = "Category_Product", joinColumns = @JoinColumn(name = "ProductId", referencedColumnName = "Product_ID"), inverseJoinColumns = @JoinColumn(name = "CategoryId", referencedColumnName = "Category_ID"))
	Set<Category> category=new HashSet<>();
	
	
	public Product() {
		super();
	}

	public Product(String product_Name, String product_Price,Set<Category> cat) {
		super();
		Product_Name = product_Name;
		Product_Price = product_Price;
		this.category = cat;
	}
	
	public int getProduct_ID() {
		return Product_ID;
	}
	public void setProduct_ID(int product_ID) {
		Product_ID = product_ID;
	}
	
	
	public String getProduct_Name() {
		return Product_Name;
	}
	public void setProduct_Name(String product_Name) {
		Product_Name = product_Name;
	}
	
	
	public String getProduct_Price() {
		return Product_Price;
	}
	public void setProduct_Price(String product_Price) {
		Product_Price = product_Price;
	}
	
	public Set<Category> getCategory() {
		return category;
	}
	public void setCategory(Set<Category> category) {
		this.category = category;
	}
	
}
