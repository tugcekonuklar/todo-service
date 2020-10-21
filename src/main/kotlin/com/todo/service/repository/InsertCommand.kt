package com.todo.service.repository

import com.todo.service.domain.Status
import java.time.Instant

data class InsertCommand(override val title: String?,
                         override val content: String?,
                         override val status: Status,
                         override val dueDate: Instant?,
                         override val createdAt: Instant,
                         override val updatedAt: Instant) : TodoCommand