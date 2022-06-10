package com.fictivestudios.tafcha.fragments

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.Settings
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.fictivestudios.tafcha.R
import com.fictivestudios.tafcha.Utils.Titlebar
import com.fictivestudios.tafcha.Utils.URIPathHelper
import com.fictivestudios.tafcha.dialogFragments.SuccessDialogueFragment
import com.github.dhaval2404.imagepicker.ImagePicker.Companion.REQUEST_CODE
import com.technado.demoapp.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_upload_challeng.view.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [UploadChallengFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class UploadChallengFragment : BaseFragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    var REQUEST_CODE_VIDEO = 15

    private lateinit var mView: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun setTitlebar(titlebar: Titlebar) {
        titlebar.setTitle(getActivityContext!!, getString(R.string.challenge))

        titlebar.setBtnBack(
            object:View.OnClickListener{
                override fun onClick(p0: View?) {
                    getActivityContext
                        ?.onBackPressed()
                }
            }
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        mView = inflater.inflate(R.layout.fragment_upload_challeng, container, false)

        mView.btn_upload.setOnClickListener {


            openGalleryForVideo()
        }

        mView.iv_upload.setOnClickListener {
            openGalleryForVideo()
        }

        mView.btn_challenge_friend.setOnClickListener {

            getActivityContext?.

            AddFragment(ChallengeFriendsFragment(),
                ChallengeFriendsFragment.javaClass.simpleName,
                true,true)

    /*        AddFragment(
                SuccessDialogueFragment(getString( R.string.thank_you_your_challenge_has_been_sent),

                    object:View.OnClickListener{
                        override fun onClick(p0: View?) {
                            getActivityContext
                                ?.onBackPressed()
                        }
                    }
                ),
                SuccessDialogueFragment.javaClass.simpleName,
                true,false)*/

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
        if (resultCode == Activity.RESULT_OK && requestCode == REQUEST_CODE) {
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

    fun playVideoInDevicePlayer(videoPath: String) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(videoPath))
        intent.setDataAndType(Uri.parse(videoPath), "video/mp4")
        startActivity(intent)
    }
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment UploadChallengFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            UploadChallengFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}