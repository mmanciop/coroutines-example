package com.instana.demo.kotlin.corountines

import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate
import java.net.URI

@Component
class Backend {

    private val restTemplate = RestTemplate()

    suspend fun httpGetGoogle(): String? {
        return restTemplate.getForObject(URI("https://www.google.com"), String::class.java)
    }

}