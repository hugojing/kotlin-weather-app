package com.guidexx.weather.domain.commands

/**
 * Created by hugo on 16/3/14.
 */

interface Command<T> {
    fun execute(): T
}



