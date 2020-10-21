package com.todo.service.repository

import com.todo.service.domain.Todo
import com.todo.service.repository.jpa.TodoEntity
import com.todo.service.repository.jpa.TodoJpaRepository
import lombok.extern.slf4j.Slf4j
import org.springframework.stereotype.Repository

@Slf4j
@Repository
class TodoRepositoryImpl(val todoJpaRepository: TodoJpaRepository) : TodoRepository {
    override fun findAll(): List<Todo> = todoJpaRepository.findAll().map { Todo(it.id, it.title, it.content, it.status, it.dueDate, it.createdAt, it.updatedAt) }

    override fun findById(id: Long): Todo? = todoJpaRepository.findById(id).map { toTodo(it) }.orElse(null)

    override fun save(command: InsertCommand): Todo = saveCommand(command)

    override fun update(command: UpdateCommand): Todo = updateCommand(command)

    override fun delete(id: Long) = todoJpaRepository.deleteById(id)

    fun saveCommand(command: InsertCommand): Todo = toTodo(todoJpaRepository.save(toInsertEntity(command)))

    fun updateCommand(command: UpdateCommand): Todo = toTodo(todoJpaRepository.save(toUpdateEntity(command)))

    fun toInsertEntity(command: InsertCommand) = TodoEntity(title = command.title, content = command.content, status = command.status, dueDate = command.dueDate, createdAt = command.createdAt, updatedAt = command.updatedAt, id = null);

    fun toUpdateEntity(command: UpdateCommand) = TodoEntity(id = command.id, title = command.title, content = command.content, status = command.status, dueDate = command.dueDate, updatedAt = command.updatedAt, createdAt = command.createdAt);

    fun toTodo(entity: TodoEntity) = Todo(entity.id, entity.title, entity.content, entity.status, entity.dueDate, entity.createdAt, entity.updatedAt)
}