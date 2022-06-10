package com.fictivestudios.tafcha.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.fictivestudios.tafcha.R
import com.fictivestudios.tafcha.adapters.TrainingAdapter
import com.fictivestudios.tafcha.Utils.Titlebar
import com.technado.demoapp.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_training.view.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [TrainingPageFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class TrainingFragment : BaseFragment() {
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

        titlebar.setMainTitle(
            getString(R.string.training),

            object:View.OnClickListener{
                override fun onClick(p0: View?) {
                    getActivityContext
                        ?.onBackPressed()
                }
            },
            R.drawable.btn_back_arrow,

            object:View.OnClickListener{
                override fun onClick(p0: View?) {
                    getActivityContext
                        ?.replaceFragment(
                            NotificationsFragment(),
                            NotificationsFragment.javaClass.simpleName,
                            true, true
                        )
                }
            },
            R.drawable.notify_icon
        )

      /*  titlebar.setTitle(getActivityContext!!, getString(R.string.training))

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
            })*/
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        mView = inflater.inflate(R.layout.fragment_training, container, false)

        initTrainingRecyclerview()





        return mView
    }

    private fun initTrainingRecyclerview()
    {


        val trainingList=ArrayList<String>()

        trainingList.add("lorem ipsum dolor sit amet, consectetur\n" +
                "adipisicing elit, sed do eiusmod tempor\n" +
                "incididunt ut labore et dolore magna\n" +
                "aliqua. Ut enim ad minim veniam, quis\n" +
                "nostrud exercitation ullamco laboris nisi\n" +
                "ut aliquip ex ea commodo consequat.\n" +
                "Sed ut perspiciatis unde omnis iste natus\n" +
                "error sit voluptatem accusantiue unde\n" +
                "doloremque laudantium lorem ipsum\n" +
                "dolor sit amet, consectetur adipisicing\n" +
                "elit, sed do eiusmod tempor voluptatem\n" +
                "incididunt ut labore et dolore magna\n" +
                "aliqua. Ut enim ad minim veniam, quis\n" +
                "nostrud exercitation ullamco laboris nisi\n" +
                "ut aliquip ex ea commodo consequat.\n" +
                "Sed ut perspiciatis unde omnis iste natus\n" +
                "error sit voluptatem accusantiue unde\n" +
                "doloremque laudantium ")


        trainingList.add("lorem ipsum dolor sit amet, consectetur\n" +
                "adipisicing elit, sed do eiusmod tempor\n" +
                "incididunt ut labore et dolore magna\n" +
                "aliqua. Ut enim ad minim veniam, quis\n" +
                "nostrud exercitation ullamco laboris nisi\n" +
                "ut aliquip ex ea commodo consequat.\n" +
                "Sed ut perspiciatis unde omnis iste natus\n" +
                "error sit voluptatem accusantiue unde\n" +
                "doloremque laudantium lorem ipsum\n" +
                "dolor sit amet, consectetur adipisicing\n" +
                "elit, sed do eiusmod tempor voluptatem\n" +
                "incididunt ut labore et dolore magna\n" +
                "aliqua. Ut enim ad minim veniam, quis\n" +
                "nostrud exercitation ullamco laboris nisi\n" +
                "ut aliquip ex ea commodo consequat.\n" +
                "Sed ut perspiciatis unde omnis iste natus\n" +
                "error sit voluptatem accusantiue unde\n" +
                "doloremque laudantium ")
        trainingList.add("lorem ipsum dolor sit amet, consectetur\n" +
                "adipisicing elit, sed do eiusmod tempor\n" +
                "incididunt ut labore et dolore magna\n" +
                "aliqua. Ut enim ad minim veniam, quis\n" +
                "nostrud exercitation ullamco laboris nisi\n" +
                "ut aliquip ex ea commodo consequat.\n" +
                "Sed ut perspiciatis unde omnis iste natus\n" +
                "error sit voluptatem accusantiue unde\n" +
                "doloremque laudantium lorem ipsum\n" +
                "dolor sit amet, consectetur adipisicing\n" +
                "elit, sed do eiusmod tempor voluptatem\n" +
                "incididunt ut labore et dolore magna\n" +
                "aliqua. Ut enim ad minim veniam, quis\n" +
                "nostrud exercitation ullamco laboris nisi\n" +
                "ut aliquip ex ea commodo consequat.\n" +
                "Sed ut perspiciatis unde omnis iste natus\n" +
                "error sit voluptatem accusantiue unde\n" +
                "doloremque laudantium ")

        trainingList.add("lorem ipsum dolor sit amet, consectetur\n" +
                "adipisicing elit, sed do eiusmod tempor\n" +
                "incididunt ut labore et dolore magna\n" +
                "aliqua. Ut enim ad minim veniam, quis\n" +
                "nostrud exercitation ullamco laboris nisi\n" +
                "ut aliquip ex ea commodo consequat.\n" +
                "Sed ut perspiciatis unde omnis iste natus\n" +
                "error sit voluptatem accusantiue unde\n" +
                "doloremque laudantium lorem ipsum\n" +
                "dolor sit amet, consectetur adipisicing\n" +
                "elit, sed do eiusmod tempor voluptatem\n" +
                "incididunt ut labore et dolore magna\n" +
                "aliqua. Ut enim ad minim veniam, quis\n" +
                "nostrud exercitation ullamco laboris nisi\n" +
                "ut aliquip ex ea commodo consequat.\n" +
                "Sed ut perspiciatis unde omnis iste natus\n" +
                "error sit voluptatem accusantiue unde\n" +
                "doloremque laudantium ")


        mView.rv_training.adapter = context?.let { TrainingAdapter(it,trainingList) }
        mView.rv_training.adapter?.notifyDataSetChanged()
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment TrainingFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            TrainingPageFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}