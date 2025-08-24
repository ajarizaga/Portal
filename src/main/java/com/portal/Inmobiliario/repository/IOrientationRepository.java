/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portal.Inmobiliario.repository;

import com.portal.Inmobiliario.model.entity.Orientation;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IOrientationRepository extends JpaRepository<Orientation, Long>{
    
}
