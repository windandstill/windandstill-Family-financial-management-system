package cn.aka.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IPController {
    @GetMapping(value = "/incomeTimeManage")
    public String incomeTimeManage() {
        return "/incomeTimeManage";
    }

    @GetMapping(value = "/payTimeManage")
    public String payTimeManage() {
        return "/payTimeManage";
    }

    @GetMapping(value = "/typePieManage")
    public String typePieManage() {
        return "/typePieManage";
    }
}
