package com.davidvargas.trabajadoresroom

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.davidvargas.trabajadoresroom.data.TrabajadorEntity
import kotlinx.android.synthetic.main.list_item_trabajador.view.*

class TrabajadorAdapter(private val onTrabajadorAdapter: OnTrabajadorAdapter) :
    RecyclerView.Adapter<TrabajadorAdapter.TrabajadorViewHolder>() {

    private var listDatos: MutableList<TrabajadorEntity> = mutableListOf()

    override fun getItemCount(): Int {
        return listDatos.size
    }

    //ENLAZAR THIS CCON EL LIST_ITEM_TRABAJADOR
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrabajadorViewHolder {
        val layoutInflate = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_trabajador, parent, false)
        return TrabajadorViewHolder(layoutInflate)
    }

    //COMUNICACION ENTRE onBindViewHolder Y TrabajadorViewHolder
    override fun onBindViewHolder(holder: TrabajadorViewHolder, position: Int) {
        val trabajador = listDatos[position]
        holder.bindTrabajador(trabajador, onTrabajadorAdapter)
    }

    //INSERTAR TRABAJADORES
    class TrabajadorViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindTrabajador(trabajador: TrabajadorEntity, onTrabajadorAdapter: OnTrabajadorAdapter) {
            itemView.setOnClickListener {
                onTrabajadorAdapter.onItemClicked(trabajador)
            }
            itemView.litNombre.text = trabajador.name
            itemView.litPuesto.text = trabajador.puesto
            itemView.litAntiguedad.text = trabajador.antiguedad
        }
    }

    fun setData(trabajadores: List<TrabajadorEntity>) {
        this.listDatos = trabajadores.toMutableList()
        notifyDataSetChanged()
    }

    fun showNewTrabajador(trabajador: TrabajadorEntity) {
        this.listDatos.add(trabajador)
        notifyItemInserted(listDatos.size)
    }

    interface OnTrabajadorAdapter {
        fun onItemClicked(trabajador: TrabajadorEntity)
    }
}
