package com.aureus.test.entities;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="M_User")
@Entity
public class UserEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="user_id")
	private long userid;
	@Column(name="firstName")
	private String firstName;
	@Column(name="lastName")
	private String lastName;
	@JsonFormat(pattern="dd/MM/yyyy")
	@Column(name="dateOfBirth")
	private Date dateOfBirth;
	@Column(name="city")
	private String city;
	@Column(name="state")
	private String state;
	
	public String toStringDate()
	{
		return firstName+":"+lastName+":"+new SimpleDateFormat("yyyy-MM-dd").format(dateOfBirth)+":"+city+":"+state;
	}
	
	public String toStringDateTime1()
	{
		return firstName+":"+lastName+":"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(dateOfBirth)+":"+city+":"+state;
	}
	
	public String toStringDateTime2()
	{
		return firstName+":"+lastName+":"+new SimpleDateFormat("yyyy-MM-dd HH:mm").format(dateOfBirth)+":"+city+":"+state;
	}

}
