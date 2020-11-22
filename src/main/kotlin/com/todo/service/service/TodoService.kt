package com.todo.service.service

import com.todo.service.domain.Status
import com.todo.service.domain.Todo

interface TodoService {
    fun retrieveTodoList(): List<Todo>
    fun retrieveById(id: Long): Todo
    fun create(command: CreateCommand): Todo
    fun update(command: UpdateTodoCommand): Todo
    fun updateStatus(id: Long, status: Status): Todo
    fun delete(id: Long)
}