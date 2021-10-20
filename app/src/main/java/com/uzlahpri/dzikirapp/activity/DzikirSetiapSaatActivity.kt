package com.uzlahpri.dzikirapp.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.uzlahpri.dzikirapp.MainActivity
import com.uzlahpri.dzikirapp.adapter.DzikirDoaAdapter
import com.uzlahpri.dzikirapp.databinding.ActivityDzikirSetiapSaatBinding
import com.uzlahpri.dzikirapp.model.DataDzikirDoa
import com.uzlahpri.dzikirapp.model.DzikirDoa

class DzikirSetiapSaatActivity : AppCompatActivity() {
    private lateinit var dzikirSetiapSaatBinding: ActivityDzikirSetiapSaatBinding
    private var listDzikirSetiapSaat: ArrayList<DzikirDoa> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dzikirSetiapSaatBinding = ActivityDzikirSetiapSaatBinding.inflate(layoutInflater)
        setContentView(dzikirSetiapSaatBinding.root)

        supportActionBar?.hide()
        showRecyclerList()
        back()
    }

    private fun back() {
        dzikirSetiapSaatBinding.ivBackDzikirSetiapSaat.setOnClickListener {
            startActivity(
                MainActivity.getLaunchService(this)
            )
        }
    }

    private fun showRecyclerList() {
        dzikirSetiapSaatBinding.rvDzikirSetiapSaat.layoutManager = LinearLayoutManager(this)

        listDzikirSetiapSaat.clear()
        listDzikirSetiapSaat.addAll(DataDzikirDoa.listDzikir)

        dzikirSetiapSaatBinding.rvDzikirSetiapSaat.adapter = DzikirDoaAdapter(listDzikirSetiapSaat)
        dzikirSetiapSaatBinding.rvDzikirSetiapSaat.setHasFixedSize(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return super.onSupportNavigateUp()
    }

    companion object {
        fun getLaunchService(from: Context) =
            Intent(from, DzikirSetiapSaatActivity::class.java).apply {
                addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
            }
    }
}