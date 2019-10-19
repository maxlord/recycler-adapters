package ru.stream.recycleradapters.presentation.view.regularadapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.threeten.bp.format.DateTimeFormatter
import ru.stream.recycleradapters.R
import ru.stream.recycleradapters.core.adapter.item.Item
import ru.stream.recycleradapters.domain.model.TrackItem

class RegularAdapter(private val dateFormatter: DateTimeFormatter) :
	RecyclerView.Adapter<RegularAdapter.RegularAdapterViewHolder>() {

	private var items = emptyList<Item>()

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RegularAdapterViewHolder {
		return when (viewType) {
			VIEW_TYPE_SEPARATOR -> RegularAdapterViewHolder(
				LayoutInflater.from(parent.context).inflate(
					R.layout.view_track_separator,
					parent,
					false
				)
			)

			VIEW_TYPE_INTRO_LESSON -> RegularAdapterViewHolder(
				LayoutInflater.from(parent.context).inflate(
					R.layout.view_track_intro_lesson,
					parent,
					false
				)
			)

			VIEW_TYPE_REGULAR_LESSON -> RegularAdapterViewHolder(
				LayoutInflater.from(parent.context).inflate(
					R.layout.view_track_regular_lesson,
					parent,
					false
				)
			)

			VIEW_TYPE_EXAM -> RegularAdapterViewHolder(
				LayoutInflater.from(parent.context).inflate(
					R.layout.view_track_exam,
					parent,
					false
				)
			)
			else -> throw IllegalStateException("View holder with view type '$viewType' not supported")
		}
	}

	override fun getItemCount(): Int {
		return items.size
	}

	override fun onBindViewHolder(holder: RegularAdapterViewHolder, position: Int) {
		when (val item = items[position]) {
			is TrackItem.IntroLesson -> {
				holder.itemView.findViewById<TextView>(R.id.textTitle).text = item.title
				holder.itemView.findViewById<TextView>(R.id.textDate).text =
					dateFormatter.format(item.date)
				holder.itemView.findViewById<TextView>(R.id.textTeacher).text = item.teacherName
			}

			is TrackItem.RegularLesson -> {
				holder.itemView.findViewById<TextView>(R.id.textTitle).text = item.title
				holder.itemView.findViewById<TextView>(R.id.textDate).text =
					dateFormatter.format(item.date)
				holder.itemView.findViewById<TextView>(R.id.textTeacher).text = item.teacherName
			}

			is TrackItem.Exam -> {
				holder.itemView.findViewById<TextView>(R.id.textTitle).text = item.title
			}
		}
	}

	override fun getItemViewType(position: Int): Int {
		return when (val item = items[position]) {
			is TrackItem.Separator -> VIEW_TYPE_SEPARATOR
			is TrackItem.IntroLesson -> VIEW_TYPE_INTRO_LESSON
			is TrackItem.RegularLesson -> VIEW_TYPE_REGULAR_LESSON
			is TrackItem.Exam -> VIEW_TYPE_EXAM
			else -> throw IllegalStateException("Item with type '${item.javaClass.simpleName}' not supported")
		}
	}

	fun setItems(items: List<Item>) {
		this.items = items
	}

	class RegularAdapterViewHolder(view: View) : RecyclerView.ViewHolder(view)

	companion object {
		private const val VIEW_TYPE_SEPARATOR = 0
		private const val VIEW_TYPE_INTRO_LESSON = 1
		private const val VIEW_TYPE_REGULAR_LESSON = 2
		private const val VIEW_TYPE_EXAM = 3
	}
}