package com.example.ibaraki_bsk.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Events {
    @Id
    private Integer event_id;
    private LocalDate event_date;
    private String location;
    private Integer facility_cost;
    private	Integer is_held;
    private String notes;
}
