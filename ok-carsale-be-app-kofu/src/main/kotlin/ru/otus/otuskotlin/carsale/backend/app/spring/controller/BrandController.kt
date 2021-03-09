package ru.otus.otuskotlin.carsale.backend.app.spring.controller

import kotlinx.datetime.Clock
import org.springframework.web.servlet.function.ServerRequest
import org.springframework.web.servlet.function.ServerResponse
import ru.otus.otuskotlin.carsale.transport.model.common.ResponseStatusDto
import ru.otus.otuskotlin.carsale.transport.model.vehicles.*

class BrandController: AbstractController() {

    fun list(serverRequest: ServerRequest): ServerResponse =
        serverRequest.handle { request: ListBrandRequest ->
            ListBrandResponse(
                onRequest = request.requestId,
                status = ResponseStatusDto.SUCCESS,
                endTime = Clock.System.now(),
                data = mockBrandList(),
            )
        }

    fun create(serverRequest: ServerRequest): ServerResponse =
        serverRequest.handle { request: CreateBrandRequest ->

            CreateBrandResponse(
                onRequest = request.requestId,
                status = ResponseStatusDto.SUCCESS,
                endTime = Clock.System.now(),
                data = BrandDto(mockBrandList().size.inc().toString(), request.data!!.name),
            )
        }

    fun read(serverRequest: ServerRequest): ServerResponse =
        serverRequest.handle { request: ReadBrandRequest ->
            ReadBrandResponse(
                onRequest = request.requestId,
                status = ResponseStatusDto.SUCCESS,
                endTime = Clock.System.now(),
                data = BrandDto(request.id, "BMW"),
            )
        }

    fun update(serverRequest: ServerRequest): ServerResponse =
        serverRequest.handle { request: UpdateBrandRequest ->
            UpdateBrandResponse(
                onRequest = request.requestId,
                status = ResponseStatusDto.SUCCESS,
                endTime = Clock.System.now(),
                data = BrandDto(request.data!!.id, request.data!!.name),
            )
        }

    fun delete(serverRequest: ServerRequest): ServerResponse =
        serverRequest.handle { request: DeleteBrandRequest ->
            DeleteBrandResponse(
                onRequest = request.requestId,
                status = ResponseStatusDto.SUCCESS,
                endTime = Clock.System.now(),
                data = BrandDto(request.id, "VW"),
                deleted = true,
            )
        }
}

fun mockBrandList() = mutableListOf(mockHonda(), mockToyota(), mockMazda(), mockNissan())
fun mockHonda() = BrandDto("1", "Honda")
fun mockToyota() = BrandDto("2", "Toyota")
fun mockMazda() = BrandDto("3", "Mazda")
fun mockNissan() = BrandDto("4", "Nissan")