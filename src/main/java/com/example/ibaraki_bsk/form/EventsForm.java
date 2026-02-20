package com.example.ibaraki_bsk.form;

import java.time.LocalDate;

import lombok.Data;

@Data
public class EventsForm {
    private Integer event_id;
	private LocalDate event_date;
	private String location;
    private Integer facility_cost;
    private Integer is_held;
    private String notes;
}
