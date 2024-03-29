package com.challenge.conexa.utils;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class Mapper {
  final ModelMapper modelMapper = new ModelMapper();
  
  public <S, T> List<T> mapList(List<S> source, Class<T> targetClass) {
    return source
      .stream()
      .map(element -> modelMapper.map(element, targetClass))
      .collect(Collectors.toList());
  } 

  public <S, T> T map(S source, Class<T> targetClass) {
    return modelMapper.map(source, targetClass);
  } 
    
}