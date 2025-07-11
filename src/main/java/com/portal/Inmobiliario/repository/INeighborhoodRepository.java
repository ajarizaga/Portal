/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portal.Inmobiliario.repository;

import com.portal.Inmobiliario.model.entity.City;
import com.portal.Inmobiliario.model.entity.Neighborhood;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Gamer
 */
public interface INeighborhoodRepository extends JpaRepository<Neighborhood, Long>
{
    List <Neighborhood> findAllByCity(City city);
}
