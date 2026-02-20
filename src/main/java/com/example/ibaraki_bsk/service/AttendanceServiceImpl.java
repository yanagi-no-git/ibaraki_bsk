package com.example.ibaraki_bsk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.ibaraki_bsk.repository.AttendanceRepository;
import com.example.ibaraki_bsk.entity.Attendance;

@Service
@Transactional
public class AttendanceServiceImpl implements AttendanceService{

    @Autowired
    AttendanceRepository repository;

    @Override
    public Iterable<Attendance> selectAll(){
        return repository.findAll();
    }
}
