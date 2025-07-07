package com.sinse.hiberasync.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/* 
 * [ORM - Directly mapping between java's Object and relation in database  - absolutely Mapping with java model
 * JPA is a Java-supported interface and standard. 
	Hibernate is a private implementation of the JPA. Not standard.
	But it is used very much.
 */

@Data
@Entity
@Table(name = "food_type")
public class FoodType {
	@Id
	private int food_type_id;
	private String title;
	
}
