package com.example.devland.clases

import android.os.Parcelable
import com.google.firebase.firestore.Exclude
import kotlinx.android.parcel.Parcelize


@Parcelize
data class Proyecto(
    var id: Int? = 0,
    var nombre: String? = "",
    var descripcion: String? = "",
    var tecnologia: String? = "",
    var ubicacion: String? = "",
    var modoTrabajo: String? = "",
    var idioma: String? = "",
    var duracion: String? = "",
    var estado: Boolean? = null,
    var numeroParticipantes: Int? = 0,
    @get:Exclude var propietario: Usuario? = null,
    var idPropietario: Int? = propietario?.id,
    var imagen: Int? = 0,
    var fechaPublicacion: String = "",

    @get:Exclude var usuariosInteresados: MutableList<Usuario> = mutableListOf(),
    @get:Exclude var usuariosSeleccionados: MutableList<Usuario> = mutableListOf(),
    var usuariosInteresadosId: MutableList<Int> = mutableListOf(),
    var usuariosSeleccionadosId: MutableList<Int> = mutableListOf()
): Parcelable