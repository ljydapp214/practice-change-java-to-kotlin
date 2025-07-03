package com.group.libraryapp.util

import com.group.libraryapp.domain.book.BookRepository
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.findByIdOrNull

fun fail(): Nothing = throw IllegalArgumentException()

fun <T, ID> CrudRepository<T, ID>.findByIdOrThrow(id: ID): T = this.findByIdOrNull(id) ?: throw IllegalArgumentException()

fun BookRepository.findByNameOrThrow(name: String) = this.findByName(name) ?: throw IllegalArgumentException()
