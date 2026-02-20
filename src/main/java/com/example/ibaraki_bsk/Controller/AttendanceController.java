package com.example.ibaraki_bsk.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.ibaraki_bsk.entity.Attendance;
import com.example.ibaraki_bsk.form.AttendanceForm;
import com.example.ibaraki_bsk.service.AttendanceService;

@RequestMapping("/attendance")
@Controller
public class AttendanceController {
    @Autowired
    AttendanceService service;

    /**
     * 一覧表示
     * @param attendanceForm
     * @param model
     * @return
     */
    @GetMapping
    public String showList(AttendanceForm attendanceForm, Model model) {
		Iterable<Attendance> attendance = service.selectAll(); // DB内のデータを全件取得
		model.addAttribute("list", attendance); 
		return "attendance";
    }
}
