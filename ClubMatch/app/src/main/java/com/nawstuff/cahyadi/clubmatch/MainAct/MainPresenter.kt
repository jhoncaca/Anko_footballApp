package com.nawstuff.cahyadi.clubmatch.MainAct

import com.nawstuff.cahyadi.clubmatch.MatchAct.MatchEventPresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MainPresenter (val mView: MainView.View,
                     val matchEventPresenter: MatchEventPresenter
): MainView.Presenter {
    override fun getClubMatchData() {
        mView.showLoading()
        compositeDisposable.add(matchEventPresenter.getFootballMatch("4328")
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe{
                mView.displayClubMatch(it.events)
                mView.hideLoading()
            })
    }

    override fun getClubUpcomingData() {
        mView.showLoading()
        compositeDisposable.add(matchEventPresenter.getUpcomingMatch("4328")
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe{
                mView.displayClubMatch(it.events)
                mView.hideLoading()
            })
    }

    val compositeDisposable = CompositeDisposable()



}