package com.challenge.conexa.model;

import java.time.ZonedDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "insurance")
public class Insurance {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private ZonedDateTime date_created;
    
    private String name;
    private String cnpj;
    private String price;

    @ManyToOne
    @JoinColumn(name="professional_id")
    private Professional professional;
}