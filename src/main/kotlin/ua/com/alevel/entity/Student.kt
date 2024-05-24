package ua.com.alevel.entity

data class Student(
    override val id: String,
    val firstName: String,
    val lastName: String,
    val age: Int) : BaseEntity
