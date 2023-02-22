package com.example.multiviewtyperecyclerview

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.example.multiviewtyperecyclerview.databinding.CardItemBinding
import com.example.multiviewtyperecyclerview.databinding.ItemHeaderBinding

sealed class DataViewHolder(binding: ViewBinding) : RecyclerView.ViewHolder(binding.root) {

    class HeaderViewHolder(binding: ItemHeaderBinding) : DataViewHolder(binding) {

        private val title = binding.tvTitleHeader

        fun bindHeader(data: DataModel.Header) {
            title.text = data.titleHeader
        }
    }

    class ItemViewHolder(binding: CardItemBinding) : DataViewHolder(binding) {

        private val title = binding.tvTitle
        private val description = binding.tvDescription

        fun bindItem(data: DataModel.Item) {

            title.text = data.titleItem
            description.text = data.description
        }
    }
}