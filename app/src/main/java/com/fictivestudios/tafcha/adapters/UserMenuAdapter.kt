package com.fictivestudios.tafcha.adapters

import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.fictivestudios.tafcha.R
import com.fictivestudios.tafcha.fragments.*

class UserMenuAdapter (fm: FragmentManager) : FragmentPagerAdapter(fm) ,View.OnClickListener {

    val fm = fm
    override fun getCount(): Int {
        return 9;
    }





    override fun getItem(position: Int): Fragment {
        when(position) {
            0 -> {
                return TrainingPageFragment()
            }
            1 -> {
                return ChallengePageFragment()
            }
            2 -> {
                return TrainersPageFragment()
            }


            3 -> {
                return FriendsPageFragment()
            }

            4 -> {
                return LeaderboardPageFragment()
            }

            5 -> {
                return CalenderPageFragment()
            }

            6 -> {
                return ChallengeFeedPageFragment()
            }

            7 -> {
                return RewardsPageFragment()
            }

            8 -> {
                return SettingsPageFragment()
            }

            else -> {
                return TrainingPageFragment()
            }
        }
    }

/*    override fun getPageTitle(position: Int): CharSequence? {
        when(position) {
            0 -> {
                return "Tab 1"
            }
            1 -> {
                return "Tab 2"
            }
            2 -> {
                return "Tab 3"
            }
        }
        return super.getPageTitle(position)
    }*/

    override fun onClick(p0: View?) {


    }

}