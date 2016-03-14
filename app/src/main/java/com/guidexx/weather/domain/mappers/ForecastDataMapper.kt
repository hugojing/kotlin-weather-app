package com.guidexx.weather.domain.mappers

/**
 * Created by hugo on 16/3/14.
 */

import com.guidexx.weather.data.Forecast
import com.guidexx.weather.data.ForecastResult
import com.guidexx.weather.domain.model.Forecast as ModelForecast
import com.guidexx.weather.domain.model.ForecastList
import java.text.DateFormat
import java.util.*



class ForecastDataMapper {
    fun convertFromDataModel(forecast: ForecastResult): ForecastList {
        return ForecastList(forecast.city.name, forecast.city.country,
                convertForecastListToDomain(forecast.list))
    }

    private fun convertForecastListToDomain(list: List<Forecast>):
            List<ModelForecast> {
        return list.map { convertForecastItemToDomain(it) }
    }

    private fun convertForecastItemToDomain(forecast: Forecast): ModelForecast {
        return ModelForecast(convertData(forecast.dt),
                forecast.weather[0].description, forecast.temp.max.toInt(),
                forecast.temp.min.toInt())
    }

    private fun convertData(data: Long): String {
        val df = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.getDefault())
        return df.format(data * 1000)
    }

}