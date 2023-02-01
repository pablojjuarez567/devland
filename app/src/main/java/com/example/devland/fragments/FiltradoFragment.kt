package com.example.devland.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.devland.Gestor
import com.example.devland.fragments.FiltradoFragmentDirections
import com.example.devland.R
import com.example.devland.clases.Proyecto
import com.example.devland.clases.Usuario
import kotlinx.coroutines.*


class FiltradoFragment : Fragment() {

    var totalProyectos: Array<Proyecto> = arrayOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        GlobalScope.launch {
            totalProyectos = withContext(Dispatchers.IO) {
                Gestor.gestorProyectos().obtenerTodosProyectos()
            }
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_filtrado, container, false)
    }

    @OptIn(DelicateCoroutinesApi::class)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navController: NavController = Navigation.findNavController(view)
        val button = view.findViewById<Button>(R.id.boton)
        val string = "Argumento enviado"

        viewLifecycleOwner
            .lifecycleScope.launch {
                totalProyectos = withContext(Dispatchers.IO) {
                    Gestor.gestorProyectos().obtenerTodosProyectos()
                }
            }


        button.setOnClickListener {

            totalProyectos.forEach {
                Log.w("Firestore", "${it.nombre}")
            }
            val action =
                FiltradoFragmentDirections.actionFiltradoFragmentToFeedFragment(totalProyectos)
            navController.navigate(action)

            //añadirDatos()


        }
    }

    fun añadirDatos() {

        val usuario: Usuario = Usuario()
        usuario.id = 1
        usuario.nombre = "Adolfo"
        usuario.apellidos = "Salado"
        usuario.administrador = true
        usuario.email = "adolfosalado.malaga@gmail.com"
        usuario.password = "12345"
        usuario.descripcion = "Estudiante de DAM"
        usuario.imagen = 1

        val proyecto: Proyecto = Proyecto()
        proyecto.id = 1
        proyecto.nombre = "JavaFX"
        proyecto.descripcion = "Proyecto en JavaFX"
        proyecto.propietario = usuario
        proyecto.idPropietario = usuario.id
        proyecto.duracion = "5 semanas"
        proyecto.estado = true
        proyecto.idioma = "Español"
        proyecto.ubicacion = "Malaga"
        proyecto.imagen = 1
        proyecto.tecnologia = "Java"
        proyecto.numeroParticipantes = 5
        proyecto.modoTrabajo = "Remoto"


        val usuario2: Usuario = Usuario()
        usuario2.id = 2
        usuario2.nombre = "Adolfo"
        usuario2.apellidos = "Salado"
        usuario2.administrador = true
        usuario2.email = "adolfosalado.malaga@gmail.com"
        usuario2.password = "12345"
        usuario2.descripcion = "Estudiante de DAM"
        usuario2.imagen = 1

        usuario.proyectosCreados?.add(proyecto)
        usuario.proyectosCreadosId?.add(proyecto.id!!)

        proyecto.usuariosSeleccionados.add(usuario2)
        usuario2.id?.let { proyecto.usuariosSeleccionadosId.add(it) }

        proyecto.usuariosInteresados.add(usuario2)
        usuario2.id?.let { proyecto.usuariosInteresadosId.add(it) }

        usuario2.proyectosInteresados?.add(proyecto)
        usuario2.proyectosInteresadosId?.add(proyecto.id!!)



        Gestor.gestorUsuarios().registrarUsuario(usuario)
        Gestor.gestorUsuarios().registrarUsuario(usuario2)
        Gestor.gestorProyectos().registrarProyecto(proyecto)

    }
/*
    fun crearArrayProyectos(): Array<Proyecto>{

        val usuarios = ArrayList<Usuario>()
        val proyectos = ArrayList<Proyecto>()
        val tecnologias = ArrayList<String>()

        var array = Array<Proyecto>(10){Proyecto(0, "", Usuario(0, "", "", "", "", 0, "", false, ArrayList<Proyecto>(), ArrayList<Proyecto>(), ArrayList<String>()), "", 0, false, "", "", "", "", "", 0, ArrayList<String>(), ArrayList<Usuario>(), ArrayList<Usuario>()) }





        for (i in 1..10){
            val usuario = Usuario(i, "Nombre $i", "Apellido $i", "Email $i", "Contraseña $i", R.drawable.ic_launcher_background, "Descripcion $i", true, proyectos, proyectos, tecnologias)

            val proyecto = Proyecto(i, "Nombre $i", usuario, "Fecha $i", R.drawable.ic_launcher_background, true, "Descripcion $i", "Ubicacion $i", "Duracion $i", "Modo $i", "Email $i", i+10, tecnologias, usuarios, usuarios)
            array[i-1] = proyecto
        }
        return array
    }

*/

}