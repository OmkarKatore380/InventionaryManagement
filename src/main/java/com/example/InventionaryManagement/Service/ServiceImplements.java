package com.example.InventionaryManagement.Service;

import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.InventionaryManagement.Entities.ItemEntity;
import com.example.InventionaryManagement.Entities.ItemFilterDto;
import com.example.InventionaryManagement.Entities.ItemRequestDto;
import com.example.InventionaryManagement.Entities.ItemResponseDto;
import com.example.InventionaryManagement.Entities.PageRequestDto;
import com.example.InventionaryManagement.Entities.PageResponseDto;
import com.example.InventionaryManagement.Repository.InventionaryRepo;

@Service
public class ServiceImplements implements InventionaryServices {

    @Autowired
    private InventionaryRepo repo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ItemResponseDto addItems(ItemRequestDto requestDto) {

        ItemEntity entity = modelMapper.map(requestDto, ItemEntity.class);

        ItemEntity saved = repo.save(entity);

        return modelMapper.map(saved, ItemResponseDto.class);
    }

    @Override
    public PageResponseDto getPageItems(PageRequestDto dto) {

        Pageable pageable = PageRequest.of(
                dto.getPage(),
                dto.getSize(),
                Sort.by(dto.getSortBy())
        );

        Page<ItemEntity> pageData = repo.findAll(pageable);

        PageResponseDto response = new PageResponseDto();

        response.setItems(
                pageData.getContent()
                        .stream()
                        .map(item -> modelMapper.map(item, ItemResponseDto.class))
                        .collect(Collectors.toList())
        );

        response.setPage(dto.getPage());
        response.setSize(dto.getSize());
        response.setTotalItems(pageData.getTotalElements());
        response.setTotalPages(pageData.getTotalPages());

        return response;
    }

    @Override
    public PageResponseDto filterItems(ItemFilterDto dto) {
        Pageable pageable = PageRequest.of(dto.getPage(),
        dto.getSize(),
        Sort.by(dto.getSortBy()));

        Page<ItemEntity> pageData = repo.filterByPrice(dto.getMinPrice(),dto.getMaxPrice(), pageable);
        PageResponseDto response = new PageResponseDto();
        response.setItems(
            pageData.getContent()
            .stream()
            .map(item-> modelMapper.map(item, ItemResponseDto.class))
            .collect(Collectors.toList()));

            response.setPage(dto.getPage());
            response.setSize(dto.getSize());
            response.setTotalItems(pageData.getTotalElements());
            response.setTotalPages(pageData.getTotalPages());
            return response;
    }

    @Override
    public ItemResponseDto UpdateItem(long id, ItemRequestDto dto) {
        ItemEntity item = repo.findById(id).orElseThrow(()-> new RuntimeException("item not found "+id));
        item.setName(dto.getName());
        item.setDescription(dto.getDescription());
        item.setPrice(dto.getPrice());
        return modelMapper.map(repo.save(item),ItemResponseDto.class);
        }

    @Override
    public String deleteItem(long id) {
        ItemEntity item=repo.findById(id).orElseThrow(()->new RuntimeException("item not found"));
        repo.delete(item);
        return "Item Deleted";
    }

    
    
}
