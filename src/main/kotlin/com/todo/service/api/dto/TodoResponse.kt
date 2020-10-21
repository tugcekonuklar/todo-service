package com.todo.service.api.dto

import com.todo.service.domain.Status
import java.time.Instant

data class TodoResponse(val id: Long?,
                        val title: String?,
                        val content: String?,
                        val status: Status,
                        val dueDate: Instant?,
                        val createdAt: Instant?,
                        val updatedAt: Instant?)