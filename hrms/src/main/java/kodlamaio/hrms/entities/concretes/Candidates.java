package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import kodlamaio.hrms.entities.abstracts.Users;
import lombok.Data;


@Data
@Entity
@Table(name="cantidates")
public class Candidates extends Users{
	
	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	
	@Column(name="first_name")
	private String firstName;
	
	
	@Column(name="last_name")
	private String lastName;
	
	
	@Column(name="identity_number")
	private String identityNumber;

	@Column(name="birth_year")
	private String birtOfYear;

}


