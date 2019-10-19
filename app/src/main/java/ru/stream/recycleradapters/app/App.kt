package ru.stream.recycleradapters.app

import android.app.Application
import com.jakewharton.threetenabp.AndroidThreeTen
import timber.log.Timber

class App : Application() {

	override fun onCreate() {
		super.onCreate()
		initDateLibrary()
		initTimber()
	}

	private fun initDateLibrary() {
		AndroidThreeTen.init(this)
	}

	private fun initTimber() {
		Timber.plant(Timber.DebugTree())
	}
}