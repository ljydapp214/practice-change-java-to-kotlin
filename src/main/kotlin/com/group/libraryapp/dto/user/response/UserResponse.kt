package com.group.libraryapp.dto.user.response

import com.group.libraryapp.domain.user.User

/**
 * init 을 쓰는 것보단 부 생성자를 사용하는 것이 더 좋음
 * 부 생성자를 사용하는 것보단, 정적 팩토리 메서드를 만드는 것을 추천
 */
data class UserResponse(
    val id: Long,
    val name: String,
    val age: Int?,
) {
    companion object {
        fun of(user: User): UserResponse =
            UserResponse(
                id = user.id!!,
                name = user.name,
                age = user.age,
            )
    }
}
