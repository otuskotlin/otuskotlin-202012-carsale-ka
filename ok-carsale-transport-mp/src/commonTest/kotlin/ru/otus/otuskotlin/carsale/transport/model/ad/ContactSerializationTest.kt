package ru.otus.otuskotlin.carsale.transport.model.ad

import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import ru.otus.otuskotlin.carsale.transport.model.AbstractSerializationTest
import ru.otus.otuskotlin.carsale.transport.model.common.Debug
import ru.otus.otuskotlin.carsale.transport.model.common.Message
import ru.otus.otuskotlin.carsale.transport.model.common.ResponseStatusDto
import ru.otus.otuskotlin.carsale.transport.model.common.WorkModeDto
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

const val CONTACT_ID = "3"
const val CONTACT_NAME = "Иванов Иван"
const val CONTACT_PHONE = "79110001122"
const val CONTACT_EMAIL = "email@mail.ru"

class BrandSerializationTest : AbstractSerializationTest() {

    @Test
    fun serializeContactTest() {
        val createAsString = "2021-02-21T12:00:00Z"
        val dto = newContact(Instant.parse(createAsString))

        val serializedString = encodeToString(dto)
        assertTrue { serializedString.contains(createAsString) }
        assertTrue { serializedString.contains(CONTACT_NAME) }
        assertTrue { serializedString.contains(CONTACT_PHONE) }
        assertTrue { serializedString.contains(CONTACT_EMAIL) }

        val deserializedDto = decodeFromString<ContactDto>(serializedString)
        assertEquals(createAsString, deserializedDto.created.toString())
        assertEquals(dto, deserializedDto)
    }

    @Test
    fun serializeCreateBrandRequestTest() {
        val now = Clock.System.now()
        val requestId = newRequestId()
        val dto: Message = CreateContactRequest(
            requestId = requestId,
            startTime = now,
            debug = Debug(WorkModeDto.TEST),
            data = CreatableContactDto(
                name = CONTACT_NAME,
                phone = CONTACT_PHONE,
                email = CONTACT_EMAIL),
        )
        val serializedString = encodeToString(dto)
        assertTrue { serializedString.contains(requestId) }
        assertTrue { serializedString.contains(now.toString()) }
        assertTrue { serializedString.contains(CONTACT_NAME) }
        assertTrue { serializedString.contains(CONTACT_PHONE) }
        assertTrue { serializedString.contains(CONTACT_EMAIL) }
        val deserializedDto = decodeFromString<Message>(serializedString)
        assertEquals(dto, deserializedDto)
    }

    @Test
    fun serializeCreateBrandResponseTest() {
        val now = Clock.System.now()
        val requestId = newRequestId()
        val responseId = newResponseId()
        val dto: Message = CreateContactResponse(
            responseId = responseId,
            onRequest = requestId,
            endTime = now,
            errors = listOf(),
            status = ResponseStatusDto.SUCCESS,
            debug = Debug(WorkModeDto.TEST),
            data = newContact(now),
        )
        val serializedString = encodeToString(dto)
        assertTrue { serializedString.contains(requestId) }
        assertTrue { serializedString.contains(responseId) }
        assertTrue { serializedString.contains(now.toString()) }
        assertTrue { serializedString.contains(CONTACT_NAME) }
        assertTrue { serializedString.contains(CONTACT_PHONE) }
        assertTrue { serializedString.contains(CONTACT_EMAIL) }
        val deserializedDto = decodeFromString<Message>(serializedString)
        assertEquals(dto, deserializedDto)
    }
}

fun newContact(created: Instant) = ContactDto(
    id = CONTACT_ID,
    name = CONTACT_NAME,
    phone = CONTACT_PHONE,
    email = CONTACT_EMAIL,
    created = created
)
