package ru.otus.otuskotlin.carsale.transport.model

import kotlinx.serialization.json.Json
import kotlinx.serialization.serializer
import ru.otus.otuskotlin.carsale.transport.serializer.modelSerializersModule
import kotlin.math.absoluteValue
import kotlin.random.Random

abstract class AbstractSerializationTest {

    protected val json = Json {
        prettyPrint = true
        serializersModule = modelSerializersModule
    }

    protected fun newRequestId() = "request-id-${Random.nextLong().absoluteValue.toString()}"
    protected fun newResponseId() = "response-id-${Random.nextLong().absoluteValue.toString()}"

    protected inline fun <reified T> encodeToString(value: T): String =
        json.encodeToString(json.serializersModule.serializer(), value)
            .also { println(it) }

    protected inline fun <reified T> decodeFromString(string: String): T {
        val result: T = json.decodeFromString(json.serializersModule.serializer(), string)
        println(result)
        return result
    }

}
