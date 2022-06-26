package com.davidvargas.trabajadoresroom

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.davidvargas.trabajadoresroom.data.TrabajadorDB
import com.davidvargas.trabajadoresroom.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)


        binding.mainActivityBtInsertarTrabajador.setOnClickListener {
            val intent = Intent(applicationContext, InsertEditActivity::class.java)
            intent.putExtra(Constants.NUEVO_USER, Constants.SI)
            startActivity(intent)
        }

        binding.mainActivityBtTodoTrabajadores.setOnClickListener {
            val intent = Intent(applicationContext, TrabajadoresActivity::class.java)
            startActivity(intent)
        }

        binding.mainActivityBtBorrarTrabajadores.setOnClickListener {
            TrabajadorDB.getDatabase(applicationContext).trabajadorDao().deleteAllWorkers()
        }

    }


}