package ru.stream.recycleradapters.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ru.stream.recycleradapters.R

class RegularAdapterFragment : Fragment() {

	override fun onCreateView(
		inflater: LayoutInflater,
		container: ViewGroup?,
		savedInstanceState: Bundle?
	): View? {
		return inflater.inflate(R.layout.fragment_regular_adapter, container, false)
	}

	companion object {

		fun newInstance() = RegularAdapterFragment()
	}
}