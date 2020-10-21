package com.todo.service.service

import com.todo.service.domain.Status
import java.time.Instant

interface TodoServiceCommand {
    val title: String?
    val content: String?
    val dueDate: Instant?
}