package com.todo.service.service

import com.todo.service.domain.Status
import com.todo.service.domain.Todo
import com.todo.service.domain.error.ErrorCode
import com.todo.service.repository.InsertCommand
import com.todo.service.repository.TodoRepository
import com.todo.service.repository.UpdateCommand
import lombok.extern.slf4j.Slf4j
import org.springframework.stereotype.Service
import java.time.Instant

@Slf4j
@Service
class TodoServiceImpl(val todoRepository: TodoRepository) : TodoService {
    override fun retrieveTodoList(): List<Todo> = todoRepository.findAll()

    override fun retrieveById(id: Long): Todo = todoRepository.findById(id)
            ?: throw  ErrorCode.TODO_NOT_FOUND.asErrorResult(id)

    override fun create(command: CreateCommand): Todo =
            todoRepository.save(InsertCommand(command.title, command.content, Status.NEW, command.dueDate, Instant.now(), Instant.now()))

    override fun update(command: UpdateTodoCommand): Todo {
        val todo = retrieveById(command.id);
        return todoRepository.update(UpdateCommand(command.id, command.title, command.content, Status.UPDATED, command.dueDate, Instant.now(), todo.createdAt))
    }

    override fun complete(id: Long): Todo {
        val todo = retrieveById(id);
        return todoRepository.update(UpdateCommand(todo.id!!, todo.title, todo.content, Status.COMPLETED, todo.dueDate, Instant.now(), todo.createdAt))
    }

    override fun delete(id: Long) {
        retrieveById(id);
        return todoRepository.delete(id)
    }

}