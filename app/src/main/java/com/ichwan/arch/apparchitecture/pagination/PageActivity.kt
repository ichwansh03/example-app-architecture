package com.ichwan.arch.apparchitecture.pagination

import android.graphics.pdf.PdfDocument.Page
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ichwan.arch.apparchitecture.R
import com.ichwan.arch.apparchitecture.databinding.ActivityPageBinding

class PageActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPageBinding
    private var arrayList = ArrayList<PageModels>()
    private var data = arrayOf("A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P")
    private var data2 = arrayOf("1","2","3","4","5","6","7","8","9","10")
    private var loading = true

    private var pastVisibleItems = 0
    private var visibleItemCount = 0
    private var totalItemCount = 0

    private var manager: LinearLayoutManager? = null
    private lateinit var adapter: PageAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = PageAdapter(getData())
        manager = LinearLayoutManager(this)
        binding.apply {
            rvPage.layoutManager = manager
            rvPage.itemAnimator = DefaultItemAnimator()
            rvPage.addItemDecoration(
                DividerItemDecoration(this@PageActivity, LinearLayoutManager.VERTICAL)
            )

            rvPage.adapter = adapter
            setupPagination()
        }

    }

    private fun setupPagination() {
        binding.rvPage.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                if (dy > 0){
                    visibleItemCount = manager!!.childCount
                    totalItemCount = manager!!.itemCount
                    pastVisibleItems = manager!!.findFirstVisibleItemPosition()
                    if (loading && (visibleItemCount + pastVisibleItems) >= totalItemCount) {
                        loading = false
                        Toast.makeText(this@PageActivity, "this is the last item!", Toast.LENGTH_SHORT).show()
                        getData2()
                        adapter.notifyDataSetChanged()
                        loading = true
                    }
                }
            }
        })
    }

    private fun getData(): ArrayList<PageModels>{
        for (i in data.indices){
            arrayList.add(PageModels(data[i]))
        }

        return arrayList
    }

    private fun getData2(): ArrayList<PageModels>{
        for (i in data2.indices){
            arrayList.add(PageModels(data2[i]))
        }

        return arrayList
    }
}