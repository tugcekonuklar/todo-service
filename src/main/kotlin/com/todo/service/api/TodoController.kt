package com.todo.service.api

import com.todo.service.api.dto.TodoRequest
import com.todo.service.api.dto.TodoResponse
import com.todo.service.api.dto.TodoUpdateRequest
import com.todo.service.domain.Status
import com.todo.service.domain.Todo
import com.todo.service.service.CreateCommand
import com.todo.service.service.TodoService
import com.todo.service.service.UpdateTodoCommand
import lombok.extern.slf4j.Slf4j
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*


@CrossOrigin(origins = ["*"], allowedHeaders = ["*"], methods = [RequestMethod.GET, RequestMethod.DELETE, RequestMethod.PATCH, RequestMethod.HEAD, RequestMethod.POST, RequestMethod.PUT, RequestMethod.OPTIONS])
@Slf4j
@RestController
@RequestMapping(value = ["api/todos"])
class TodoController(val todoService: TodoService) {

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun retrieveTodoList(): List<TodoResponse> {
        return todoService.retrieveTodoList()
                .map { toResponse(it) }
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun retrieveTodoById(@PathVariable id: Long): TodoResponse = toResponse(todoService.retrieveById(id));

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody request: TodoRequest): TodoResponse = toResponse(todoService.create(toCreateCommand(request)));

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun update(@RequestBody request: TodoUpdateRequest, @PathVariable id: Long): TodoResponse = toResponse(todoService.update(toUpdateCommand(request, id)));

    @PatchMapping("/{id}/complete")
    @ResponseStatus(HttpStatus.OK)
    fun complete(@PathVariable id: Long): TodoResponse = toResponse(todoService.updateStatus(id, Status.COMPLETED));

    @PatchMapping("/{id}/activate")
    @ResponseStatus(HttpStatus.OK)
    fun activated(@PathVariable id: Long): TodoResponse = toResponse(todoService.updateStatus(id, Status.ACTIVATED));

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: Long) = todoService.delete(id);

    fun toResponse(todo: Todo): TodoResponse =
            TodoResponse(todo.id, todo.title, todo.content, todo.status, todo.dueDate, todo.createdAt, todo.updatedAt)

    fun toCreateCommand(request: TodoRequest): CreateCommand =
            CreateCommand(request.title, request.content, request.dueDate)

    fun toUpdateCommand(request: TodoUpdateRequest, id: Long): UpdateTodoCommand =
            UpdateTodoCommand(id, request.title, request.content, request.dueDate)
}