package itheima.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
        @RequestMapping(value = "/quickStart", method= RequestMethod.GET)
    public String save() {
        System.out.println("controller save running...");
        jsonMapper.write
        return "itcast";
    }
//    @RequestMapping(value = "/quickStart2", method= RequestMethod.GET)
//    public ModelAndView save2() {
//        //System.out.println("controller save running...");
//        ModelAndView model = new ModelAndView();
//        model.addObject("username","itcast");
//        model.setViewName("success");
//        return model;
//    }
}
