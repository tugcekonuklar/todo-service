package com.todo.service.api.dto

import com.todo.service.domain.Status
import java.time.Instant

data class TodoRequest(override val title: String, override val content: String?, override val dueDate: Instant?) : BaseRequest