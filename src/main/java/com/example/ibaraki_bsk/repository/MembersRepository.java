package com.example.ibaraki_bsk.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.ibaraki_bsk.entity.Members;

public interface MembersRepository extends CrudRepository<Members, Integer>{
    
}