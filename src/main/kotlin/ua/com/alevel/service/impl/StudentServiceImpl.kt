package ua.com.alevel.service.impl

import ua.com.alevel.dao.StudentDao
import ua.com.alevel.dao.impl.StudentDaoImpl
import ua.com.alevel.entity.Student
import ua.com.alevel.service.StudentService

class StudentServiceImpl: StudentService {

    private val studentDao: StudentDao = StudentDaoImpl()

    override fun create(entity: Student) {
        studentDao.create(entity)
    }

    override fun update(entity: Student) {
        studentDao.update(entity)
    }

    override fun delete(id: String) {
        studentDao.delete(id)
    }

    override fun findById(id: String): Student {
        return studentDao.findById(id).orElseThrow()
    }

    override fun findAll(): Collection<Student> {
        return studentDao.findAll()
    }
}