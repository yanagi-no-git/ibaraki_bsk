package com.example.ibaraki_bsk.service;

import com.example.ibaraki_bsk.entity.Finances;

public interface FinancesService {

    Iterable<Finances> selectAll();
}
