package de.novatec.kafkacdc

import org.springframework.kafka.annotation.KafkaListener
import org.springframework.messaging.Message
import org.springframework.stereotype.Service

@Service
class EventReceiver {

    @KafkaListener(id = "Consumer1", topics = ["books"])
    fun listen(x: Message<String>) {
        println("Received: $x")
    }

}