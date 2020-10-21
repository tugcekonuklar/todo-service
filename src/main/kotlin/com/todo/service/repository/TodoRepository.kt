package com.todo.service.repository

import com.todo.service.domain.Todo
import java.util.*

interface TodoRepository {
    fun findAll(): List<Todo>
    fun findById(id: Long): Todo?
    fun save(command: InsertCommand): Todo
    fun update(command: UpdateCommand): Todo
    fun delete(id: Long)
}