package com.todo.service.repository

import com.todo.service.domain.Status
import java.time.Instant

data class UpdateCommand(val id: Long,
                         override val title: String?,
                         override val content: String?,
                         override val status: Status,
                         override val dueDate: Instant?,
                         override val updatedAt: Instant,
                         override val createdAt: Instant) : TodoCommand