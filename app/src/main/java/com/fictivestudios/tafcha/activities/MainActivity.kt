package com.fictivestudios.tafcha.activities

import android.os.Bundle
import android.util.Log
import com.fictivestudios.tafcha.R
import com.fictivestudios.tafcha.Utils.Constants.Companion.IS_USER
import com.fictivestudios.tafcha.Utils.PreferenceUtils
import com.fictivestudios.tafcha.adapters.UserMenuAdapter
import com.fictivestudios.tafcha.Utils.Titlebar
import com.fictivestudios.tafcha.adapters.TrainerMenuAdapter
import com.fictivestudios.tafcha.fragments.HomeFragment

import com.technado.demoapp.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : BaseActivity() {




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        setMainFrameLayoutID()
        replaceFragment(HomeFragment(), HomeFragment.javaClass.simpleName,false,false)

       // setViewPager()




     //   tabDots.setupWithViewPager(viewPagerMain)


    }

    private fun setViewPager() {
        if(PreferenceUtils.getBoolean(IS_USER))
        {
            viewPagerMain.adapter = UserMenuAdapter(supportFragmentManager)
        }
        else
        {
            viewPagerMain.adapter = TrainerMenuAdapter(supportFragmentManager)
        }
    }

    override fun setMainFrameLayoutID() {

       mainFrameLayoutID = R.id.main_view_container
    }

    fun getTitlebar(): Titlebar {
        return main_title_bar
    }


    override fun onResume() {
        super.onResume()
        Log.d("onResume","onResume()")
    }


    override fun onBackPressed() {
        super.onBackPressed()
    }

}