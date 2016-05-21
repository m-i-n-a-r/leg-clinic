package it.leg.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Admin {
	
	
        @Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;

		@Column(nullable = false)
		private String firstName;

		@Column(nullable = false)
		private String lastName;
		
		@Column(unique=true)
		private String email;
		
		@Column(nullable = false)
		private String password;

		
	    public Admin(String firstName,String lastName,String email,String password) {
	    	
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		
	}

	// System management related methods

}
