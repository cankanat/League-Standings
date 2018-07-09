package com.example.teknasyon.myapplication

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

class TeamAdapter(private val context: Context, private val items: List<Team>) : RecyclerView.Adapter<TeamAdapter.TeamViewHolder>() {

    private var teamClickListener: OnTeamClickListener? = null

    fun setTeamClickListener(teamClickListener: OnTeamClickListener) {
        this.teamClickListener = teamClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamViewHolder {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.list_item, parent, false)
        return TeamViewHolder(view)
    }


    override fun onBindViewHolder(holder: TeamViewHolder, position: Int) {
        val item = items[position]
        holder.ranks.text = item.position
        holder.team_name.text = item.teamName
        holder.game_played.text = item.overallGp
        holder.points.text = item.points


    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class TeamViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

        internal var ranks: TextView
        internal var logo: ImageView
        internal var team_name: TextView
        internal var game_played: TextView
        internal var points: TextView



        init {
            ranks = itemView.findViewById(R.id.TeamRanks)
            logo = itemView.findViewById(R.id.image_team_logo)
            team_name = itemView.findViewById(R.id.TeamName)
            game_played = itemView.findViewById(R.id.game_played)
            points = itemView.findViewById(R.id.TeamPoints)

            itemView.setOnClickListener(this)
        }

        override fun onClick(view: View) {
            if (teamClickListener != null) {
                val clickedPosition = adapterPosition
                val clickedTeam = items[clickedPosition]
                teamClickListener!!.onTeamClick(clickedTeam)
            }
        }
    }

}
