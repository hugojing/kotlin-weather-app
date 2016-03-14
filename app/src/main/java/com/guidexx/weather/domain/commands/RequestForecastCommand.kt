package com.guidexx.weather.domain.commands

import com.guidexx.weather.data.ForecastRequest
import com.guidexx.weather.domain.mappers.ForecastDataMapper
import com.guidexx.weather.domain.model.ForecastList

/**
 * Created by hugo on 16/3/14.
 */
class RequestForecastCommand(val zipCode: String): Command<ForecastList> {
    override fun execute(): ForecastList {
        val forecastRequest = ForecastRequest(zipCode)
        return ForecastDataMapper().convertFromDataModel(
                forecastRequest.execute()
        )
    }
}