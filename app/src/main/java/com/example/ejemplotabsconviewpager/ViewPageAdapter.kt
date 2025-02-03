package com.example.ejemplotabsconviewpager

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPageAdapter(gestorFragmentos:FragmentManager,ciclo_vida:Lifecycle):FragmentStateAdapter(gestorFragmentos,ciclo_vida) {
    //Puedo definir un List de Fragments
    val lista_fragmentos= mutableListOf<Fragment>()
    override fun getItemCount(): Int=lista_fragmentos.size

    override fun createFragment(position: Int): Fragment {
       lista_fragmentos.get(position).arguments= Bundle().apply {
           putString("param1","INFORMACION")
       }
        return lista_fragmentos.get(position)

        //Otra opción es en función de la position, que comienza
        //en 0 retornar un fragmento u otro con un when
    }

    fun add_fragmento(frag:Fragment)
    {
        this.lista_fragmentos.add(frag)
    }
}