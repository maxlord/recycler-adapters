package ru.stream.recycleradapters.domain.model

import org.threeten.bp.LocalDateTime
import ru.stream.recycleradapters.core.adapter.item.Item

sealed class TrackItem : Item {

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

	object Separator : TrackItem()
}