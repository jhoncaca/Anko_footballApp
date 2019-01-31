package com.nawstuff.cahyadi.clubmatch.MatchAct

import com.google.gson.annotations.SerializedName

data class MatchEventResponse (
    @SerializedName("events") var events: List<MatchEvent>)
