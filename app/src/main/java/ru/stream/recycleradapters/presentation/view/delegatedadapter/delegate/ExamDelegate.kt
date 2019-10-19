package ru.stream.recycleradapters.presentation.view.delegatedadapter.delegate

import android.view.View
import kotlinx.android.synthetic.main.view_track_exam.view.*
import ru.stream.recycleradapters.R
import ru.stream.recycleradapters.core.adapter.ItemViewHolder
import ru.stream.recycleradapters.core.adapter.delegate.BaseAdapterDelegate
import ru.stream.recycleradapters.core.adapter.item.Item
import ru.stream.recycleradapters.domain.model.TrackItem

class ExamDelegate :
	BaseAdapterDelegate<TrackItem.Exam, ExamDelegate.ExamHolder>() {

	override fun isForViewType(item: Item): Boolean = item is TrackItem.Exam

	override val layoutId: Int = R.layout.view_track_exam

	override fun createViewHolder(view: View): ExamHolder = ExamHolder(view)

	class ExamHolder(view: View) : ItemViewHolder<TrackItem.Exam>(view) {

		override fun onBindItem(item: TrackItem.Exam) {
			itemView.textTitle.text = item.title
		}
	}
}