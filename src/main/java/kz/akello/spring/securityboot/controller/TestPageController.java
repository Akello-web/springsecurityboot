package kz.akello.spring.securityboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestPageController {
    @GetMapping(value = "/test-page")
    public String testPage(){
        return "testPage";
    }
}
