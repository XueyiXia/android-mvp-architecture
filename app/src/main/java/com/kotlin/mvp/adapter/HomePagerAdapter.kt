package com.kotlin.mvp.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.kotlin.mvp.R
import com.kotlin.mvp.bean.HomeBean


class HomePagerAdapter(var context : Context, private val dataList: MutableList<HomeBean.Issue.Item>) : RecyclerView.Adapter<HomePagerAdapter.ItemViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_home_content, null)
        return ItemViewHolder(view)

    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        var bean:HomeBean.Issue.Item=dataList[position]
        //这里给子条目控件设置图片跟文字
        val defAvatar = R.mipmap.ic_launcher
        val cover = bean.data?.cover?.feed
        var avatar = bean.data?.author?.icon
        var tagText: String? = "#"

        // 加载封页图
        Glide.with(context)
            .load(cover)
            .placeholder(R.drawable.placeholder_banner)
            .transition(DrawableTransitionOptions().crossFade())
            .into(holder.iv_cover_feed)


        if (avatar.isNullOrEmpty()) {
            Glide.with(context)
                .load(defAvatar)
                .placeholder(R.mipmap.ic_launcher).circleCrop()
                .transition(DrawableTransitionOptions().crossFade())
                .into(holder.iv_avatar)

        } else {
            Glide.with(context)
                .load(avatar)
                .placeholder(R.mipmap.ic_launcher).circleCrop()
                .transition(DrawableTransitionOptions().crossFade())
                .into(holder.iv_avatar)
        }

        holder.tv_title.text = bean.data?.title ?: ""

        //遍历标签
        bean.data?.tags?.take(4)?.forEach {
            tagText += (it.name + "/")
        }
        // 格式化时间
        val timeFormat = durationFormat( bean.data?.duration)

        tagText += timeFormat

        holder.tv_tag.text = tagText!!

        holder.tv_category.text="#${bean.data?.category}"
    }

    override fun getItemCount(): Int {
        return dataList.size
    }



    fun durationFormat(duration: Long?): String {
        val minute = duration!! / 60
        val second = duration % 60
        return if (minute <= 9) {
            if (second <= 9) {
                "0$minute' 0$second''"
            } else {
                "0$minute' $second''"
            }
        } else {
            if (second <= 9) {
                "$minute' 0$second''"
            } else {
                "$minute' $second''"
            }
        }
    }

    fun setItemClickListener(l: ItemClickListener) {

    }



   class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var iv_cover_feed: ImageView
        var iv_avatar: ImageView
        var tv_title: TextView
        var tv_category: TextView

       var tv_tag: TextView

        init {
            iv_cover_feed = view.findViewById(R.id.iv_cover_feed)
            iv_avatar = view.findViewById(R.id.iv_avatar)
            tv_title = view.findViewById(R.id.tv_title)
            tv_category = view.findViewById(R.id.tv_category)
            tv_tag = view.findViewById(R.id.tv_tag)
        }


    }



    interface ItemClickListener {
        fun onClick(v: View, position: Int)
    }

    interface ItemLongClickListener {
        fun onClick(v: View, position: Int)
    }

    interface LabelClickListener {
        fun onClick(v: View, position: Int)
    }

}