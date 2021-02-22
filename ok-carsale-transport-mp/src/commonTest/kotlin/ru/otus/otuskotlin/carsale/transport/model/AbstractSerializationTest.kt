package ru.otus.otuskotlin.carsale.transport.model

import kotlinx.serialization.json.Json
import ru.otus.otuskotlin.carsale.transport.model.vehicles.brandSerializersModule
import kotlin.random.Random

abstract class AbstractSerializationTest {

    protected val requestId = "request-id-${Random.nextLong().toString()}"
    protected val json = Json {
        prettyPrint = true
        serializersModule = brandSerializersModule
    }

}
