package com.davidvargas.trabajadoresroom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.davidvargas.trabajadoresroom.data.TrabajadorDB
import com.davidvargas.trabajadoresroom.data.TrabajadorEntity
import kotlinx.android.synthetic.main.activity_insert_edit.*


class InsertEditActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insert_edit)

        var nuevoTrabajador = intent.getStringExtra(Constants.NUEVO_USER)
        var trabajador = TrabajadorEntity(0, "", "", "")

        if (nuevoTrabajador.equals(Constants.SI)) {


        } else {
            trabajador.id = intent.getIntExtra(Constants.ID, 0)
            trabajador.name = intent.getStringExtra(Constants.NOMBRE)
            activityInsertHintNombre.setText(trabajador.name)
            trabajador.puesto = intent.getStringExtra(Constants.PUESTO)
            activityInsertHintPuesto.setText(trabajador.puesto)
            trabajador.antiguedad = intent.getStringExtra(Constants.ANTIGUEDAD)
            activityInsertHintAntiguedad.setText(trabajador.antiguedad)
        }

        activityInsertBtborrar.setOnClickListener {
            if (nuevoTrabajador.equals(Constants.SI)) {

            } else {

                TrabajadorDB.getDatabase(applicationContext).trabajadorD().deleteWorker(trabajador)
                finish()
            }

        }

        activityInsertBtGuardar.setOnClickListener {

            var trabajadorGuardar = TrabajadorEntity(
                0,
                activityInsertHintNombre.text.toString(),
                activityInsertHintPuesto.text.toString(),
                activityInsertHintAntiguedad.text.toString()
            )

            if (nuevoTrabajador.equals(Constants.SI)) {
                TrabajadorDB.getDatabase(applicationContext).trabajadorD()
                    .insertTrabajador(trabajadorGuardar)
                finish()

            } else {


            }
        }
    }
}