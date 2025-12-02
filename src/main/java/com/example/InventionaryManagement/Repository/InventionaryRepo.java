package com.example.InventionaryManagement.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.InventionaryManagement.Entities.ItemEntity;

public interface InventionaryRepo extends JpaRepository<ItemEntity,Long>{ 

    @Query("SELECT i FROM ItemEntity i WHERE i.price BETWEEN :min AND :max")
    Page<ItemEntity> filterByPrice(@Param("min") double min,
                                   @Param("max") double max,
                                   Pageable pageable);

}
