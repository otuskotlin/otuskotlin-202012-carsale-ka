package ru.otus.otuskotlin.carsale.backend.app.kofu.controller

import kotlinx.datetime.Clock
import org.springframework.web.servlet.function.ServerRequest
import org.springframework.web.servlet.function.ServerResponse
import ru.otus.otuskotlin.carsale.transport.model.common.ResponseStatusDto
import ru.otus.otuskotlin.carsale.transport.model.vehicles.*

class ModelController: AbstractController() {

    fun list(serverRequest: ServerRequest): ServerResponse =
        serverRequest.handle { request: ListModelRequest ->
            ListModelResponse(
                onRequest = request.requestId,
                status = ResponseStatusDto.SUCCESS,
                endTime = Clock.System.now(),
                data = mockModelList(),
            )
        }

    fun create(serverRequest: ServerRequest): ServerResponse =
        serverRequest.handle { request: CreateModelRequest ->
            CreateModelResponse(
                onRequest = request.requestId,
                status = ResponseStatusDto.SUCCESS,
                endTime = Clock.System.now(),
                data = ModelDto(mockModelList().size.inc().toString(), request.data!!.name, request.data!!.brand),
            )
        }

    fun read(serverRequest: ServerRequest): ServerResponse =
        serverRequest.handle { request: ReadModelRequest ->
            ReadModelResponse(
                onRequest = request.requestId,
                status = ResponseStatusDto.SUCCESS,
                endTime = Clock.System.now(),
                data = ModelDto(request.id, "Jazz", mockHonda()),
            )
        }

    fun update(serverRequest: ServerRequest): ServerResponse =
        serverRequest.handle { request: UpdateModelRequest ->
            UpdateModelResponse(
                onRequest = request.requestId,
                status = ResponseStatusDto.SUCCESS,
                endTime = Clock.System.now(),
                data = ModelDto(request.data!!.id, request.data!!.name, mockHonda()),
            )
        }

    fun delete(serverRequest: ServerRequest): ServerResponse =
        serverRequest.handle { request: DeleteModelRequest ->
            DeleteModelResponse(
                onRequest = request.requestId,
                status = ResponseStatusDto.SUCCESS,
                endTime = Clock.System.now(),
                data = ModelDto(request.id, "Jazz", mockHonda()),
                deleted = true,
            )
        }
}

fun mockModelList() = mutableListOf(mockCRV(), mockCivic(), mockAccord(), mockCorolla(), mockCamry())
fun mockCRV() = ModelDto("1", "CRV", mockHonda())
fun mockCivic() = ModelDto("2", "Civic", mockHonda())
fun mockAccord() = ModelDto("3", "Accord", mockHonda())
fun mockCorolla() = ModelDto("4", "Corolla", mockToyota())
fun mockCamry() = ModelDto("5", "Camry", mockToyota())