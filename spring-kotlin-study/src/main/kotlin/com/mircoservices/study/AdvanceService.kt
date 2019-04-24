package com.mircoservices.study

import com.mircoservices.study.Interface.ServiceInterface
import org.springframework.beans.factory.annotation.Value

class AdvanceService : ServiceInterface {
    @Value(value = "\${service.message.text}")
    private lateinit var text: String;
    private var count = 1;

    override fun getHello(name: String): String {
        count++
        return "$text $name ($count)"

    }
}