package com.ssafy.mvc.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class User {
    private Integer id; // 고유 식별자
    private String userid; // 로그인용 아이디
    private String password; // 암호화된 비밀번호
    private String email; // 이메일
    private String phoneNumber; // 전화번호
    private String name; // 사용자 이름
    private String role; // 사용자 역할
    private LocalDateTime createdAt; // 생성 시간
    private LocalDateTime updatedAt; // 업데이트 시간
}
