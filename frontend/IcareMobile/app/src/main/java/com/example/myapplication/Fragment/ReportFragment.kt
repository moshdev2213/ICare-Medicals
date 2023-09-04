package com.example.myapplication.Fragment

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.APIServices.AppointmentAPI
import com.example.myapplication.APIServices.DoctorAPI
import com.example.myapplication.Adapter.ConsultAdapter
import com.example.myapplication.Entity.Appointment
import com.example.myapplication.Entity.Doctor
import com.example.myapplication.Entity.Patient
import com.example.myapplication.R
import com.example.myapplication.RetrofitService.RetrofitService
import com.facebook.shimmer.ShimmerFrameLayout
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ReportFragment : Fragment() {
    private lateinit var rvreportfrag:RecyclerView
    private lateinit var adapter: ConsultAdapter
    private lateinit var shimmerConsultFrag: ShimmerFrameLayout
    private lateinit var out: Patient
    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_report, container, false)

        out = arguments?.getSerializable("patientObject", Patient::class.java)!!
        shimmerConsultFrag = view.findViewById(R.id.shimmerConsultFrag)
        shimmerConsultFrag.startShimmer()
        initRecycler(view)
        return view
    }
    private fun initRecycler(view: View){
        rvreportfrag = view.findViewById(R.id.rvreportfrag)
        rvreportfrag.layoutManager= LinearLayoutManager(requireContext())
        adapter = ConsultAdapter {
                appointment:Appointment ->consultCardClicked(appointment)
        }
        rvreportfrag.adapter = adapter
        fetchData()
    }

    private fun fetchData() {
        val retrofitService= RetrofitService()
        val getList =retrofitService.getRetrofit().create(AppointmentAPI::class.java)

        val call: Call<List<Appointment>> = getList.getAllAppointments(out.email)
        call.enqueue(object : Callback<List<Appointment>> {
            override fun onResponse(call: Call<List<Appointment>>,response: Response<List<Appointment>>) {
                if(response.isSuccessful){
                    if (response.body()!=null){
                        adapter.setList(response.body()!!)
                        shimmerConsultFrag.stopShimmer()
                        shimmerConsultFrag.visibility = View.GONE
                        rvreportfrag.visibility = View.VISIBLE
                    }
                }else{
                    shimmerConsultFrag.stopShimmer()
                    shimmerConsultFrag.visibility = View.GONE
                    Toast.makeText(requireContext(),"Invalid response", Toast.LENGTH_SHORT).show()
                }
            }
            override fun onFailure(call: Call<List<Appointment>>, t: Throwable) {
                shimmerConsultFrag.stopShimmer()
                shimmerConsultFrag.visibility = View.GONE
                Toast.makeText(requireContext(),"Server Error", Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun consultCardClicked(appointment: Appointment) {
        Toast.makeText(requireContext(),"Clicked",Toast.LENGTH_SHORT).show()
    }

}