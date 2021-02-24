package ru.otus.otuskotlin.carsale.transport.model.vehicles

import kotlinx.datetime.Clock
import ru.otus.otuskotlin.carsale.transport.model.*
import ru.otus.otuskotlin.carsale.transport.model.common.Debug
import ru.otus.otuskotlin.carsale.transport.model.common.Message
import ru.otus.otuskotlin.carsale.transport.model.common.ResponseStatusDto
import ru.otus.otuskotlin.carsale.transport.model.common.WorkModeDto
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

const val MODEL_ID = "2"
const val MODEL_NAME = "CRV"

class ModelSerializationTest : AbstractSerializationTest() {

    @Test
    fun serializeModelTest() {
        val dto = newModel()

        val serializedString = encodeToString(dto)
        assertTrue { serializedString.contains(MODEL_NAME) }
        assertTrue { serializedString.contains(BRAND_NAME) }

        val deserializedDto = decodeFromString<ModelDto>(serializedString)
        assertEquals(dto, deserializedDto)
    }

    @Test
    fun serializeCreateModelRequestTest() {
        val now = Clock.System.now()
        val requestId = newRequestId()
        val dto: Message = CreateModelRequest(
            requestId = requestId,
            startTime = now,
            debug = Debug(WorkModeDto.TEST),
            data = CreatableModelDto(MODEL_NAME, newBrand()),
        )
        val serializedString = encodeToString(dto)
        assertTrue { serializedString.contains(requestId) }
        assertTrue { serializedString.contains(now.toString()) }
        assertTrue { serializedString.contains(BRAND_NAME) }
        assertTrue { serializedString.contains(START_TIME_FIELD) }
        assertTrue { serializedString.contains(REQUEST_ID_FIELD) }
        val deserializedDto = decodeFromString<Message>(serializedString)
        assertEquals(dto, deserializedDto)
    }

    @Test
    fun serializeCreateModelResponseTest() {
        val now = Clock.System.now()
        val requestId = newRequestId()
        val responseId = newResponseId()
        val dto: Message = CreateModelResponse(
            responseId = responseId,
            onRequest = requestId,
            endTime = now,
            errors = listOf(),
            status = ResponseStatusDto.SUCCESS,
            debug = Debug(WorkModeDto.TEST),
            data = newModel(),
        )
        val serializedString = encodeToString(dto)
        assertTrue { serializedString.contains(requestId) }
        assertTrue { serializedString.contains(responseId) }
        assertTrue { serializedString.contains(now.toString()) }
        assertTrue { serializedString.contains(BRAND_NAME) }
        assertTrue { serializedString.contains(MODEL_NAME) }
        assertTrue { serializedString.contains(END_TIME_FIELD) }
        assertTrue { serializedString.contains(ON_REQUEST_ID_FIELD) }
        assertTrue { serializedString.contains(RESPONSE_ID_FIELD) }
        val deserializedDto = decodeFromString<Message>(serializedString)
        assertEquals(dto, deserializedDto)
    }
}

fun newModel() = ModelDto(MODEL_ID, MODEL_NAME, newBrand())