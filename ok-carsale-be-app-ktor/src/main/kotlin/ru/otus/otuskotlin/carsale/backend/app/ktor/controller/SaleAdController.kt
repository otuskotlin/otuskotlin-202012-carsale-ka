package ru.otus.otuskotlin.carsale.backend.app.ktor.controller

import io.ktor.application.*
import io.ktor.util.pipeline.*
import kotlinx.datetime.Clock
import ru.otus.otuskotlin.carsale.transport.model.ad.*
import ru.otus.otuskotlin.carsale.transport.model.common.ResponseStatusDto
import ru.otus.otuskotlin.carsale.transport.model.vehicles.*

class SaleAdController: AbstractController() {

    suspend fun list(pipelineContext: PipelineContext<Unit, ApplicationCall>) =
        pipelineContext.handle { request: ListSaleAdRequest ->
            ListSaleAdResponse(
                onRequest = request.requestId,
                status = ResponseStatusDto.SUCCESS,
                endTime = Clock.System.now(),
                data = mockSaleAdList,
            )
        }

    suspend fun create(pipelineContext: PipelineContext<Unit, ApplicationCall>) =
        pipelineContext.handle { request: CreateSaleAdRequest ->
            val data = request.data!!
            CreateSaleAdResponse(
                onRequest = request.requestId,
                status = ResponseStatusDto.SUCCESS,
                endTime = Clock.System.now(),
                data = SaleAdDto(
                    id = mockContactList.size.inc().toString(),
                    contact = ContactDto(
                        id = data.contact!!.id,
                        name = mockContact1.name,
                        phone = mockContact1.phone,
                        email = mockContact1.email,
                        created = mockContact1.created,
                    ),
                    car = data.car!!,
                    price = data.price!!,
                    created = Clock.System.now(),
                )
            )
        }

    suspend fun read(pipelineContext: PipelineContext<Unit, ApplicationCall>) =
        pipelineContext.handle { request: ReadSaleAdRequest ->
            ReadSaleAdResponse(
                onRequest = request.requestId,
                status = ResponseStatusDto.SUCCESS,
                endTime = Clock.System.now(),
                data = newSaleAd(request.id!!),
            )
        }

    suspend fun update(pipelineContext: PipelineContext<Unit, ApplicationCall>) =
        pipelineContext.handle { request: UpdateSaleAdRequest ->
            val data = request.data!!
            val originalData = mockSaleAd1
            UpdateSaleAdResponse(
                onRequest = request.requestId,
                status = ResponseStatusDto.SUCCESS,
                endTime = Clock.System.now(),
                data = SaleAdDto(
                    id = data.id!!,
                    contact = mockContact1,
                    car = data.car!!,
                    price = data.price!!,
                    created = originalData.created,
                )
            )
        }

    suspend fun delete(pipelineContext: PipelineContext<Unit, ApplicationCall>) =
        pipelineContext.handle { request: DeleteSaleAdRequest ->
            DeleteSaleAdResponse(
                onRequest = request.requestId,
                status = ResponseStatusDto.SUCCESS,
                endTime = Clock.System.now(),
                data = newSaleAd(request.id!!),
                deleted = true,
            )
        }
}

fun newSaleAd(id: String) = SaleAdDto(
    id = id,
    contact = mockContact1,
    car = CarDto(
        vin = "JNKCV51E63M064917",
        model = mockCRV,
        year = 1998,
        mileage = 320500,
        carcase = CarcaseDto.STATION_WAGON,
        color = ColorDto.SILVER,
        engine = EngineDto(
            type = EngineTypeDto.GAZOLINE,
            volume = 2,
            powerHP = 128,
        ),
        gearbox = GearboxDto.AUTO,
        drive = DriveDto.PART_TIME_AWD,
        steeringWheel = SteeringWheelDto.LEFT,
    ),
    price = 350000,
    created = Clock.System.now(),
)

val mockSaleAd1 = newSaleAd("1")
val mockSaleAdList = mutableListOf(mockSaleAd1)