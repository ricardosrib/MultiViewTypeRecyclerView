package com.example.multiviewtyperecyclerview

import android.provider.ContactsContract.Data
import androidx.recyclerview.widget.DiffUtil

class DataDiffUtil(
    private val oldList: List<DataModel>,
    private val newList: List<DataModel>) :
    DiffUtil.Callback() {

    override fun getOldListSize(): Int {
        return oldList.size
//        return oldList.count()
    }

    override fun getNewListSize(): Int {
        return newList.size
//        return newList.count()
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return when {
            (oldList[oldItemPosition] is DataModel.Header) && (newList[newItemPosition] is DataModel.Header) -> {
                (oldList[oldItemPosition] as DataModel.Header).titleHeader == (newList[newItemPosition] as DataModel.Header).titleHeader
            }
            oldList[oldItemPosition] is DataModel.Item && newList[newItemPosition] is DataModel.Item -> {
                (oldList[oldItemPosition] as DataModel.Item).titleItem == (newList[newItemPosition] as DataModel.Item).titleItem
            }
            else -> false
        }
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }
}