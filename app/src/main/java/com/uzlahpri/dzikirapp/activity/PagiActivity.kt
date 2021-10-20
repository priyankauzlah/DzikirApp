package com.uzlahpri.dzikirapp.activity

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.uzlahpri.dzikirapp.R
import com.uzlahpri.dzikirapp.adapter.DzikirDoaAdapter
import com.uzlahpri.dzikirapp.databinding.ActivityPagiBinding
import com.uzlahpri.dzikirapp.model.DataDzikirDoa
import com.uzlahpri.dzikirapp.model.DzikirDoa

class PagiActivity : AppCompatActivity() {
    private lateinit var pagiBinding: ActivityPagiBinding
    private var listDzikirPagi : ArrayList<DzikirDoa> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        pagiBinding = ActivityPagiBinding.inflate(layoutInflater)
        setContentView(pagiBinding.root)

        showRecyclerList()
    }

    private fun showRecyclerList() {
        pagiBinding.rvDzikirPagi.setHasFixedSize(true)
        listDzikirPagi.clear()
        listDzikirPagi.addAll(DataDzikirDoa.listDzikirPagi)
        pagiBinding.rvDzikirPagi.layoutManager = LinearLayoutManager(this)
        pagiBinding.rvDzikirPagi.adapter = DzikirDoaAdapter(listDzikirPagi)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }

    companion object {
        fun getLaunchService(from: Context) = Intent(from, PagiActivity::class.java).apply {
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
        }
    }
}