package com.fictivestudios.tafcha.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fictivestudios.tafcha.R
import com.fictivestudios.tafcha.activities.MainActivity
import com.fictivestudios.tafcha.fragments.EventDetailsFragment
import com.fictivestudios.tafcha.fragments.InviteUsersFragment
import com.fictivestudios.tafcha.fragments.OtherUserFragment
import kotlinx.android.synthetic.main.item_challenge_friends.view.*

class EventListAdapter (context: Context, private val mlist:ArrayList<String>)
    :RecyclerView.Adapter<EventListAdapter.ViewHolder>(){

    val contex = context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_events, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

/*
        holder.itemView.setOnClickListener {

            val activity = contex as MainActivity
            activity
                ?.replaceFragment(
                    EventDetailsFragment(),
                    EventDetailsFragment.javaClass.simpleName,
                    true, true
                )
        }*/

    }


    override fun getItemCount(): Int { return mlist.size }

    class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView)
    {

    }


}