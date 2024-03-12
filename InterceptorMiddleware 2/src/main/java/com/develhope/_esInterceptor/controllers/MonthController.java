package com.develhope._esInterceptor.controllers;

import com.develhope._esInterceptor.entities.Month;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j

@RequestMapping("/months")
public class MonthController {

    @GetMapping("/InsaneRequest")
    public Month getResponse(HttpServletRequest request){

        System.out.println("getResponseMethod()");
        Month month =(Month) request.getAttribute("requestedMonth");

        return month;
    }



}
