package com.todo.service.api.dto

import java.time.Instant

interface BaseRequest {
    val title: String?
    val content: String?
    val dueDate: Instant?
}