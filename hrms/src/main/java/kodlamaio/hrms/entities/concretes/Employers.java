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
@Table(name="employers")
public class Employers extends Users{
		
		@Id
		@GeneratedValue
		@Column(name="id")
		private int id;
		
		@Column(name="company_name")
		private String companyName;
		
		@Column(name="web_address")
		private String webAddress;
		
		@Column	(name="phone_number")
		private String phoneNumber;
		

}
