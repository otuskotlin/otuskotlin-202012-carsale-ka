package ru.otus.otuskotlin.carsale.transport.model.ad

import kotlinx.datetime.Instant
import ru.otus.otuskotlin.carsale.transport.model.AbstractSerializationTest
import ru.otus.otuskotlin.carsale.transport.model.DATE_TIME
import ru.otus.otuskotlin.carsale.transport.model.REQUEST_ID
import ru.otus.otuskotlin.carsale.transport.model.RESPONSE_ID
import ru.otus.otuskotlin.carsale.transport.model.common.Debug
import ru.otus.otuskotlin.carsale.transport.model.common.Message
import ru.otus.otuskotlin.carsale.transport.model.common.ResponseStatusDto
import ru.otus.otuskotlin.carsale.transport.model.common.WorkModeDto
import kotlin.test.Test
import kotlin.test.assertEquals

const val CONTACT_ID = "3"
const val CONTACT_NAME = "Иванов Иван"
const val CONTACT_PHONE = "79110001122"
const val CONTACT_EMAIL = "email@mail.ru"

class BrandSerializationTest : AbstractSerializationTest() {

    @Test
    fun serializeContactTest() {
        val dto = newContact(Instant.parse(DATE_TIME))

        val serializedString = encodeToString(dto)
        assertEquals(SERIALIZED_CONTACT, serializedString)

        val deserializedDto = decodeFromString<ContactDto>(serializedString)
        assertEquals(DATE_TIME, deserializedDto.created.toString())
        assertEquals(dto, deserializedDto)
    }

    @Test
    fun serializeCreateBrandRequestTest() {
        val dto: Message = CreateContactRequest(
            requestId = REQUEST_ID,
            startTime = Instant.parse(DATE_TIME),
            debug = Debug(WorkModeDto.TEST),
            data = CreatableContactDto(
                name = CONTACT_NAME,
                phone = CONTACT_PHONE,
                email = CONTACT_EMAIL),
        )
        val serializedString = encodeToString(dto)
        assertEquals(SERIALIZED_CREATE_CONTACT_REQUEST, serializedString)

        val deserializedDto = decodeFromString<Message>(serializedString)
        assertEquals(dto, deserializedDto)
    }

    @Test
    fun serializeCreateBrandResponseTest() {
        val date = Instant.parse(DATE_TIME)
        val requestId = REQUEST_ID
        val responseId = RESPONSE_ID
        val dto: Message = CreateContactResponse(
            responseId = responseId,
            onRequest = requestId,
            endTime = date,
            errors = listOf(),
            status = ResponseStatusDto.SUCCESS,
            debug = Debug(WorkModeDto.TEST),
            data = newContact(date),
        )
        val serializedString = encodeToString(dto)
        assertEquals(SERIALIZED_CREATE_CONTACT_RESPONSE, serializedString)

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

private const val SERIALIZED_CONTACT = """{
    "id": "3",
    "name": "Иванов Иван",
    "phone": "79110001122",
    "email": "email@mail.ru",
    "created": "2021-02-24T18:22:17.517Z"
}"""

private const val SERIALIZED_CREATE_CONTACT_REQUEST = """{
    "type": "ru.otus.otuskotlin.carsale.transport.model.ad.CreateContactRequest",
    "requestId": "request-id-6057115544696617309",
    "startTime": "2021-02-24T18:22:17.517Z",
    "debug": {
        "mode": "TEST"
    },
    "data": {
        "name": "Иванов Иван",
        "phone": "79110001122",
        "email": "email@mail.ru"
    }
}"""

private const val SERIALIZED_CREATE_CONTACT_RESPONSE = """{
    "type": "ru.otus.otuskotlin.carsale.transport.model.ad.CreateContactResponse",
    "responseId": "response-id-8266843433733270380",
    "onRequest": "request-id-6057115544696617309",
    "endTime": "2021-02-24T18:22:17.517Z",
    "errors": [
    ],
    "status": "SUCCESS",
    "debug": {
        "mode": "TEST"
    },
    "data": {
        "id": "3",
        "name": "Иванов Иван",
        "phone": "79110001122",
        "email": "email@mail.ru",
        "created": "2021-02-24T18:22:17.517Z"
    }
}"""