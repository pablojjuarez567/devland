package com.example.devland

import com.example.devland.clases.Proyecto

interface ProyectoDAO {
    fun obtenerTodosProyectos(): Array<Proyecto>
    fun obtenerProyectoId(id: Int?): Proyecto
    fun registrarProyecto(proyecto: Proyecto): Boolean
    fun modificarProyecto(proyecto: Proyecto): Boolean
    fun eliminarProyecto(proyecto: Proyecto): Boolean
}