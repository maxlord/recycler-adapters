package ru.stream.recycleradapters.core.adapter.delegate

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hannesdorfmann.adapterdelegates3.AdapterDelegate
import ru.stream.recycleradapters.core.adapter.ItemViewHolder
import ru.stream.recycleradapters.core.adapter.item.Item

abstract class BaseAdapterDelegate<T : Item, VH : ItemViewHolder<T>> :
	AdapterDelegate<List<Item>>() {

	override fun isForViewType(items: List<Item>, position: Int): Boolean {
		return isForViewType(items[position])
	}

	protected abstract fun isForViewType(item: Item): Boolean

	protected abstract val layoutId: Int

	protected abstract fun createViewHolder(view: View): VH

	protected open fun onBind(item: T, holder: VH) = holder.bindItem(item)

	override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
		val view = LayoutInflater.from(parent.context).inflate(layoutId, parent, false)
		return createViewHolder(view)
	}

	@Suppress("UNCHECKED_CAST")
	override fun onBindViewHolder(
		items: List<Item>,
		position: Int,
		holder: RecyclerView.ViewHolder,
		payloads: MutableList<Any>
	) {
		val item = items[position] as T
		val vh = holder as VH
		onBind(item, vh)
	}
}