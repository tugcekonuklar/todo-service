package com.todo.service.api.error

data class ErrorResponse(val message: String?,
                         val type: String,
                         val status: Int,
                         val code: String)