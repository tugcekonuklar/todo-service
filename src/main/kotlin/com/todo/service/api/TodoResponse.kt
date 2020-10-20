package com.todo.service.api

import com.todo.service.domain.Status
import java.time.Instant

data class TodoResponse(val id: Long,
                        val title: String,
                        val content: String,
                        val status: Status,
                        val duaDate: Instant,
                        val createdAt: Instant)