package com.lening.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 牛胜浩
 * @date 2021/4/13 13:51
 */
@Controller
public class UrlNotFoundController {

    @RequestMapping("*")
    public String test404(){
        //TODO
        return "404Page";
    }

}
