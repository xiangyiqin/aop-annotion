package com.elephant.demo.aop;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xyq
 * @描述：
 * @创建时间：2020/11/14 14:33
 */
@RestController
@RequestMapping("/aop")
public class AopController {
    @RequestMapping(value = "/Curry")
    @Info(doWhat = "playBasketball",operationType = "three goal")
    public void Curry(){
        System.out.println("库里上场打球了！！");
    }

    @RequestMapping(value = "/Harden")
    @Info(doWhat = "eat",operationType = "humberger")
    public void Harden(){
        System.out.println("哈登上场打球了！！");
    }

}
