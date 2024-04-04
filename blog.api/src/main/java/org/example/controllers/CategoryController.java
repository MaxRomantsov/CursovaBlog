package org.example.controllers;

import lombok.AllArgsConstructor;
import org.example.entities.CategoryEntity;
import org.example.repositories.CategoryRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.example.storage.FileSaveFormat;
import org.example.storage.StorageService;
import org.springframework.http.MediaType;
import org.example.dto.CategoryItemDTO;
import org.example.mapper.CategoryMapper;
import org.springframework.web.bind.annotation.*;
import org.example.dto.CategoryCreateDTO;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/categories")
public class CategoryController {

    private final CategoryMapper categoryMapper;
    private final CategoryRepository categoryRepository;
    private final StorageService storageService;

    @GetMapping
    public ResponseEntity<List<CategoryItemDTO>> index() {
        List<CategoryEntity> list = categoryRepository.findAll();
        var result =  categoryMapper.categoryItemDTOList(list);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping(value="", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<CategoryItemDTO> create(@ModelAttribute CategoryCreateDTO model) {
        var entity = categoryMapper.categoryEntityByCategoryCreateDTO(model);
        categoryRepository.save(entity);
        var result = categoryMapper.categoryItemDTO(entity);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/{categoryId}")
    public ResponseEntity<CategoryItemDTO> getById(@PathVariable int categoryId) {
        var entity = categoryRepository.findById(categoryId).orElse(null);
        if (entity == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        var result =  categoryMapper.categoryItemDTO(entity);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
