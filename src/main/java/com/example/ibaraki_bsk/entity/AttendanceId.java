package com.example.ibaraki_bsk.entity;

import java.io.Serializable;
import lombok.Data;

@Data
public class AttendanceId implements Serializable {
    private Integer member_id;
    private Integer event_id; 
}