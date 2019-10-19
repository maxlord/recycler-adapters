package ru.stream.recycleradapters.core.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import com.hannesdorfmann.adapterdelegates3.AdapterDelegate
import com.hannesdorfmann.adapterdelegates3.AdapterDelegatesManager
import ru.stream.recycleradapters.core.adapter.item.Item

open class SimpleAdapter<T : Item> : RxRecyclerViewAdapter<T, ItemViewHolder<T>>() {

	private var delegatesManager: AdapterDelegatesManager<List<Item>> = AdapterDelegatesManager()
	protected var items = emptyList<T>()

	override fun getItemViewType(position: Int): Int {
		return delegatesManager.getItemViewType(items, position)
	}

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder<T> {
		@Suppress("UNCHECKED_CAST")
		return delegatesManager.onCreateViewHolder(parent, viewType) as ItemViewHolder<T>
	}

	override fun onBindViewHolder(holder: ItemViewHolder<T>, position: Int) {
		super.onBindViewHolder(holder, position)
		delegatesManager.onBindViewHolder(items, position, holder)
	}

	override fun onViewAttachedToWindow(holder: ItemViewHolder<T>) {
		delegatesManager.onViewAttachedToWindow(holder)
	}

	override fun onViewDetachedFromWindow(holder: ItemViewHolder<T>) {
		delegatesManager.onViewDetachedFromWindow(holder)
	}

	override fun getItemCount(): Int {
		return items.size
	}

	fun getItem(position: Int): T? {
		return items.getOrNull(position)
	}

	fun attachItems(
		newItems: List<T>,
		ignoreEqual: Boolean = false,
		callbackProvider: ((List<T>, List<T>) -> DiffUtil.Callback)? = null
	): Boolean {
		if (ignoreEqual && items.areItemsEqual(newItems)) return false

		val oldItems = items
		items = newItems

		callbackProvider?.let {
			DiffUtil.calculateDiff(it.invoke(oldItems, newItems)).dispatchUpdatesTo(this)
		} ?: notifyDataSetChanged()

		return true
	}

	fun addDelegate(delegate: AdapterDelegate<List<Item>>): SimpleAdapter<T> {
		delegatesManager.addDelegate(delegate)
		return this
	}

	fun addDelegates(vararg delegates: AdapterDelegate<List<Item>>) {
		delegates.forEach { addDelegate(it) }
	}
}

fun <T> Collection<T>.areItemsEqual(other: Collection<T>): Boolean {
	if (size != other.size) return false

	zip(other) { a: T, b: T ->
		if (a != b) return false
	}

	return true
}