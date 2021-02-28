package ru.otus.otuskotlin.carsale.transport.model.common

interface CreatableDataDto

interface UpdatableDataDto : CreatableDataDto {
    val id: String?
}

interface DataDto : UpdatableDataDto

