package com.andrewn.java2304springmvc.controller;

import com.andrewn.java2304springmvc.model.Name;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloController {


    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("/helloAgain")
    public String helloAgain() {
        return "helloAgain";
    }

    @GetMapping("/greetsomeone")
    public String greetName(Model model,
            @RequestParam(name="firstname", defaultValue="World", required = false) String firstName) {
        model.addAttribute("firstname", firstName);
        System.out.println("firstname = " + firstName);
        return "greet";
    }

    //@GetMapping("/greetntimes/qwdf/{asd}")
    @GetMapping("/greetntimes/{ntimes}")
    public String greetNTimes(Model model,
                              @PathVariable("ntimes") String ntimes) {
        int n = Integer.parseInt(ntimes);
        model.addAttribute("ntimes", n);

        String helloNTimes = "";
        for (int i = 0; i < n; i++) {
            helloNTimes = helloNTimes.concat("hello\n");
        }
        model.addAttribute("hellontimes", helloNTimes);
//        System.out.println(helloNTimes);
        return "greetntimes";
    }

    @PostMapping("/greetbyjson")
    public String greetByJson(Model model,
                              @RequestBody Name name,
                              @RequestHeader("Content-Length") int contentLength) {
        model.addAttribute("name", name);
        System.out.println(contentLength);
        return "greetbyjson";
    }
}
