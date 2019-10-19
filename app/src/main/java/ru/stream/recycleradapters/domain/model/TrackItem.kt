package ru.stream.recycleradapters.domain.model

import org.threeten.bp.LocalDateTime

sealed class TrackItem {

	data class IntroLesson(
		val id: String,
		val date: LocalDateTime,
		val title: String,
		val teacherName: String
	) : TrackItem()

	data class RegularLesson(
		val id: String,
		val date: LocalDateTime,
		val title: String,
		val teacherName: String
	) : TrackItem()

	data class Exam(
		val id: String,
		val title: String
	) : TrackItem()
}