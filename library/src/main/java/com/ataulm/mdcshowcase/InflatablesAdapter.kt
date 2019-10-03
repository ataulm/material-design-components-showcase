package com.ataulm.mdcshowcase

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter

internal class InflatablesAdapter : ListAdapter<Int, InflatingViewHolder>(Differ) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = InflatingViewHolder.create(parent)

    override fun onBindViewHolder(holder: InflatingViewHolder, position: Int) {
        holder.inflate(getItem(position))
    }

    object Differ : DiffUtil.ItemCallback<Int>() {
        override fun areItemsTheSame(oldItem: Int, newItem: Int) = oldItem == newItem
        override fun areContentsTheSame(oldItem: Int, newItem: Int) = oldItem == newItem
    }
}
