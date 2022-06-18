package com.davidvargas.trabajadoresroom

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.View.inflate
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.davidvargas.trabajadoresroom.data.TrabajadorEntity
import kotlinx.android.synthetic.main.list_item_trabajador.view.*

class TrabajadorAdapter(val trabajadores: List<TrabajadorEntity>, val activity: Activity) :
    RecyclerView.Adapter<TrabajadorAdapter.TrabajadorViewHolder>() {

    override fun getItemCount(): Int {
        return trabajadores.size
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrabajadorViewHolder {
        var layoutInflate = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_trabajador, parent, false)
        return TrabajadorViewHolder(layoutInflate)
    }

    override fun onBindViewHolder(holder: TrabajadorViewHolder, position: Int) {
        val trabajador = trabajadores[position]
        holder.bindTrabajador(trabajador, activity)
    }


    class TrabajadorViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bindTrabajador(trabajador: TrabajadorEntity, activity: Activity){
            itemView.setOnClickListener({

                val intent = Intent(itemView.context, InsertEditActivity::class.java)
                intent.putExtra(Constants.ID, trabajador.id)
                intent.putExtra(Constants.NOMBRE, trabajador.name)
                intent.putExtra(Constants.PUESTO, trabajador.puesto)
                intent.putExtra(Constants.ANTIGUEDAD, trabajador.antiguedad)
                intent.putExtra(Constants.NUEVO_USER, Constants.NO)
                itemView.context.startActivity(intent)
                activity.finish()
            })
            itemView.litNombre.text = trabajador.name
            itemView.litPuesto.text = trabajador.puesto
            itemView.litAntiguedad.text = trabajador.antiguedad
        }
    }
}
