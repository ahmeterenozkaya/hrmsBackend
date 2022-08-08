package com.hrms.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.hrms.hrms.entities.abstracts.Users;
import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Table(name="employers")
@PrimaryKeyJoinColumn(name="user_id")
public class Employers extends Users{
	 
	@NotNull
	@Column(name="company_name")
	private String companyName;
	
	@NotNull
	@Column(name="web_address")
	private String webSite;
	
	@NotNull
	@Column(name="phone_number")
	private String phoneNumber;
	
	@Column(name="status")
	private Boolean status;
	
}
