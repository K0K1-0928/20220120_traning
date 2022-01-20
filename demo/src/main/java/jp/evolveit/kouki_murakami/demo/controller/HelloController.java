package jp.evolveit.kouki_murakami.demo.controller;

import jp.evolveit.kouki_murakami.demo.service.LoginUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;

@Controller
public class HelloController {
    @Autowired
    private LoginUserDetailsService loginUserDetailsService;

    @RequestMapping("/hello")
    public ModelAndView hello(HttpServletRequest request, ModelAndView mav) {
        String username = request.getRemoteUser();
        UserDetails userDetails = loginUserDetailsService.loadUserByUsername(username);
        String password = userDetails.getPassword();
        mav.addObject("username", username);
        mav.addObject("password", password);
        mav.setViewName("hello");
        return mav;
    }
}
