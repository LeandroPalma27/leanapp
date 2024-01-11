package com.leancoder.leanapp.controllers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.leancoder.leanapp.model.User;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
@SessionAttributes({"user"})
public class HomeController {

    @GetMapping({"/", "/home"})
    public String home() {
        return "redirect:/home3";
    }

    @GetMapping("/forward")
    public String forward(Model model) {
        model.addAttribute("data", "no me he ido causa");
        return "forward:/other";
    }

    @GetMapping("/other")
    public String getMethodName(Model model) {
        return "other";
    }
    

    @GetMapping("/form")
    public String myForm(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "form";
    }

    @PostMapping("/process-form")
    public String processForm(@ModelAttribute("user") User user, Model model) {
        return "form";
    }
    

    @GetMapping("/home3")
    public String Home(@RequestParam(defaultValue = "Hola mundo", required = false) String param, Model model) {
        User user = new User("Leandro", "Palma");
        model.addAttribute("value", param);
        model.addAttribute("user", user);
        return "home";
    }

    @GetMapping("/home2")
    @ResponseBody
    public Map<String, Object> Home2(@RequestParam(defaultValue = "Hola mundo", required = false) String param) {
        Map<String, Object> params = new HashMap<>();
        params.put("first", param);
        params.put("name", "Leandro");
        return params;
    }

    @GetMapping("/native")
    public String NativeRequest(HttpServletRequest request) {
        request.getParameterMap().values().stream().forEach(value -> {
            Arrays.asList(value).forEach(data -> {
                System.out.println(data);
            });
        });
        return "native-request";
    }

}
