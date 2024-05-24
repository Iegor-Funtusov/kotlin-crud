package ua.com.alevel.dao

import ua.com.alevel.entity.BaseEntity
import java.util.*

interface CrudDao<E: BaseEntity> {
    fun create(entity: E)
    fun update(entity: E)
    fun delete(id: String)
    fun findById(id: String): Optional<E>
    fun findAll(): Collection<E>
}