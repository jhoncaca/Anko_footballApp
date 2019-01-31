package com.nawstuff.cahyadi.clubmatch.MainAct

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.nawstuff.cahyadi.clubmatch.MatchAct.MatchEvent
import com.nawstuff.cahyadi.clubmatch.MatchAct.MatchEventPresenter
import com.nawstuff.cahyadi.clubmatch.R
import com.nawstuff.cahyadi.clubmatch.R.id.*
import com.nawstuff.cahyadi.clubmatch.Utilities.TeamsAdapter
import com.nawstuff.cahyadi.clubmatch.Utilities.invisible
import com.nawstuff.cahyadi.clubmatch.Utilities.visible
import com.nawstuff.cahyadi.clubmatch.Utilities.api.SportDBrest
import com.nawstuff.cahyadi.clubmatch.Utilities.api.SportDbAPI
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.AnkoLogger

class MainActivity : AppCompatActivity(), AnkoLogger, MainView.View {
    private var matchLists: MutableList<MatchEvent> = mutableListOf()

    override fun hideLoading() {
        mProgressBar.invisible()
    }

    override fun showLoading() {
        mProgressBar.visible()
    }

    override fun displayClubMatch(matchList: List<MatchEvent>) {
       matchLists.clear()
        matchLists.addAll(matchLists)

        val layoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)
        recyleViewClub.layoutManager = layoutManager
        recyleViewClub.adapter = TeamsAdapter(matchList, applicationContext)

    }

    lateinit var mPresenter : MainPresenter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val service = SportDbAPI.getClient().create(SportDBrest::class.java)
        val request = MatchEventPresenter(service)
        mPresenter = MainPresenter(this, request)
        mPresenter.getClubMatchData()

        bottom_navigation.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                lastMatch -> {
                    mPresenter.getClubMatchData()
                }
                nextMatch -> {
                    mPresenter.getClubUpcomingData()
                }
            }
            true
        }
        bottom_navigation.selectedItemId = lastMatch

    }











}
