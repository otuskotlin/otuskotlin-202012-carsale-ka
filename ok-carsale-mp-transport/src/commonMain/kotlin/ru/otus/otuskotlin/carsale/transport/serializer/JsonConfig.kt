package ru.otus.otuskotlin.carsale.transport.serializer

import kotlinx.serialization.json.Json

val jsonConfig: Json by lazy {
    Json {
        prettyPrint = true
        serializersModule = modelSerializersModule
        classDiscriminator = "type"
    }
}
