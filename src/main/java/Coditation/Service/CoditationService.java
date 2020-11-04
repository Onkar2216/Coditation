package Coditation.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Coditation.Dao.CoditationDao;
import Coditation.Model.Category;
import Coditation.Model.Product;

@Service
public class CoditationService 
{
	
	@Autowired
	CoditationDao coditationDao;
	
	public String AddCategoryService(Category category) 
	{
		String Men=category.getCategoryName();
		Category men=new Category(Men);
		
		if(category.getCategory()!=null) 
		{ 
			String jacket=category.getCategory().getCategoryName(); 
			Category Jacket=new Category(jacket,men);
		  	if(category.getCategory().getCategory()!=null) 
		  	{ 
		  		String rainjacket=category.getCategory().getCategory().getCategoryName(); 
		  		Category RainJacket=new Category(rainjacket, Jacket); 
		  		Jacket.addChildren(RainJacket);
		  	} 
		  	men.addChildren(Jacket); 
		}
		String msg=coditationDao.AddCategoryDao(men);
		return msg;
	}

	public List<Category> GetAllCategoryService() {
		List<Category> CategoryList=coditationDao.GetAllCategoryDao();
		return CategoryList;
	}

	public String AddProductService(Product product) {
		String message=coditationDao.AddProductDao(product);
		return message;
	}

	public ArrayList<Product> GetAllProductService() {
		List<Product> ProductList=coditationDao.GetAllProductDao();			
		return (ArrayList<Product>)ProductList;
	}

	public String UpdateProductService(Product product) {
		String message=coditationDao.UpdateProductDao(product);
		return message;
	}
}
