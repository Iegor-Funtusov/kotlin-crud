package ua.com.alevel.controller

import ua.com.alevel.entity.Student
import ua.com.alevel.service.StudentService
import ua.com.alevel.service.impl.StudentServiceImpl

class StudentController {

    private val studentService: StudentService = StudentServiceImpl()

    fun start() {
        println("Welcome to app")
        menu()
        var command = ""
        while (command != "exit") {
            command = readlnOrNull().toString()
            goToOperations(command)
            menu()
        }
    }

    private fun menu()  {
        println("If you want create student please enter 1")
        println("If you want find all student please enter 2")
        println("If you want find by id student please enter 3")
        println("If you want update student please enter 4")
        println("If you want delete student please enter 5")
        println("If you want exit please enter exit")
    }

    private fun goToOperations(command: String)  {
        when (command) {
            "1" -> create()
            "2" -> findAll()
            "3" -> findById()
            "4" -> update()
            "5" -> delete()
        }
    }

    private fun create() {
        println("Please enter first name")
        val fName: String = readlnOrNull().toString()
        println("Please enter last name")
        val lName: String = readlnOrNull().toString()
        println("Please enter age")
        val age: Int =Integer.parseInt(readlnOrNull().toString())

        val student = Student("", fName, lName, age)

        studentService.create(student)
    }

    private fun findAll() {
        studentService.findAll().forEach { println(it) }
    }

    private fun update() {
        println("Please enter id")
        val id: String = readlnOrNull().toString()
        println("Please enter first name")
        val fName: String = readlnOrNull().toString()
        println("Please enter last name")
        val lName: String = readlnOrNull().toString()
        println("Please enter age")
        val age: Int =Integer.parseInt(readlnOrNull().toString())

        val student = Student(id, fName, lName, age)

        studentService.update(student)
    }

    private fun findById() {
        println("Please enter id")
        val id: String = readlnOrNull().toString()
        println(studentService.findById(id))
    }

    private fun delete() {
        println("Please enter id")
        val id: String = readlnOrNull().toString()
        studentService.delete(id)
    }
}