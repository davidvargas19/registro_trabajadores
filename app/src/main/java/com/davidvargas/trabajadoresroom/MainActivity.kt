package com.davidvargas.trabajadoresroom


import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.davidvargas.trabajadoresroom.data.TrabajadorDB
import com.davidvargas.trabajadoresroom.data.TrabajadorEntity
import com.davidvargas.trabajadoresroom.data.TrabajadoresActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainActivityBtInsertarTrabajador.setOnClickListener {
            val intent = Intent(applicationContext, InsertEditActivity::class.java)
            intent.putExtra(Constants.NUEVO_USER, Constants.SI)
            startActivity(intent)
        }

        mainActivityBtTodoTrabajadores.setOnClickListener {
            val intent = Intent(applicationContext, TrabajadoresActivity::class.java)
            startActivity(intent)
        }

        mainActivityBtBorrarTrabajadores.setOnClickListener {
            TrabajadorDB.getDatabase(applicationContext).trabajadorD().deleteAllWorkers()
        }

        mainActivityBtBuscar.setOnClickListener {
            var nombre = mainActivityBtBuscar.text.toString()
            var trabajador =
                TrabajadorDB.getDatabase(applicationContext).trabajadorD().getWorkerByName(nombre)
            if (trabajador == null) {
                mainActivityBtBuscar.setText("No Trabajador")
            } else {
                val intent = Intent(applicationContext, InsertEditActivity::class.java)
                intent.putExtra(Constants.ID, trabajador.id)
                intent.putExtra(Constants.NOMBRE, trabajador.name)
                intent.putExtra(Constants.PUESTO, trabajador.puesto)
                intent.putExtra(Constants.ANTIGUEDAD, trabajador.antiguedad)
                intent.putExtra(Constants.NUEVO_USER, Constants.NO)
                startActivity(intent)
            }

        }


    }
}