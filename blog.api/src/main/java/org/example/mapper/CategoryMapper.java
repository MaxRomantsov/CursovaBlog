package org.example.mapper;

import org.example.dto.CategoryItemDTO;
import org.example.entities.CategoryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.mapstruct.Mapping;
import org.example.dto.CategoryCreateDTO;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    CategoryItemDTO categoryItemDTO(CategoryEntity category);
    List<CategoryItemDTO> categoryItemDTOList(List<CategoryEntity> categories);

    CategoryEntity categoryEntityByCategoryCreateDTO(CategoryCreateDTO category);
}