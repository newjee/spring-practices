package com.poscodx.guestbook.controller;

import com.poscodx.guestbook.repository.GuestBookRepository;
import com.poscodx.guestbook.vo.GuestBookVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class GuestBookController {

    @Autowired
    private GuestBookRepository guestBookRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String main(Model model) {
        List<GuestBookVo> list = guestBookRepository.findAll();
        model.addAttribute("list", list);
        return "main";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(GuestBookVo vo) {
        guestBookRepository.insert(vo);
        return "redirect:/";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String delete() {
        return "delete";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(@RequestParam("no") Long no, @RequestParam("password") String password) {
        guestBookRepository.deleteByNoAndPassword(no, password);
        return "redirect:/";
    }
}
