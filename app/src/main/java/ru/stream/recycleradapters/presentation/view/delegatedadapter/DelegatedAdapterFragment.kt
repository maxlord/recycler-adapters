package ru.stream.recycleradapters.presentation.view.delegatedadapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_regular_adapter.*
import org.threeten.bp.LocalDateTime
import org.threeten.bp.format.DateTimeFormatter
import ru.stream.recycleradapters.R
import ru.stream.recycleradapters.core.adapter.SimpleAdapter
import ru.stream.recycleradapters.core.adapter.item.Item
import ru.stream.recycleradapters.domain.model.TrackItem
import ru.stream.recycleradapters.presentation.view.delegatedadapter.delegate.ExamDelegate
import ru.stream.recycleradapters.presentation.view.delegatedadapter.delegate.IntroLessonDelegate
import ru.stream.recycleradapters.presentation.view.delegatedadapter.delegate.RegularLessonDelegate
import ru.stream.recycleradapters.presentation.view.delegatedadapter.delegate.SeparatorDelegate

class DelegatedAdapterFragment : Fragment() {

	private val dateFormatter: DateTimeFormatter by lazy {
		DateTimeFormatter.ofPattern("dd.MM.yyyy")
	}
	private val separatorDelegate = SeparatorDelegate()
	private val introLessonDelegate = IntroLessonDelegate(dateFormatter)
	private val regularLessonDelegate = RegularLessonDelegate(dateFormatter)
	private val examDelegate = ExamDelegate()

	private val adapter: SimpleAdapter<Item> = SimpleAdapter<Item>().also {
		it.addDelegates(
			separatorDelegate,
			introLessonDelegate,
			regularLessonDelegate,
			examDelegate
		)
	}

	override fun onCreateView(
		inflater: LayoutInflater,
		container: ViewGroup?,
		savedInstanceState: Bundle?
	): View? {
		return inflater.inflate(R.layout.fragment_delegated_adapter, container, false)
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		recycler.adapter = adapter

		adapter.attachItems(prepareTrackItems())
	}

	private fun prepareTrackItems(): List<Item> {
		return listOf(
			TrackItem.IntroLesson(
				"1",
				LocalDateTime.of(2019, 10, 1, 0, 0, 0),
				"Вводный урок",
				"Иван Васильевич"
			),
			TrackItem.Separator,
			TrackItem.RegularLesson(
				"2",
				LocalDateTime.of(2019, 10, 15, 0, 0, 0),
				"Английский язык",
				"Мария Ивановна"
			),
			TrackItem.Separator,
			TrackItem.RegularLesson(
				"3",
				LocalDateTime.of(2019, 10, 17, 0, 0, 0),
				"Математика",
				"Мария Ивановна"
			),
			TrackItem.Separator,
			TrackItem.RegularLesson(
				"4",
				LocalDateTime.of(2019, 10, 19, 0, 0, 0),
				"Русский язык",
				"Мария Ивановна"
			),
			TrackItem.Separator,
			TrackItem.Exam("5", "Экзамен по анлийскому языку")
		)
	}

	companion object {

		fun newInstance() =
			DelegatedAdapterFragment()
	}
}