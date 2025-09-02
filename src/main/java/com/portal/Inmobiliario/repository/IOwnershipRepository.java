/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portal.Inmobiliario.repository;

import com.portal.Inmobiliario.model.entity.City;
import com.portal.Inmobiliario.model.entity.Neighborhood;
import com.portal.Inmobiliario.model.entity.Ownership;
import com.portal.Inmobiliario.model.entity.OwnershipType;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOwnershipRepository  extends JpaRepository<Ownership, Long>
{
    List<Ownership> findAllByCity(City city);
    
    List<OwnershipType> findByOwnershipType(OwnershipType ownershipType);
    
    List<Neighborhood> findByNeigborhod(Neighborhood neighborhood);
}
