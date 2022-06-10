package com.fictivestudios.tafcha.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.fictivestudios.tafcha.R
import com.fictivestudios.tafcha.activities.MainActivity
import com.fictivestudios.tafcha.Utils.Titlebar
import com.technado.demoapp.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_verification.view.*
import android.os.CountDownTimer
import android.text.Spannable
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import com.fictivestudios.tafcha.Utils.Constants
import com.fictivestudios.tafcha.Utils.PreferenceUtils
import kotlinx.android.synthetic.main.fragment_login.view.*
import kotlinx.android.synthetic.main.fragment_verification.view.btn_back


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [VerificationFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class VerificationFragment : BaseFragment() {
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

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_verification, container, false)

        startCountDown(45000)

        mView?.btn_continue.setOnClickListener {

            getRegisterationActivity?.
            replaceFragment(ResetPasswordFragment(),
                ResetPasswordFragment.javaClass.simpleName,
                true,true)


        }

        mView.btn_back.setOnClickListener {
            getRegisterationActivity?.onBackPressed()
        }




        mView.tv_Link_resend.setMovementMethod(LinkMovementMethod.getInstance())
        val spans: Spannable =  mView.tv_Link_resend.getText() as Spannable
        val clickSpan: ClickableSpan = object : ClickableSpan() {


            override fun onClick(widget: View) {


            }
        }
        spans.setSpan(clickSpan, 20, spans.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)

        return mView
    }

    private fun startCountDown(startTime:Long)
    {

        object : CountDownTimer(startTime, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                mView.tv_timer.setText("00:" +millisUntilFinished / 1000)
                mView.circularProgressBar.setProgressWithAnimation(100f,4500)
                mView.circularProgressBar.progressMax = 100f
/*
                progress = 65f
                // or with animation
                setProgressWithAnimation(65f, 1000) // =1s

                // Set Progress Max
                progressMax = 200f*/

            }

            override fun onFinish() {

            }
        }.start()
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment VerificationFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            VerificationFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}