package com.guidexx.weather.ui.activities

import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.view.View
import android.view.Menu
import android.view.MenuItem
import com.guidexx.weather.R
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.find
import org.jetbrains.anko.async
import org.jetbrains.anko.longToast
import org.jetbrains.anko.uiThread
import android.support.v7.widget.LinearLayoutManager
import com.guidexx.weather.domain.commands.RequestForecastCommand
import com.guidexx.weather.ui.adapters.ForecastListAdapter


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val forecastList: RecyclerView = find(R.id.forecast_list)
        forecastList.layoutManager = LinearLayoutManager(this)

        async() {
            val result = RequestForecastCommand("hangzhou").execute()
            uiThread {
                longToast("已获取最新预报")
                forecastList.adapter = ForecastListAdapter(result)
            }
        }
    }
}
