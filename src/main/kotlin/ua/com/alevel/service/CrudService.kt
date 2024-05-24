package ua.com.alevel.service

import ua.com.alevel.entity.BaseEntity

interface CrudService<E: BaseEntity> {
    fun create(entity: E)
    fun update(entity: E)
    fun delete(id: String)
    fun findById(id: String): E
    fun findAll(): Collection<E>
}
