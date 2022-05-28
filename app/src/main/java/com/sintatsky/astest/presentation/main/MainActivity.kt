package com.sintatsky.astest.presentation.main

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.mikepenz.materialdrawer.AccountHeader
import com.mikepenz.materialdrawer.AccountHeaderBuilder
import com.mikepenz.materialdrawer.Drawer
import com.mikepenz.materialdrawer.DrawerBuilder
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem
import com.mikepenz.materialdrawer.model.ProfileDrawerItem
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem
import com.sintatsky.astest.R
import com.sintatsky.astest.databinding.ActivityMainBinding
import com.sintatsky.astest.presentation.screens.bottom_items.BookmarksFragment
import com.sintatsky.astest.presentation.screens.bottom_items.ContentFragment
import com.sintatsky.astest.presentation.screens.bottom_items.ProfileFragment
import com.sintatsky.astest.presentation.screens.bottom_items.SupportFragment
import com.sintatsky.astest.presentation.screens.diagrams.CircleDiagramFragment
import com.sintatsky.astest.presentation.screens.diagrams.DynamicDiagramFragment


class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private lateinit var drawer: Drawer
    private lateinit var header: AccountHeader

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.bottom_nav_content -> {
                    setupFragment(ContentFragment.newInstance())
                    true
                }
                R.id.bottom_nav_profile -> {
                    setupFragment(ProfileFragment.newInstance())
                    true
                }
                R.id.bottom_nav_support -> {
                    setupFragment(SupportFragment.newInstance())
                    true
                }
                R.id.bottom_nav_bookmarks -> {
                    setupFragment(BookmarksFragment.newInstance())
                    true
                }
                else -> false
            }
        }
        if (savedInstanceState == null) {
            binding.bottomNavigationView.selectedItemId = R.id.bottom_nav_content
        }
    }

    override fun onStart() {
        super.onStart()
        initFunc()
    }

    private fun initFunc() {
        createHeader()
        createDrawer()
    }

    private fun createDrawer() {
        drawer = DrawerBuilder()
            .withActivity(this)
            .withActionBarDrawerToggle(false)
            .withSelectedItem(-1)
            .withTranslucentStatusBar(true)
            .withAccountHeader(header)
            .addDrawerItems(
                PrimaryDrawerItem().withIdentifier(101)
                    .withIconTintingEnabled(true)
                    .withName(getString(R.string.diagram))
                    .withSelectable(true)
                    .withIcon(R.drawable.ic_diagram),
                PrimaryDrawerItem().withIdentifier(102)
                    .withIconTintingEnabled(true)
                    .withName(getString(R.string.circle_diagram))
                    .withSelectable(true)
                    .withIcon(R.drawable.ic_circle_diagram)
            ).withOnDrawerItemClickListener(object : Drawer.OnDrawerItemClickListener {
                override fun onItemClick(
                    view: View?,
                    position: Int,
                    drawerItem: IDrawerItem<*>
                ): Boolean {
                    when (position) {
                        1 -> setupFragment(DynamicDiagramFragment.newInstance())
                        2 -> setupFragment(CircleDiagramFragment.newInstance())
                    }
                    return false
                }
            })
            .build()
        drawer.drawerLayout.setStatusBarBackgroundColor(Color.LTGRAY)
    }

    private fun createHeader() {
        header = AccountHeaderBuilder()
            .withActivity(this)
            .withHeaderBackground(R.drawable.header)
            .addProfiles(
                ProfileDrawerItem().apply {
                    withName(getString(R.string.name))
                    withEmail(getString(R.string.github))
                    withIcon(R.drawable.profile_icon)
                }
            ).withCompactStyle(true)
            .build()
    }

    private fun setupFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .addToBackStack(null)
            .replace(R.id.frameContainer, fragment)
            .commit()
    }
}