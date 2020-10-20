package com.todo.service.api

import com.todo.service.service.TodoService
import lombok.extern.slf4j.Slf4j
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@Slf4j
@RestController
@RequestMapping(value = ["api/todos"])
class TodoController(val todoService: TodoService) {

    @GetMapping
    fun retrieveTodoList(): List<TodoResponse> {
        return todoService.retrieveTodoList()
                .map { TodoResponse(it.id, it.title, it.content, it.status, it.duaDate, it.createdAt) }
    }

}