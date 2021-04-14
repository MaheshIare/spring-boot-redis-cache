/**
 * 
 */
package com.java.techhub.redis.demo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author mahes
 *
 */
@Setter
@Getter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "USERS")
public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "USER_ID")
	@ApiModelProperty(name = "User ID", required = false, notes = "The database generated user ID", allowEmptyValue = false, dataType = "java.lang.Integer", hidden = true)
	private Integer userId;

	@ApiModelProperty(name = "First Name", required = true, notes = "First name of the user", allowEmptyValue = true, dataType = "java.lang.String")
	@Column(name = "FIRST_NAME")
	private String firstName;

	@ApiModelProperty(name = "Middle Name", required = false, notes = "Middle name of the user", allowEmptyValue = true, dataType = "java.lang.String")
	@Column(name = "MIDDLE_NAME")
	private String middleName;

	@ApiModelProperty(name = "Last Name", required = true, notes = "Last name of the user", allowEmptyValue = true, dataType = "java.lang.String")
	@Column(name = "LAST_NAME")
	private String lastName;

	@ApiModelProperty(name = "Email ID", required = true, notes = "Email ID of the user", allowEmptyValue = true, dataType = "java.lang.String", allowableValues = ".*@.*\\..*", example = "example@example.com")
	@Column(name = "EMAIL")
	private String email;

	/**
	 * @param firstName
	 * @param middleName
	 * @param lastName
	 * @param email
	 */
	public User(String firstName, String middleName, String lastName, String email) {
		super();
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.email = email;
	}
	
}
