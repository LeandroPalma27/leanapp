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

import com.leancoder.leanapp.model.User;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class HomeController {

    @ModelAttribute("firstValue")
    public String firstValue() {
        return "firstValue";
    }

    @GetMapping("/home")
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
