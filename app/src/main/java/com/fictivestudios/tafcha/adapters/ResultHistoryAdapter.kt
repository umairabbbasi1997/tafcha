package com.fictivestudios.tafcha.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fictivestudios.tafcha.R
import com.fictivestudios.tafcha.activities.MainActivity
import com.fictivestudios.tafcha.fragments.LiveEventFragment
import com.fictivestudios.tafcha.fragments.OtherUserFragment
import com.fictivestudios.tafcha.fragments.PendingDetailsFragment
import com.fictivestudios.tafcha.fragments.ResultDetailsFragment
import kotlinx.android.synthetic.main.item_challenge_request.view.*


class ResultHistoryAdapter (context: Context, private val mlist:ArrayList<String>)
    :RecyclerView.Adapter<ResultHistoryAdapter.ViewHolder>(){

    val contex = context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_result, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.itemView.setOnClickListener {
            val activity = contex as MainActivity

            holder.itemView.setOnClickListener {
                activity
                    ?.replaceFragment(
                        ResultDetailsFragment(),
                        ResultDetailsFragment.javaClass.simpleName,
                        true, true
                    )
            }

        }

/*

       holder.itemView.profile_image.setOnClickListener {

           val activity = contex as MainActivity
           activity.
           replaceFragment(OtherUserFragment()
               ,OtherUserFragment.javaClass.simpleName,
               true,true)
       }

        holder.itemView.btn_accept.setOnClickListener {


            val activity = contex as MainActivity
            activity.
            replaceFragment(LiveEventFragment()
                ,LiveEventFragment.javaClass.simpleName,
                true,true)
        }


        holder.itemView.tv_user_name.setOnClickListener {

            val activity = contex as MainActivity
            activity.
            replaceFragment(OtherUserFragment()
                ,OtherUserFragment.javaClass.simpleName,
                true,true)
        }








*/


    }


    override fun getItemCount(): Int { return mlist.size }

    class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView)
    {

    }


}