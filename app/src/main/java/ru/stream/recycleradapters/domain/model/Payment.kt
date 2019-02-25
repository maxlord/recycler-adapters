package ru.stream.recycleradapters.domain.model

data class Payment(
	val id: Int,
	val name: String,
	val lessonCount: Int,
	val discount: Float
)