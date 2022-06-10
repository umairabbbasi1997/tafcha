package com.fictivestudios.tafcha.adapters

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.fictivestudios.tafcha.R
import com.fictivestudios.tafcha.activities.MainActivity
import com.fictivestudios.tafcha.fragments.OtherUserFragment
import com.fictivestudios.tafcha.fragments.TrainingFragment3
import com.technado.demoapp.base.BaseFragment
import kotlinx.android.synthetic.main.item_challenge_friends.view.*
import kotlinx.android.synthetic.main.item_training_expand.view.*

class ReminderAdapter (context: Context, private val mlist:ArrayList<String>)
    :RecyclerView.Adapter<ReminderAdapter.ViewHolder>(){

    val contex = context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_reminder, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {




    }


    override fun getItemCount(): Int { return mlist.size }

    class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView)
    {

    }


}