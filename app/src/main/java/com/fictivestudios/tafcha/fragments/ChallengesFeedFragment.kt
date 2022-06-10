package com.fictivestudios.tafcha.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.ViewPager
import com.fictivestudios.tafcha.R
import com.fictivestudios.tafcha.adapters.ViewPagerFeedsAdapter

import com.fictivestudios.tafcha.Utils.Titlebar
import com.technado.demoapp.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_challenges_feed.view.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ChallengesFeedFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ChallengesFeedFragment : BaseFragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private var isFeedClick = true

    private lateinit var mView: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun setTitlebar(titlebar: Titlebar) {
        titlebar.setTitle(getActivityContext!!, getString(R.string.profile))

        titlebar.setBtnBack(
            object:View.OnClickListener{
                override fun onClick(p0: View?) {
                    getActivityContext
                        ?.onBackPressed()
                }
            }

        )

        titlebar.setBtnRight(R.drawable.add_icon,
            object:View.OnClickListener{
                override fun onClick(p0: View?) {
                    getActivityContext?.
                    replaceFragment(ChallengeFriendsFragment(),
                        ChallengeFriendsFragment.javaClass.simpleName,true,false)

                }
            })
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

       mView = inflater.inflate(R.layout.fragment_challenges_feed, container, false)

        var adapter = ViewPagerFeedsAdapter(childFragmentManager)
        mView.view_pager_feed.adapter = adapter


        mView.view_pager_feed.addOnPageChangeListener(object:ViewPager.OnPageChangeListener{
            override fun onPageScrolled(position: Int, positionOffset: Float,
                                        positionOffsetPixels: Int) {}

            override fun onPageSelected(position: Int) {

                if (position == 0)
                {
                    isFeedClick = true
                    mView.btn_feed.setBackgroundResource(R.drawable.btn_squire_round_pink)
                    mView.btn_my_challenges.setBackgroundResource(R.drawable.btn_squire_round_gray)

                }
                else
                {
                    isFeedClick = false
                    mView.btn_my_challenges.setBackgroundResource(R.drawable.btn_squire_round_pink)
                    mView.btn_feed.setBackgroundResource(R.drawable.btn_squire_round_gray)


                }
            }
            override fun onPageScrollStateChanged(state: Int) {}
        })

        mView.btn_feed.setOnClickListener {

            if(!isFeedClick)
            {
                isFeedClick = true
                mView.btn_feed.setBackgroundResource(R.drawable.btn_squire_round_pink)
                mView.btn_my_challenges.setBackgroundResource(R.drawable.btn_squire_round_gray)
                mView.view_pager_feed.setCurrentItem(0,true)

            }





        }

        mView.btn_my_challenges.setOnClickListener {

            if(isFeedClick)
            {
                isFeedClick = false
                mView.btn_my_challenges.setBackgroundResource(R.drawable.btn_squire_round_pink)
                mView.btn_feed.setBackgroundResource(R.drawable.btn_squire_round_gray)
                mView.view_pager_feed.setCurrentItem(0,true)

            }

            mView.view_pager_feed.setCurrentItem(1,true)

        }


        return mView
    }

    fun addFragment(frag: BaseFragment, tag: String, isAddToBackStack: Boolean, animate: Boolean) {




        val transaction =   getActivityContext?.supportFragmentManager?.beginTransaction()

        if (animate) {
            //transaction.setCustomAnimations(R.anim.slide_left_in, R.anim.slide_left_out)
            transaction?.setCustomAnimations(
                R.anim.slide_in_right,
                R.anim.slide_out_left,
                R.anim.slide_in_left,
                R.anim.slide_out_right
            )
        }
        transaction?.add(R.id.view_pager_feed,MyChallengesFragment())

        if (isAddToBackStack) {
            transaction?.addToBackStack(null)?.commit()
        } else {
            transaction?.commitAllowingStateLoss()
        }
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ChallengesFeedFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ChallengesFeedFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}