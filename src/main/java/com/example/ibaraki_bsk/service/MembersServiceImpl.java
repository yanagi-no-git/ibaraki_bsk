package com.example.ibaraki_bsk.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.ibaraki_bsk.repository.MembersRepository;
import com.example.ibaraki_bsk.entity.Members;

@Service
@Transactional
public class MembersServiceImpl implements MembersService{

    @Autowired
    MembersRepository repository;

    @Override
    public Iterable<Members> selectAll(){
        return repository.findAll();
    }

    @Override
    public Optional<Members> selectOneById(Integer member_id){
        return repository.findById(member_id);
	}

    @Override
    public void save(Members member){
        repository.save(member);
    }

	@Override
	public void updateMember(Members member) {
		repository.save(member);
	}
    
}
