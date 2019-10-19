package ru.stream.recycleradapters.core.adapter

import android.annotation.SuppressLint
import androidx.annotation.CallSuper
import androidx.recyclerview.widget.RecyclerView
import com.jakewharton.rxrelay2.PublishRelay
import io.reactivex.Observable

abstract class RxRecyclerViewAdapter<T, VH : ItemViewHolder<T>> : RecyclerView.Adapter<VH>() {

	private val itemClicksRelay = PublishRelay.create<ItemViewHolder<T>>()

	val itemClicksObservable: Observable<T> = itemClicksRelay
		.map { it.item }

	val itemClicksPositionObservable: Observable<Int> = itemClicksRelay
		.map { it.adapterPosition }
		.filter { it != RecyclerView.NO_POSITION }

	@SuppressLint("CheckResult")
	@CallSuper
	override fun onBindViewHolder(holder: VH, position: Int) {
		holder.itemView.setOnClickListener { itemClicksRelay.accept(holder) }
	}
}