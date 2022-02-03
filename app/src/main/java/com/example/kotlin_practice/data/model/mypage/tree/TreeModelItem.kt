package com.example.kotlin_practice.data.model.mypage.tree

data class TreeModelItem(
    val exp: Int,
    val item: Item,
    val latitude: Double,
    val level: Int,
    val longitude: Double,
    val treeId: Int
)