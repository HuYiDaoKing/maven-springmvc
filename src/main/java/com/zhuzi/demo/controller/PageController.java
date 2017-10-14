package com.zhuzi.demo.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by lenovo on 2017/6/27.
 */

@Controller
@RequestMapping("/page/")
public class PageController {
    @RequestMapping("index")
    public String index()
    {
        return "/page/index";
    }

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String printHello(ModelMap model) {
        model.addAttribute("msg", "Spring MVC Hello World");
        model.addAttribute("name", "yuntao");
        return "/page/hello";
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test(ModelMap model) {
        return "test";
    }

}
