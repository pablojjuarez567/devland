package com.example.devland.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.fragment.navArgs
import com.example.devland.fragments.DetallesProyectoOtroFragmentArgs
import com.example.devland.R


class DetallesProyectoOtroFragment : Fragment() {

    val args: DetallesProyectoOtroFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_detalles_proyecto_otro, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val textViewNombreProyecto = view.findViewById<TextView>(R.id.nombre)
        val textViewDescripcionProyecto = view.findViewById<TextView>(R.id.descripcion)
        val textViewUbicacion = view.findViewById<TextView>(R.id.ubicacion)
        val textViewModo = view.findViewById<TextView>(R.id.modo)
        val textViewTecnologias = view.findViewById<TextView>(R.id.tecnologias)
        val textViewGente = view.findViewById<TextView>(R.id.genteProyecto)
        val textViewFecha = view.findViewById<TextView>(R.id.fechaPublicacion)
        val textViewEstado = view.findViewById<TextView>(R.id.estado)
        val textViewIdioma = view.findViewById<TextView>(R.id.idioma)
        val textViewDuracion = view.findViewById<TextView>(R.id.duracion)
        val textViewUsuario = view.findViewById<TextView>(R.id.usuarioPropietario)

        textViewNombreProyecto.text = args.proyecto.nombre
        textViewDescripcionProyecto.text = args.proyecto.descripcion
        textViewUbicacion.text = args.proyecto.ubicacion
        textViewModo.text = args.proyecto.modoTrabajo
        textViewGente.text = args.proyecto.numeroParticipantes.toString()
        textViewFecha.text = args.proyecto.fechaPublicacion
        textViewEstado.text = args.proyecto.estado.toString()
        textViewIdioma.text = args.proyecto.idioma
        textViewDuracion.text = args.proyecto.duracion
        //textViewUsuario.text = args.proyecto.propietario?.nombre ?: "No hay usuario"
    }
}