package com.group.libraryapp.domain.user.loanhistory

import com.group.libraryapp.domain.user.User
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne

@Entity
class UserLoanHistory(
    @ManyToOne
    val user: User,
    val bookName: String,
    @Enumerated(value = EnumType.STRING)
    var status: UserStatus = UserStatus.LOANED,
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
) {
    fun doReturn() {
        this.status = UserStatus.RETURNED
    }

    companion object {
        fun fixture(
            borrower: User,
            bookName: String,
            status: UserStatus,
        ): UserLoanHistory = UserLoanHistory(borrower, bookName, status, null)
    }
}
