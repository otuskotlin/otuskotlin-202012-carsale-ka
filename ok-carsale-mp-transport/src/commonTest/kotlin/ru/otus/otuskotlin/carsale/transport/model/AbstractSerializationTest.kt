package ru.otus.otuskotlin.carsale.transport.model

import kotlinx.serialization.json.Json
import kotlinx.serialization.serializer
import ru.otus.otuskotlin.carsale.transport.serializer.modelSerializersModule
import kotlin.math.absoluteValue
import kotlin.random.Random

const val REQUEST_ID = "request-id-6057115544696617309"
const val RESPONSE_ID = "response-id-8266843433733270380"
const val DATE_TIME = "2021-02-24T18:22:17.517Z"

const val START_TIME_FIELD = "startTime"
const val END_TIME_FIELD = "endTime"
const val REQUEST_ID_FIELD = "requestId"
const val ON_REQUEST_ID_FIELD = "onRequest"
const val RESPONSE_ID_FIELD = "responseId"

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
