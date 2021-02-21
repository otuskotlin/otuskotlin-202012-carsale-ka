package ru.otus.otuskotlin.carsale.transport.model.ad

import kotlinx.datetime.Instant
import kotlinx.serialization.json.Json
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class AdSerializationTest {

    private val json = Json { prettyPrint = true }

    @Test
    fun serializeContactTest() {
        val createAsString = "2021-02-21T12:00:00Z"
        val dto = ContactDto(
            id = "1",
            name = "test",
            phone = "79110001122",
            email = "email@mail.ru",
            created = Instant.parse(createAsString)
        )

        val serializedDto = json.encodeToString(ContactDto.serializer(), dto)
        println(serializedDto)
        assertTrue { serializedDto.contains(createAsString) }
        assertTrue { serializedDto.contains(dto.email!!) }

        val deserializedDto = json.decodeFromString(ContactDto.serializer(), serializedDto)
        println(deserializedDto)
        assertEquals(createAsString, deserializedDto.created.toString())
    }

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
