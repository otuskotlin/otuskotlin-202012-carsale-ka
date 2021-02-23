package ru.otus.otuskotlin.carsale.transport.model.vehicles

import kotlinx.datetime.Clock
import ru.otus.otuskotlin.carsale.transport.model.AbstractSerializationTest
import ru.otus.otuskotlin.carsale.transport.model.common.Debug
import ru.otus.otuskotlin.carsale.transport.model.common.Message
import ru.otus.otuskotlin.carsale.transport.model.common.ResponseStatusDto
import ru.otus.otuskotlin.carsale.transport.model.common.WorkModeDto
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

const val BRAND_ID = "1"
const val BRAND_NAME = "Honda"

class BrandSerializationTest : AbstractSerializationTest() {

    @Test
    fun serializeBrandTest() {
        val dto = newBrand()

        val serializedString = encodeToString(dto)
        assertTrue { serializedString.contains(BRAND_NAME) }

        val deserializedDto = decodeFromString<BrandDto>(serializedString)
        assertEquals(dto, deserializedDto)
    }

    @Test
    fun serializeCreateBrandRequestTest() {
        val now = Clock.System.now()
        val requestId = newRequestId()
        val dto: Message = CreateBrandRequest(
            requestId = requestId,
            startTime = now,
            debug = Debug(WorkModeDto.TEST),
            data = CreatableBrandDto(BRAND_NAME),
        )
        val serializedString = encodeToString(dto)
        assertTrue { serializedString.contains(requestId) }
        assertTrue { serializedString.contains(now.toString()) }
        assertTrue { serializedString.contains(BRAND_NAME) }
        val deserializedDto = decodeFromString<Message>(serializedString)
        assertEquals(dto, deserializedDto)
    }

    @Test
    fun serializeCreateBrandResponseTest() {
        val now = Clock.System.now()
        val requestId = newRequestId()
        val responseId = newResponseId()
        val dto: Message = CreateBrandResponse(
            responseId = responseId,
            onRequest = requestId,
            endTime = now,
            errors = listOf(),
            status = ResponseStatusDto.SUCCESS,
            debug = Debug(WorkModeDto.TEST),
            data = newBrand(),
        )
        val serializedString = encodeToString(dto)
        assertTrue { serializedString.contains(requestId) }
        assertTrue { serializedString.contains(responseId) }
        assertTrue { serializedString.contains(now.toString()) }
        assertTrue { serializedString.contains(BRAND_NAME) }
        val deserializedDto = decodeFromString<Message>(serializedString)
        assertEquals(dto, deserializedDto)
    }
}

fun newBrand() = BrandDto(BRAND_ID, BRAND_NAME)