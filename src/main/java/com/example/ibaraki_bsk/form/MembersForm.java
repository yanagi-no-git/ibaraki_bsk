package com.example.ibaraki_bsk.form;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class MembersForm {
    private Integer member_id;
	private String name;
	private String line_name;
    private LocalDateTime created_at;
	
	/* 「登録」か「更新」判定用 */
	private Boolean NewMember;
}
