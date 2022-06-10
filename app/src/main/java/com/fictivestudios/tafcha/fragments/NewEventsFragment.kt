package com.fictivestudios.tafcha.fragments

import android.app.TimePickerDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TimePicker
import com.fictivestudios.tafcha.R
import com.fictivestudios.tafcha.Utils.DatePickerHelper
import com.fictivestudios.tafcha.Utils.Titlebar
import com.fictivestudios.tafcha.adapters.InviteUsersAdapter
import com.fictivestudios.tafcha.dialogFragments.SuccessDialogueFragment
import com.technado.demoapp.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_new_events.view.*
import java.util.*
import kotlin.collections.ArrayList

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [NewEventsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class NewEventsFragment : BaseFragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    lateinit var datePicker: DatePickerHelper

    private lateinit var mView: View
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun setTitlebar(titlebar: Titlebar) {
        titlebar.setTitle(getActivityContext!!, getString(R.string.events))
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

        mView = inflater.inflate(R.layout.fragment_new_events, container, false)

        datePicker = DatePickerHelper(requireContext(),true)

        mView.btn_create_new.setOnClickListener {
            getActivityContext
                ?.AddFragment(
                    SuccessDialogueFragment(getString(R.string.your_event_has_been_created),
                        object:View.OnClickListener{
                            override fun onClick(p0: View?) {
                                getActivityContext
                                    ?.onBackPressed()
                            }
                        }

                    ),
                    SuccessDialogueFragment.javaClass.simpleName,
                    true, false
                )

        }

        mView.date.setOnClickListener {
            showDatePickerDialog()
        }

        mView.time.setOnClickListener {
            timePicker()
        }

        initUsersRecyclerview()

        return mView

    }

    private fun timePicker()
    {
        val mTimePicker: TimePickerDialog
        val mcurrentTime = Calendar.getInstance()
        val hour = mcurrentTime.get(Calendar.HOUR_OF_DAY)
        val minute = mcurrentTime.get(Calendar.MINUTE)

        mTimePicker = TimePickerDialog(context, object : TimePickerDialog.OnTimeSetListener {
            override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int) {
                mView.time.setText(String.format("%d : %d", hourOfDay, minute))
            }
        }, hour, minute, false)

        mView.time.setOnClickListener({ v ->
            mTimePicker.show()
        })
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
                mView.time.setText("${dayStr}-${monthStr}-${year}")
            }
        })
    }

    private fun initUsersRecyclerview()
    {

        val usersList=ArrayList<String>()
        usersList.add("")
        usersList.add("")
        usersList.add("")

        mView.rv_invite_users_event.adapter = context?.let { InviteUsersAdapter(it,usersList) }
        mView.rv_invite_users_event.adapter?.notifyDataSetChanged()

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment NewEventsFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            NewEventsFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}