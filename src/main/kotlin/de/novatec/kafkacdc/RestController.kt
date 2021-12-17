package de.novatec.kafkacdc

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class RestController(
    private val eventSender: EventSender
) {

    @PostMapping("/hello")
    fun helloWorld() {
        eventSender.sendEvent("Dune")
    }

}