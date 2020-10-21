package com.todo.service.service

import lombok.Getter
import java.time.Instant

@Getter
data class UpdateTodoCommand(val id: Long,
                             override val title: String?,
                             override val content: String?,
                             override val dueDate: Instant?) : TodoServiceCommand