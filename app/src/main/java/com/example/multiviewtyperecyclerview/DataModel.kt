package com.example.multiviewtyperecyclerview

sealed class DataModel {

    data class Header(
        val titleHeader: String
        ) : DataModel()

    data class Item(
        val titleItem: String,
        val description: String
        ) : DataModel()
}