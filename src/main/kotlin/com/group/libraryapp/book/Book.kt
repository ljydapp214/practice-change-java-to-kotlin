package com.group.libraryapp.book

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
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private val id: Long? = null,
    @Column(name = "name", nullable = false)
    var name: String,
    @Column(name = "type", nullable = false)
    private val type: String = "novel",
) {
    @Column(nullable = false)
    val createdAt: LocalDateTime = LocalDateTime.now()

    init {
        require(!name.isBlank()) { "이름은 비어있을 수 없습니다." }
    }

    constructor(name: String) : this(null, name, "novel")
}
