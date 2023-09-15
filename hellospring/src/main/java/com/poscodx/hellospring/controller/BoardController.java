package com.poscodx.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * RequestMapping 메소드 단독 매핑
 * 가능
 */
@Controller
public class BoardController {

    @ResponseBody
    @RequestMapping("/board/write")
    public String write() {
        return "BoardController.write()";

    }

    // /board/view/10
    @ResponseBody
    @RequestMapping("/board/view/{no1}/{no2}")
    public String view(@PathVariable("no1") Long no1, @PathVariable("no2") Long no2) { //url path에 있는..
        return "BoardController.view("+ no1 + no2+ ")";
    }

    // /board/view?no=10
    @ResponseBody
    @RequestMapping("/board/view")
    public String view2(Long no1, Long no2) { //url path에 있는..
        return "BoardController.view("+ no1 + no2+ ")";


    }
}
