package ru.otus.otuskotlin.carsale.transport.model.vehicles

import kotlinx.datetime.Clock
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import ru.otus.otuskotlin.carsale.transport.model.common.Debug
import ru.otus.otuskotlin.carsale.transport.model.common.Message
import ru.otus.otuskotlin.carsale.transport.model.common.WorkModeDto
import kotlin.random.Random
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

const val BRAND_ID = "1"
const val BRAND_NAME = "Honda"

class BrandSerializationTest {

    private val requestId = "request-id-${Random.nextLong().toString()}"
    private val json = Json {
        prettyPrint = true
        serializersModule = brandSerializersModule
    }

    @Test
    fun serializeBrandTest() {
        val dto = BrandDto(BRAND_ID, BRAND_NAME)

        val serializedDto = json.encodeToString(dto)
        println(serializedDto)
        assertTrue { serializedDto.contains(dto.name!!) }

        val deserializedDto = json.decodeFromString<BrandDto>(serializedDto)
        println(deserializedDto)
        assertEquals(dto, deserializedDto)
    }

//    @Test
//    fun serializeCreateBrandRequestTest() {
//        val now = Clock.System.now()
//        val dto: Message = CreateBrandRequest(
//            requestId = requestId,
//            startTime = now,
//            debug = Debug(WorkModeDto.TEST),
//            data = CreatableBrandDto(BRAND_NAME),
//        )
//        val serializedString = json.encodeToString(dto)
//        println(serializedString)
//        assertTrue { serializedString.contains(requestId) }
//        assertTrue { serializedString.contains(now.toString()) }
//        assertTrue { serializedString.contains(BRAND_NAME) }
//        val deserializedDto = json.decodeFromString<Message>(serializedString)
//        println(deserializedDto)
//        assertEquals(dto, deserializedDto)
//    }
}
