package com.minhaz_uddin.midtermproject.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.minhaz_uddin.midtermproject.R
import com.minhaz_uddin.midtermproject.adapter.NewsAdapter
import com.minhaz_uddin.midtermproject.viewModel.NewsViewModel

class ScienceFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewModel: NewsViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_science, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView=view.findViewById(R.id.science_recycler)
        recyclerView.layoutManager=LinearLayoutManager(requireContext())
        viewModel=ViewModelProvider(this)[NewsViewModel::class.java]
        viewModel.newsList2.observe(viewLifecycleOwner){
            recyclerView.adapter=NewsAdapter(requireContext(),viewModel, it)
        }

    }


}