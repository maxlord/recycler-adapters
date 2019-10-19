package ru.stream.recycleradapters.presentation.view.delegatedadapter.delegate

import android.view.View
import kotlinx.android.synthetic.main.view_track_regular_lesson.view.*
import org.threeten.bp.format.DateTimeFormatter
import ru.stream.recycleradapters.R
import ru.stream.recycleradapters.core.adapter.ItemViewHolder
import ru.stream.recycleradapters.core.adapter.delegate.BaseAdapterDelegate
import ru.stream.recycleradapters.core.adapter.item.Item
import ru.stream.recycleradapters.domain.model.TrackItem

class RegularLessonDelegate(private val dateFormatter: DateTimeFormatter) :
	BaseAdapterDelegate<TrackItem.RegularLesson, RegularLessonDelegate.RegularLessonHolder>() {

	override fun isForViewType(item: Item): Boolean = item is TrackItem.RegularLesson

	override val layoutId: Int = R.layout.view_track_regular_lesson

	override fun createViewHolder(view: View): RegularLessonHolder = RegularLessonHolder(view)

	inner class RegularLessonHolder(view: View) : ItemViewHolder<TrackItem.RegularLesson>(view) {

		override fun onBindItem(item: TrackItem.RegularLesson) {
			itemView.textTitle.text = item.title
			itemView.textTeacher.text = item.teacherName
			itemView.textDate.text = dateFormatter.format(item.date)
		}
	}
}