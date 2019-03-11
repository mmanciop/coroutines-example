package com.instana.demo.kotlin.corountines

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class ApiController(private val backend: Backend) {

    companion object {
        val LOGGER: Logger = LoggerFactory.getLogger(ApiController::class.java)
    }

    @GetMapping("/**")
    fun serveAsynch(): ResponseEntity<Any> = runBlocking {
        launch(Dispatchers.Default) {
            val res = backend.httpGetGoogle()

            LOGGER.warn(res)
        }

        ResponseEntity.accepted().build<Any>()
    }

}