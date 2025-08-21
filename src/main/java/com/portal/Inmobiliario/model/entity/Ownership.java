/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portal.Inmobiliario.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.math.BigInteger;
import java.util.Date;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "ownership")
public class Ownership 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer rooms;
    private Integer bedrooms;
    private Integer bathrooms;
    private boolean garage;
    private Integer yearOfConstruction;
    private boolean plans;
    private String totalMeters;
    private String builtMeters;
    private BigInteger price;
    private Integer expenses;
    private Date publicateionDate;
    private Boolean deed;//se va a caracteristicas
    //private String deedDetails; 
    private String writingDesk;
    private Boolean gasWorkADay;
    
    @ManyToOne
    @JoinColumn(name = "neigborhood_id")
    private Neighborhood neigborhood;
    
    @ManyToOne
    @JoinColumn(name = "currency_id")
    private Currency currency;
    
    @ManyToOne
    @JoinColumn(name = "orientation_id")
    private Orientation orientation;
    
    /*@ManyToOne
    @JoinColumn(name = "deed_detail_id")
    private DeedDetail deedDetail;*/
    
    @ManyToOne
    @JoinColumn(name = "ownership_type_id")
    private OwnershipType ownershipType;
    
    @ManyToMany
    @JoinTable(
        name = "services_ownerships",
        joinColumns = @JoinColumn(name = "ownership_id"),
        inverseJoinColumns = @JoinColumn(name = "services_id")
    )
    private Set<Services> services;
    
}
