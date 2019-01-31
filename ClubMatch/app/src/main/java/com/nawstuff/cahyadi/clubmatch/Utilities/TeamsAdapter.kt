package com.nawstuff.cahyadi.clubmatch.Utilities

import android.content.Context
import android.content.Intent
import android.os.Build
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nawstuff.cahyadi.clubmatch.DetailAct.DetailActivity
import com.nawstuff.cahyadi.clubmatch.MatchAct.MatchEvent
import com.nawstuff.cahyadi.clubmatch.R
import kotlinx.android.synthetic.main.match_item.view.*
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.newTask
import org.jetbrains.anko.startActivity

class TeamsAdapter (private val eventList:List<MatchEvent>,
                    val context: Context):
                    RecyclerView.Adapter<TeamsAdapter.clubViewHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): clubViewHolder {
        return clubViewHolder(LayoutInflater.from(context).inflate(R.layout.match_item,p0, false))
    }

    override fun getItemCount(): Int = eventList.size

    override fun onBindViewHolder(p0: clubViewHolder, p1: Int) {
        p0.bind(eventList[p1])
    }


    inner class clubViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        fun bind(event: MatchEvent){
            if (event.intHomeScore == null){
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    itemView.dateScheduleTv.setTextColor(context.getColor(R.color.colorAccent))
                }
            }
            itemView.dateScheduleTv.text = event.dateEvent
            itemView.homeNameTv.text = event.strHomeTeam
            itemView.homeScoreTv.text = event.intHomeScore
            itemView.awayNameTv.text = event.strAwayTeam
            itemView.awayScoreTv.text = event.intAwayScore

            //revisi sesuai dengan yang disarankan
            itemView.setOnClickListener {
               val intent = Intent(context,DetailActivity::class.java)
                intent.putExtra("match",event)
                itemView.context.startActivity(intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK))
            }
        }
    }



}