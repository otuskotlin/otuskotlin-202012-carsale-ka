package ru.otus.otuskotlin.carsale.backend.app.ktor.controller

import io.ktor.http.*
import ru.otus.otuskotlin.carsale.transport.model.common.ResponseStatusDto
import ru.otus.otuskotlin.carsale.transport.model.vehicles.*
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import ru.otus.otuskotlin.carsale.transport.model.vehicles.UpdateBrandResponse as UpdateBrandResponse

const val REQUEST_ID = "req-123"
const val BRAND_ID = "1"
const val BRAND_NAME = "Honda"

internal class BrandControllerTest : AbstractControllerTest() {

    @Test
    fun `brand list when success`() {
        val request = ListBrandRequest(
            requestId = REQUEST_ID,
        )

        handleRequest(HttpMethod.Post, "/brand/list", request) {
                response: ListBrandResponse, _ ->

            assertEquals(ResponseStatusDto.SUCCESS, response.status)
            assertEquals(REQUEST_ID, response.onRequest)
            assertEquals(4, response.data?.size)
            assertEquals(BRAND_ID, response.data!![0].id)
            assertEquals(BRAND_NAME, response.data!![0].name)
        }
    }

    @Test
    fun `brand read when success`() {
        val request = ReadBrandRequest(
            requestId = REQUEST_ID,
            id = BRAND_ID,
        )

        handleRequest(HttpMethod.Post, "/brand/read", request) {
                response: ReadBrandResponse, _ ->

                assertEquals(ResponseStatusDto.SUCCESS, response.status)
                assertEquals(REQUEST_ID, response.onRequest)
                assertEquals(BRAND_ID, response.data?.id)
                assertEquals(BRAND_NAME, response.data?.name)
        }
    }

    @Test
    fun `brand read when id from request is empty`() {
        val request = ReadBrandRequest(
            requestId = REQUEST_ID,
        )

        handleRequest(HttpMethod.Post, "/brand/read", request) {
                response: ReadBrandResponse, _ ->

            assertEquals(ResponseStatusDto.BAD_REQUEST, response.status)
            assertEquals(REQUEST_ID, response.onRequest)
            assertNotNull(response.errors)
            assertEquals("IllegalArgumentException", response.errors!![0].code)
            assertEquals("id is empty", response.errors!![0].message)
        }
    }

    @Test
    fun `brand create when success`() {
        val request = CreateBrandRequest(
            requestId = REQUEST_ID,
            data = CreatableBrandDto(
                name = BRAND_NAME,
            ),
        )

        handleRequest(HttpMethod.Post, "/brand/create", request) {
                response: CreateBrandResponse, _ ->

            assertEquals(ResponseStatusDto.SUCCESS, response.status)
            assertEquals(REQUEST_ID, response.onRequest)
            assertNotNull(response.data?.id)
            assertEquals(BRAND_NAME, response.data?.name)
        }
    }

    @Test
    fun `brand update when success`() {
        val request = UpdateBrandRequest(
            requestId = REQUEST_ID,
            data = UpdatableBrandDto(
                id = BRAND_ID,
                name = BRAND_NAME,
            ),
        )

        handleRequest(HttpMethod.Post, "/brand/update", request) {
                response: UpdateBrandResponse, _ ->

            assertEquals(ResponseStatusDto.SUCCESS, response.status)
            assertEquals(REQUEST_ID, response.onRequest)
            assertEquals(BRAND_ID, response.data?.id)
            assertEquals(BRAND_NAME, response.data?.name)
        }
    }

    @Test
    fun `brand update when id from request is empty`() {
        val request = UpdateBrandRequest(
            requestId = REQUEST_ID,
            data = UpdatableBrandDto(
                name = BRAND_NAME,
            ),
        )

        handleRequest(HttpMethod.Post, "/brand/update", request) {
                response: UpdateBrandResponse, _ ->

            assertEquals(ResponseStatusDto.BAD_REQUEST, response.status)
            assertEquals(REQUEST_ID, response.onRequest)
            assertNotNull(response.errors)
            assertEquals("IllegalArgumentException", response.errors!![0].code)
            assertEquals("id is empty", response.errors!![0].message)
        }
    }

    @Test
    fun `brand delete when success`() {
        val request = DeleteBrandRequest(
            requestId = REQUEST_ID,
            id = BRAND_ID,
        )

        handleRequest(HttpMethod.Post, "/brand/delete", request) {
                response: DeleteBrandResponse, _ ->

            assertEquals(ResponseStatusDto.SUCCESS, response.status)
            assertEquals(REQUEST_ID, response.onRequest)
            assertEquals(BRAND_ID, response.data?.id)
            assertNotNull(response.data?.name)
        }
    }

    @Test
    fun `brand delete when id from request is empty`() {
        val request = DeleteBrandRequest(
            requestId = REQUEST_ID,
        )

        handleRequest(HttpMethod.Post, "/brand/delete", request) {
                response: DeleteBrandResponse, _ ->

            assertEquals(ResponseStatusDto.BAD_REQUEST, response.status)
            assertEquals(REQUEST_ID, response.onRequest)
            assertNotNull(response.errors)
            assertEquals("IllegalArgumentException", response.errors!![0].code)
            assertEquals("id is empty", response.errors!![0].message)
        }
    }
}