package ru.stream.recycleradapters.presentation.view.delegatedadapter.delegate

import android.view.View
import kotlinx.android.synthetic.main.view_track_intro_lesson.view.*
import org.threeten.bp.format.DateTimeFormatter
import ru.stream.recycleradapters.R
import ru.stream.recycleradapters.core.adapter.ItemViewHolder
import ru.stream.recycleradapters.core.adapter.delegate.BaseAdapterDelegate
import ru.stream.recycleradapters.core.adapter.item.Item
import ru.stream.recycleradapters.domain.model.TrackItem

class IntroLessonDelegate(private val dateFormatter: DateTimeFormatter) :
	BaseAdapterDelegate<TrackItem.IntroLesson, IntroLessonDelegate.IntroLessonHolder>() {

	override fun isForViewType(item: Item): Boolean = item is TrackItem.IntroLesson

	override val layoutId: Int = R.layout.view_track_intro_lesson

	override fun createViewHolder(view: View): IntroLessonHolder = IntroLessonHolder(view)

	inner class IntroLessonHolder(view: View) : ItemViewHolder<TrackItem.IntroLesson>(view) {

		override fun onBindItem(item: TrackItem.IntroLesson) {
			itemView.textTitle.text = item.title
			itemView.textTeacher.text = item.teacherName
			itemView.textDate.text = dateFormatter.format(item.date)
		}
	}
}