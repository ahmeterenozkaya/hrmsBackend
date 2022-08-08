package com.hrms.hrms.entities.concretes.users;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.hrms.hrms.entities.abstracts.Users;
import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EqualsAndHashCode(callSuper = false)
@PrimaryKeyJoinColumn(name="user_id")
@Table(name="employee")
public class Employee extends Users{

	@NotNull
	@Column(name="name")
	private String name;
	
	@NotNull
	@Column(name="surname")
	private String surname;
	
	@NotNull
	@Column(name="national_identity")
	private String tcNo;
	
	@NotNull
	@Column(name="year_of_birth")
	private int birthOfYear;
}
