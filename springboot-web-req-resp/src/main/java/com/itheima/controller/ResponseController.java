package com.itheima.controller;

import com.itheima.pojo.Address;
import com.itheima.pojo.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ResponseController {
    @RequestMapping("/hello")
    public Result hello() {
        return Result.success("Hello World");
    }

    @RequestMapping("/getAddr")
    public Result getAddr() {
        Address addr = new Address();
        addr.setProvince("广东省");
        addr.setCity("深圳");
        return Result.success(addr);
    }

    @RequestMapping("/getList")
    public Result getList() {
        List<Address> list = new ArrayList<>();

        Address addr1 = new Address();
        addr1.setProvince("广东省");
        addr1.setCity("深圳");

        Address addr2 = new Address();
        addr2.setProvince("陕西省");
        addr2.setCity("西安");

        list.add(addr1);
        list.add(addr2);
        return Result.success(list);
    }
}
