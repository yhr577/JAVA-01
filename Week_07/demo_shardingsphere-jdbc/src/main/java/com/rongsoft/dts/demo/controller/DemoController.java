package com.rongsoft.dts.demo.controller;


import com.rongsoft.dts.demo.service.CardBinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class DemoController {

    @Autowired
    public CardBinService cardBinService;

    @GetMapping("/getCardBin")
    public void getCardBin(@RequestParam("id") String id){

        cardBinService.getCardBinWithSharding(id);

    }


}
