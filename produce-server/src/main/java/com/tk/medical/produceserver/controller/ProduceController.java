package com.tk.medical.produceserver.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/producer")
//@ResponseBody
public class ProduceController {

    @RequestMapping(value = "/getProducer",method = RequestMethod.GET)
    public String getProducer(){
       return "服务提供者API";
    }
}
