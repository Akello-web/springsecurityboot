package kz.akello.spring.securityboot.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/test")
public class TestAjaxController {
    @GetMapping(value = "/get-all")
    public List<String> textList(@RequestParam(name = "testName", required = false, defaultValue = "Aqyl")
                                     String testName){
        List<String> list = new ArrayList<>();
        list.add("Hello " + testName);
        list.add("Assalaumagaleikum " + testName);
        list.add("Uagaleikumassalam " + testName);

        return list;
    }

}
