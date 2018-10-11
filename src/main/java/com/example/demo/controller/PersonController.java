package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.domain.Person;

@Controller
public class PersonController {
	
	@RequestMapping("/list")
    public String list(Model model) {
		List<Person> pList = new ArrayList<Person>();
		pList.add(new Person(1l, "luoermao", "999", 28));
		pList.add(new Person(2l, "luosanmao", "888", 18));
		model.addAttribute("persons", pList);
		return "person/list";
	}
	
	@RequestMapping("/thyindex")
    public String thyindex(Model model) {
		
		return "index";
	}

}
