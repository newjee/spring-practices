package com.poscodx.emaillist.controller;

import com.poscodx.emaillist.repository.EmaillistRepository;
import com.poscodx.emaillist.vo.EmaillistVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class EmaillistController {

    @Autowired
    private EmaillistRepository emaillistRepository;

    @RequestMapping("/")
    public String main(Model model) {
        List<EmaillistVo> list = emaillistRepository.findAll();
        model.addAttribute("list", list);
        return "main";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add() {
        return "add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(EmaillistVo vo) {
        emaillistRepository.insert(vo);
        return "redirect:/";
    }
}
