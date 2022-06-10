package com.fictivestudios.tafcha.fragments

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.Spannable
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.text.style.ForegroundColorSpan
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.fictivestudios.tafcha.R
import com.fictivestudios.tafcha.Utils.Constants
import com.fictivestudios.tafcha.Utils.Constants.Companion.IS_USER
import com.fictivestudios.tafcha.Utils.PreferenceUtils
import com.fictivestudios.tafcha.activities.MainActivity
import com.fictivestudios.tafcha.Utils.Titlebar
import com.technado.demoapp.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_login.view.*
import kotlinx.android.synthetic.main.fragment_login.view.btn_back
import kotlinx.android.synthetic.main.fragment_login.view.et_email
import kotlinx.android.synthetic.main.fragment_login.view.et_pass



// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [LoginFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LoginFragment : BaseFragment() {
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
        mView = inflater.inflate(R.layout.fragment_login, container, false)


        mView.tv_Link_signup.setMovementMethod(LinkMovementMethod.getInstance())
        val spans: Spannable =  mView.tv_Link_signup.getText() as Spannable
        val clickSpan: ClickableSpan = object : ClickableSpan() {

            override fun onClick(widget: View) {

                if (PreferenceUtils.getBoolean(IS_USER))
                {
                    getRegisterationActivity()?.
                    replaceFragment(SignupUserFragment(),SignupUserFragment().javaClass.simpleName,true,true)

                }
                else
                {
                    getRegisterationActivity()?.
                    replaceFragment(SignupTrainerFragment(),SignupTrainerFragment().javaClass.simpleName,true,true)

                }

            }
        }
        spans.setSpan( clickSpan, 23, spans.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)





        mView?.btn_login?.setOnClickListener {

            validateFields()

        }
        mView.btn_back.setOnClickListener {
            getRegisterationActivity?.
            onBackPressed()
        }

        mView.tv_forget_pass.setOnClickListener {

            getRegisterationActivity?.
            replaceFragment(ForgotPasswordFragment(),ForgotPasswordFragment().javaClass.simpleName,true,true)

        }

        return mView

    }

    private fun validateFields() {

        if (mView.et_email.text.toString().isNullOrBlank()&&
            mView.et_pass.text.toString().isNullOrBlank()
             )
        {
            Toast.makeText(context, getString(R.string.fields_cant_be_empty), Toast.LENGTH_SHORT).show()
            return
        }

        if (!Constants.isValidEmail(mView.et_email.text.toString()))
        {
            mView.et_email.setError(getString(R.string.invalid_email_format))
            return
        }
        if (mView.et_pass.text.toString().length <8 )
        {
            mView.et_pass.setError(getString(R.string.password_must_be))
            return
        }
        else
        {
            startActivity(Intent(context, MainActivity::class.java))
            getRegisterationActivity?.finish()
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment LoginFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            LoginFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}