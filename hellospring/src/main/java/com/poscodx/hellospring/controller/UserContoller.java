package com.poscodx.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


/**
 * @RequestMapping 완결버전
 * 클래스 + 메서드 매핑
 */

@RequestMapping("/user")
@Controller
public class UserContoller {

    @RequestMapping(value = "/join", method = RequestMethod.GET)
    public String joinform() {
        return "/WEB-INF/views/join.jsp";
    }

    @RequestMapping(value = "/join", method = RequestMethod.POST)
    public String join(UserVo vo) {
        System.out.println("UserController.join() : UserDao.insert(" + vo + ").... ");
        return "redirect:/";
    }

    @ResponseBody
    @RequestMapping(value = "/update")
    public String update(@RequestParam("n") String name) {
        /**
         *  if --- n이라는 이름의 url 파라미터가 없으면
         *  400 bad request 애러
         */
        return "UserController.update(" + name + ")";
    }

    @ResponseBody
    @RequestMapping(value = "/update2")
    public String update2(@RequestParam(value = "n", required = true, defaultValue = "") String name) {
        return "UserController.update(" + name + ")";
    }

    @ResponseBody
    @RequestMapping(value = "/list")
    public String list(@RequestParam(value = "p", required = true, defaultValue = "1") int pageNo) {
        return "userController.update(" + pageNo + ")";
    }
}
