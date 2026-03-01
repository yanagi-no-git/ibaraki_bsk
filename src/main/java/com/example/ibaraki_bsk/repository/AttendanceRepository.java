package com.example.ibaraki_bsk.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.ibaraki_bsk.entity.AttendanceId;
import com.example.ibaraki_bsk.entity.Attendance;

public interface AttendanceRepository extends CrudRepository<Attendance, AttendanceId>{
    
}