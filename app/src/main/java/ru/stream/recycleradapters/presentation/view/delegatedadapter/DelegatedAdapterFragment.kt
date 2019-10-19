package ru.stream.recycleradapters.presentation.view.delegatedadapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ru.stream.recycleradapters.R

class DelegatedAdapterFragment : Fragment() {

	override fun onCreateView(
		inflater: LayoutInflater,
		container: ViewGroup?,
		savedInstanceState: Bundle?
	): View? {
		return inflater.inflate(R.layout.fragment_delegated_adapter, container, false)
	}

	companion object {

		fun newInstance() =
			DelegatedAdapterFragment()
	}
}