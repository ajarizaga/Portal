/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portal.Inmobiliario.controller;

import com.portal.Inmobiliario.model.dto.Orientation.CreateOrientationRequest;
import com.portal.Inmobiliario.model.dto.Orientation.OrientationResponse;
import com.portal.Inmobiliario.service.IOrientationService;
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
@RequestMapping("/api/orientations")
public class OrientationController 
{
    private final IOrientationService orientationService;
    
    @GetMapping
    public List<OrientationResponse> findAll()    
    {
        return orientationService.findAll();
    }
    
    @GetMapping("/{id}")
    public OrientationResponse findById(@PathVariable Long id)
    {
        return orientationService.findbyId(id);
    }
    
    @PostMapping
    public ResponseEntity<OrientationResponse> save(@Valid @RequestBody CreateOrientationRequest request)
    {
        OrientationResponse response = orientationService.save(request);
        return ResponseEntity.created(URI.create("(api/orientations/" + response.getId())).body(response);
    }
    
    @PutMapping("/{id}")
    public OrientationResponse update(@PathVariable Long id, @Valid @RequestBody CreateOrientationRequest request)
    {
        return orientationService.update(id, request);
    }
    
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id)
    {
        orientationService.deleteByid(id);
    }
    
}
