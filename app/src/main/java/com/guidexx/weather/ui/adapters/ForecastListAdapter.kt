package com.guidexx.weather.ui.adapters

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*


class ForecastListAdapter(val items: List<String>) : RecyclerView.Adapter<ForecastListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): com.guidexx.weather.ui.adapters.ForecastListAdapter.ViewHolder {
        return com.guidexx.weather.ui.adapters.ForecastListAdapter.ViewHolder(TextView(parent.context))
    }

    override fun onBindViewHolder(holder: com.guidexx.weather.ui.adapters.ForecastListAdapter.ViewHolder, position: Int) {
        holder.textView.text = items[position]
    }

    override fun getItemCount(): Int = items.size

    class ViewHolder(val textView: TextView) : RecyclerView.ViewHolder(textView)
}