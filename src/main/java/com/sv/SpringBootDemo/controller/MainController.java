
package com.sv.SpringBootDemo.controller;

import java.util.ArrayList;
import java.util.List;
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
    
    String name = "<h1>BAD CODE</h1>";
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
    
    @GetMapping("testList")
    public String testList(Model model) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(10);
        numbers.add(100);
        numbers.add(1000);
        numbers.add(10000);
        
        model.addAttribute("numbers", numbers);
        
        return "testList";
    }
    
    @GetMapping("testConditional")
    public String testConditional(Model model) {
        
        model.addAttribute("truth", true);
        model.addAttribute("number", number);
        model.addAttribute("aString", "differentCase2");
        
        return "testConditional";
    }
    
    @PostMapping("upDown")
    public String upDown(HttpServletRequest request) {
        if (request.getParameter("down") == null) number++;
        else number--;
        return "redirect:/testConditional";
    }
}
