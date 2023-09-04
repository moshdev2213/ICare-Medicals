package com.example.myapplication.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.Entity.Appointment
import com.example.myapplication.Entity.Doctor
import com.example.myapplication.R

class ConsultAdapter(
    private val consultCardClicked: (Appointment) -> Unit
): RecyclerView.Adapter<ConsultAdapterViewHolder>() {

    private val consultList = ArrayList<Appointment>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ConsultAdapterViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val listItem = layoutInflater.inflate(R.layout.counsult_item,parent,false)
        return ConsultAdapterViewHolder(listItem)
    }

    override fun getItemCount(): Int {
        return consultList.size
    }

    override fun onBindViewHolder(holder: ConsultAdapterViewHolder, position: Int) {
        holder.bind(consultList[position],consultCardClicked)
    }
    fun setList(appointment: List<Appointment>){
        consultList.clear()
        consultList.addAll(appointment)
        notifyDataSetChanged()
    }

}
class ConsultAdapterViewHolder(private val view: View):RecyclerView.ViewHolder(view){
    fun bind(appointment: Appointment,consultCardClicked:(Appointment)->Unit){
        val tvSpecDocAddress = view.findViewById<TextView>(R.id.tvSpecDocAddress)
        val cvMainConsCard = view.findViewById<CardView>(R.id.cvMainConsCard)
        val tvMainNameDis = view.findViewById<TextView>(R.id.tvMainNameDis)
        val tvSpecDocCard = view.findViewById<TextView>(R.id.tvSpecDocCard)
        val tvScanDate = view.findViewById<TextView>(R.id.tvScanDate)
        val tvScanTime = view.findViewById<TextView>(R.id.tvScanTime)

        tvSpecDocAddress.text = "Ad :"+appointment.venue.capitalize()
        tvMainNameDis.text = "Dr. "+appointment.docName.capitalize()
        tvSpecDocCard.text = "Charges : "+appointment.amount
        tvScanDate.text = appointment.date
        tvScanTime.text = appointment.time

        cvMainConsCard.setOnClickListener {
            consultCardClicked(appointment)
        }
    }
}