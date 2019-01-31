package com.nawstuff.cahyadi.clubmatch.DetailAct

import android.os.Build
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.nawstuff.cahyadi.clubmatch.MatchAct.MatchEvent
import com.nawstuff.cahyadi.clubmatch.MatchAct.MatchEventPresenter
import com.nawstuff.cahyadi.clubmatch.R
import com.nawstuff.cahyadi.clubmatch.Utilities.api.SportDBrest
import com.nawstuff.cahyadi.clubmatch.Utilities.api.SportDbAPI
import com.nawstuff.cahyadi.clubmatch.Utilities.Teams
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity(), DetailView.View {
    override fun displayTeamBadgeHome(team: Teams) {
        Picasso.get()
            .load(team.strTeamBadge)
            .placeholder(R.drawable.ic_launcher_background)
            .error(R.drawable.ic_launcher_background)
            .into(img_home)
    }

    override fun displayTeamBadgeAway(team: Teams) {
        Picasso.get()
            .load(team.strTeamBadge)
            .placeholder(R.drawable.ic_launcher_background)
            .error(R.drawable.ic_launcher_background)
            .into(img_away)
    }
    private lateinit var mPresenter: DetailPresenter

    private fun initData(matchEvent: MatchEvent){
        if (matchEvent.intHomeScore == null) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                match_date.setTextColor(applicationContext.getColor(R.color.colorAccent))
            }

        }
        match_date.text = matchEvent.dateEvent
        home_score_match.text = matchEvent.intHomeScore
        away_score_match.text = matchEvent.intAwayScore

        home_shots.text = matchEvent.intHomeShots
        away_shot.text = matchEvent.intAwayShots

        home_goals.text = matchEvent.strHomeGoalDetails
        away_goals.text = matchEvent.strAwayGoalDetails

        home_goalkeeper.text = matchEvent.strHomeLineupGoalkeeper
        away_goalkeeper.text = matchEvent.strAwayLineupGoalkeeper

        home_defense.text = matchEvent.strHomeLineupDefense
        away_defense.text = matchEvent.strAwayLineupDefense

        home_midfield.text = matchEvent.strHomeLineupMidfield
        away_midfield.text = matchEvent.strAwayLineupMidfield

        home_forward.text = matchEvent.strHomeLineupForward
        away_forward.text = matchEvent.strAwayLineupForward

        home_substitutes.text = matchEvent.strHomeLineupSubstitutes
        away_substitutes.text = matchEvent.strAwayLineupSubstitutes
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val service = SportDbAPI.getClient().create(SportDBrest::class.java)
        val request = MatchEventPresenter(service)
        mPresenter = DetailPresenter(this, request)

        val event = intent.getParcelableExtra<MatchEvent>("match")
        mPresenter.getTeamBadgeAway(event.idAwayTeam)
        mPresenter.getTeamBadgeHome(event.idHomeTeam)
        initData(event)
        supportActionBar?.title = event.strEvent
    }

}