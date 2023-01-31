package com.gable.runma.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

@Entity
@Data
public class Runner extends User{
	private String emergencyName;
	private String emergencyPhone;
	private String chronicDisease;
}
