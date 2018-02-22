package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.Optional;

@Controller
public class PageController {
	 @RequestMapping("/hello")
	 public String index ()
	 {
		 return "hello123";
	 }
	 @RequestMapping("/greeting")
	 public String greeting (@RequestParam (value="name", required= false, defaultValue = "dunia") String name, Model model)
	 {
		 model.addAttribute ("name", name);
		 return "greeting";
	 }
	 @RequestMapping({"/greeting","/greeting/{name}"})
	 public String greetingPath (@PathVariable Optional<String> name, Model model)
	 {
		 if (name.isPresent()) {
			 model.addAttribute("name",name.get());
		 }else {
			 model.addAttribute("name","apap");
		 }
		 return "greeting";
	 }
}
