package com.example.myapplication.ui.listabsen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.R
import com.example.myapplication.model.ItemsHome
import com.example.myapplication.ui.home.adapter.HomeAdapter
import kotlinx.android.synthetic.main.activity_list_absen.*

class ListAbsenActivity : AppCompatActivity() {

        val itemhomes: ArrayList<ItemsHome> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_absen)
        addItems()
        RVListAbsen.layoutManager = LinearLayoutManager(applicationContext)
        RVListAbsen.adapter = HomeAdapter(itemhomes, applicationContext)
    }

    private fun addItems() {
        itemhomes.add(0, ItemsHome("https://iso.500px.com/wp-content/uploads/2014/12/macro_cover.jpg"))
        itemhomes.add(1, ItemsHome("https://iso.500px.com/wp-content/uploads/2015/12/macro_cover.jpg"))
        itemhomes.add(2, ItemsHome("https://drscdn.500px.org/photo/151383103/m%3D900/v2?webp=true&sig=73beb3b876e58367411a7a96c7675b5bb7c71d907183968be03b4896add09237"))
        itemhomes.add(3, ItemsHome("https://thumb.cloud.mail.ru/weblink/thumb/xw1/KzUH/jWTfJx9qX/71/00/71009073/71009073_450.jpg"))
        itemhomes.add(4, ItemsHome("https://pbs.twimg.com/media/B-eOa_SCUAABURj.jpg"))
        itemhomes.add(5, ItemsHome("https://i.pinimg.com/originals/b5/52/c6/b552c61da1d1fcadbe1b672feb4b98a7.jpg"))
    }
}
