/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portal.Inmobiliairo.repository;

import com.portal.Inmobiliairo.model.entity.City;
import com.portal.Inmobiliairo.model.entity.Province;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Gamer
 */
public interface ICityRepository extends JpaRepository<City, Long>
{
    List<City> findAllByProvince(Province province);
}
