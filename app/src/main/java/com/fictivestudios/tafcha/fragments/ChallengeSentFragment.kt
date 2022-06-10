package com.fictivestudios.tafcha.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.fictivestudios.tafcha.R
import com.fictivestudios.tafcha.Utils.Titlebar
import com.fictivestudios.tafcha.adapters.ChallengeSentAdapter
import com.technado.demoapp.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_challenge_sent.view.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ChallengeSentFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ChallengeSentFragment : BaseFragment() {
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
        titlebar.setTitle(getActivityContext!!, getString(R.string.challenge_a_friend))

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

        mView = inflater.inflate(R.layout.fragment_challenge_sent, container, false)

        initChallengeRecyclerview()

        return mView
    }


    private fun initChallengeRecyclerview()
    {


        val challengeReqList=ArrayList<String>()
        challengeReqList.add("Justin Wade")
        challengeReqList.add("Justin Wade")
        challengeReqList.add("Justin Wade")
        challengeReqList.add("Justin Wade")
        challengeReqList.add("Justin Wade")
        challengeReqList.add("Justin Wade")

        mView.rv_challenge_sent.adapter = context?.let { ChallengeSentAdapter(it,challengeReqList) }
        mView.rv_challenge_sent.adapter?.notifyDataSetChanged()





    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ChallengeSentFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ChallengeSentFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}