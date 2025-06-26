package com.group.libraryapp.domain.user.loanhistory

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne

@Entity
class UserLoanHistory(
    @ManyToOne
    val user: User,
    val bookName: String,
    var isReturn: Boolean,
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
) {
    fun doReturn() {
        this.isReturn = true
    }

    companion object {
        fun fixture(
            borrower: User,
            bookName: String,
        ): UserLoanHistory = UserLoanHistory(borrower, bookName, false, null)
    }
}
