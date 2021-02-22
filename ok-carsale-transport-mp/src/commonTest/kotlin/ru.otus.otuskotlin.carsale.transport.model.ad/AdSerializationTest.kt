package ru.otus.otuskotlin.carsale.transport.model.ad

import kotlinx.datetime.Instant
import kotlinx.serialization.json.Json
import ru.otus.otuskotlin.carsale.transport.model.vehicles.*
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class AdSerializationTest {

    private val json = Json { prettyPrint = true }

    @Test
    fun serializeContactTest() {
        val createAsString = "2021-02-21T12:00:00Z"
        val dto = createContact(Instant.parse(createAsString))

        val serializedDto = json.encodeToString(ContactDto.serializer(), dto)
        println(serializedDto)
        assertTrue { serializedDto.contains(createAsString) }
        assertTrue { serializedDto.contains(dto.email!!) }

        val deserializedDto = json.decodeFromString(ContactDto.serializer(), serializedDto)
        println(deserializedDto)
        assertEquals(createAsString, deserializedDto.created.toString())
        assertEquals(dto, deserializedDto)
    }

    @Test
    fun serializeSaleAdTest() {
        val createAsString = "2021-02-21T12:00:00Z"
        val dto = createSaleAd(Instant.parse(createAsString))

        val serializedDto = json.encodeToString(SaleAdDto.serializer(), dto)
        println(serializedDto)
        assertTrue { serializedDto.contains(createAsString) }
        assertTrue { serializedDto.contains(dto.vin!!) }

        val deserializedDto = json.decodeFromString(SaleAdDto.serializer(), serializedDto)
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



//    @Test
//    fun serializeMpRequestTest(){
//        val jsonRequest = Json {
//            prettyPrint = true
//            serializersModule = SerializersModule {
//
//                polymorphic(MpMessage::class) {
//                    subclass(MpRequestDemandCreate::class, MpRequestDemandCreate.serializer())
//                }
//
//            }
//            classDiscriminator = "type"
//        }
//        val dto:MpMessage = MpRequestDemandCreate(
//            requestId = "create-id",
//            startTime = "2021-02-13T12:00:00",
//            createData = MpDemandCreateDto(
//                title = "demand-2",
//                description = "some description",
//                techDets = setOf(TechDetsDto(
//                    id = "tech-det-id"
//                ))
//            )
//        )
//        val serializedString = jsonRequest.encodeToString(dto)
//        println(serializedString)
//        assertTrue { serializedString.contains("demand-2") }
//        val deserializedDto = jsonRequest.decodeFromString(MpMessage.serializer(), serializedString)
//        assertEquals("tech-det-id", (deserializedDto as? MpRequestDemandCreate)?.createData?.techDets?.firstOrNull()?.id)
//    }

}
