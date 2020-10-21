package com.todo.service.domain

import java.time.Instant

data class Todo(val id: Long?,
                val title: String?,
                val content: String?,
                val status: Status,
                val dueDate: Instant?,
                val createdAt: Instant,
                val updatedAt: Instant)