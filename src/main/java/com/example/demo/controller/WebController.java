package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.domain.User;

@Controller
public class WebController {
	
	@RequestMapping("/list0")
    public String userList2(Model model) throws Exception {
        model.addAttribute("hello","sadmin");
        List<User> userList = new ArrayList<User>();
        userList.add(new User(1, "luoermao", new Date(), 12.2));
        userList.add(new User(2, "luoxiaoguan", new Date(), 13.4));
        model.addAttribute("userList",userList);
        return "/user/list";
    }
	
	
	
	@RequestMapping("/to_page")
    public String toPage(Model model){
		System.out.println(111);
		StringBuffer sb = new StringBuffer("https://pcgame.vgs.lenovo.com.cn/#/");
		sb.append("?par=111");
		return "redirect:" + sb.toString();
	}
	
}
