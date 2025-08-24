/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portal.Inmobiliario.service;

import com.portal.Inmobiliario.model.dto.Characteristic.CharacteristicResponse;
import com.portal.Inmobiliario.model.dto.Characteristic.CreateCharacteristicRequest;
import java.util.List;


public interface ICharacteristicService 
{
    CharacteristicResponse findById(Long id);
    List<CharacteristicResponse> findAll();
    CharacteristicResponse save(CreateCharacteristicRequest request);
    CharacteristicResponse update(Long id, CreateCharacteristicRequest request);
    void deleteById(Long id);
 }
