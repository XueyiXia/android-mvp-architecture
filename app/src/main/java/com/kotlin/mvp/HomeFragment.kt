package com.kotlin.mvp

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.framework.mvp.base.BaseFragment
import com.framework.mvp.dialog.CustomLoadingView
import com.kotlin.mvp.adapter.HomePagerAdapter
import com.kotlin.mvp.bean.HomeBean
import com.kotlin.mvp.mvp_contract.HomeContract
import com.kotlin.mvp.mvp_presenter.HomePresenter

/**
 * @author: xiaxueyi
 * @date: 2022-12-09
 * @time: 15:34
 * @说明:
 */

class HomeFragment :BaseFragment<HomePresenter>() , HomeContract.View{

    private lateinit var mRecyclerView: RecyclerView

    private lateinit var mCustomLoadingView: CustomLoadingView

    private var mHomeAdapter: HomePagerAdapter? = null

    private var dataList: MutableList<HomeBean.Issue.Item> = mutableListOf()


    private val linearLayoutManager by lazy {
        LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
    }


    override fun createPresenter(): HomePresenter {
        return HomePresenter()
    }

    override fun getLayoutResId(): Int {
        return R.layout.fragment_home
    }

    override fun initView(rootView: View, savedInstanceState: Bundle?) {
        mRecyclerView=rootView.findViewById(R.id.recycler_view)
        mCustomLoadingView=rootView.findViewById(R.id.loading_view)
        mHomeAdapter=HomePagerAdapter(rootView.context, dataList )
        mRecyclerView.adapter = mHomeAdapter
        mRecyclerView.layoutManager = linearLayoutManager
        mRecyclerView.itemAnimator = DefaultItemAnimator()

        mPresenter.requestHome(1)
        mCustomLoadingView.show()
    }


    override fun onSuccess(bean: HomeBean) {
        println(bean)
        dataList.addAll( bean.issueList[0].itemList)
        mHomeAdapter?.notifyItemRangeChanged(0,bean.issueList[0].itemList.size)
        mCustomLoadingView.dismiss()
    }

    override fun onLError(`object`: Any?) {
        mCustomLoadingView.dismiss()
        mCustomLoadingView.setErrorText(resources.getString(com.framework.mvp.R.string.load_failed),object :View.OnClickListener{

            override fun onClick(v: View?) {
                mPresenter.requestHome(1)
            }
        })
    }
}