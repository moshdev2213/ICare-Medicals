package com.example.myapplication.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.Entity.Doctor
import com.example.myapplication.R
import java.util.Locale

class DoctorAdapter(
    private val doctorCardClicked: (Doctor) -> Unit
):RecyclerView.Adapter<DoctorViewHolder>() {

    private val doctorList = ArrayList<Doctor>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DoctorViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val listItem = layoutInflater.inflate(R.layout.doctor_item,parent,false)
        return DoctorViewHolder(listItem)
    }

    override fun getItemCount(): Int {
        return doctorList.size
    }

    override fun onBindViewHolder(holder: DoctorViewHolder, position: Int) {
        holder.bind(doctorList[position],doctorCardClicked)
    }
    fun setList(doctor: List<Doctor>){
        doctorList.clear()
        doctorList.addAll(doctor)
        notifyDataSetChanged()
    }
}
class DoctorViewHolder(private val view: View):RecyclerView.ViewHolder(view){
    fun bind(doctor: Doctor,doctorCardClicked:(Doctor)->Unit){
        val tvDocSpecializing = view.findViewById<TextView>(R.id.tvDocSpecializing)
        val imgDoctorPic = view.findViewById<ImageView>(R.id.imgDoctorPic)
        val cvDoctorCard = view.findViewById<CardView>(R.id.cvDoctorCard)
        val tvDoctorName = view.findViewById<TextView>(R.id.tvDoctorName)
        val tvDocSpecializing2 = view.findViewById<TextView>(R.id.tvDocSpecializing2)

        tvDoctorName.text = doctor.firstName.uppercase()
        tvDocSpecializing.text = doctor.specializing
        tvDocSpecializing2.text = doctor.email

        cvDoctorCard.setOnClickListener {
            doctorCardClicked(doctor)
        }
    }

}