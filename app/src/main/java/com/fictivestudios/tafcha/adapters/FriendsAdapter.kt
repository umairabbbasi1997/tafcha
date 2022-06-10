package com.fictivestudios.tafcha.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import com.fictivestudios.tafcha.R
import com.fictivestudios.tafcha.activities.MainActivity
import com.fictivestudios.tafcha.fragments.OtherUserFragment
import kotlinx.android.synthetic.main.item_challenge_friends.view.*
import kotlinx.android.synthetic.main.item_training_expand.view.*
import java.util.*
import kotlin.collections.ArrayList

class FriendsAdapter (context: Context, private val mlist:ArrayList<String>)
    :RecyclerView.Adapter<FriendsAdapter.ViewHolder>(), Filterable {

    val contex = context

    var filteredList = ArrayList<String>()

    init {
        filteredList = mlist
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_friend, parent, false)

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



        holder.itemView.tv_user_name.setOnClickListener {

            val activity = contex as MainActivity
            activity.
            replaceFragment(OtherUserFragment()
                ,OtherUserFragment.javaClass.simpleName,
                true,true)
        }

    }


    override fun getItemCount(): Int { return filteredList.size }

    class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView)
    {

    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val charSearch = constraint.toString()
                if (charSearch.isEmpty()) {
                    filteredList = mlist
                } else {
                    val resultList = ArrayList<String>()
                    for (row in mlist) {
                        if (row.lowercase(Locale.ROOT).contains(charSearch.lowercase(Locale.ROOT))) {
                            resultList.add(row)
                        }
                    }
                    filteredList = resultList
                }
                val filterResults = FilterResults()
                filterResults.values = filteredList
                return filterResults
            }

            @Suppress("UNCHECKED_CAST")
            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                filteredList = results?.values as ArrayList<String>
                notifyDataSetChanged()
            }

        }
        }


}