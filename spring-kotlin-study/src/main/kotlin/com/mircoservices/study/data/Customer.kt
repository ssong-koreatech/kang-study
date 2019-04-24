package com.mircoservices.study.data

import com.fasterxml.jackson.annotation.JsonInclude

/**
spring:
    jackson:
        default-property-inclusion: NON_NULL
 전역화 in appication.yaml
**/
@JsonInclude(JsonInclude.Include.NON_NULL)
data class Customer(var id : Int = 0,  var name: String = "" , var telephone: Telephone? = null){
    data class Telephone(var countryCode : String = "", var telephoneNumber : String = "")
}