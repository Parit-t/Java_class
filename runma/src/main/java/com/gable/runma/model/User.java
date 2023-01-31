package com.gable.runma.model;


import java.util.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Entity
@Data
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String password;
	private String firstName;
	private String email;
	private String phone;
	private Long nid;
	private Gender gender;
	@Temporal(TemporalType.DATE)
	private Date date;
	private String address;
	private String country;
	private String province;
	private String district;
	private String subDistrict;
	private Integer postalCode;
}
