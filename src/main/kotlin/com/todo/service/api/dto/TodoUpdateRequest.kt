package com.todo.service.api.dto

import java.time.Instant

data class TodoUpdateRequest(val id: Long,
                             override val title: String?,
                             override val content: String?,
                             override val dueDate: Instant?) : BaseRequest