package com.fictivestudios.tafcha.fragments

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.fictivestudios.tafcha.R
import com.fictivestudios.tafcha.adapters.LeaderBoardAdapter
import com.fictivestudios.tafcha.Utils.Titlebar
import com.technado.demoapp.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_friends.view.*
import kotlinx.android.synthetic.main.fragment_leaderboard.view.*
import kotlinx.android.synthetic.main.fragment_leaderboard.view.tv_search

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [LeaderboardFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LeaderboardFragment : BaseFragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var mView: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun setTitlebar(titlebar: Titlebar) {
        titlebar.setTitle(getActivityContext!!, getString(R.string.leader_board))

        titlebar.setBtnBack(
            object:View.OnClickListener{
                override fun onClick(p0: View?) {
                    getActivityContext
                        ?.onBackPressed()
                }
            }

        )

        titlebar.setBtnRight(R.drawable.notify_icon,
            object:View.OnClickListener{
                override fun onClick(p0: View?) {
                    getActivityContext
                        ?.replaceFragment(
                            NotificationsFragment(),
                            NotificationsFragment.javaClass.simpleName,
                            true, true
                        )
                }
            })
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

       mView =  inflater.inflate(R.layout.fragment_leaderboard, container, false)

        initTrainingRecyclerview()

        return mView
    }

    private fun initTrainingRecyclerview()
    {


        val leaderBoardList=ArrayList<String>()

        leaderBoardList.add("John Smith")
        leaderBoardList.add("John Smith")
        leaderBoardList.add("John Smith")
        leaderBoardList.add("John Smith")
        leaderBoardList.add("John Smith")
        leaderBoardList.add("John Smith")
        leaderBoardList.add("John Smith")
        leaderBoardList.add("John Smith")

        val adapter = context?.let { LeaderBoardAdapter(it,leaderBoardList) }


        mView.rv_leaderboard.adapter = adapter
        mView.rv_leaderboard.adapter?.notifyDataSetChanged()

        mView.tv_search.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                adapter?.filter?.filter(p0)
            }

            override fun afterTextChanged(p0: Editable?) {

            }
        })
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment LeaderboardFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            LeaderboardFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}