package kodlamaio.hrms.entities.abstracts;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="users")
public abstract class Users {
		@Id
		@GeneratedValue
		@Column(name = "id")
		private int id;

		@Column(name = "email")
		private String email;
		
		@Column(name="password")
		private String password;
	
}