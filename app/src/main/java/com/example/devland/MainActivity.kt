package com.example.devland

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import com.example.devland.clases.Proyecto
import com.example.devland.clases.Usuario
import com.example.devland.fragments.FeedFragment
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()


        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNavigationView.setOnItemSelectedListener  { item ->
            when (item.itemId) {

                R.id.item_1 -> {
                    val bundle = Bundle()
                    bundle.putParcelableArray("lista_proyectos", crearArrayProyectos())

                    val navController = findNavController(R.id.fragmentContainerView)
                    navController.navigate(R.id.feedFragment, bundle)
                }
                R.id.item_2 -> {
                    val navController = findNavController(R.id.fragmentContainerView)
                    navController.navigate(R.id.crearProyectoFragment)
                }
                R.id.item_3 -> {
                    val bundle = Bundle()

                    var proyectos = LoginActivity.usuario!!.proyectosCreados
                    val arrayProyectos=pasarMutableListAArray(proyectos)




                    bundle.putParcelableArray("listaProyectos", arrayProyectos)

                    val navController = findNavController(R.id.fragmentContainerView)
                    navController.navigate(R.id.misProyectosFragment, bundle)
                }
                R.id.item_4 -> {
                    val navController = findNavController(R.id.fragmentContainerView)
                    navController.navigate(R.id.perfilFragment)
                }
            }
            true
        }

    }



    fun crearArrayProyectos(): Array<Proyecto>{

        val usuarios = ArrayList<Usuario>()
        val proyectos = ArrayList<Proyecto>()
        val tecnologias = ArrayList<String>()

        var array = Array<Proyecto>(10){Proyecto() }

        for (i in 1..10){
            val usuario = Usuario(i, "Nombre $i", "Apellido $i", "Email $i", "Contraseña $i", false, "Descripcion $i", R.drawable.ic_launcher_background, proyectos, proyectos, null)

            val proyecto = Proyecto(i, "Nombre $i", "Descripcion $i", "Tecnologia $i", "Lugar $i", "Modo $i", "Idioma $i", "Duracion $i", true, 10+i, null, null, null, "")
            array[i-1] = proyecto
        }
        return array
    }

    fun pasarMutableListAArray(lista: MutableList<Proyecto>?): Array<Proyecto>{
        val arrayProyectos:Array<Proyecto> = Array(lista!!.size){Proyecto()}

        for (i in 0 until lista.size){
            arrayProyectos[i] = lista[i]
        }

        return arrayProyectos
    }


}