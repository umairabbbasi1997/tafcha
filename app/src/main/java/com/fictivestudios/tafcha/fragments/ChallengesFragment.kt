package com.fictivestudios.tafcha.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.ViewPager
import com.fictivestudios.tafcha.R
import com.fictivestudios.tafcha.Utils.Titlebar
import com.fictivestudios.tafcha.adapters.ViewPagerChallengesAdapter
import com.technado.demoapp.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_challenges.view.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ChallengesFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ChallengesFragment : BaseFragment() {
    private var isSentClick: Boolean = false

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

        titlebar.setMainTitle(
            getString(R.string.challenges),

            object:View.OnClickListener{
                override fun onClick(p0: View?) {
                    getActivityContext
                        ?.onBackPressed()
                }
            },
            R.drawable.btn_back_arrow,

            object:View.OnClickListener{
                override fun onClick(p0: View?) {
                    getActivityContext
                        ?.replaceFragment(
                            NotificationsFragment(),
                            NotificationsFragment.javaClass.simpleName,
                            true, true
                        )
                }
            },
            R.drawable.notify_icon
        )


/*        titlebar.setTitle(getActivityContext!!, getString(R.string.challenges))

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
            })*/
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        // Inflate the layout for this fragment

        mView = inflater.inflate(R.layout.fragment_challenges, container, false)

        var adapter = ViewPagerChallengesAdapter(childFragmentManager)
        mView.view_pager_challenge.adapter = adapter


        mView.view_pager_challenge.addOnPageChangeListener(object: ViewPager.OnPageChangeListener{
            override fun onPageScrolled(position: Int, positionOffset: Float,
                                        positionOffsetPixels: Int) {}

            override fun onPageSelected(position: Int) {

                if (position == 0)
                {
                    isSentClick = true
                    mView.btn_sent.setBackgroundResource(R.drawable.btn_squire_round_pink)
                    mView.btn_my_received.setBackgroundResource(R.drawable.btn_squire_round_gray)

                }
                else
                {
                    isSentClick = false
                    mView.btn_my_received.setBackgroundResource(R.drawable.btn_squire_round_pink)
                    mView.btn_sent.setBackgroundResource(R.drawable.btn_squire_round_gray)


                }
            }
            override fun onPageScrollStateChanged(state: Int) {}
        })

        mView.btn_sent.setOnClickListener {

            if(!isSentClick)
            {
                isSentClick = true
                mView.btn_sent.setBackgroundResource(R.drawable.btn_squire_round_pink)
                mView.btn_my_received.setBackgroundResource(R.drawable.btn_squire_round_gray)
                mView.view_pager_challenge.setCurrentItem(0,true)

            }





        }

        mView.btn_my_received.setOnClickListener {

            if(isSentClick)
            {
                isSentClick = false
                mView.btn_my_received.setBackgroundResource(R.drawable.btn_squire_round_pink)
                mView.btn_sent.setBackgroundResource(R.drawable.btn_squire_round_gray)
                mView.view_pager_challenge.setCurrentItem(0,true)

            }

            mView.view_pager_challenge.setCurrentItem(1,true)

        }



        return mView
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ChallengesFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ChallengesFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}