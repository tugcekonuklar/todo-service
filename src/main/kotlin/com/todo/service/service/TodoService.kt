package com.todo.service.service

import com.todo.service.domain.Todo

interface TodoService {
    fun retrieveTodoList(): List<Todo>
}