/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portal.Inmobiliario.controller;

import com.portal.Inmobiliario.model.dto.DeedDetails.CreateDeedDetailRequest;
import com.portal.Inmobiliario.model.dto.DeedDetails.DeedDetailResponse;
import com.portal.Inmobiliario.service.IDeedDetailService;
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
@RequestMapping("/api/deeddetails")
public class DeedDetailController 
{
    private final IDeedDetailService deedDetailService;
    
    @GetMapping
    private List<DeedDetailResponse> findAll()
    {
        return deedDetailService.findAll();
    }
    
    @GetMapping("/{id}")
    private DeedDetailResponse findById(@PathVariable Long id)
    {
        return deedDetailService.findById(id);
    }
    
    @PostMapping
    private ResponseEntity<DeedDetailResponse> save(@Valid @RequestBody CreateDeedDetailRequest request)
    {
        DeedDetailResponse response = deedDetailService.save(request);
        return ResponseEntity.created(URI.create("api/deedDetails/" + response.getId())).body(response);
    }
    
    @PutMapping("{id}")
    private DeedDetailResponse update(@PathVariable Long id, @Valid @RequestBody CreateDeedDetailRequest request)
    {
        return deedDetailService.update(id, request);
    }
    
    @DeleteMapping("{id}")
    private void deleteById(@PathVariable Long id)
    {
        deedDetailService.deleteById(id);
    }
}
