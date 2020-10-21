package com.todo.service.repository.jpa

import org.springframework.data.jpa.repository.JpaRepository

interface TodoJpaRepository : JpaRepository<TodoEntity,Long> {
}