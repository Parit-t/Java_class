package com.example.something;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import productDAO.ProductRepo;

@RestController
@RequestMapping
public class ProductController {
	private static Map<Integer, Product> productRepo = new HashMap<>();
	   static {
	      Product honey = new Product( 1 , "Honey");
	      productRepo.put(honey.getId(), honey);
	      
	      Product almond = new Product(2, "Almond");
	      productRepo.put(almond.getId(), almond);
	   }
	   
	   @Autowired
	   private ProductRepo ProdRepo;
	   
	   @DeleteMapping(value = "/products/{id}")
	   public ResponseEntity<Object> delete(@PathVariable("id") int id) { 
	      productRepo.remove(id);
	      return new ResponseEntity<>("Product is deleted successsfully", HttpStatus.OK);
	   }
	   
	   @PutMapping(value = "/products/{id}")
	   public Product updateProduct(@PathVariable("id") Integer id,  @RequestBody Product product) { 
	      Product oldProduct = productRepo.get(id);
		  oldProduct.setName(product.getName());
	      
	      return product;
	   }
	   
	   @PostMapping(value = "/products")
	   public Product createProduct(@RequestBody Product product) {
	      //productRepo.put(product.getId(), product);
	      ProdRepo.save(product);
	      return product;
	   }
	   
	   @GetMapping(value = "/products")
	   public Iterable<Product> getProduct() {
	     // return productRepo.values();
	   	return ProdRepo.findAll();
	   }
}
