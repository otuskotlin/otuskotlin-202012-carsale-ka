package ru.otus.otuskotlin.carsale.backend.app.ktor.controller

import io.ktor.http.*
import ru.otus.otuskotlin.carsale.transport.model.common.ResponseStatusDto
import ru.otus.otuskotlin.carsale.transport.model.vehicles.ReadBrandRequest
import ru.otus.otuskotlin.carsale.transport.model.vehicles.ReadBrandResponse
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

const val REQUEST_ID = "req-123"
const val BRAND_ID = "1"
const val BRAND_NAME = "Honda"

internal class BrandControllerTest : AbstractControllerTest() {

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
            requestId = REQUEST_ID
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
}