package com.SDEadda247.Kafkaconsumer.user;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "kafka_details")
public class user implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 88152598957926672L;
	private String name;

	@Id
	private String email;
	private String phone_number;

	public user() {

	}

	public user(String name, String email, String phone_number) {
		super();
		this.name = name;
		this.email = email;
		this.phone_number = phone_number;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "user [name=" + name + ", email=" + email + ", phone_number=" + phone_number + "]";
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
