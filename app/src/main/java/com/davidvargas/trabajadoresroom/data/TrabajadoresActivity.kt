package com.davidvargas.trabajadoresroom.data

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.davidvargas.trabajadoresroom.R
import com.davidvargas.trabajadoresroom.TrabajadorAdapter
import kotlinx.android.synthetic.main.activity_trabajadores.*
import kotlinx.android.synthetic.main.list_item_trabajador.*

class TrabajadoresActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_trabajadores)

        var trabajadores: List<TrabajadorEntity> = TrabajadorDB.getDatabase(applicationContext).trabajadorD().getAllWorkers()

        taRv.layoutManager = LinearLayoutManager(this)
        taRv.adapter = TrabajadorAdapter(trabajadores, this)

    }
}