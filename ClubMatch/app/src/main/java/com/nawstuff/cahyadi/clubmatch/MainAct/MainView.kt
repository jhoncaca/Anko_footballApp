package com.nawstuff.cahyadi.clubmatch.MainAct

import com.nawstuff.cahyadi.clubmatch.MatchAct.MatchEvent

interface MainView {

    interface View {
        fun  hideLoading ()
        fun  showLoading ()
        fun displayClubMatch (matchList: List<MatchEvent>)
    }
    interface Presenter {
        fun getClubMatchData()
        fun getClubUpcomingData()
    }
}