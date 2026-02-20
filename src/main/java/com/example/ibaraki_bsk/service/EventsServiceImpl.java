package com.example.ibaraki_bsk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.ibaraki_bsk.repository.EventsRepository;
import com.example.ibaraki_bsk.entity.Events;

@Service
@Transactional
public class EventsServiceImpl implements EventsService{

    @Autowired
    EventsRepository repository;

    @Override
    public Iterable<Events> selectAll(){
        return repository.findAll();
    }
}
