package com.example.ibaraki_bsk.form;

import lombok.Data;

@Data
public class AttendanceForm {
    private Integer member_id;
    private Integer event_id;
    private Integer is_paid;
}
