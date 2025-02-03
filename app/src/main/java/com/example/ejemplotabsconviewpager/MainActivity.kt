package com.example.ejemplotabsconviewpager

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.FragmentManager
import com.example.ejemplotabsconviewpager.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    lateinit var mibinding:ActivityMainBinding
    lateinit var miadaptador:ViewPageAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        mibinding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(mibinding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        Inicializar_viewPager()



    }

    private fun Inicializar_viewPager() {
        val iconos= listOf(R.drawable.faltas,R.drawable.positivo,R.drawable.partes)
        val textos=listOf("FALTAS","POSITIVOS","PARTES")
        miadaptador= ViewPageAdapter(supportFragmentManager,lifecycle)
        //Añado fragmentos al adaptador

        miadaptador.add_fragmento(Fragmento_Faltas())
        miadaptador.add_fragmento(Fragmento_positivos())
        miadaptador.add_fragmento(Fragmento_Partes())

        mibinding.viewpager.adapter=miadaptador

        //Ahora añadimos las pestañas, para eso sera
        //necesario definir un TabLayoutMediator
        TabLayoutMediator(mibinding.tabLayout,mibinding.viewpager){
            tab,posicion->

            tab.text=textos.get(posicion)
            tab.icon=this@MainActivity.getDrawable(iconos.get(posicion))

        }.attach()

    }
}