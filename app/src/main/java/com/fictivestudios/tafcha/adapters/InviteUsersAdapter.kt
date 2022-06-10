package com.fictivestudios.tafcha.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fictivestudios.tafcha.R
import kotlinx.android.synthetic.main.item_invite_users.view.*

class InviteUsersAdapter (context: Context, private val mlist:ArrayList<String>)
    :RecyclerView.Adapter<InviteUsersAdapter.ViewHolder>(){

    val contex = context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_invite_users, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {


        if (position == mlist.size-1)
        {
         holder.itemView.iv_user_dp.setImageResource(R.drawable.invite)

        }


    }


    override fun getItemCount(): Int { return mlist.size }

    class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView)
    {

    }


}