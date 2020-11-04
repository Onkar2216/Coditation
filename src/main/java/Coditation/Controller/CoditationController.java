package Coditation.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Coditation.Model.Category;
import Coditation.Model.Product;
import Coditation.Service.CoditationService;

@RestController
@CrossOrigin
@RequestMapping("Coditation")
@ComponentScan("Coditation")
public class CoditationController 
{

	@Autowired
	CoditationService coditationService;
	
	@PostMapping("/AddCategory")
	public ResponseEntity<String> AddCategory(@RequestBody Category category)
	{
		String message=coditationService.AddCategoryService(category);
		return new ResponseEntity<String>(message,HttpStatus.CREATED);
	}
	
	
	@GetMapping("/GetAllCategory")
	public ResponseEntity<List<Category>> GetAllCategory()
	{
		List<Category> CategoryList=coditationService.GetAllCategoryService();
		return new ResponseEntity<List<Category>>(CategoryList, HttpStatus.OK);
	}
	
	@PostMapping("/AddProduct")
	public ResponseEntity<String> AddProduct(@RequestBody Product product)
	{
		String message=coditationService.AddProductService(product);
		return new ResponseEntity<String>(message,HttpStatus.CREATED);
	}
	
	@GetMapping("/GetAllProduct")
	public ResponseEntity<ArrayList<Product>> GetAllProduct()
	{
		ArrayList<Product> ProductList=coditationService.GetAllProductService();
		return new ResponseEntity<ArrayList<Product>>(ProductList, HttpStatus.OK);
	}
	
	@PutMapping("/UpdateProduct")
	public ResponseEntity<String> UpdateProduct(@RequestBody Product product)
	{
		String message=coditationService.UpdateProductService(product);
		return new ResponseEntity<String>(message,HttpStatus.OK);
	}
}
