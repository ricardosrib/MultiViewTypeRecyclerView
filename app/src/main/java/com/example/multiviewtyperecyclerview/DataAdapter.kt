package com.example.multiviewtyperecyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.multiviewtyperecyclerview.databinding.CardItemBinding
import com.example.multiviewtyperecyclerview.databinding.ItemHeaderBinding

class DataAdapter : RecyclerView.Adapter<DataViewHolder>() {

    private val dataList = mutableListOf<DataModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        return when (viewType) {
            R.layout.item_header -> DataViewHolder.HeaderViewHolder(
                ItemHeaderBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
            R.layout.card_item -> DataViewHolder.ItemViewHolder(
                CardItemBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
            else -> throw IllegalArgumentException("Invalid ViewType provided")
        }
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        when (holder) {
            is DataViewHolder.HeaderViewHolder -> holder.bindHeader(dataList[position] as DataModel.Header)
            is DataViewHolder.ItemViewHolder -> holder.bindItem(dataList[position] as DataModel.Item)
        }
    }

    override fun getItemCount(): Int = dataList.size

    override fun getItemViewType(position: Int): Int {
        return when (dataList[position]) {
            is DataModel.Header -> R.layout.item_header
            is DataModel.Item -> R.layout.card_item
        }
    }

    fun setItems(data: List<DataModel>) {
        dataList.apply {
            clear()
            addAll(data)
        }
        notifyDataSetChanged()
    }

}