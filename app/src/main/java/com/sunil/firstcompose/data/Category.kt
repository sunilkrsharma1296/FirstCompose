package com.sunil.firstcompose.data

import com.sunil.firstcompose.R

data class Category(val imgId: Int, val title: String, val subtitle: String)

fun getCategoryList(): MutableList<Category>{
    val list=mutableListOf<Category>()
    list.add(Category(R.drawable.bg_1, "Sunil Sharma", "Software Developer"))
    list.add(Category(R.drawable.bg_2, "Rani Sharma", "Android Developer"))
    list.add(Category(R.drawable.ic_launcher_foreground, "Sharma Sharma", "Graphic Developer"))
    list.add(Category(R.drawable.bg_1, "Sunil Sharma", "Software Developer"))
    list.add(Category(R.drawable.bg_2, "Rani Sharma", "Android Developer"))
    list.add(Category(R.drawable.ic_launcher_foreground, "Sharma Sharma", "Graphic Developer"))
    list.add(Category(R.drawable.bg_1, "Sunil Sharma", "Software Developer"))
    list.add(Category(R.drawable.bg_2, "Rani Sharma", "Android Developer"))
    list.add(Category(R.drawable.ic_launcher_foreground, "Sharma Sharma", "Graphic Developer"))



    return list
}