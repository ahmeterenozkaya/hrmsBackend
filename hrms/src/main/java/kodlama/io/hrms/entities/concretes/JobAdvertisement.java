package kodlama.io.hrms.entities.concretes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="job_advertisements")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class JobAdvertisement {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) //AutoIncrement
	@Column(name="id")
	private int id;
	
	@Column(name = "job_description")
	private String jobDescription;
	
	@Column(name="application_deadline")
	private Date applicationDeadline;
	
	@Column(name = "posting_date")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date postingDate;
	
	@Column(name="is_active")
	private boolean isActive;
	
	@Column(name="max_salary")
	private double maxSalary;
	
	@Column(name="min_salary")
	private double minSalary;
	
	@Column(name = "number_of_open_positions")
	private int openPositions;
	
	@ManyToOne()
	@JoinColumn(name="employer_id")
	private Employer employer;
	
	@ManyToOne()
	@JoinColumn(name="city_id")
	private City city;
	
	@ManyToOne()
	@JoinColumn(name="job_position_id")
	private JobPosition jobPosition;
}
