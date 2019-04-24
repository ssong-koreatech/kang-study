package com.microservice.study.exception

import java.lang.Exception

class CustomerNoExistException(override val message: String) : Exception(message)