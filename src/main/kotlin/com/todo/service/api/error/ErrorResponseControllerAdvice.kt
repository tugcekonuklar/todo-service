package com.todo.service.api.error

import com.fasterxml.jackson.core.JsonParseException
import com.todo.service.domain.error.ErrorCode
import com.todo.service.domain.error.ErrorResultException
import org.hibernate.exception.ConstraintViolationException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ErrorResponseControllerAdvice {

    @ExceptionHandler(ConstraintViolationException::class)
    fun handleConstraintViolationException(ex: ConstraintViolationException): ResponseEntity<ErrorResponse?>? =
            ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(ErrorResponse(message = ex.message,
                            type = ErrorCode.INVALID_REQUEST.name,
                            status = ErrorCode.INVALID_REQUEST.status.value(),
                            code = HttpStatus.BAD_REQUEST.name
                    ))

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleMethodArgumentNotValidException(ex: MethodArgumentNotValidException): ResponseEntity<ErrorResponse?>? =
            ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(ErrorResponse(message = ex.message,
                            type = ErrorCode.INVALID_REQUEST.name,
                            status = ErrorCode.INVALID_REQUEST.status.value(),
                            code = HttpStatus.BAD_REQUEST.name
                    ))

    @ExceptionHandler(ErrorResultException::class)
    fun handleErrorResultException(ex: ErrorResultException): ResponseEntity<ErrorResponse?>? =
            ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(ErrorResponse(message = ex.message,
                            type = ex.type,
                            status = ex.status,
                            code = ex.code
                    ))

    @ExceptionHandler(JsonParseException::class)
    fun handleErrorResultException(ex: JsonParseException): ResponseEntity<ErrorResponse?>? =
            ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(ErrorResponse(message = ex.message,
                            type = ErrorCode.INVALID_REQUEST.name,
                            status = ErrorCode.INVALID_REQUEST.status.value(),
                            code = HttpStatus.BAD_REQUEST.name
                    ))

}