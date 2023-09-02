package com.example.myapplication.Fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.APIServices.DoctorAPI
import com.example.myapplication.Adapter.DoctorAdapter
import com.example.myapplication.DoctorDetails
import com.example.myapplication.Entity.Doctor
import com.example.myapplication.R
import com.example.myapplication.RetrofitService.RetrofitService
import com.facebook.shimmer.ShimmerFrameLayout
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DoctorFragment : Fragment() {
    private lateinit var rvFragDocList :RecyclerView
    private lateinit var adapter: DoctorAdapter
    private lateinit var shimmerDocFrag: ShimmerFrameLayout
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_doctor, container, false)
        shimmerDocFrag = view.findViewById(R.id.shimmerDocFrag)
        shimmerDocFrag.startShimmer()
        initRecyclerView(view)

        return view
    }
    private fun initRecyclerView(view: View){
        rvFragDocList = view.findViewById(R.id.rvFragDocList)
        rvFragDocList.layoutManager=LinearLayoutManager(requireContext())
        adapter = DoctorAdapter {
            doctor: Doctor ->doctorCardClicked(doctor)
        }
        rvFragDocList.adapter = adapter
        fetchData()
    }

    private fun doctorCardClicked(doctor: Doctor) {
        val bundle = Bundle()
        bundle.putSerializable("doctor", doctor)

        val intent = Intent(requireContext(),DoctorDetails::class.java)
        intent.putExtras(bundle)
        startActivity(intent)
    }

    private fun fetchData(){
        val retrofitService= RetrofitService()
        val getList =retrofitService.getRetrofit().create(DoctorAPI::class.java)

        val call:Call<List<Doctor>> = getList.getAllDoctors(1)
        call.enqueue(object :Callback<List<Doctor>>{
            override fun onResponse(call: Call<List<Doctor>>, response: Response<List<Doctor>>) {
                if(response.isSuccessful){
                    if (response.body()!=null){
                        adapter.setList(response.body()!!)
                        shimmerDocFrag.stopShimmer()
                        shimmerDocFrag.visibility = View.GONE
                        rvFragDocList.visibility = View.VISIBLE
                    }
                }else{
                    Toast.makeText(requireContext(),"Invalid response", Toast.LENGTH_SHORT).show()
                }
            }
            override fun onFailure(call: Call<List<Doctor>>, t: Throwable) {
                Toast.makeText(requireContext(),"Server Error", Toast.LENGTH_SHORT).show()
            }
        })

    }
}