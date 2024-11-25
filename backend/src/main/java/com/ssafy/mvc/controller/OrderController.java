package com.ssafy.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.mvc.config.SessionUtils;
import com.ssafy.mvc.dto.ApproveResponse;
import com.ssafy.mvc.dto.OrderCreateForm;
import com.ssafy.mvc.dto.ReadyResponse;
import com.ssafy.mvc.service.KakaoPayService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/order")
@CrossOrigin("*")
public class OrderController {
	
	
    private final KakaoPayService kakaoPayService;
    
    @PostMapping("/pay/ready")
    public @ResponseBody ReadyResponse payReady(@RequestBody OrderCreateForm orderCreateForm) {
    	System.out.println(orderCreateForm);
        
    	int id = orderCreateForm.getId();
        String name = orderCreateForm.getName();
        int totalPrice = orderCreateForm.getTotalPrice();
        
        log.info("주문 상품 이름: " + name);
        log.info("주문 금액: " + totalPrice);

        // 카카오 결제 준비하기
        ReadyResponse readyResponse = kakaoPayService.payReady(id,name, totalPrice);
        // 세션에 결제 고유번호(tid) 저장
        SessionUtils.addAttribute("tid", readyResponse.getTid());
        log.info("결제 고유번호: " + readyResponse.getTid());

        return readyResponse;
    }

    @GetMapping("/pay/completed")
    public String payCompleted(@RequestParam("pg_token") String pgToken) {
    
        String tid = SessionUtils.getStringAttributeValue("tid");
        log.info("결제승인 요청을 인증하는 토큰: " + pgToken);
        log.info("결제 고유번호: " + tid);

        // 카카오 결제 요청하기
        ApproveResponse approveResponse = kakaoPayService.payApprove(tid, pgToken);

        return "redirect:/order/completed";
    }
}