/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portal.Inmobiliario.service;

import com.portal.Inmobiliario.model.dto.Nieghborhood.CreateNeighborhoodRequest;
import com.portal.Inmobiliario.model.dto.Nieghborhood.NeighborhoodResponse;
import java.util.List;

/**
 *
 * @author garro
 */
public interface INeighborhoodService 
{
    NeighborhoodResponse findById(Long id);
    List<NeighborhoodResponse> findAll();
    List<NeighborhoodResponse> findByCityId(Long id);
    NeighborhoodResponse save(CreateNeighborhoodRequest request);
    NeighborhoodResponse update(Long id, CreateNeighborhoodRequest request);
    void deleteById(Long id);
}
