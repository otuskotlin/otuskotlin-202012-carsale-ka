package ru.otus.otuskotlin.carsale.backend.app.ktor.controller

import io.ktor.application.*
import io.ktor.util.pipeline.*
import kotlinx.datetime.Clock
import ru.otus.otuskotlin.carsale.transport.model.ad.*
import ru.otus.otuskotlin.carsale.transport.model.common.ResponseStatusDto

class ContactController: AbstractController() {

    suspend fun list(pipelineContext: PipelineContext<Unit, ApplicationCall>) =
        pipelineContext.handle { request: ListContactRequest ->
            ListContactResponse(
                onRequest = request.requestId,
                status = ResponseStatusDto.SUCCESS,
                endTime = Clock.System.now(),
                data = mockContactList,
            )
        }

    suspend fun create(pipelineContext: PipelineContext<Unit, ApplicationCall>) =
        pipelineContext.handle { request: CreateContactRequest ->
            val data = request.data!!
            CreateContactResponse(
                onRequest = request.requestId,
                status = ResponseStatusDto.SUCCESS,
                endTime = Clock.System.now(),
                data = ContactDto(mockContactList.size.inc().toString(), data.name, data.phone, data.email, Clock.System.now()),
            )
        }

    suspend fun read(pipelineContext: PipelineContext<Unit, ApplicationCall>) =
        pipelineContext.handle { request: ReadContactRequest ->
            val data = mockContact1;
            ReadContactResponse(
                onRequest = request.requestId,
                status = ResponseStatusDto.SUCCESS,
                endTime = Clock.System.now(),
                data = ContactDto(request.id, data.name, data.phone, data.email, data.created),
            )
        }

    suspend fun update(pipelineContext: PipelineContext<Unit, ApplicationCall>) =
        pipelineContext.handle { request: UpdateContactRequest ->
            val data = request.data!!
            val originalData = mockContact1
            UpdateContactResponse(
                onRequest = request.requestId,
                status = ResponseStatusDto.SUCCESS,
                endTime = Clock.System.now(),
                data = ContactDto(data.id!!,
                    data.name ?: originalData.name,
                    data.phone ?: originalData.phone,
                    data.email ?: originalData.email,
                    originalData.created),
            )
        }

    suspend fun delete(pipelineContext: PipelineContext<Unit, ApplicationCall>) =
        pipelineContext.handle { request: DeleteContactRequest ->
            val data = mockContact1;
            DeleteContactResponse(
                onRequest = request.requestId,
                status = ResponseStatusDto.SUCCESS,
                endTime = Clock.System.now(),
                data = ContactDto(request.id, data.name, data.phone, data.email, data.created),
                deleted = true,
            )
        }
}

val mockContact1 = ContactDto("1", "Иванов", "79001230001", "ivanov@mail.ru", Clock.System.now())
val mockContact2 = ContactDto("2", "Петров", "79001230002", "petrov@mail.ru", Clock.System.now())
val mockContact3 = ContactDto("3", "Сидоров", "79001230003", "sidorov@mail.ru", Clock.System.now())
val mockContactList = mutableListOf(mockContact1, mockContact2, mockContact3)