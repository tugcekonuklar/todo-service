package com.todo.service.domain.error

class ErrorResultException(override val message: String?,
                           val type: String,
                           val status: Int,
                           val code: String) : RuntimeException(message)