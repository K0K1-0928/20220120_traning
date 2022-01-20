package jp.evolveit.kouki_murakami.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
    @RequestMapping("/hello")
    public ModelAndView hello(ModelAndView mav) {
        mav.setViewName("hello");
        return mav;
    }
}