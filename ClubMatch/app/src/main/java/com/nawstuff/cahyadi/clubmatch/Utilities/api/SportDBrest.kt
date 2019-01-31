package com.nawstuff.cahyadi.clubmatch.Utilities.api

import com.nawstuff.cahyadi.clubmatch.MatchAct.MatchEventResponse
import com.nawstuff.cahyadi.clubmatch.Utilities.TeamsResponse
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Query

interface SportDBrest {
    @GET("eventspastleague.php")
    fun getLastmatch(@Query("id") id:String) : Flowable<MatchEventResponse>

    @GET("eventsnextleague.php")
    fun getUpcomingMatch(@Query("id") id:String) : Flowable<MatchEventResponse>

    @GET("lookupteam.php")
    fun getTeam(@Query("id") id:String) : Flowable<TeamsResponse>
}