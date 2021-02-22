package ru.otus.otuskotlin.carsale.transport.model.vehicles

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import kotlinx.serialization.modules.PolymorphicModuleBuilder
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.polymorphic
import kotlinx.serialization.modules.subclass
import ru.otus.otuskotlin.carsale.transport.model.common.*
import ru.otus.otuskotlin.carsale.transport.serializer.InstantSerializer

private interface Brand {
    val name: String?
}

@Serializable
data class CreatableBrandDto(
    override val name: String? = null,
): Brand, CreatableDataDto

@Serializable
data class UpdatableBrandDto(
    override val id: String? = null,
    override val name: String? = null,
): Brand, UpdatableDataDto

@Serializable
data class BrandDto(
    override val id: String? = null,
    override val name: String? = null,
): Brand, DataDto


// Create

@Serializable
data class CreateBrandRequest(
    override val requestId: String? = null,
    override val onResponse: String? = null,
    @Serializable(with = InstantSerializer::class) override val startTime: Instant? = null,
    override val debug: Debug? = null,
    val data: CreatableBrandDto? = null,
) : Request

@Serializable
data class CreateBrandResponse(
    override val responseId: String? = null,
    override val onRequest: String? = null,
    @Serializable(with = InstantSerializer::class) override val endTime: Instant? = null,
    override val errors: List<ErrorDto>? = null,
    override val status: ResponseStatusDto? = null,
    override val debug: Debug? = null,
    val data: BrandDto? = null,
) : Response


// Read

@Serializable
data class ReadBrandRequest(
    override val requestId: String? = null,
    override val onResponse: String? = null,
    @Serializable(with = InstantSerializer::class) override val startTime: Instant? = null,
    override val debug: Debug? = null,
    val id: String? = null,
) : Request

@Serializable
data class ReadBrandResponse(
    override val responseId: String? = null,
    override val onRequest: String? = null,
    @Serializable(with = InstantSerializer::class) override val endTime: Instant? = null,
    override val errors: List<ErrorDto>? = null,
    override val status: ResponseStatusDto? = null,
    override val debug: Debug? = null,
    val data: BrandDto? = null,
) : Response


// Update

@Serializable
data class UpdateBrandRequest(
    override val requestId: String? = null,
    override val onResponse: String? = null,
    @Serializable(with = InstantSerializer::class) override val startTime: Instant? = null,
    override val debug: Debug? = null,
    val data: UpdatableBrandDto? = null,
) : Request

@Serializable
data class UpdateBrandResponse(
    override val responseId: String? = null,
    override val onRequest: String? = null,
    @Serializable(with = InstantSerializer::class) override val endTime: Instant? = null,
    override val errors: List<ErrorDto>? = null,
    override val status: ResponseStatusDto? = null,
    override val debug: Debug? = null,
    val data: BrandDto? = null,
) : Response


// Delete

@Serializable
data class DeleteBrandRequest(
    override val requestId: String? = null,
    override val onResponse: String? = null,
    @Serializable(with = InstantSerializer::class) override val startTime: Instant? = null,
    override val debug: Debug? = null,
    val id: String? = null,
) : Request

@Serializable
data class DeleteBrandResponse(
    override val responseId: String? = null,
    override val onRequest: String? = null,
    @Serializable(with = InstantSerializer::class) override val endTime: Instant? = null,
    override val errors: List<ErrorDto>? = null,
    override val status: ResponseStatusDto? = null,
    override val debug: Debug? = null,
    val data: BrandDto? = null,
    val deleted: Boolean? = null,
) : Response


val brandSerializersModule = SerializersModule {
    polymorphic(Brand::class) {
        subclass(CreatableBrandDto::class)
        subclass(UpdatableBrandDto::class)
        subclass(BrandDto::class)
    }

    fun PolymorphicModuleBuilder<Request>.registerRequestSubclasses() {
        subclass(CreateBrandRequest::class)
        subclass(ReadBrandRequest::class)
        subclass(UpdateBrandRequest::class)
        subclass(DeleteBrandRequest::class)
    }

    fun PolymorphicModuleBuilder<Response>.registerResponseSubclasses() {
        subclass(CreateBrandResponse::class)
        subclass(ReadBrandResponse::class)
        subclass(UpdateBrandResponse::class)
        subclass(DeleteBrandResponse::class)
    }

    polymorphic(Message::class) {
        registerRequestSubclasses()
        registerResponseSubclasses()
    }
    polymorphic(Request::class) { registerRequestSubclasses() }
    polymorphic(Response::class) { registerResponseSubclasses() }
}