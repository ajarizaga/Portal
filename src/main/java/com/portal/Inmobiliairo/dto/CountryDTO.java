/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portal.Inmobiliairo.dto;

import jakarta.validation.constraints.NotEmpty;

/**
 *
 * @author Gamer
 */
public class CountryDTO {
    private Long id;
    
    @NotEmpty
    private String country;

    public CountryDTO() {
    }

    public CountryDTO(Long id, String country) {
        this.id = id;
        this.country = country;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
    
    
}
