/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portal.Inmobiliario.service;

import com.portal.Inmobiliario.exceptions.NotFoundException;
import com.portal.Inmobiliario.mapper.ICharacteristicMapper;
import com.portal.Inmobiliario.model.dto.Characteristic.CharacteristicResponse;
import com.portal.Inmobiliario.model.dto.Characteristic.CreateCharacteristicRequest;
import com.portal.Inmobiliario.model.entity.Characteristic;
import com.portal.Inmobiliario.repository.ICharacteristicRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class CharacteristicServiceImplement implements ICharacteristicService
{
    private final ICharacteristicRepository characteristicRepository;
    private final ICharacteristicMapper characteristicMapper;
    @Override
    public CharacteristicResponse findById(Long id) 
    {
        return characteristicRepository.findById(id)
            .map(characteristicMapper::toCharacteristicResponse)
            .orElseThrow(NotFoundException::new);
    }

    @Override
    public List<CharacteristicResponse> findAll() 
    {
        return characteristicRepository.findAll()
            .stream()
            .map(characteristicMapper::toCharacteristicResponse)
            .collect(Collectors.toList());
    }

    @Override
    public CharacteristicResponse save(CreateCharacteristicRequest request) 
    {
        Characteristic characteristic = new Characteristic();
        characteristic.setCharacteristic(request.getCharacteristic());
        Characteristic savedCharacteristic = characteristicRepository.save(characteristic);
        return findById(savedCharacteristic.getId());
    }

    @Override
    public CharacteristicResponse update(Long id, CreateCharacteristicRequest request) 
    {
        return characteristicRepository.findById(id)
            .map(characteristic ->{
                characteristic.setCharacteristic(request.getCharacteristic());
                return characteristicRepository.save(characteristic);
            })
            .map(characteristicMapper::toCharacteristicResponse)
            .orElseThrow(NotFoundException::new);
    }

    @Override
    public void deleteById(Long id) 
    {
       if(characteristicRepository.findById(id).isEmpty())
       {
           throw new NotFoundException();
       }
       else
       {
           characteristicRepository.deleteById(id);
       }
    }
    
}



