package ru.otus.otuskotlin.carsale.backend.app.ktor.controller

import io.ktor.application.*
import io.ktor.util.pipeline.*
import kotlinx.datetime.Clock
import ru.otus.otuskotlin.carsale.transport.model.common.ResponseStatusDto
import ru.otus.otuskotlin.carsale.transport.model.vehicles.*
import java.util.*

class BrandController: AbstractController() {

    suspend fun list(pipelineContext: PipelineContext<Unit, ApplicationCall>) =
        pipelineContext.handle { request: ListBrandRequest ->
                ListBrandResponse(
                    responseId = UUID.randomUUID().toString(),
                    onRequest = request.requestId,
                    status = ResponseStatusDto.SUCCESS,
                    endTime = Clock.System.now(),
                    data = mockBrandList,
                )
        }

    suspend fun create(pipelineContext: PipelineContext<Unit, ApplicationCall>) =
        pipelineContext.handle { request: CreateBrandRequest ->
            CreateBrandResponse(
                onRequest = request.requestId,
                status = ResponseStatusDto.SUCCESS,
                endTime = Clock.System.now(),
                data = BrandDto(
                    id = mockBrandList.size.inc().toString(),
                    name = request.data!!.name
                ),
            )
        }

    suspend fun read(pipelineContext: PipelineContext<Unit, ApplicationCall>) =
        pipelineContext.handle { request: ReadBrandRequest ->
            ReadBrandResponse(
                onRequest = request.requestId,
                status = ResponseStatusDto.SUCCESS,
                endTime = Clock.System.now(),
                data = BrandDto(
                    id = request.id ?: throw IllegalArgumentException("id is empty"),
                    name = mockHonda.name
                ),
            )
        }

    suspend fun update(pipelineContext: PipelineContext<Unit, ApplicationCall>) =
        pipelineContext.handle { request: UpdateBrandRequest ->
            UpdateBrandResponse(
                onRequest = request.requestId,
                status = ResponseStatusDto.SUCCESS,
                endTime = Clock.System.now(),
                data = BrandDto(
                    id = request.data!!.id ?: throw IllegalArgumentException("id is empty"),
                    name = request.data!!.name
                ),
            )
        }

    suspend fun delete(pipelineContext: PipelineContext<Unit, ApplicationCall>) =
        pipelineContext.handle { request: DeleteBrandRequest ->
            DeleteBrandResponse(
                onRequest = request.requestId,
                status = ResponseStatusDto.SUCCESS,
                endTime = Clock.System.now(),
                data = BrandDto(
                    id = request.id ?: throw IllegalArgumentException("id is empty"),
                    name = "VW"
                ),
                deleted = true,
            )
        }
}

val mockHonda = BrandDto("1", "Honda")
val mockToyota = BrandDto("2", "Toyota")
val mockMazda = BrandDto("3", "Mazda")
val mockNissan = BrandDto("4", "Nissan")
val mockBrandList = mutableListOf(mockHonda, mockToyota, mockMazda, mockNissan)