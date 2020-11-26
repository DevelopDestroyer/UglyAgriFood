package com.ugly.agri.service;

import com.google.common.collect.Lists;
import com.ugly.agri.dto.ResponseRetailProductDTO;
import com.ugly.agri.repository.RetailProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class RetailProductService {
    private final RetailProductRepository retailProductRepository;

    public List<ResponseRetailProductDTO> getRetailProducts() {
        List<ResponseRetailProductDTO> retailProductDTOList = Lists.newArrayList();
        retailProductRepository.findAll().forEach(retailProduct -> retailProductDTOList.add(ResponseRetailProductDTO.of(retailProduct)));
        return retailProductDTOList;
    }
}
