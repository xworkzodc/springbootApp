package com.xworkz.user_app.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name ="user_details")
public class UserEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -67041777636534145L;

	@Id
	@GenericGenerator(name = "primary" , strategy =  "increment")
	@GeneratedValue(generator = "primary")
	private Integer id;
	private String name;
	private String email;

	@Override
	public String toString() {
		return "UserEntity [id=" + id + ", name=" + name + ", email=" + email + "]";
	}

}
