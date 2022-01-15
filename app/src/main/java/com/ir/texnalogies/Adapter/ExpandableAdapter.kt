package com.ir.texnalogies.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import android.widget.Toast
import com.ir.texnalogies.MainActivity3
import com.ir.texnalogies.Object.Object
import com.ir.texnalogies.R
import com.ir.texnalogies.UserData.ForUserData
import kotlinx.android.synthetic.main.dinamikview_chiled.view.*
import kotlinx.android.synthetic.main.dinamikview_todolist.view.*

class ExpandableAdapter(var titleLis: ArrayList<String>, var map: HashMap<String, ArrayList<String>> ,var context: Context) :
    BaseExpandableListAdapter() {
    override fun getGroupCount(): Int = titleLis.size

    override fun getChildrenCount(groupPosition: Int): Int = map[titleLis[groupPosition]]!!.size

    override fun getGroup(groupPosition: Int): Any = titleLis[groupPosition]

    override fun getChild(groupPosition: Int, childPosition: Int): Any =
        map[titleLis[groupPosition]]!![childPosition]

    override fun getGroupId(groupPosition: Int): Long = groupPosition.toLong()

    override fun getChildId(groupPosition: Int, childPosition: Int): Long = childPosition.toLong()

    override fun hasStableIds(): Boolean = false

    override fun getGroupView(
        groupPosition: Int,
        isExpanded: Boolean,
        convertView: View?,
        parent: ViewGroup?
    ): View {
        val itemView: View
        if (convertView == null) {
            itemView = LayoutInflater.from(parent?.context)
                .inflate(R.layout.dinamikview_todolist, parent, false)
        } else {
            itemView = convertView
        }

        itemView.tv_todolistName.text = titleLis[groupPosition]

        return itemView
    }

    override fun getChildView(
        groupPosition: Int,
        childPosition: Int,
        isLastChild: Boolean,
        convertView: View?,
        parent: ViewGroup?
    ): View {
        val itemView: View
        if (convertView == null) {
            itemView = LayoutInflater.from(parent?.context)
                .inflate(R.layout.dinamikview_chiled, parent, false)
        } else {
            itemView = convertView
        }

        itemView.tv_todolist_childName.text = map[titleLis[groupPosition]]!![childPosition]
        itemView.setOnClickListener {
            Object.todoName = map[titleLis[groupPosition]]!![childPosition]
            val intent = Intent(context , MainActivity3::class.java)
            context.startActivity(intent)
        }

        return itemView
    }

    override fun isChildSelectable(groupPosition: Int, childPosition: Int): Boolean = false
}