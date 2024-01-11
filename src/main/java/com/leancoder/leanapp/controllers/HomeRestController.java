package com.leancoder.leanapp.controllers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.leancoder.leanapp.model.User;

@RestController()
public class HomeRestController {

    @Value("${values.username}")
    private String userName;
    @Value("${values.listOfSongs}")
    private List<String> listOfSongs;
    @Value("${values.password}")
    private String password;
    @Value("#{'${values.listOfSongs}'.split(',')}")
    private List<String> songs;
    @Value("#{${values.likedSongs}}")
    private Map<String, String> likedSongs;
    @Value("#{${values.likedSongs}.taemin}")
    private String bestSong;
    @Autowired
    private Environment environment;

    @GetMapping("/rest/home")
    public Map<String, Object> Home(@RequestParam(defaultValue = "Hola mundo", required = false) String param) {
        Map<String, Object> body = new HashMap<>();
        User user = new User("Leandro", "Palma");
        body.put("user", user);
        body.put("first", param);
        return body;
    }

    @GetMapping("/mix/{id}/{name}/{lastname}")
    public Map<String, Object> MixPathVariables(@PathVariable(name = "id") String id,
            @PathVariable(name = "name") String name, @PathVariable(name = "lastname") String lastname) {
        Map<String, Object> json = new HashMap<>();
        json.put("id", id);
        json.put("name", name);
        json.put("lastname", lastname);
        return json;
    }

    @GetMapping("/mix/{id}")
    public String Troll2(@PathVariable(name = "id") String id) {
        return "Estoy troleando...";
    }

    @GetMapping("/mix/10")
    public String Troll1() {
        return "Estoy troleando.";
    }

    @PostMapping("/create")
    public User createUser(@RequestBody(required = true) User user) {
        System.out.println(user.toString());
        User userPrincipal = new User(user.getName().toUpperCase(), user.getLastName());
        return userPrincipal;
    }

    @PostMapping("/random2")
    public void postMethodWithParams(@RequestParam Map<String, Object> params) {
        System.out.println(params);
    }

    @GetMapping("/mixparamsGET")
    public List<Object> mixParamsGet(@RequestParam(name = "name") List<Object> params) {
        return params;
    }

    @GetMapping("/getValues")
    public List<Object> getConfigValues() {
        return Arrays.asList(userName, listOfSongs.toArray()[0], password, songs.get(2), likedSongs.get("kai"),
                bestSong);
    }

}
