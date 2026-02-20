package com.example.ibaraki_bsk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.ibaraki_bsk.repository.FinancesRepository;
import com.example.ibaraki_bsk.entity.Finances;

@Service
@Transactional
public class FinancesServiceImpl implements FinancesService{

    @Autowired
    FinancesRepository repository;

    @Override
    public Iterable<Finances> selectAll(){
        return repository.findAll();
    }
}
