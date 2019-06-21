package com.lovisgod.wikiapp

import android.content.Intent
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main2.*


class Main2Activity : AppCompatActivity() {

    private val exploreFragment : ExploereFragment
    private val favouritesFragment : FavouritesFragment
    private val historyFragment : HistoryFragment

    init {
        exploreFragment = ExploereFragment()
        favouritesFragment = FavouritesFragment()
        historyFragment = HistoryFragment()
    }

    private lateinit var textMessage: TextView
    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        val transaction = supportFragmentManager.beginTransaction()
        transaction.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)
        when (item.itemId) {
          R.id.navigation_explore -> transaction.replace(R.id.fragment_container,exploreFragment)
          R.id.navigation_favourite -> transaction.replace(R.id.fragment_container, favouritesFragment)
          R.id.navigation_history -> transaction.replace(R.id.fragment_container, historyFragment)
        }
        transaction.commit()
        true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        setSupportActionBar(toolbar)
        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)

        // display the explore fragment oncreate
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.fragment_container, exploreFragment)
        transaction.commit()
    }
}
