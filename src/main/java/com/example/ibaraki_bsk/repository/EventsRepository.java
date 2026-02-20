package com.example.ibaraki_bsk.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.ibaraki_bsk.entity.Events;

public interface EventsRepository extends CrudRepository<Events, Integer>{
    
}