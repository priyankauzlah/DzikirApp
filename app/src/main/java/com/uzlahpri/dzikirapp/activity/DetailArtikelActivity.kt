package com.uzlahpri.dzikirapp.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.uzlahpri.dzikirapp.MainActivity
import com.uzlahpri.dzikirapp.databinding.ActivityDetailArtikelBinding
import com.uzlahpri.dzikirapp.model.Artikel

class DetailArtikelActivity : AppCompatActivity() {
    private lateinit var detailArtikelBinding: ActivityDetailArtikelBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        detailArtikelBinding = ActivityDetailArtikelBinding.inflate(layoutInflater)
        setContentView(detailArtikelBinding.root)
        supportActionBar?.hide()
        supportActionBar?.title = "Artikel Islami"
        back()

        val dataArtikel = intent.getParcelableExtra<Artikel>("data")
        detailArtikelBinding.ivDetail.setImageResource(dataArtikel!!.imageArtikel)
        detailArtikelBinding.tvTitleDetail.text = dataArtikel.titleArtikel
        detailArtikelBinding.tvDescDetail.text = dataArtikel.descArtikel
    }

    private fun back() {
        detailArtikelBinding.ivBackDetailArtikel.setOnClickListener {
            startActivity(MainActivity.getLaunchService(this))
        }

    }
}