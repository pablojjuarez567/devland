package com.example.devland.fragments

import android.content.Intent
import android.os.Bundle
import android.text.InputType
import android.text.TextUtils
import android.util.Patterns
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.devland.R
import com.example.devland.clases.Proyecto
import com.example.devland.clases.Usuario
import kotlinx.android.synthetic.main.fragment_crear_proyecto.*


class CrearProyectoFragment : Fragment() {

    private var nombreProyecto: EditText? = null
    private var ubicacionProyecto : Spinner? = null
    private var cantidadProyecto : EditText? = null
    private var descripcionProyecto : EditText? = null
    private var tecnologiaProyecto : Spinner? = null
    private var idiomaProyecto : Spinner? = null
    private var tiempo :EditText? = null
    private var tipo: Spinner? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_crear_proyecto, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)




        val spinner = view.findViewById<Spinner>(R.id.tecnologia_nuevoProyecto)
        val spinner2 = view.findViewById<Spinner>(R.id.idioma_nuevoProyecto)
        val spinner3 = view.findViewById<Spinner>(R.id.ubicacion_nuevoProyecto)
        val spinner4 = view.findViewById<Spinner>(R.id.tipo)

        val lista = resources.getStringArray(R.array.tecnologias)
        val lista2 = resources.getStringArray(R.array.idiomas)
        val lista3 = resources.getStringArray(R.array.ubicacion)
        val lista4 = resources.getStringArray(R.array.tiempo)

        val adaptador = ArrayAdapter(view.context, android.R.layout.simple_spinner_item, lista)
        val adaptador2 = ArrayAdapter(view.context, android.R.layout.simple_spinner_item, lista2)
        val adaptador3 = ArrayAdapter(view.context, android.R.layout.simple_spinner_item, lista3)
        val adaptador4 = ArrayAdapter(view.context, android.R.layout.simple_spinner_item, lista4)

        spinner.adapter = adaptador
        spinner2.adapter = adaptador2
        spinner3.adapter = adaptador3
        spinner4.adapter = adaptador4

        val btnCrear = view.findViewById<Button>(R.id.crear)
        btnCrear.setOnClickListener {

            var nombreProyecto = view.findViewById<EditText>(R.id.nombre_nuevoProyecto)
            var ubicacionProyecto =view.findViewById<Spinner> (R.id.ubicacion_nuevoProyecto)
            var cantidadProyecto =view.findViewById<EditText> (R.id.cantidad_nuevoProyecto)
            var descripcionProyecto = view.findViewById<EditText>(R.id.descripcion_nuevoProyecto)
            var tecnologiaProyecto = view.findViewById<Spinner>(R.id.tecnologia_nuevoProyecto)
            var idiomaProyecto =view.findViewById<Spinner> (R.id.idioma_nuevoProyecto)
            var fechaActual = System.currentTimeMillis().toString()
            var tiempo =view.findViewById<EditText>(R.id.numero_tiempo)
            var tipo = view.findViewById<Spinner>(R.id.tipo)




            val nombreP = nombreProyecto!!.text.toString()
            val cantidadP = cantidadProyecto!!.text.toString()
            val descripcionP = descripcionProyecto!!.text.toString()
            val time = tiempo!!.text.toString()

            var cantidadPI = cantidadP.toInt()

            val tiempoProyecto = time + " " + onItemSelected(tipo,view ,0, 0)



            comprobarnombre(nombreP.toString())
            comprobartiempo(tiempo.toString())
            comprobardescripcion(descripcionProyecto.toString())


            var proyecto: Proyecto
            var usuarioPrueba: Usuario
            var proyectosCreados= ArrayList<Proyecto>()

            usuarioPrueba = Usuario(4543, "Eusebio",
                "El monoloco", "supadumacaco@macacomail.mac", "vivalasopademacaco",
                false, "soy un macaco llamado eusebio", 0, proyectosCreados, null,
                null)

            proyecto = Proyecto(0,
                nombreP,descripcionP,onItemSelected(tecnologiaProyecto, 0),onItemSelected(ubicacionProyecto, 0),
                boxchecker(presencial_modo_nuevoProyecto,teletrabajo_modo_nuevoProyecto),onItemSelected(idiomaProyecto,0),tiempoProyecto,switchchecker(estado_nuevoProyecto),cantidadPI,
               null,usuarioPrueba.id,0,fechaActual)

            println(proyecto.toString())

        }
    }

    fun switchchecker(switch: Switch): Boolean {

        if ( switch.isChecked){

            return true
        }
        else{
            return false
        }
    }

    fun boxchecker(checkBox1: CheckBox,checkBox2: CheckBox): String{

        if(checkBox1.isChecked) {
            return "Presencial"

        }
        if (checkBox2.isChecked) {
            return "Teletrabajo"
        }
        return "Mixto"

    }
    fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long): String {
        // Obtener el elemento seleccionado en el spinner
        val selectedItem = parent?.getItemAtPosition(position) as String
        // Hacer algo con el elemento seleccionado

        return selectedItem
    }

    private fun comprobarnombre(nombre: String): Boolean {
        return !TextUtils.isEmpty(nombre)
    }

    private fun comprobardescripcion(cantidad: String): Boolean {
        return !TextUtils.isEmpty(cantidad)
    }

    private fun comprobartiempo(tiempo: String): Boolean {
        return !TextUtils.isEmpty(tiempo)
    }

}