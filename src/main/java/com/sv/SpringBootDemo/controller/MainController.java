
package com.sv.SpringBootDemo.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author: Steven Vallarsa
 *   email: stevenvallarsa@gmail.com
 *    date: 2022-01-27
 * purpose: 
 */
@Controller
public class MainController {
    
    String name = "Steve";
    int number = 99;

    @GetMapping("test")
    public String testPge(Model model) {
        model.addAttribute("number", number);
        model.addAttribute("name", name);
        
        return "test";
    }
    
    @PostMapping("testForm")
    public String testForm(HttpServletRequest request) {
        name = request.getParameter("formName");
        number = Integer.parseInt(request.getParameter("formNumber"));
        return "redirect:/test";
    }
}
