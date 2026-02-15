package com.example.ibaraki_bsk.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;
import java.util.Optional;

import com.example.ibaraki_bsk.entity.Members;
import com.example.ibaraki_bsk.form.MembersForm;
import com.example.ibaraki_bsk.service.MembersService;

import org.springframework.web.bind.annotation.GetMapping;


@RequestMapping("/members")
@Controller
public class MembersController {
    
    @Autowired
    MembersService service;

    @ModelAttribute
    public MembersForm setupForm() {
        MembersForm form = new MembersForm();
        return form;
    }

    /**
     * 一覧表示
     * @param membersForm
     * @param model
     * @return
     */
    @GetMapping
    public String showList(MembersForm membersForm, Model model) {
		membersForm.setNewMember(true); // 新規登録設定(初期値をtrueとしておく) 
		Iterable<Members> members = service.selectAll(); // DB内のデータを全件取得
		model.addAttribute("list", members); 
		return "members";
    }
    
    /**
     * 登録機能
     * @param membersForm
     * @param bindingResult
     * @param model
     * @param redirectAttributes
     * @return
     */
	@PostMapping("/insert")
	public String insert(@Validated MembersForm membersForm, BindingResult bindingResult,
			Model model, RedirectAttributes redirectAttributes) {
		/* FormからEntityに詰め替え */
		Members members = makeMember(membersForm);
		
		/* 入力チェック */
		if( !bindingResult.hasErrors()) {
			service.save(members);
			return "redirect:/members";
		} else {
			/* エラーがある場合は、一覧表示処理を呼ぶ */
			return showList(membersForm, model);
		}
	}
	
    /**
     * 更新機能
     * @param membersForm
     * @param member_id
     * @param model
     * @return
     */
	@GetMapping("/{id}")
	public String ShowUpdate(MembersForm membersForm, @PathVariable Integer id, Model model) {
		/* 表示する行を取得 */
		Optional<Members> membersOpt = service.selectOneById(id);
		/* membersFormに入れ直す */
		Optional<MembersForm> membersFormOpt = membersOpt.map(t -> makeMembersForm(t));
		/* membersFormがnullでなければ中身を取り出す */
		if(membersFormOpt.isPresent()) {
			membersForm = membersFormOpt.get();
		}
		makeUpdateModel(membersForm, model);
		return "members";
	}
	
    /**
     * 更新用のModelを作成
     * @param membersForm
     * @param model
     */
	private void makeUpdateModel(MembersForm membersForm, Model model) {
		model.addAttribute("id", membersForm.getMember_id());
		membersForm.setNewMember(false);
		model.addAttribute("membersForm", membersForm);
	}
	
    /**
     * idをキーにしてデータを更新
     * @param membersForm
     * @param result
     * @param model
     * @param redirectAttributes
     * @return
     */
	@PostMapping("/update")
	public String update(@Validated MembersForm membersForm, BindingResult result,
        Model model, RedirectAttributes redirectAttributes) {
		Members members = makeMember(membersForm);
		if(!result.hasErrors()) {
			service.updateMember(members);
            return "redirect:/members/" + members.getMember_id();
		} else {
			makeUpdateModel(membersForm, model);
			return "members";
        }
	}
	
    /**
     * データを新規登録
     * @param membersForm
     * @return
     */
	private Members makeMember(MembersForm membersForm) {
		Members members = new Members();
		members.setMember_id(membersForm.getMember_id());
		members.setName(membersForm.getName());
		members.setLine_name(membersForm.getLine_name());
		members.setCreated_at(LocalDateTime.now());
		return members;
	}
	
    /**
     * フォームを生成
     * @param members
     * @return
     */
	private MembersForm makeMembersForm(Members members) {
		MembersForm form = new MembersForm();
		form.setMember_id(members.getMember_id());
		form.setName(members.getName());
		form.setLine_name(members.getLine_name());
		form.setCreated_at(members.getCreated_at());
		form.setNewMember(false);
		return form;
    }
}
