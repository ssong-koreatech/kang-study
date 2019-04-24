package com.microservice.study.exception

import java.lang.Exception

class CustomerExistException(override val message: String) : Exception(message)