package ru.stream.recycleradapters.core.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class ItemViewHolder<T>(view: View) : RecyclerView.ViewHolder(view) {
	var item: T? = null
		private set

	fun bindItem(item: T) {
		this.item = item
		onBindItem(item)
	}

	open fun onBindItem(item: T) {}
}