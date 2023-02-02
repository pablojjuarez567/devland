package com.example.devland.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.devland.LoginActivity
import com.example.devland.MainActivity
import com.example.devland.R


class PerfilFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_perfil, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val textViewNombre = view.findViewById<TextView>(R.id.nombre_y_apellidos)
        val textViewEmail = view.findViewById<TextView>(R.id.email)
        val textViewDescripcion = view.findViewById<TextView>(R.id.descripcion)

        val usuario = LoginActivity.usuario

        if (usuario != null) {
            textViewNombre.text = usuario.nombre + " " + usuario.apellidos
            textViewEmail.text = usuario.email
            textViewDescripcion.text = usuario.descripcion
        }

    }
}