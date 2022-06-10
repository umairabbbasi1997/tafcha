package com.fictivestudios.tafcha.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fictivestudios.tafcha.R
import com.fictivestudios.tafcha.activities.MainActivity
import com.fictivestudios.tafcha.fragments.ChallengeFriendsFragment
import com.fictivestudios.tafcha.fragments.TrainingFragment3
import com.fictivestudios.tafcha.fragments.UploadChallengFragment
import com.fictivestudios.tafcha.models.ChallengeFriend
import kotlinx.android.synthetic.main.item_training_expand.view.*

class TrainingAdapter (context: Context, private val mlist:ArrayList<String>) :RecyclerView.Adapter<TrainingAdapter.ViewHolder>(){

    private var isExpanded = false
    private var isSeeMore = false
    val contex = context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_training_expand, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {


        holder.itemView.btn_arrow_down.setOnClickListener {

            if (!isExpanded)
            {
                isExpanded = true
                expandText(holder.itemView)
            }
            else
            {
                isExpanded = false
                hideText(holder.itemView)

            }

        }
        holder.itemView.tv_see_more.setOnClickListener {

            if (!isSeeMore)
            {
                isSeeMore = true
                expandViews(holder.itemView)

            }
            else
            {
                isSeeMore = false
                hideViews(holder.itemView)

            }


        }


        holder.itemView.btn_upload.setOnClickListener {
            val activity = contex as MainActivity
          activity.
          AddFragment(UploadChallengFragment(),
              UploadChallengFragment.javaClass.simpleName,
              true,true)
        }

        holder.itemView.btn_challenge_friend.setOnClickListener {
            val activity = contex as MainActivity
            activity.
            AddFragment(ChallengeFriendsFragment(),
                ChallengeFriendsFragment.javaClass.simpleName,
                true,true)
        }

    }

    private fun hideViews(itemView: View)
    {
        itemView.button_layout.visibility = View.GONE
        itemView.tv_see_more.visibility = View.VISIBLE
    }

    private fun expandViews(itemView: View)
    {
        itemView.button_layout.visibility = View.VISIBLE
        itemView.tv_see_more.visibility = View.GONE
    }

    private fun hideText(itemView: View)
    {
        itemView.btn_arrow_down.setImageResource(R.drawable.arrow_right_icon)
        itemView.expandable_text.visibility = View.GONE
        itemView.tv_see_more.visibility = View.GONE
    }

    private fun expandText(itemView: View)
    {
        itemView.btn_arrow_down.setImageResource(R.drawable.arrow_down_icon)
        itemView.expandable_text.visibility = View.VISIBLE
        itemView.tv_see_more.visibility = View.VISIBLE
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