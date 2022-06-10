package com.fictivestudios.tafcha.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.fictivestudios.tafcha.R
import com.fictivestudios.tafcha.Utils.Constants.Companion.IS_USER
import com.fictivestudios.tafcha.Utils.PreferenceUtils
import com.fictivestudios.tafcha.adapters.LanguageAdapter
import com.fictivestudios.tafcha.Utils.Titlebar
import com.fictivestudios.tafcha.activities.RegisterationActivity
import com.technado.demoapp.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_settings.view.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SettingsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SettingsFragment : BaseFragment() {
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
        titlebar.setTitle(getActivityContext!!, getString(R.string.settings))

        titlebar.setBtnBack(
            object:View.OnClickListener{
                override fun onClick(p0: View?) {
                    getActivityContext
                        ?.onBackPressed()
                }
            }
        )


        titlebar.setBtnRightUser(R.drawable.user_dp,
            object:View.OnClickListener{
                override fun onClick(p0: View?) {
                    if (PreferenceUtils.getBoolean(IS_USER))
                    {
                        getActivityContext
                            ?.replaceFragment(
                                ProfileUserFragment(),
                                ProfileUserFragment.javaClass.simpleName,
                                true, true
                            )
                    }
                    else
                    {
                        getActivityContext
                        ?.replaceFragment(
                            TrainerMyProfileFragment(),
                            TrainerMyProfileFragment.javaClass.simpleName,
                            true, true
                        )

                    }

                }
            })
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        mView = inflater.inflate(R.layout.fragment_settings, container, false)


        mView.btn_password_reset.setOnClickListener {

            getActivityContext?.
            replaceFragment(UpdatePasswordFragment(),
                UpdatePasswordFragment.javaClass.simpleName,
                true,false)

        }
        mView.btn_logout.setOnClickListener {
            startActivity(Intent(context, RegisterationActivity::class.java))
            getActivityContext?.finish()
        }
        initLanguageSpinner()

        return mView
    }

    private fun initLanguageSpinner()
    {

        val languageList=ArrayList<String>()
        languageList.add("English")
        languageList.add("English")
        languageList.add("English")


        mView.sp_language.adapter = context?.let { LanguageAdapter(it,languageList) }


    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment SettingsFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SettingsFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}