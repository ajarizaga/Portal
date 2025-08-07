/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portal.Inmobiliario.service;

import com.portal.Inmobiliario.exceptions.NotFoundException;
import com.portal.Inmobiliario.mapper.IOperationMapper;
import com.portal.Inmobiliario.model.dto.Operation.CreateOperationRequest;
import com.portal.Inmobiliario.model.dto.Operation.OperationResponse;
import com.portal.Inmobiliario.model.entity.Operation;
import com.portal.Inmobiliario.repository.IOperationRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OperationServiceImplement implements IOperationService
{
    private final IOperationMapper operationMapper;
    private final IOperationRepository operationRepository;

    @Override
    public OperationResponse findById(Long id) 
    {
        return operationRepository.findById(id)
            .map(operationMapper::toOperationResponse)
            .orElseThrow(NotFoundException::new);
    }

    @Override
    public List<OperationResponse> findAll() 
    {
        return operationRepository.findAll()
            .stream()
            .map(operationMapper::toOperationResponse)
            .collect(Collectors.toList());
    }

    @Override
    public OperationResponse save(CreateOperationRequest request) 
    {
        Operation operation = new Operation();
        operation.setOperation(request.getOperation());
        Operation savedOperation = operationRepository.save(operation);
        return findById(savedOperation.getId());
    }

    @Override
    public OperationResponse update(Long id, CreateOperationRequest request) 
    {
        return operationRepository.findById(id)
            .map(operation->{
                operation.setOperation(request.getOperation());
                return operationRepository.save(operation);
            })
            .map(operationMapper::toOperationResponse)
            .orElseThrow(NotFoundException::new);
    }

    @Override
    public void deleteById(Long id) 
    {
        if(operationRepository.findById(id).isEmpty())
        {
            throw new NotFoundException();
        }
        else
            operationRepository.deleteById(id);
    }
    
    
}
