package com.guidexx.weather.ui.adapters

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import com.guidexx.weather.domain.model.ForecastList


class ForecastListAdapter(val weekForecast: ForecastList) : RecyclerView.Adapter<ForecastListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): com.guidexx.weather.ui.adapters.ForecastListAdapter.ViewHolder {
        return com.guidexx.weather.ui.adapters.ForecastListAdapter.ViewHolder(TextView(parent.context))
    }

    override fun onBindViewHolder(holder: com.guidexx.weather.ui.adapters.ForecastListAdapter.ViewHolder, position: Int) {
        with(weekForecast.dailyForecast[position]) {
            holder.textView.text = "$data - $description - $high/$low"
        }
    }

    override fun getItemCount(): Int = weekForecast.dailyForecast.size

    class ViewHolder(val textView: TextView) : RecyclerView.ViewHolder(textView)
}