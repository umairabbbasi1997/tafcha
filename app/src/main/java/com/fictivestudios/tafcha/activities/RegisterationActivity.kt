package com.fictivestudios.tafcha.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fictivestudios.tafcha.R
import com.fictivestudios.tafcha.fragments.SelectUserFragment
import com.technado.demoapp.base.BaseActivity

class RegisterationActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registeration)

        setMainFrameLayoutID()
        replaceFragment(SelectUserFragment(),SelectUserFragment.javaClass.simpleName,true,false)
    }

    override fun setMainFrameLayoutID() {
      mainFrameLayoutID = R.id.register_container
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }
}