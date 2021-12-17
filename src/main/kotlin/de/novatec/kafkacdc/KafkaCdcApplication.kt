package de.novatec.kafkacdc

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.kafka.annotation.EnableKafka

@SpringBootApplication
class KafkaCdcApplication

fun main(args: Array<String>) {
	runApplication<KafkaCdcApplication>(*args)
}
