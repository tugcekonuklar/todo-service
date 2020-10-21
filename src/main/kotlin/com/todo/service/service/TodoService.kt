package com.todo.service.service

import com.todo.service.domain.Todo
import com.todo.service.repository.InsertCommand
import com.todo.service.repository.UpdateCommand
import java.util.*

interface TodoService {
    fun retrieveTodoList(): List<Todo>
    fun retrieveById(id: Long): Todo
    fun create(command: CreateCommand): Todo
    fun update(command: UpdateTodoCommand): Todo
    fun delete(id: Long)
}