package ru.otus.otuskotlin.carsale.backend.app.spring.controller

import kotlinx.datetime.Clock
import org.springframework.web.servlet.function.ServerRequest
import org.springframework.web.servlet.function.ServerResponse
import org.springframework.web.servlet.function.ServerResponse.ok
import ru.otus.otuskotlin.carsale.transport.model.common.ResponseStatusDto
import ru.otus.otuskotlin.carsale.transport.model.vehicles.*

class BrandController {

    fun list(serverRequest: ServerRequest): ServerResponse {
        val request = serverRequest.body(ListBrandRequest::class.java)
        val response = ListBrandResponse(
            onRequest = request.requestId,
            status = ResponseStatusDto.SUCCESS,
            endTime = Clock.System.now(),
            data = listOf(
                BrandDto("1", "Honda"),
                BrandDto("2", "Toyota"),
                BrandDto("3", "Mazda"),
                BrandDto("4", "Nissan"),
            ),
        )
        return ok().body(response)
    }

    fun create(serverRequest: ServerRequest): ServerResponse {
        val request = serverRequest.body(CreateBrandRequest::class.java)
        val response = CreateBrandResponse(
            onRequest = request.requestId,
            status = ResponseStatusDto.SUCCESS,
            endTime = Clock.System.now(),
            data = BrandDto("1", request.data!!.name),
        )
        return ok().body(response)
    }

    fun read(serverRequest: ServerRequest): ServerResponse {
        val request = serverRequest.body(ReadBrandRequest::class.java)
        val response = ReadBrandResponse(
            onRequest = request.requestId,
            status = ResponseStatusDto.SUCCESS,
            endTime = Clock.System.now(),
            data = BrandDto(request.id, "Honda"),
        )
        return ok().body(response)
    }

    fun update(serverRequest: ServerRequest): ServerResponse {
        val request = serverRequest.body(UpdateBrandRequest::class.java)
        val response = UpdateBrandResponse(
            onRequest = request.requestId,
            status = ResponseStatusDto.SUCCESS,
            endTime = Clock.System.now(),
            data = BrandDto(request.data!!.id, request.data!!.name),
        )
        return ok().body(response)
    }

    fun delete(serverRequest: ServerRequest): ServerResponse {
        val request = serverRequest.body(DeleteBrandRequest::class.java)
        val response = DeleteBrandResponse(
            onRequest = request.requestId,
            status = ResponseStatusDto.SUCCESS,
            endTime = Clock.System.now(),
            data = BrandDto(request.id, "Honda"),
            deleted = true,
        )
        return ok().body(response)
    }
}