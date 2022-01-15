package com.ir.texnalogies.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.ir.texnalogies.DegreeClass
import com.ir.texnalogies.R
import kotlinx.android.synthetic.main.dinamikview_degree.view.*

class DegreeAdapter(val context: Context, val degreeList: ArrayList<DegreeClass>) :
    BaseAdapter() {
    override fun getCount(): Int = degreeList.size

    override fun getItem(position: Int): Any {
        return position
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view: View
        if (convertView == null){
            view = LayoutInflater.from(parent?.context).inflate(R.layout.dinamikview_degree , parent , false)
        }else{
            view = convertView
        }
        view.tv_degree.text = degreeList[position].string
        view.image_degree.setImageResource(degreeList[position].int!!)
        return view
    }

}