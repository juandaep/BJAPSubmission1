package com.example.bjapsubmission1.ui.home.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.bjapsubmission1.R
import com.example.bjapsubmission1.model.DataModel
import com.example.bjapsubmission1.ui.detail.DetailActivity
import com.example.bjapsubmission1.ui.home.content.ContentAdapter
import com.example.bjapsubmission1.ui.home.content.ContentCallback
import com.example.bjapsubmission1.ui.home.content.ContentViewModel
import com.example.bjapsubmission1.utils.Helper.TYPE_TV
import kotlinx.android.synthetic.main.fragment_movie.*
import kotlinx.android.synthetic.main.fragment_tv.*

class TvFragment : Fragment(), ContentCallback {

    private lateinit var viewModel: ContentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tv, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        activity?.let {
            viewModel = ViewModelProvider(it, ViewModelProvider.NewInstanceFactory())[ContentViewModel::class.java]
        }

        val listTv = viewModel.getListTv()
        setRecyclerView(listTv)
    }

    private fun setRecyclerView(listTv: List<DataModel>) {
        rv_tv.apply {
            layoutManager = GridLayoutManager(context, 2)
            adapter = ContentAdapter(this@TvFragment)
        }.also {
            it.adapter.let { adapter ->
                when (adapter) {
                    is ContentAdapter -> {
                        adapter.setListData(listTv)
                    }
                }
            }
        }
    }

    override fun onItemClicked(data: DataModel) {
        startActivity(
            Intent(context, DetailActivity::class.java)
                .putExtra(DetailActivity.EXTRA_DATA, data.id)
                .putExtra(DetailActivity.EXTRA_TYPE, TYPE_TV)
        )
    }
}