package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Entity
//@Data
//@AllArgsConstructor
//public class Product {
//	@Id
//	@GeneratedValue
//	   private int id;
//	   private String name;
//}

@Entity
public class Product {
	@Id
	@GeneratedValue
	   private int id;
	   private String name;

	   public Product() {
		   super();
	   }
	   
	   public Product(int id, String name) {
		   super();
		   this.id = id;
		   this.name = name;
	   }
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
	}