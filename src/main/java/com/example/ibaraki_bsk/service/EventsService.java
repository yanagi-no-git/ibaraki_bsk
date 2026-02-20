package com.example.ibaraki_bsk.service;

import com.example.ibaraki_bsk.entity.Events;

public interface EventsService {

    Iterable<Events> selectAll();
}
