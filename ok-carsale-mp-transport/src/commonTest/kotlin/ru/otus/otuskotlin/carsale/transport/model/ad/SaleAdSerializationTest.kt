package ru.otus.otuskotlin.carsale.transport.model.ad

import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import ru.otus.otuskotlin.carsale.transport.model.*
import ru.otus.otuskotlin.carsale.transport.model.common.Debug
import ru.otus.otuskotlin.carsale.transport.model.common.Message
import ru.otus.otuskotlin.carsale.transport.model.common.ResponseStatusDto
import ru.otus.otuskotlin.carsale.transport.model.common.WorkModeDto
import ru.otus.otuskotlin.carsale.transport.model.vehicles.*
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

const val AD_ID = "4"
const val AD_VIN = "JNKCV51E63M064917"

class SaleAdSerializationTest : AbstractSerializationTest() {

    @Test
    fun serializeSaleAdTest() {
        val createAsString = "2021-02-21T12:00:00Z"
        val dto = newSaleAd(Instant.parse(createAsString))

        val serializedString = encodeToString(dto)
        assertTrue { serializedString.contains(createAsString) }
        assertTrue { serializedString.contains(AD_VIN) }

        val deserializedDto = decodeFromString<SaleAdDto>(serializedString)
        assertEquals(createAsString, deserializedDto.created.toString())
        assertEquals(dto, deserializedDto)
    }

    @Test
    fun serializeCreateSaleAdRequestTest() {
        val now = Clock.System.now()
        val requestId = newRequestId()
        val dto: Message = CreateSaleAdRequest(
            requestId = requestId,
            startTime = now,
            debug = Debug(WorkModeDto.TEST),
            data = newCreatableSaleAdDto(now),
        )
        val serializedString = encodeToString(dto)
        assertTrue { serializedString.contains(requestId) }
        assertTrue { serializedString.contains(now.toString()) }
        assertTrue { serializedString.contains(AD_VIN) }
        assertTrue { serializedString.contains(BRAND_NAME) }
        assertTrue { serializedString.contains(CONTACT_EMAIL) }
        assertTrue { serializedString.contains(START_TIME_FIELD) }
        assertTrue { serializedString.contains(REQUEST_ID_FIELD) }
        val deserializedDto = decodeFromString<Message>(serializedString)
        assertEquals(dto, deserializedDto)
    }

    @Test
    fun serializeCreateSaleAdResponseTest() {
        val now = Clock.System.now()
        val requestId = newRequestId()
        val responseId = newResponseId()
        val dto: Message = CreateSaleAdResponse(
            responseId = responseId,
            onRequest = requestId,
            endTime = now,
            errors = listOf(),
            status = ResponseStatusDto.SUCCESS,
            debug = Debug(WorkModeDto.TEST),
            data = newSaleAd(now),
        )
        val serializedString = encodeToString(dto)
        assertTrue { serializedString.contains(requestId) }
        assertTrue { serializedString.contains(responseId) }
        assertTrue { serializedString.contains(now.toString()) }
        assertTrue { serializedString.contains(AD_VIN) }
        assertTrue { serializedString.contains(BRAND_NAME) }
        assertTrue { serializedString.contains(CONTACT_EMAIL) }
        assertTrue { serializedString.contains(END_TIME_FIELD) }
        assertTrue { serializedString.contains(ON_REQUEST_ID_FIELD) }
        assertTrue { serializedString.contains(RESPONSE_ID_FIELD) }
        val deserializedDto = decodeFromString<Message>(serializedString)
        assertEquals(dto, deserializedDto)
    }
}

fun newSaleAd(created: Instant) = SaleAdDto(
    id = AD_ID,
    contact = newContact(created),
    car = newCar(),
    price = 350000,
    created = created
)

fun newEngine() = EngineDto(
    type = EngineTypeDto.GAZOLINE,
    volume = 2,
    powerHP = 128,
)

fun newCar() = CarDto(
    vin = AD_VIN,
    model = newModel(),
    year = 1998,
    mileage = 320500,
    carcase = CarcaseDto.STATION_WAGON,
    color = ColorDto.SILVER,
    engine = newEngine(),
    gearbox = GearboxDto.AUTO,
    drive = DriveDto.PART_TIME_AWD,
    steeringWheel = SteeringWheelDto.LEFT,
)

fun newCreatableSaleAdDto(created: Instant) = CreatableSaleAdDto(
    contact = newContact(created),
    car = newCar(),
    price = 350000,
    created = created
)