package ru.stream.recycleradapters.presentation.view.delegatedadapter.delegate

import android.view.View
import ru.stream.recycleradapters.R
import ru.stream.recycleradapters.core.adapter.ItemViewHolder
import ru.stream.recycleradapters.core.adapter.delegate.BaseAdapterDelegate
import ru.stream.recycleradapters.core.adapter.item.Item
import ru.stream.recycleradapters.domain.model.TrackItem

class SeparatorDelegate :
	BaseAdapterDelegate<TrackItem.Separator, SeparatorDelegate.SeparatorHolder>() {

	override fun isForViewType(item: Item): Boolean = item is TrackItem.Separator

	override val layoutId: Int = R.layout.view_track_separator

	override fun createViewHolder(view: View): SeparatorHolder = SeparatorHolder(view)

	class SeparatorHolder(view: View) : ItemViewHolder<TrackItem.Separator>(view)
}