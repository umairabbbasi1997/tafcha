package com.fictivestudios.tafcha.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.fictivestudios.tafcha.R
import com.fictivestudios.tafcha.Utils.Titlebar
import com.fictivestudios.tafcha.dialogFragments.SuccessDialogueFragment
import com.technado.demoapp.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_reset_password.view.*
import kotlinx.android.synthetic.main.fragment_reset_password.view.et_confirm_pass
import kotlinx.android.synthetic.main.fragment_reset_password.view.et_pass


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ResetPasswordFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ResetPasswordFragment : BaseFragment() {
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
        titlebar.setTitle(getActivityContext!!, getString(R.string.reset_password))

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


        mView = inflater.inflate(R.layout.fragment_reset_password, container, false)

        mView.btn_continue.setOnClickListener {

            validatePassword()

        }
      /*  mView.btn_back.setOnClickListener {
            getActivityContext?.
            onBackPressed()
        }
*/

        return mView

    }

    private fun validatePassword() {

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
        else{



            getRegisterationActivity?.
            AddFragment(
                SuccessDialogueFragment(getString( R.string.password_reset_successfull),
                    object:View.OnClickListener{
                        override fun onClick(p0: View?) {
                            getRegisterationActivity
                                ?.replaceFragment(LoginFragment(),
                                LoginFragment.javaClass.simpleName,
                                false,true)
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
         * @return A new instance of fragment ResetPasswordFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ResetPasswordFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}