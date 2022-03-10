package cn.aka.controller;

import cn.aka.service.DatadicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class DatadicController {
    @Autowired
    private DatadicService datadicService;


}
