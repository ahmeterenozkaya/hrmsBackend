package com.hrms.hrms.entities.concretes.users;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="employer_status")
public class EmployerStatus {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="employer_status_id")
	private int employerStatusId;
	
	@NotNull
	@Column(name="employer_id")
	private int employerId;
	
	@NotNull
	@Column(name="status")
	private boolean status;
	
	@Column(name="candidate_id")
	private int candidateId;
	
	@Column(name="note")
	private String note;

	public EmployerStatus(int employerId, boolean status) {
		super();
		this.employerId = employerId;
		this.status = status;
	}
	
	
	
}
