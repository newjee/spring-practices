package com.poscodx.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @RequestMapping 완결버전
 * 클래스 + 메서드 매핑
 */

@RequestMapping("/user")
@Controller
public class UserContoller {

    @RequestMapping("/joinform")
    public String joinform() {
        return "/WEB-INF/views/joinform.jsp";
    }
//
//    @RequestMapping("/joinform ")
//    public String joinform() {
//        return "UserController.joinform()";
//    }

}
