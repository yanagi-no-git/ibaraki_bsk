package com.example.ibaraki_bsk.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.ibaraki_bsk.entity.Finances;
import com.example.ibaraki_bsk.form.FinancesForm;
import com.example.ibaraki_bsk.service.FinancesService;

@RequestMapping("/finances")
@Controller
public class FinancesController {
    
    @Autowired
    FinancesService service;

    /**
     * 一覧表示
     * @param financesForm
     * @param model
     * @return
     */
    @GetMapping
    public String showList(FinancesForm financesForm, Model model) {
		Iterable<Finances> members = service.selectAll(); // DB内のデータを全件取得
		model.addAttribute("list", members); 
		return "finances";
    }
}
