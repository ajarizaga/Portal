/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portal.Inmobiliario.mapper;

import org.mapstruct.Mapper;


@Mapper(componentModel = "spring", uses = INeighborhoodMapper.class)
//@Mapper(componentModel = "spring", uses = {INeighborhoodMapper.class, IAddressMapper.class, IUserDetailsMapper.class})
//incluir todas 
//LLEVO 1:30 MIN
public interface IOwnershipMapper {
    
}
