package com.develhope._esInterceptor.interceptors;

import com.develhope._esInterceptor.entities.Month;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
@Slf4j
@Order(Ordered.HIGHEST_PRECEDENCE)
public class MonthInterceptor implements HandlerInterceptor {


    public static List<Month> monthsList  = new ArrayList<>(Arrays.asList(
            new Month(1,"Jennuary", "Gennaio","cruftlibbeh"),
            new Month(2,"Febbruary", "Febbraio","gutenTahk"),
            new Month(3,"March", "Marzo","crauti"),
            new Month(4,"April", "Aprile","shlendershloba"),
            new Month(5,"May", "Maggio","ricolaaaaa"),
            new Month(8,"October", "Ottobre","OctoberFest")
    ));

    private Month findMonth(int number){
        for (Month m : monthsList){
            if (m.getMonth_number()==number)return m;
        }
        return new Month(0,"nope","nope","nope");
    }

//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        System.out.println("prehandle()");
//        String month = request.getHeader("month_number");
//
//        if (request.getRequestURL().toString().contains("/months/InsaneRequest")) {
//            if (month == null || month.isEmpty()){
//                response.sendError(HttpServletResponse.SC_BAD_REQUEST,"Bad request"); //è questo che non funziona
//            return false;
//            }
////            System.out.println("status: 410 Gone");
////            response.sendError(HttpServletResponse.SC_GONE,"This is just old code");
////            return false;
//        }
//        return true;
//    }
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("Prehandle()");
        String month = request.getHeader("month_number");
        if (request.getRequestURL().toString().contains("/months/InsaneRequest")) {
            if (month == null || month.isEmpty()) {

//            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
//            response.getWriter().write("Bad Request");
                System.out.println("sending a bad request");

                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Luca imperatore di Roma"); //è questo che non funziona
                return false;
            }
        }
        int month_number_request = Integer.parseInt(month);
        request.setAttribute("requestedMonth",findMonth(month_number_request));
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
