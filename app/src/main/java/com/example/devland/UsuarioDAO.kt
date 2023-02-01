package com.example.devland

import com.example.devland.clases.Usuario

interface UsuarioDAO {
    fun obtenerTodosUsuarios(): MutableList<Usuario>
    fun obtenerUsuarioId(id: Int): Usuario
    fun registrarUsuario(usuario: Usuario): Boolean
    fun modificarUsuario(usuario: Usuario): Boolean
    fun eliminarUsuario(usuario: Usuario): Boolean
}