package de.novatec.kafkacdc

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class KafkaCdcApplicationTests @Autowired constructor(
    private val eventSender: EventSender,
    private val eventReceiver: EventReceiver,
) {

    @Test
    fun contextLoads() {
        eventSender.sendEvent("Accelerate")
        Thread.sleep(3000)
    }

}
