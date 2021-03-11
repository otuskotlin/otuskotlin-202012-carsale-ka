package ru.otus.otuskotlin.carsale.transport.serializer

import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.polymorphic
import kotlinx.serialization.modules.subclass
import ru.otus.otuskotlin.carsale.transport.model.ad.*
import ru.otus.otuskotlin.carsale.transport.model.common.Message
import ru.otus.otuskotlin.carsale.transport.model.vehicles.*

val modelSerializersModule = SerializersModule {
    polymorphic(Message::class) {
        subclass(CreateBrandRequest::class)
        subclass(CreateBrandResponse::class)
        subclass(ReadBrandRequest::class)
        subclass(ReadBrandResponse::class)
        subclass(UpdateBrandRequest::class)
        subclass(UpdateBrandResponse::class)
        subclass(DeleteBrandRequest::class)
        subclass(DeleteBrandResponse::class)
        subclass(ListBrandRequest::class)
        subclass(ListBrandResponse::class)

        subclass(CreateModelRequest::class)
        subclass(CreateModelResponse::class)
        subclass(ReadModelRequest::class)
        subclass(ReadModelResponse::class)
        subclass(UpdateModelRequest::class)
        subclass(UpdateModelResponse::class)
        subclass(DeleteModelRequest::class)
        subclass(DeleteModelResponse::class)
        subclass(ListModelRequest::class)
        subclass(ListModelResponse::class)

        subclass(CreateContactRequest::class)
        subclass(CreateContactResponse::class)
        subclass(ReadContactRequest::class)
        subclass(ReadContactResponse::class)
        subclass(UpdateContactRequest::class)
        subclass(UpdateContactResponse::class)
        subclass(DeleteContactRequest::class)
        subclass(DeleteContactResponse::class)
        subclass(ListContactRequest::class)
        subclass(ListContactResponse::class)

        subclass(CreateSaleAdRequest::class)
        subclass(CreateSaleAdResponse::class)
        subclass(ReadSaleAdRequest::class)
        subclass(ReadSaleAdResponse::class)
        subclass(UpdateSaleAdRequest::class)
        subclass(UpdateSaleAdResponse::class)
        subclass(DeleteSaleAdRequest::class)
        subclass(DeleteSaleAdResponse::class)
        subclass(ListSaleAdRequest::class)
        subclass(ListSaleAdResponse::class)
    }
}
