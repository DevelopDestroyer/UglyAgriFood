package com.ugly.agri.service;

import com.ugly.agri.type.CategoryType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
@Service
@RequiredArgsConstructor
public class CategoryService {
    public List<String> getCategories() {
        return Stream.of(CategoryType.values())
                .map(m -> m.getCategoryName())
                .collect(Collectors.toList());
    }
}
