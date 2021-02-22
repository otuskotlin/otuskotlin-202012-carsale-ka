package ru.otus.otuskotlin.carsale.transport.model.ad

import kotlinx.datetime.Instant
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import ru.otus.otuskotlin.carsale.transport.model.AbstractSerializationTest
import ru.otus.otuskotlin.carsale.transport.model.vehicles.*
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class AdSerializationTest : AbstractSerializationTest() {

    @Test
    fun serializeContactTest() {
        val createAsString = "2021-02-21T12:00:00Z"
        val dto = createContact(Instant.parse(createAsString))

        val serializedDto = json.encodeToString(dto)
        println(serializedDto)
        assertTrue { serializedDto.contains(createAsString) }
        assertTrue { serializedDto.contains(dto.email!!) }

        val deserializedDto = json.decodeFromString<ContactDto>(serializedDto)
        println(deserializedDto)
        assertEquals(createAsString, deserializedDto.created.toString())
        assertEquals(dto, deserializedDto)
    }

    @Test
    fun serializeSaleAdTest() {
        val createAsString = "2021-02-21T12:00:00Z"
        val dto = createSaleAd(Instant.parse(createAsString))

        val serializedDto = json.encodeToString(dto)
        println(serializedDto)
        assertTrue { serializedDto.contains(createAsString) }
        assertTrue { serializedDto.contains(dto.vin!!) }

        val deserializedDto = json.decodeFromString<SaleAdDto>(serializedDto)
        println(deserializedDto)
        assertEquals(createAsString, deserializedDto.created.toString())
        assertEquals(dto, deserializedDto)
    }

    private fun createContact(created: Instant) = ContactDto(
        id = "1",
        name = "test",
        phone = "79110001122",
        email = "email@mail.ru",
        created = created
    )

    private fun createSaleAd(created: Instant) = SaleAdDto(
        id = "2",
        contact = createContact(created),
        vin = "JNKCV51E63M064917",
        model = ModelDto(
            id = "m1",
            name = "CRV",
            brand = BrandDto(
                id = "b1",
                name = "Honda"
            )
        ),
        year = 1998,
        mileage = 320500,
        carcase = CarcaseDto.STATION_WAGON,
        color = ColorDto.SILVER,
        engineVolume = 2,
        powerHP = 128,
        engine = EngineDto.GAZOLINE,
        gearbox = GearboxDto.AUTO,
        drive = DriveDto.PART_TIME_AWD,
        steeringWheel = SteeringWheelDto.LEFT,
        price = 350000,
        created = created
    )
}
