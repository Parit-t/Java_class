package com.example.demo;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

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
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.ProductRepository;

@RestController()
@RequestMapping("/catalog")
public class ProductController {
	private static Map<Integer, Product> productRepo = new HashMap<>();
	   static {
	      Product honey = new Product( 1 , "Honey");
	      productRepo.put(honey.getId(), honey);
	      
	      Product almond = new Product(2, "Almond");
	      productRepo.put(almond.getId(), almond);
	   }
	   
	   @Autowired
	   private ProductRepository repo;
	   
	   @DeleteMapping("/products/{id}")
	   public ResponseEntity<Object> delete(@PathVariable("id") Integer id) { 
	      productRepo.remove(id);
	      return new ResponseEntity<>("Product is deleted successsfully", HttpStatus.OK);
	   }
	   
	   @PutMapping("/products/{id}")
	   public Product updateProduct(@PathVariable("id") Integer id,@RequestBody  Product product) { 
	      Product oldProduct = productRepo.get(id);
		  oldProduct.setName(product.getName());
	      return product;
	   }
	   
	   @PostMapping("/products")
	   public Product createProduct(@RequestBody Product product) {
	      //productRepo.put(product.getId(), product);
		  //product.setId(0);
		  repo.save(product);
	      return product;
	   }
	   
	   @GetMapping("/products")
	   public Iterable<Product> getProduct() {
		  return repo.findAll();
	      //return productRepo.values();
	   }
	   
	   @GetMapping("/products/{id}")
	   public Product getOneProduct(@PathVariable("id") int id) {
		  Product prod = repo.findById(id).orElseThrow();
//		  if (prod == null) {
//			  throw new RuntimeException("Product Not found");
//		  }
		  return prod;
	      //return productRepo.values();
	   }
}
