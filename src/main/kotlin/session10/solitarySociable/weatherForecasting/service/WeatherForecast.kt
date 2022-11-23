package session10.solitarySociable.weatherForecasting.service

import session10.solitarySociable.weatherForecasting.domain.ClimateType
import session10.solitarySociable.weatherForecasting.domain.Location

class WeatherForecast(private val locationEngine: LocationEngine) {

    fun getWeatherConditionFromCoordinates(latitude: Double, longitude: Double): WeatherCondition {
        val location = locationEngine.getLocationFromCoordinates(latitude, longitude)
        val climateType = getClimateForLocation(location)

        return WeatherCondition(
            location = location,
            climateType = climateType,
            temperatureInCelsius = 35.7
        )
    }

    private fun getClimateForLocation(location: Location): ClimateType {
        return if(location.latitude >= -90 && location.latitude <= -45) {
            ClimateType.SUNNY
        } else if(location.latitude > -45 && location.latitude <= 0) {
            ClimateType.WARM
        } else if(location.latitude > 0 && location.latitude <= 45) {
            ClimateType.COOL
        } else {
            ClimateType.COLD
        }
    }
}

data class WeatherCondition(
    val location: Location,
    val climateType: ClimateType,
    val temperatureInCelsius: Double
)
