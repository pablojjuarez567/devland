package com.example.devland.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.devland.fragments.FeedFragmentArgs
import com.example.devland.R
import com.example.devland.adapters.ProyectoOtroAdapter


class FeedFragment : Fragment() {

    val args: FeedFragmentArgs by navArgs()
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapterCarta: ProyectoOtroAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_feed, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.recycler_view_feed)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        adapterCarta = ProyectoOtroAdapter(args.listaProyectos)
        recyclerView.adapter = adapterCarta

    }
}