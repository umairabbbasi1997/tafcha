package com.fictivestudios.tafcha.fragments

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.fictivestudios.tafcha.R
import com.fictivestudios.tafcha.Utils.Constants.Companion.isValidEmail
import com.fictivestudios.tafcha.Utils.DatePickerHelper
import com.fictivestudios.tafcha.activities.MainActivity
import com.fictivestudios.tafcha.Utils.Titlebar
import com.fictivestudios.tafcha.dialogFragments.DialogueAgreement
import com.github.dhaval2404.imagepicker.ImagePicker
import com.technado.demoapp.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_setup_profile_trainer.view.*
import kotlinx.android.synthetic.main.fragment_signup_user.view.*
import kotlinx.android.synthetic.main.fragment_signup_user.view.btn_back
import kotlinx.android.synthetic.main.fragment_signup_user.view.et_dob
import kotlinx.android.synthetic.main.fragment_signup_user.view.et_full_name
import kotlinx.android.synthetic.main.fragment_signup_user.view.et_phone
import kotlinx.android.synthetic.main.fragment_signup_user.view.et_wieght
import kotlinx.android.synthetic.main.fragment_signup_user.view.imgLogo
import java.util.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SignupUserFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SignupUserFragment : BaseFragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var mView: View
    lateinit var datePicker: DatePickerHelper
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

        mView = inflater.inflate(R.layout.fragment_signup_user, container, false)


         datePicker = DatePickerHelper(requireContext(),true)



        mView?.et_wieght.setOnClickListener {

            getRegisterationActivity()?.
            replaceFragment(HeightFragment(),
                HeightFragment().javaClass.simpleName,
                true,true)
        }

        mView?.btn_signup.setOnClickListener {

            validateFields()


        }

        mView.et_dob.setOnClickListener {
            showDatePickerDialog()
        }

        mView.imgLogo.setOnClickListener {

            ImagePicker.with(this)
                .galleryMimeTypes(arrayOf(""))
                .crop()	    			//Crop image(Optional), Check Customization for more option
                .compress(1024)			//Final image size will be less than 1 MB(Optional)
                .maxResultSize(1080, 1080)	//Final image resolution will be less than 1080 x 1080(Optional)
                .start()
        }

        mView.btn_back.setOnClickListener {
            getRegisterationActivity?.
            onBackPressed()
        }
        return mView


    }
    private fun showDatePickerDialog() {
        val cal = Calendar.getInstance()
        val d = cal.get(Calendar.DAY_OF_MONTH)
        val m = cal.get(Calendar.MONTH)
        val y = cal.get(Calendar.YEAR)
        datePicker.showDialog(d, m, y, object : DatePickerHelper.Callback {
            override fun onDateSelected(dayofMonth: Int, month: Int, year: Int) {
                val dayStr = if (dayofMonth < 10) "0${dayofMonth}" else "${dayofMonth}"
                val mon = month + 1
                val monthStr = if (mon < 10) "0${mon}" else "${mon}"
                mView.et_dob.setText("${dayStr}-${monthStr}-${year}")
            }
        })
    }

    private fun validateFields() {

        if (mView.et_full_name.text.toString().isNullOrBlank()||
            mView.et_email.text.toString().isNullOrBlank()||
            mView.et_pass.text.toString().isNullOrBlank()||
            mView.et_confirm_pass.text.toString().isNullOrBlank()||
            mView.et_phone.text.toString().isNullOrBlank()
                )
        {
            Toast.makeText(context, getString(R.string.fields_cant_be_empty), Toast.LENGTH_SHORT).show()
            return
        }

        if (!isValidEmail(mView.et_email.text.toString()))
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
            AddFragment(
                DialogueAgreement(),
                DialogueAgreement.javaClass.simpleName,
                true,false)
        }
    }




    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == Activity.RESULT_OK) {
            //Image Uri will not be null for RESULT_OK
            val fileUri: Uri = data?.data!!

            // Use Uri object instead of File to avoid storage permissions
            mView.imgLogo.setImageURI(fileUri)
        } else if (resultCode == ImagePicker.RESULT_ERROR) {
            Toast.makeText(context, ImagePicker.getError(data), Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(context, "Task Cancelled", Toast.LENGTH_SHORT).show()
        }
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment SignupFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SignupUserFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}