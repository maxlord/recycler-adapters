package ru.stream.recycleradapters

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*
import ru.stream.recycleradapters.presentation.view.DelegatedAdapterFragment
import ru.stream.recycleradapters.presentation.view.MainFragment
import ru.stream.recycleradapters.presentation.view.RegularAdapterFragment

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

	private var currentFragment: Fragment? = null


	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)
		setSupportActionBar(toolbar)

		val toggle = ActionBarDrawerToggle(
			this,
			drawer_layout,
			toolbar,
			R.string.navigation_drawer_open,
			R.string.navigation_drawer_close
		)
		drawer_layout.addDrawerListener(toggle)
		toggle.syncState()

		nav_view.setNavigationItemSelectedListener(this)

		if (savedInstanceState == null) {
			currentFragment = MainFragment.newInstance()
			displayCurrentFragment()
		}
	}

	private fun displayCurrentFragment() {
		currentFragment?.let {
			supportFragmentManager.beginTransaction().replace(R.id.container, it).commit()
		}
	}

	override fun onBackPressed() {
		if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
			drawer_layout.closeDrawer(GravityCompat.START)
		} else {
			super.onBackPressed()
		}
	}

	override fun onNavigationItemSelected(item: MenuItem): Boolean {
		// Handle navigation view item clicks here.
		when (item.itemId) {
			R.id.nav_regular_adapter -> {
				currentFragment = RegularAdapterFragment.newInstance()
				displayCurrentFragment()
			}
			R.id.nav_delegated_adapter -> {
				currentFragment = DelegatedAdapterFragment.newInstance()
				displayCurrentFragment()
			}
		}

		drawer_layout.closeDrawer(GravityCompat.START)
		return true
	}
}