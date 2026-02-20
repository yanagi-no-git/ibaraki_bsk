package com.example.ibaraki_bsk.service;

import com.example.ibaraki_bsk.entity.Attendance;

public interface AttendanceService {

    Iterable<Attendance> selectAll();
}
