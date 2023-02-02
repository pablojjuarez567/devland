package com.example.devland

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import com.example.devland.LoginActivity.Companion.usuario
import com.example.devland.clases.Proyecto
import com.example.devland.clases.Usuario
import com.example.devland.fragments.FeedFragment

class LoginActivity : AppCompatActivity() {
    private var etEmail: EditText? = null
    private var etPassword: EditText? = null
    private var btnInicioSesion: Button? = null
    lateinit var tvOlvidarPwd: TextView
    lateinit var tvRegistro: TextView
    private var prefs: SharedPreferences? = null

    companion object {
        var usuario: Usuario? = null
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        etEmail = findViewById(R.id.etEmail)
        etPassword = findViewById(R.id.etContraseña)
        btnInicioSesion = findViewById(R.id.btnInicioSesion)
        tvOlvidarPwd = findViewById(R.id.tvOlvidarPwd)
        tvRegistro = findViewById(R.id.tvRegistro)


        prefs = getSharedPreferences("app", MODE_PRIVATE)

        establecerValoresSiExisten()

        tvOlvidarPwd.setOnClickListener {
            goToOlvidarPwd()
        }

        tvRegistro.setOnClickListener {
            goToRegistro()
        }

        btnInicioSesion?.setOnClickListener {
            val email = etEmail!!.text.toString()
            val password = etPassword!!.text.toString()

            if (login(email, password)) {

                usuario = Usuario(1, "Paco", "García", "paco@gmail.com","12345678", false, "Soy un desarrollador de aplicaciones móviles", 0, mutableListOf(), mutableListOf(), mutableListOf(), mutableListOf())

                var proyecto1s = Proyecto(0, "Videojuego Unity", "Un videojuego RPG en 2D", "C#, Videojuegos, SQL", "Malaga", "Presencial", "Español", "5 meses", true, 9,usuario)
                var proyecto2s = Proyecto(1, "Aplicación Android", "Una aplicación de mensajería", "Kotlin, Android, Firebase", "Malaga", "Presencial", "Español", "3 meses", true, 9,usuario)
                var proyecto3s = Proyecto(2, "Aplicación iOS", "Una aplicación de mensajería", "Swift, iOS, Firebase", "Malaga", "Presencial", "Español", "3 meses", true, 9, usuario)
                var proyecto4s = Proyecto(3, "Aplicacion gestora de un supermercado", "Una aplicación para Mercadona", "Java, Android, SQL", "Malaga", "Presencial", "Español", "3 meses", true, 9, usuario)
                usuario!!.proyectosCreados?.add(proyecto1s)
                print(usuario!!.proyectosCreados?.size)
                print(usuario!!.proyectosCreados?.get(0)?.nombre)
                usuario!!.proyectosCreados?.add(proyecto2s)
                usuario!!.proyectosCreados?.add(proyecto3s)
                usuario!!.proyectosCreados?.add(proyecto4s)

                goToFeed()
            }
            guardarPreferencias(email, password)
        }
    }

    private fun comprobarCorreo(email: String): Boolean {
        return !TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    private fun comprobarPassword(password: String): Boolean {
        return !TextUtils.isEmpty(password) && password.length > 7
    }

    private fun login(email: String, password: String): Boolean {
        var valido = false
        if (!comprobarCorreo(email)) {
            Toast.makeText(
                this,
                "El correo electrónico introducido, no es válido. Introduce un e-mail correcto.",
                Toast.LENGTH_SHORT
            ).show()
        } else if (!comprobarPassword(password)) {
            Toast.makeText(
                this,
                "Contraseña no válida. Ingresa al menos una contraseña de 8 caracteres.",
                Toast.LENGTH_SHORT
            ).show()
        } else if (email=="paco@gmail.com" && password=="12345678") {
            valido = true

        }
        return valido
    }

    private fun guardarPreferencias(email: String, password: String) {
        val editor = prefs!!.edit()

        editor.putString("email", email)
        editor.putString("password", password)
        editor.apply()
    }

    private fun establecerValoresSiExisten() {
        val email = prefs!!.getString("email", "")
        val password = prefs!!.getString("password", "")
        if (!TextUtils.isEmpty(email) && !TextUtils.isEmpty(password)) {
            etEmail!!.setText(email)
            etPassword!!.setText(password)
        }
    }

    private fun goToFeed() {
        val intent = Intent(this, MainActivity::class.java)
        // Evita que pasemos de nuevo a la activity login
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
    }

    private fun goToRegistro() {
        val intent = Intent(this, RegistroActivity::class.java)
        //Evita que pasemos de nuevo a la activity login
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
    }

    private fun goToOlvidarPwd() {
        //val intent = Intent(this, MainActivity::class.java)
        //Evita que pasemos de nuevo a la activity login
        //intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        // startActivity(intent)
    }
}