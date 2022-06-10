package com.fictivestudios.tafcha.dialogFragments

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.Spannable
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.fictivestudios.tafcha.R
import com.fictivestudios.tafcha.Utils.Constants
import com.fictivestudios.tafcha.Utils.PreferenceUtils
import com.fictivestudios.tafcha.Utils.Titlebar
import com.fictivestudios.tafcha.activities.MainActivity
import com.fictivestudios.tafcha.fragments.*
import com.technado.demoapp.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_dialogue_agreement.view.*
import kotlinx.android.synthetic.main.fragment_login.view.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [DialogueAgreement.newInstance] factory method to
 * create an instance of this fragment.
 */
class DialogueAgreement : BaseFragment() {
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

        mView = inflater.inflate(R.layout.fragment_dialogue_agreement, container, false)



        mView.btn_accept.setOnClickListener {

            if (!mView.tv_terms.isChecked && !mView.tv_privacy.isChecked)
            {
                Toast.makeText(context, getString(R.string.please_accept_terms), Toast.LENGTH_SHORT).show()
            }
            else
            {
                getRegisterationActivity?.
                replaceFragment(LoginFragment(),
                    LoginFragment.javaClass.simpleName,
                    true,true)
            }


        }

        mView.btn_reject.setOnClickListener {
            getRegisterationActivity?.onBackPressed()
        }


        mView.text_term.setOnClickListener {
            getRegisterationActivity?.
                    replaceFragment(TermsConditionsFragment(),
                    TermsConditionsFragment.javaClass.simpleName,
                    true,true)
        }

        mView.text_privacy.setOnClickListener {
            getRegisterationActivity?.
            replaceFragment(PrivacyPolicyFragment(),
                PrivacyPolicyFragment.javaClass.simpleName,
                true,true)
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
         * @return A new instance of fragment DialogueAgreement.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            DialogueAgreement().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}