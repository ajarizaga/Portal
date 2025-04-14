/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portal.Inmobiliairo.repository;

import com.portal.Inmobiliairo.model.entity.DeedDetail;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Gamer
 */
public interface IDeedDetailRepository extends JpaRepository<DeedDetail, Long>{
    
}
