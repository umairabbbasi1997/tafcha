package com.fictivestudios.tafcha.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.recyclerview.widget.RecyclerView
import com.fictivestudios.tafcha.R


class LanguageAdapter (context: Context, private val mlist:ArrayList<String>): BaseAdapter() {

    val contex = context

    private val inflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater


    override fun getCount(): Int {
       return mlist.size
    }

    override fun getItem(p0: Int): Any {
       return mlist[p0]
    }

    override fun getItemId(p0: Int): Long {
       return  p0.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup? ): View {
        val view: View
        val vh: ItemHolder
        if (convertView == null) {
            view = inflater.inflate(R.layout.item_language, parent, false)
            vh = ItemHolder(view)
            view?.tag = vh
        } else {
            view = convertView
            vh = view.tag as ItemHolder
        }

        return view
    }

    private class ItemHolder(row: View?) {
/*        val label: TextView
        val img: ImageView*/

        init {
           /* label = row?.findViewById(R.id.text) as TextView
            img = row?.findViewById(R.id.img) as ImageView*/
        }
    }


}