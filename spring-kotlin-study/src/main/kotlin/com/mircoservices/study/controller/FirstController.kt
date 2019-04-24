package com.mircoservices.study.controller

import com.mircoservices.study.Interface.ServiceInterface
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseBody

@Controller
class FirstController {
    @Autowired
    lateinit var service: ServiceInterface

    @RequestMapping(value = "/user", method = arrayOf(RequestMethod.GET))
    @ResponseBody
    fun hello() = "hello world"

    @RequestMapping(value = "/user/{name}", method = arrayOf(RequestMethod.GET))
    @ResponseBody
    fun hello2(@PathVariable("name") name: String) = service.getHello(name);
}