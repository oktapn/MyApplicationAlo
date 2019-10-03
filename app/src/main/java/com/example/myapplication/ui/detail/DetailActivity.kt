package com.example.myapplication.ui.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.custom.sliderimage.logic.SliderImage
import com.example.myapplication.R
import com.example.myapplication.model.ItemsHome
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {
    val itemhomes: ArrayList<ItemsHome> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        addItems()
        // Create slider image component
        val sliderImage = SliderImage(this)

        // add images URLs
        val images = listOf(
            itemhomes[0].imageFP, itemhomes[1].imageFP, itemhomes[2].imageFP,
            itemhomes[3].imageFP, itemhomes[4].imageFP)

        // Add image URLs to sliderImage
        slider.setItems(images as List<String>)

        // Add slider component to a container
//        sliderImage.addView(slider)
    }

    private fun addItems() {
        itemhomes.add(
            0,
            ItemsHome("https://iso.500px.com/wp-content/uploads/2014/12/macro_cover.jpg")
        )
        itemhomes.add(
            1,
            ItemsHome("https://iso.500px.com/wp-content/uploads/2015/12/macro_cover.jpg")
        )
        itemhomes.add(
            2,
            ItemsHome("https://drscdn.500px.org/photo/151383103/m%3D900/v2?webp=true&sig=73beb3b876e58367411a7a96c7675b5bb7c71d907183968be03b4896add09237")
        )
        itemhomes.add(
            3,
            ItemsHome("https://thumb.cloud.mail.ru/weblink/thumb/xw1/KzUH/jWTfJx9qX/71/00/71009073/71009073_450.jpg")
        )
        itemhomes.add(4, ItemsHome("https://pbs.twimg.com/media/B-eOa_SCUAABURj.jpg"))
        itemhomes.add(
            5,
            ItemsHome("https://i.pinimg.com/originals/b5/52/c6/b552c61da1d1fcadbe1b672feb4b98a7.jpg")
        )
    }
}
