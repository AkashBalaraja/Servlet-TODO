package dto;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.GenerationType;

import lombok.Data;

@Entity
@Data
public class Task {

	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  int id;
	  String name;
	  String description;
	  LocalDate taskDate;
	  LocalDate completionDate;
	  boolean status;
	  
}
