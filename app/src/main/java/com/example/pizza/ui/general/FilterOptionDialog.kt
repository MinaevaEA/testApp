package com.example.pizza.ui.general

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.view.*
import androidx.fragment.app.DialogFragment
import com.example.pizza.R


class FilterOptionDialog: DialogFragment() {
          override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            return inflater.inflate(R.layout.fragment_dialog, container, false)
        }

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)
          //  setupView(view)
         //   setupClickListeners(view)
        }

        override fun onStart() {
            super.onStart()
            val window = dialog?.window
            window?.setGravity(Gravity.BOTTOM)
            val params = window?.attributes
            params?.x = 300
            params?.y = 0
            window?.attributes = params
            dialog?.window?.attributes
            dialog?.window?.setLayout(
               WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.MATCH_PARENT
            )
        }

      /*  private fun setupView(view: View) {
           // view.tvTitle.text = arguments?.getString(KEY_TITLE)
          //  view.tvSubTitle.text = arguments?.getString(KEY_SUBTITLE)
        }

        private fun setupClickListeners(view: View) {
        //    view.btnPositive.setOnClickListener {
                // TODO: Do some task here
            //    dismiss()
            }
            view.btnNegative.setOnClickListener {
                // TODO: Do some task here
                dismiss()
            }*/
       // }
    }
