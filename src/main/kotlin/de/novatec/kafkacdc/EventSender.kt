package de.novatec.kafkacdc

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.kafka.support.SendResult
import org.springframework.stereotype.Service
import org.springframework.util.concurrent.ListenableFutureCallback

@Service
class EventSender(
    private val kafkaTemplate: KafkaTemplate<Int, String>,
    private val mapper: ObjectMapper,
) {

    fun sendEvent(title: String) {
        val event = BookCreatedEvent(title)
        val future = kafkaTemplate.send("books", mapper.writeValueAsString(event))
        future.addCallback(object : ListenableFutureCallback<SendResult<Int, String>> {

            override fun onSuccess(result: SendResult<Int, String>?) {
                println("On Success: $result")
            }

            override fun onFailure(ex: Throwable) {
                println("On Failure: $ex")
            }

        })
        future.get()
    }

}