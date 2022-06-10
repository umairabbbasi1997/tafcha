package com.fictivestudios.tafcha.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.fictivestudios.tafcha.R
import com.fictivestudios.tafcha.Utils.Constants
import com.fictivestudios.tafcha.Utils.Constants.Companion.IS_USER
import com.fictivestudios.tafcha.Utils.PreferenceUtils
import com.fictivestudios.tafcha.Utils.SharedPref
import com.fictivestudios.tafcha.Utils.Titlebar
import com.technado.demoapp.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_select_user.view.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SelectUserFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SelectUserFragment : BaseFragment() {
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

        mView = inflater.inflate(R.layout.fragment_select_user, container, false)

        mView?.btn_user.setOnClickListener {

            PreferenceUtils.saveBoolean(IS_USER,true)

            getRegisterationActivity()?.
            replaceFragment(PreLoginFragment(),PreLoginFragment().javaClass.simpleName,true,true)


        }
        mView?.btn_trainer.setOnClickListener {

            PreferenceUtils.saveBoolean(IS_USER,false)
            getRegisterationActivity()?.
            replaceFragment(PreLoginFragment(),PreLoginFragment().javaClass.simpleName,true,true)



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
         * @return A new instance of fragment SelectUserFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SelectUserFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}