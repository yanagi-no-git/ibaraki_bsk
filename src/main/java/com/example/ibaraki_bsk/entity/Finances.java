package com.example.ibaraki_bsk.entity;

import java.time.LocalDate;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

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
public class Finances {
    @Id
    private Integer finance_id;
    private LocalDate transaction_date;
    private String title;
    private String category;
    private Integer amount;
    private String notes;
}
