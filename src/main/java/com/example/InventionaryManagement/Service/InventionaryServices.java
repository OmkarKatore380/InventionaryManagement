package com.example.InventionaryManagement.Service;

import com.example.InventionaryManagement.Entities.ItemFilterDto;
import com.example.InventionaryManagement.Entities.ItemRequestDto;
import com.example.InventionaryManagement.Entities.ItemResponseDto;
import com.example.InventionaryManagement.Entities.PageResponseDto;

public interface InventionaryServices {
public ItemResponseDto addItems(ItemRequestDto requestDto);
public PageResponseDto getPageItems(com.example.InventionaryManagement.Entities.PageRequestDto pageRequestDto);
public PageResponseDto filterItems(ItemFilterDto dto);
public ItemResponseDto UpdateItem(long id, ItemRequestDto dto);
public String deleteItem(long id);

}
