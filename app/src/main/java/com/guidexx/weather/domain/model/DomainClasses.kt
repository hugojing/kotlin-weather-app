package com.guidexx.weather.domain.model

/**
 * Created by hugo on 16/3/14.
 */

data class ForecastList(val city: String, val country: String,
                        val dailyForecast: List<Forecast>)
data class Forecast(val data: String, val description: String,
                    val high: Int, val low: Int)
