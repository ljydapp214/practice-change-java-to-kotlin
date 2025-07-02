package com.group.libraryapp.domain.book

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.time.LocalDateTime

@Entity
@Table(name = "book")
class Book(
    @Column(name = "name", nullable = false)
    var name: String,
    @Column(name = "type", nullable = false)
    val type: String = "novel",
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
) {
    @Column(nullable = false)
    val createdAt: LocalDateTime = LocalDateTime.now()

    init {
        require(!name.isBlank()) { "이름은 비어있을 수 없습니다." }
    }

    constructor(name: String) : this(name, "novel", null)

    constructor(name: String, type: String) : this(name, type, null)

    companion object {
        fun fixture(bookName: String): Book = Book(bookName)
    }
}
