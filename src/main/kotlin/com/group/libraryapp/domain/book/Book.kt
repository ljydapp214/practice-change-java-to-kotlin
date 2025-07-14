package com.group.libraryapp.domain.book

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
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
    @Enumerated(value = EnumType.STRING)
    @Column(name = "type", nullable = false)
    val type: BookType,
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
) {
    @Column(nullable = false)
    val createdAt: LocalDateTime = LocalDateTime.now()

    init {
        require(!name.isBlank()) { "이름은 비어있을 수 없습니다." }
    }

    constructor(name: String) : this(name, BookType.COMPUTER, null)

    constructor(name: String, type: String) : this(name, BookType.COMPUTER, null)

    companion object {
        fun fixture(bookName: String = "책 이름"): Book = Book(bookName)

        fun fixture(
            bookName: String = "책 이름",
            type: BookType = BookType.COMPUTER,
            id: Long?,
        ): Book = Book(bookName, type, id)
    }
}
