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
import com.fictivestudios.tafcha.dialogFragments.DialogueDescriptionFragment
import com.fictivestudios.tafcha.dialogFragments.SuccessDialogueFragment
import com.fictivestudios.tafcha.fragments.OtherUserFragment
import com.fictivestudios.tafcha.fragments.TrainingFragment3
import com.technado.demoapp.base.BaseFragment
import kotlinx.android.synthetic.main.item_challenge_friends.view.*
import kotlinx.android.synthetic.main.item_training_expand.view.*

class ChallengeFriendsAdapter (context: Context, private val mlist:ArrayList<String>)
    :RecyclerView.Adapter<ChallengeFriendsAdapter.ViewHolder>(){

    val contex = context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_challenge_friends, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {


       holder.itemView.profile_image.setOnClickListener {

           val activity = contex as MainActivity
           activity.
           replaceFragment(OtherUserFragment()
               ,OtherUserFragment.javaClass.simpleName,
               true,true)
       }

        holder.itemView.btn_challenge.setOnClickListener {
            val activity = contex as MainActivity?
            activity?.
            AddFragment(
                SuccessDialogueFragment(contex.getString( R.string.thank_you_your_challenge_has_been_sent),
                    object:View.OnClickListener{
                        override fun onClick(p0: View?) {
                            val activity = contex as MainActivity
                            activity
                                ?.onBackPressed()
                        }
                    }

                ),
                SuccessDialogueFragment.javaClass.simpleName,
                true,false)


        }



        holder.itemView.tv_user_name.setOnClickListener {

            val activity = contex as MainActivity
            activity.
            replaceFragment(OtherUserFragment()
                ,OtherUserFragment.javaClass.simpleName,
                true,true)
        }

    }


    override fun getItemCount(): Int { return mlist.size }

    class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView)
    {

    }


}