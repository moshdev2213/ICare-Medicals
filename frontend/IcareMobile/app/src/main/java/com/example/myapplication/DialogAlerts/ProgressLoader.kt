package com.example.myapplication.DialogAlerts

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.Window
import android.widget.ProgressBar
import android.widget.TextView
import com.example.myapplication.R

class ProgressLoader(
    private val context: Context,
                     private val title:String,
                     private val description:String
) {
    var dialog = Dialog(context)

    fun startProgressLoader(){
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.progress_loader)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.setCancelable(false)

        val tvDescritionLoader = dialog.findViewById<TextView>(R.id.tvDescritionLoader)
        val tvTitleLoader = dialog.findViewById<TextView>(R.id.tvTitleLoader)
        val pbLoader = dialog.findViewById<ProgressBar>(R.id.pbLoader)

        tvDescritionLoader.text = description
        tvTitleLoader.text = title

        dialog.show()
    }
    fun dismissProgressLoader(){
        dialog.dismiss()
    }
}