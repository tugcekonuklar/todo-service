package com.todo.service.repository

import com.todo.service.domain.Status
import java.time.Instant

interface TodoCommand {
    val title: String?
    val content: String?
    val status: Status
    val dueDate: Instant?
    val createdAt: Instant
    val updatedAt: Instant
}