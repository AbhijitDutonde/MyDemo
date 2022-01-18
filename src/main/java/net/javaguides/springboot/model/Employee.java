package net.javaguides.springboot.model;


import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employee")

public class Employee {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long id;

@Column(name = "first_name")
private String firstname;

@Column(name = "last_name")
private String lastname;

@Column(name = "email_id")
private String emailId;
}
