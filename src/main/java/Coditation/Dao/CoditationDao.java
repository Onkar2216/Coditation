package Coditation.Dao;


import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import Coditation.Model.Category;
import Coditation.Model.Product;

@Repository
public class CoditationDao {

	@Autowired
	SessionFactory sessionFactory;
	
	public String AddCategoryDao(Category categoryWithChildren) 
	{
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		session.save(categoryWithChildren);
		tx.commit();
		return "Category Added Successfully..";
	}

	@SuppressWarnings("unchecked")
	public List<Category> GetAllCategoryDao() {
		Session session=sessionFactory.openSession();
		Criteria criteria=session.createCriteria(Category.class);
		List<Category> CategoryList=criteria.list();
		return CategoryList;
	}

	public String AddProductDao(Product product) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		session.save(product);
		tx.commit();
		return "Product Added Successfully..";
	}

	@SuppressWarnings("unchecked")
	public List<Product> GetAllProductDao() 
	{
		Session session=sessionFactory.openSession();
		Criteria criteria=session.createCriteria(Product.class);
		List<Product> productList=criteria.list();
		return productList;
	}

	public String UpdateProductDao(Product product) 
	{
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		session.saveOrUpdate(product);
		tx.commit();
		return "Product Updated Successfully..";	
	}
}
