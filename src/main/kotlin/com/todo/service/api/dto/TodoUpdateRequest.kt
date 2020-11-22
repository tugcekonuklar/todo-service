package com.todo.service.api.dto

import java.time.Instant

data class TodoUpdateRequest(override val title: String?,
                             override val content: String?,
                             override val dueDate: Instant?) : BaseRequest