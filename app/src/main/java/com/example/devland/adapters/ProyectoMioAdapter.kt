package com.example.devland.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.devland.fragments.MisProyectosFragmentDirections
import com.example.devland.R
import com.example.devland.clases.Proyecto
import com.example.devland.fragments.MisProyectosFragment

class ProyectoMioAdapter(var listaProyectos:Array<Proyecto>)
    : RecyclerView.Adapter<ProyectoMioAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var nombreProyecto: TextView = itemView.findViewById(R.id.nombre)
        var descripcionProyecto: TextView = itemView.findViewById(R.id.descripcion)
        val cardView: CardView = itemView.findViewById(R.id.card_view_proyecto_otro)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.adapter_proyecto_otro, viewGroup, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.nombreProyecto.text = listaProyectos[position].nombre
        holder.descripcionProyecto.text = listaProyectos[position].descripcion

        holder.cardView.setOnClickListener {



            val action =
                MisProyectosFragmentDirections.actionMisProyectosFragmentToDetallesProyectoMioFragment(
                    listaProyectos[position]
                )
            holder.itemView.findNavController().navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return listaProyectos.size
    }
}