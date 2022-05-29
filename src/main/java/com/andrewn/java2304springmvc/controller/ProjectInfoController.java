package com.andrewn.java2304springmvc.controller;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProjectInfoController {
    private final Environment env;

    public ProjectInfoController(Environment env) {
        this.env = env;
    }

    // task0
    /*
    Создать класс ProjectInfoController (аннотация @Controller)
    Если при запуске ошибка с портом (занят порт 8080),
    открыть файл src/main/resources/application.properties
    и прописать внутри строчку "server.port=8081"
     */
    // task1
    /*
    Создать метод с именем basicInfo, возвращающий строку "basicinfo"
    Метод связан с GET запросом по адресу "/basicinfo"
    Создать шаблон /src/main/resources/templates/basicinfo.html
    В шаблоне вывести любую информацию по проекту
    (html статический, без использования th:)
     */
    @GetMapping("/basicinfo")
    public String basicInfo() {
        return "basicinfo";
    }
    // task2
    /*
    Создать метод с именем getAttribute, возвращающий строку "getattr"
    Аргументы метода - объект model класса Model,
    обязательный параметр адресной строки с именем attribute
    В случае, если attribute="version", в модель добавить "attribute":"1.0"
    В случае, если attribute="language", в модель добавить "attribute":"Java"
    В других случаях добавить "attribute":"None"
    Создать шаблон /src/main/resources/templates/getattr.html
    В шаблоне вывести строчку
    "You asked for attribute. Here it is: " + attribute
     */

    @GetMapping("/getattr")
    public String getAttribute(Model model,
                               @RequestParam(name="attribute") String attribute) {
//        if (attribute.equals("version")) {
//            model.addAttribute("attribute", "1.0");
//        } else if (attribute.equals("language")) {
//            model.addAttribute("attribute", "java");
//        } else {
//            model.addAttribute("attribute", "None");
//        }
        if (env.containsProperty(attribute)) {
            model.addAttribute("attribute", env.getProperty(attribute));
        } else {
            model.addAttribute("attribute", "None");
        }
        return "getattr";
    }

}
