/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portal.Inmobiliario.controller;

import com.portal.Inmobiliario.model.dto.Characteristic.CharacteristicResponse;
import com.portal.Inmobiliario.model.dto.Characteristic.CreateCharacteristicRequest;
import com.portal.Inmobiliario.service.ICharacteristicService;
import jakarta.validation.Valid;
import java.net.URI;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/characteristics")
public class CharacteristicController 
{
    private final ICharacteristicService characteristicService;
    
    @GetMapping
    public List<CharacteristicResponse> findAll()
    {
        return characteristicService.findAll();
    }
    
    @GetMapping("/{id}")
    public CharacteristicResponse findById(@PathVariable Long id)
    {
        return characteristicService.findById(id);
    }
    
    @PostMapping
    public ResponseEntity<CharacteristicResponse> save(@Valid @RequestBody CreateCharacteristicRequest request)
    {
        CharacteristicResponse response = characteristicService.save(request);
        return ResponseEntity.created(URI.create("api/characteristics/" + response.getId())).body(response);
    }
    
    @PutMapping("/{id}")
    public CharacteristicResponse update(@PathVariable Long id, @RequestBody CreateCharacteristicRequest request)
    {
        return characteristicService.update(id, request);
    }
    
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id)
    {
        characteristicService.deleteById(id);
    }
}
