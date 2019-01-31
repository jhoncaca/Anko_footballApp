package com.nawstuff.cahyadi.clubmatch.Utilities

import com.google.gson.annotations.SerializedName
import com.nawstuff.cahyadi.clubmatch.Utilities.Teams

data class TeamsResponse (
    @SerializedName("teams")
    var teams:List<Teams>)
