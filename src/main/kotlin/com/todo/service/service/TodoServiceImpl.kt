package com.todo.service.service

import com.todo.service.domain.Status
import com.todo.service.domain.Todo
import lombok.extern.slf4j.Slf4j
import org.springframework.stereotype.Service
import java.time.Instant

@Slf4j
@Service
class TodoServiceImpl : TodoService {
    override fun retrieveTodoList(): List<Todo> {
        return listOf(Todo(1, "title", "Content", Status.NEW, Instant.now(), Instant.now()))
    }
}