package com.fictivestudios.tafcha.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.fictivestudios.tafcha.R
import com.fictivestudios.tafcha.Utils.Constants
import com.fictivestudios.tafcha.Utils.Titlebar
import com.fictivestudios.tafcha.activities.MainActivity
import com.fictivestudios.tafcha.dialogFragments.DialogueAgreement
import com.fictivestudios.tafcha.dialogFragments.SuccessDialogueFragment
import com.technado.demoapp.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_signup_trainer.view.*
import kotlinx.android.synthetic.main.fragment_signup_trainer.view.btn_back
import kotlinx.android.synthetic.main.fragment_signup_trainer.view.btn_signup
import kotlinx.android.synthetic.main.fragment_signup_trainer.view.et_confirm_pass
import kotlinx.android.synthetic.main.fragment_signup_trainer.view.et_email
import kotlinx.android.synthetic.main.fragment_signup_trainer.view.et_full_name
import kotlinx.android.synthetic.main.fragment_signup_trainer.view.et_pass


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SignupTrainerFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SignupTrainerFragment : BaseFragment() {
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

        mView = inflater.inflate(R.layout.fragment_signup_trainer, container, false)


        mView?.btn_signup?.setOnClickListener {

            validateFields()

        }
        mView.btn_back.setOnClickListener {
            getRegisterationActivity?.
            onBackPressed()
        }
        return mView



    }
    private fun validateFields() {

        if (mView.et_full_name.text.toString().isNullOrBlank()||
            mView.et_email.text.toString().isNullOrBlank()||
            mView.et_pass.text.toString().isNullOrBlank()||
            mView.et_confirm_pass.text.toString().isNullOrBlank()
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
        if (!mView.et_pass.text.toString().equals(mView.et_confirm_pass.text.toString()) )
        {
            mView.et_confirm_pass.setError(getString(R.string.confirm_pass_doesnt_match))

            return
        }

        else
        {
            getRegisterationActivity?.
            AddFragment(SuccessDialogueFragment(getString( R.string.congrats_your_acc__),
                object:View.OnClickListener{
                    override fun onClick(p0: View?) {
                        startActivity(Intent(context,MainActivity::class.java))
                        getRegisterationActivity?.finish()
                    }
                }

            ),
                SuccessDialogueFragment.javaClass.simpleName,
                true,false)




        }
    }
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment SignupTrainerFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SignupTrainerFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}