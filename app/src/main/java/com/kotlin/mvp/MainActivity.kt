package com.kotlin.mvp

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.framework.mvp.base.BaseActivity
import com.kotlin.mvp.adapter.HomePagerAdapter
import com.kotlin.mvp.bean.HomeBean
import com.kotlin.mvp.mvp_contract.HomeContract
import com.kotlin.mvp.mvp_presenter.HomePresenter

class MainActivity : BaseActivity<HomePresenter>(),HomeContract.View {

    private lateinit var mRecyclerView: RecyclerView

    private var mHomeAdapter: HomePagerAdapter? = null

    private var dataList: MutableList<HomeBean.Issue.Item> = mutableListOf()


    private val linearLayoutManager by lazy {
        LinearLayoutManager(MainActivity@this, LinearLayoutManager.VERTICAL, false)
    }

    override fun createPresenter(): HomePresenter {
        return HomePresenter()
    }

    override fun getLayoutResId(): Int {
        return R.layout.activity_main
    }

    override fun initView(rootView: View, savedInstanceState: Bundle?) {
        mRecyclerView=findViewById(R.id.recycler_view)

        mHomeAdapter=HomePagerAdapter(this, dataList )
        mRecyclerView.adapter = mHomeAdapter
        mRecyclerView.layoutManager = linearLayoutManager
        mRecyclerView.itemAnimator = DefaultItemAnimator()

        mPresenter.requestHome(1)
    }

    override fun onSuccess(bean: HomeBean) {
        println(bean)
        dataList.addAll( bean.issueList[0].itemList)
        mHomeAdapter?.notifyItemRangeChanged(0,bean.issueList[0].itemList.size)

    }

    override fun onLError(`object`: Any?) {
        println(`object`)
    }
}