package com.example.ibaraki_bsk.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.ibaraki_bsk.entity.Finances;

public interface FinancesRepository extends CrudRepository<Finances, Integer>{
    
}