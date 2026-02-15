package com.example.ibaraki_bsk.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data                   // Getter, Setterが不要になる
@NoArgsConstructor      // デフォルトコンストラクタ自動生成
@AllArgsConstructor     // 全フィールドに対する初期化値を引数に取るコンストラクタを自動生成
@EntityListeners(AuditingEntityListener.class)
@Entity
public class Members{
    @Id
    private Integer member_id;
    private String name;
    private String line_name;
    
    @CreatedDate
    @Column(updatable = false) // updateの時は更新しない。
    private LocalDateTime created_at;
}

