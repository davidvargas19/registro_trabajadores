package com.davidvargas.trabajadoresroom

import android.content.Intent
import android.os.Bundle
import android.view.KeyEvent
import androidx.appcompat.app.AppCompatActivity
import com.davidvargas.trabajadoresroom.data.TrabajadorDB
import com.davidvargas.trabajadoresroom.data.TrabajadorEntity
import com.davidvargas.trabajadoresroom.databinding.ActivityTrabajadoresBinding
import kotlinx.android.synthetic.main.activity_trabajadores.*


class TrabajadoresActivity : AppCompatActivity(), TrabajadorAdapter.OnTrabajadorAdapter {

    private lateinit var binding: ActivityTrabajadoresBinding
    private lateinit var listDatos: ArrayList<String>
    private lateinit var adapter: TrabajadorAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityTrabajadoresBinding.inflate(layoutInflater)

        binding.litBtBuscar.setOnClickListener {
            buscar()
        }
//        binding.litHintBuscar.editableText.addTextChangedListener(TextWatcher()



        setContentView(binding.root)
        setupRecyclerView()
        buscarNombre()
        showTrabajadores()
    }

    private fun setupRecyclerView() {
        adapter = TrabajadorAdapter(this)
        binding.aTrabajadoresRV.adapter = adapter
    }

    private fun showTrabajadores() {
        val trabajadores: List<TrabajadorEntity> =
            TrabajadorDB.getDatabase(applicationContext).trabajadorDao().getAllWorkers()
        adapter.setData(trabajadores)
    }

    private fun buscarNombre() {
        litHintBuscar.setOnKeyListener { v, keyCode, event ->
            if (keyCode == KeyEvent.KEYCODE_ENTER) {
                buscar()
            }
            false
        }
    }

    override fun onItemClicked(trabajador: TrabajadorEntity) {
        val intent = Intent(this, InsertEditActivity::class.java)
        intent.putExtra(Constants.ID, trabajador.id)
        intent.putExtra(Constants.NOMBRE, trabajador.name)
        intent.putExtra(Constants.PUESTO, trabajador.puesto)
        intent.putExtra(Constants.ANTIGUEDAD, trabajador.antiguedad)
        intent.putExtra(Constants.NUEVO_USER, Constants.NO)
        startActivity(intent)
        //activity.finish()
    }
    private fun buscar(){
        val nombre = litHintBuscar.text.toString()

        val trabajadores =
            TrabajadorDB.getDatabase(applicationContext).trabajadorDao().getWorkerByName(nombre)

        if (trabajadores.isEmpty()) {
            litHintBuscar.setText("No Trabajador")
        } else {
            adapter.setData(trabajadores)
        }

    }
}