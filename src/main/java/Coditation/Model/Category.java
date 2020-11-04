package Coditation.Model;
// Generated 2 Nov, 2020 8:43:55 PM by Hibernate Tools 5.1.10.Final

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * Category generated by hbm2java
 */
@Entity
@Table
public class Category implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "Category_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int CategoryId;

	@Column(name = "Category_Name")
	private String CategoryName;
	
	@OneToOne 
	@JoinColumn(name = "Parent_ID") 
	private Category category;
	 
	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
	@JsonIgnore
	Set<Category> children=new HashSet<>();
	   
	@ManyToMany(mappedBy = "category", cascade = CascadeType.ALL)
	@JsonIgnore
	Set<Product> product = new HashSet<>();

	public Category() 
	{
		super();
	}

	public Category(String categoryName) {
		super();
		CategoryName = categoryName;
	}

	public Category(int categoryId, String categoryName) {
		super();
		CategoryId = categoryId;
		CategoryName = categoryName;
	}

	public Category(String categoryName , Category category ) 
	{ 
	  CategoryName = categoryName; 
	  this.category = category; 
	}
	 
	public int getCategoryId() 
	{
		return CategoryId;
	}

	public void setCategoryId(int categoryId) {
		CategoryId = categoryId;
	}

	public String getCategoryName() {
		return CategoryName;
	}

	public void setCategoryName(String categoryName) {
		CategoryName = categoryName;
	}

	public Category getCategory() 
	{ 
		return category; 
	}
	 
	public void setCategory(Category category) 
	{ 
		this.category = category; 
	}
	

	public Set<Category> getChildren() 
	{ 
		return children; 
	}
	 
	public void setChildren(Set<Category> children) 
	{ 
		this.children = children; 
	}
	 
	public void addChildren(Category category) 
	{ 
		this.children.add(category); 
	}
	

	public Set<Product> getProduct() {
		return product;
	}

	public void setProduct(Set<Product> product) {
		this.product = product;
	}


}