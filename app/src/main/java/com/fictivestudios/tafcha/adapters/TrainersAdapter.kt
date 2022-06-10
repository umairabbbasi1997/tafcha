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
import com.fictivestudios.tafcha.fragments.TrainerProfileFragment
import com.fictivestudios.tafcha.fragments.TrainingFragment3
import com.technado.demoapp.base.BaseFragment
import kotlinx.android.synthetic.main.item_trainer.view.*
import kotlinx.android.synthetic.main.item_trainer.view.tv_user_name

class TrainersAdapter (context: Context, private val mlist:ArrayList<String>) :RecyclerView.Adapter<TrainersAdapter.ViewHolder>(){


    val contex = context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_trainer, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {



        holder.itemView.tv_user_name.setOnClickListener {

            val activity = contex as MainActivity
            activity.
            replaceFragment(
                TrainerProfileFragment()
                , TrainerProfileFragment.javaClass.simpleName,
                true,true)
        }



        holder.itemView.profile_image.setOnClickListener {

            val activity = contex as MainActivity
            activity.
            replaceFragment(
                TrainerProfileFragment()
                , TrainerProfileFragment.javaClass.simpleName,
                true,true)
        }

        holder.itemView.btn_send_request.setOnClickListener {

            holder.itemView.btn_send_request.setBackgroundResource(R.drawable.request_sent_icon)
        }

    }

    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
    }

    override fun getItemCount(): Int { return mlist.size }

    class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView)
    {

    }

/*    fun replaceFragment(
        frag: Fragment,
        tag: String,
        isAddToBackStack: Boolean,
        animate: Boolean
    ) {


        val activity = contex as MainActivity

        val transaction = activity.replaceFragment()
        fragmentManager.beginTransaction()


        transaction.replace(R.id.main_view_container, frag )

        if (isAddToBackStack) {
            transaction.addToBackStack(null).commit()
        } else {
            transaction.commitAllowingStateLoss()
        }
    }*/

}