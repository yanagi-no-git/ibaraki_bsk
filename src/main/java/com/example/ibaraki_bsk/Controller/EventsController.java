package com.example.ibaraki_bsk.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.ibaraki_bsk.entity.Events;
import com.example.ibaraki_bsk.form.EventsForm;
import com.example.ibaraki_bsk.service.EventsService;

@RequestMapping("/events")
@Controller
public class EventsController {
    @Autowired
    EventsService service;

    /**
     * 一覧表示
     * @param eventsForm
     * @param model
     * @return
     */
    @GetMapping
    public String showList(EventsForm eventsForm, Model model) {
		Iterable<Events> events = service.selectAll(); // DB内のデータを全件取得
		model.addAttribute("list", events); 
		return "events";
    }
}
