package com.example.ibaraki_bsk.form;

import java.time.LocalDate;

import lombok.Data;

@Data
public class FinancesForm {
    private Integer finance_id;
	private LocalDate transaction_date;
	private String title;
    private String category;
    private Integer amount;
    private String notes;
}
