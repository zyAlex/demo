package com.example.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HellowController {

    @RequestMapping("/hellow")
    public String index(Model map){
        map.addAttribute("name","zy");
        return "index";
    }

    @RequestMapping("/testException")
    public String testException() throws Exception {
        throw new Exception("");
    }
}
