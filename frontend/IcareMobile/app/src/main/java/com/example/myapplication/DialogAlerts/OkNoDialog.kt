package com.example.myapplication.DialogAlerts

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.View
import android.view.Window
import android.widget.Button
import android.widget.TextView
import com.example.myapplication.R

class OkNoDialog(
    private val context: Context
) {
    private var dialog = Dialog(context)
    private lateinit var  tvDescription : TextView
    private lateinit var btnDialogSuccess : Button
//    private lateinit var btnDialogCAncel : Button

    fun dialogWithSuccess(description: String,onDismiss: () -> Unit) {

        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.ok_no_dialog)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        tvDescription = dialog.findViewById(R.id.tvDescription)
        btnDialogSuccess = dialog.findViewById(R.id.btnDialogSuccess)
//        btnDialogCAncel = dialog.findViewById(R.id.btnDialogCAncel)

        tvDescription.text = description
//        btnDialogCAncel.visibility=View.GONE
        btnDialogSuccess.setOnClickListener {
            onDismiss()
            dialog.dismiss()
        }
        dialog.show()
    }
}