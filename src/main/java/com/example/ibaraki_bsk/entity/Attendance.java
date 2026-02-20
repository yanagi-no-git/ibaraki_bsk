package com.example.ibaraki_bsk.entity;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data                   // Getter, Setterが不要になる
@NoArgsConstructor      // デフォルトコンストラクタ自動生成
@AllArgsConstructor     // 全フィールドに対する初期化値を引数に取るコンストラクタを自動生成
@EntityListeners(AuditingEntityListener.class)
@IdClass(AttendanceId.class) // 複合主キー
@Entity
public class Attendance {
    @Id
    private Integer member_id;
    @Id
    private Integer event_id;
    private Integer is_paid;
}
