package com.nawstuff.cahyadi.clubmatch.DetailAct

import com.nawstuff.cahyadi.clubmatch.Utilities.Teams

interface DetailView {

    interface View {
        fun displayTeamBadgeHome(team: Teams)
        fun displayTeamBadgeAway(team: Teams)
    }
    interface Presenter {
        fun  getTeamBadgeHome(id: String)
        fun getTeamBadgeAway (id:String)

    }
}