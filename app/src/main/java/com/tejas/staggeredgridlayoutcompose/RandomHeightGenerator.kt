package com.tejas.staggeredgridlayoutcompose

import kotlin.random.Random

object RandomHeightGenerator {

    fun generate(): Int {
        val list = listOf(150, 200, 300)
        return list[Random.nextInt(0, 3)]
    }

}