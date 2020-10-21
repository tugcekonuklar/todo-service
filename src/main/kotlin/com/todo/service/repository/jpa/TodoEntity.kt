package com.todo.service.repository.jpa

import com.todo.service.domain.Status
import java.time.Instant
import javax.persistence.*

@Entity
@Table(name = "todos")
data class TodoEntity(@Id
                      @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long?,
                      @Column val title: String?,
                      @Column val content: String?,
                      @Column(nullable = false) @Enumerated(EnumType.STRING) val status: Status,
                      @Column val dueDate: Instant?,
                      @Column val createdAt: Instant,
                      @Column val updatedAt: Instant)