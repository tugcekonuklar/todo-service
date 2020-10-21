package com.todo.service.service

import java.time.Instant

data class CreateCommand(override val title: String,
                         override val content: String?,
                         override val dueDate: Instant?) : TodoServiceCommand