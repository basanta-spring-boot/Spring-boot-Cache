package com.spring.enable.cache.api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "MyUser")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class UserModel {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String profession;
	private String[] address;

}
