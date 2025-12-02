package com.example.InventionaryManagement.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.InventionaryManagement.Entities.ItemFilterDto;
import com.example.InventionaryManagement.Entities.ItemRequestDto;
import com.example.InventionaryManagement.Entities.ItemResponseDto;
import com.example.InventionaryManagement.Entities.PageRequestDto;
import com.example.InventionaryManagement.Entities.PageResponseDto;
import com.example.InventionaryManagement.Service.InventionaryServices;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("/items")
public class InventionaryController {
@Autowired 
private InventionaryServices services;
@PostMapping("/create")
public ItemResponseDto createItem(@RequestBody ItemRequestDto requestDto) {
    return services.addItems(requestDto);
}

@PostMapping("/page")
public PageResponseDto getPage(@RequestBody PageRequestDto pageRequestDto) {
    return services.getPageItems(pageRequestDto);
}
@PostMapping("/filter")
public PageResponseDto filterMethod(@RequestBody ItemFilterDto dto) {
    return services.filterItems(dto);
}

@PutMapping("/update/{id}")
public ItemResponseDto putMethodName(@PathVariable Long id, @RequestBody ItemRequestDto requestDto) {
    return services.UpdateItem(id, requestDto);
}
@DeleteMapping("delete/{id}")
public String deleteMethod(@PathVariable Long id){
    return services.deleteItem(id);
}
}
