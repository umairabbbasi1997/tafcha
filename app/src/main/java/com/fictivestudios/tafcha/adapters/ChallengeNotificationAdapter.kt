package com.fictivestudios.tafcha.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fictivestudios.tafcha.R
import com.fictivestudios.tafcha.activities.MainActivity
import com.fictivestudios.tafcha.dialogFragments.ChallengeWonFragment
import com.fictivestudios.tafcha.fragments.OtherUserFragment
import kotlinx.android.synthetic.main.item_challenge_friends.view.profile_image
import kotlinx.android.synthetic.main.item_challenge_friends.view.tv_user_name
import kotlinx.android.synthetic.main.item_challenge_notification.view.*

class ChallengeNotificationAdapter (context: Context, private val mlist:ArrayList<String>)
    :RecyclerView.Adapter<ChallengeNotificationAdapter.ViewHolder>(){

    val contex = context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_challenge_notification, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.itemView.setOnClickListener {
            val activity = contex as MainActivity

            if (mlist[position].equals("Challenge Won!"))
            {
                activity.
                AddFragment(ChallengeWonFragment(true)
                    ,ChallengeWonFragment.javaClass.simpleName,
                    true,false)
            }
            else
            {
                activity.
                AddFragment(ChallengeWonFragment(false)
                    ,ChallengeWonFragment.javaClass.simpleName,
                    true,false)
            }



        }

       holder.itemView.profile_image.setOnClickListener {

           val activity = contex as MainActivity
           activity.
           replaceFragment(OtherUserFragment()
               ,OtherUserFragment.javaClass.simpleName,
               true,true)
       }



        holder.itemView.tv_user_name.setOnClickListener {

            val activity = contex as MainActivity
            activity.
            replaceFragment(OtherUserFragment()
                ,OtherUserFragment.javaClass.simpleName,
                true,true)
        }

        holder.itemView.tv_challenged_to_you.text = mlist[position]


    }


    override fun getItemCount(): Int { return mlist.size }

    class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView)
    {
        fun bindItems(position: Int)
        {

        }

    }


}