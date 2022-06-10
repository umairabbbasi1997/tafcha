package com.fictivestudios.tafcha.fragments

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.fictivestudios.tafcha.R
import com.fictivestudios.tafcha.Utils.Titlebar
import com.fictivestudios.tafcha.Utils.URIPathHelper
import com.github.dhaval2404.imagepicker.ImagePicker
import com.technado.demoapp.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_challenge_received_details.view.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ChallengeReceivedDetailsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ChallengeReceivedDetailsFragment : BaseFragment() {
    private val REQUEST_CODE_VIDEO: Int =157

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

        mView = inflater.inflate(R.layout.fragment_challenge_received_details, container, false)


        mView.btn_upload.setOnClickListener {
            openGalleryForVideo()
        }

        return mView
    }

    private fun openGalleryForVideo() {
        val intent = Intent()
        intent.type = "video/*"
        intent.action = Intent.ACTION_PICK
        startActivityForResult(Intent.createChooser(intent, "Select Video"),REQUEST_CODE_VIDEO)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK && requestCode == ImagePicker.REQUEST_CODE) {
            if (data?.data != null) {
                val uriPathHelper = URIPathHelper()
                val videoFullPath = uriPathHelper.getPath(requireContext(), data?.data!!) // Use this video path according to your logic
                // if you want to play video just after picking it to check is it working
                if (videoFullPath != null) {
                   // playVideoInDevicePlayer(videoFullPath);
                }
            }
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ChallengeReceivedDetailsFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ChallengeReceivedDetailsFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}