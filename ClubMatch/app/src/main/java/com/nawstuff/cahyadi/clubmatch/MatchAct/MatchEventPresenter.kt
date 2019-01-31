package com.nawstuff.cahyadi.clubmatch.MatchAct

import com.nawstuff.cahyadi.clubmatch.Utilities.api.SportDBrest
import com.nawstuff.cahyadi.clubmatch.Utilities.TeamsResponse
import io.reactivex.Flowable

class MatchEventPresenter (private val SportDBRest: SportDBrest) :
    MatchEventView {
    override fun getFootballMatch(id: String): Flowable<MatchEventResponse> = SportDBRest.getLastmatch(id)

    override fun getTeams(id: String): Flowable<TeamsResponse> = SportDBRest.getTeam(id)

    override fun getUpcomingMatch(id: String): Flowable<MatchEventResponse>  = SportDBRest.getUpcomingMatch(id)
}