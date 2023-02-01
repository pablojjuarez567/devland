package com.example.devland

class Gestor {

    companion object {
        private var gestorUsuarios: UsuarioController = UsuarioController()
        private var gestorProyectos: ProyectoController = ProyectoController()

        fun gestorUsuarios(): UsuarioController {
            return gestorUsuarios
        }

        fun gestorProyectos(): ProyectoController {
            return gestorProyectos
        }

    }

}