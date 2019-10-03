package com.ataulm.mdcshowcase

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView

internal class InflatingViewHolder(private val itemViewContainer: ViewGroup) : RecyclerView.ViewHolder(itemViewContainer) {

    fun inflate(@LayoutRes layoutResource: Int) {
        View.inflate(itemViewContainer.context, layoutResource, itemViewContainer)
    }

    companion object {
        fun create(parent: ViewGroup): InflatingViewHolder {
            val itemViewContainer = LayoutInflater.from(parent.context)
                    .inflate(R.layout.mdcs__itemview_container, parent, false)
            return InflatingViewHolder(itemViewContainer as ViewGroup)
        }
    }
}
