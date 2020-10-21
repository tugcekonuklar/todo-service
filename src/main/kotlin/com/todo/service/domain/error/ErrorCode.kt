package com.todo.service.domain.error

import org.springframework.http.HttpStatus
import java.text.MessageFormat

enum class ErrorCode(val status: HttpStatus,
                     val message: String) {
    INVALID_REQUEST(HttpStatus.BAD_REQUEST, "Invalid client request : {0}"),
    INTERNAL_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "Invalid server error"),
    TODO_NOT_FOUND(HttpStatus.NOT_FOUND, "Todo message not found with id : {0}");

    fun asErrorResult(vararg params: Any?): ErrorResultException =
            ErrorResultException(message = MessageFormat.format(message, *params),
                    code = name,
                    type = status.name,
                    status = status.value())
}