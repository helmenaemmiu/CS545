package com.example.CS545.helper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
public class ListMapper<T,E> {

    @Autowired
    ModelMapper modelMapper;

    /**
     *
     * This method will traverse through a list and map all the elements with a Dto or vice versa
     *
     * @param list This is the list of elements that you want you want to convert to.
     * @param convertTo This is the type of class that it will convert to.
     * @return This will return a generic type holding a list of converted elements (NOTE: Downcast to the wiling type when you call the method)
     */
    public List<?> mapList(Iterable<T > list, E convertTo){
        return
                StreamSupport.stream(list.spliterator(), false)
                .map(e -> modelMapper.map(e,convertTo.getClass()))
                .collect(Collectors.toList());
    }



}
