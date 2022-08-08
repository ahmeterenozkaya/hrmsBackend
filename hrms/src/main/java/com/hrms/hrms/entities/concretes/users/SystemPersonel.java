package com.hrms.hrms.entities.concretes.users;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.hrms.hrms.entities.abstracts.Users;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EqualsAndHashCode(callSuper = false)
@Table(name="candidates")
@PrimaryKeyJoinColumn(name="user_id")
public class SystemPersonel extends Users{

	@Column(name="name")
	private String name;
	
	@Column(name="surname")
	private String surname;
}
