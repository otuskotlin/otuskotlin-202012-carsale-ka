package ru.otus.otuskotlin.carsale.backend.app.ktor.controller

import io.ktor.application.*
import io.ktor.util.pipeline.*
import kotlinx.datetime.Clock
import ru.otus.otuskotlin.carsale.transport.model.common.ResponseStatusDto
import ru.otus.otuskotlin.carsale.transport.model.vehicles.*

class ModelController: AbstractController() {

    suspend fun list(pipelineContext: PipelineContext<Unit, ApplicationCall>) =
        pipelineContext.handle { request: ListModelRequest ->
            ListModelResponse(
                onRequest = request.requestId,
                status = ResponseStatusDto.SUCCESS,
                endTime = Clock.System.now(),
                data = mockModelList,
            )
        }

    suspend fun create(pipelineContext: PipelineContext<Unit, ApplicationCall>) =
        pipelineContext.handle { request: CreateModelRequest ->
            CreateModelResponse(
                onRequest = request.requestId,
                status = ResponseStatusDto.SUCCESS,
                endTime = Clock.System.now(),
                data = ModelDto(
                    id = mockModelList.size.inc().toString(),
                    name = request.data!!.name,
                    brand = request.data!!.brand
                ),
            )
        }

    suspend fun read(pipelineContext: PipelineContext<Unit, ApplicationCall>) =
        pipelineContext.handle { request: ReadModelRequest ->
            ReadModelResponse(
                onRequest = request.requestId,
                status = ResponseStatusDto.SUCCESS,
                endTime = Clock.System.now(),
                data = ModelDto(
                    id = request.id ?: throw IllegalArgumentException("id is empty"),
                    name = "Jazz",
                    brand = mockHonda
                ),
            )
        }

    suspend fun update(pipelineContext: PipelineContext<Unit, ApplicationCall>) =
        pipelineContext.handle { request: UpdateModelRequest ->
            UpdateModelResponse(
                onRequest = request.requestId,
                status = ResponseStatusDto.SUCCESS,
                endTime = Clock.System.now(),
                data = ModelDto(
                    id = request.data!!.id ?: throw IllegalArgumentException("id is empty"),
                    name = request.data!!.name,
                    brand = mockHonda
                ),
            )
        }

    suspend fun delete(pipelineContext: PipelineContext<Unit, ApplicationCall>) =
        pipelineContext.handle { request: DeleteModelRequest ->
            DeleteModelResponse(
                onRequest = request.requestId,
                status = ResponseStatusDto.SUCCESS,
                endTime = Clock.System.now(),
                deleted = true,
                data = ModelDto(
                    id = request.id ?: throw IllegalArgumentException("id is empty"),
                    name = "Jazz",
                    brand = mockHonda
                ),
            )
        }
}

val mockCRV = ModelDto("1", "CRV", mockHonda)
val mockCivic = ModelDto("2", "Civic", mockHonda)
val mockAccord = ModelDto("3", "Accord", mockHonda)
val mockCorolla = ModelDto("4", "Corolla", mockToyota)
val mockCamry = ModelDto("5", "Camry", mockToyota)
val mockModelList = mutableListOf(mockCRV, mockCivic, mockAccord, mockCorolla, mockCamry)