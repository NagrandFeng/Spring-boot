package demo.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * Created by Administrator on 2016/7/26.
 */
@Controller
public class HelloController {
    private Logger logger=Logger.getLogger(HelloController.class);
    @RequestMapping("/")
    public String hello(){
        return  new Date().toString()+"  ";
    }

    @RequestMapping("/hello/{name}")
    public String hello(@PathVariable("name") String name, Model model) {
        logger.info("-------------------name: "+name);
        model.addAttribute("name", name);
        return "hello";
    }
}
