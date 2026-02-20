package com.example.ibaraki_bsk.service;

import java.util.Optional;

import com.example.ibaraki_bsk.entity.Members;

public interface MembersService {
    Iterable<Members> selectAll();

    /**
	 * id(主キー)をキーにして1件取得する
	 * 戻り値型はOptional型を使用 
	 * isPresent()を使用でき、値がある場合はtrueを返す
	 */
    Optional<Members> selectOneById(Integer member_id);

    void save(Members member);

    void updateMember(Members member);
}
