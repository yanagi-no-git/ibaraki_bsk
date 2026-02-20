package com.example.ibaraki_bsk.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/")
@Controller
public class TopController {
    /**
     * トップ画面表示
     * @return
     */
    @GetMapping
    public String showTop() {
		return "top";
    }
}
