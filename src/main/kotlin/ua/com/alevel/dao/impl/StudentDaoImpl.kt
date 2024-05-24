package ua.com.alevel.dao.impl

import ua.com.alevel.dao.StudentDao
import ua.com.alevel.entity.Student
import java.util.*
import kotlin.collections.List

class StudentDaoImpl: StudentDao {
    private var students: List<Student> = mutableListOf()

    override fun create(entity: Student) {
        students = students.plus(
            Student(generateId(), entity.firstName, entity.lastName, entity.age)
        )
    }

    override fun update(entity: Student) {
        students = students.map { student -> if (student.id == entity.id) entity else student }
    }

    override fun delete(id: String) {
        students = students.filter { student -> student.id == id }
    }

    override fun findById(id: String): Optional<Student> {
        return Optional.ofNullable(students.find { student -> student.id == id })
    }

    override fun findAll(): Collection<Student> {
        return students
    }

    private fun generateId(): String {
        val id: String = UUID.randomUUID().toString()
        return if (students.any { it.id == id }) return generateId() else id
    }
}