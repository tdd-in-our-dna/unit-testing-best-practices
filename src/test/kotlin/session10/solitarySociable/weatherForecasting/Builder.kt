package session10.solitarySociable.weatherForecasting

import session10.solitarySociable.weatherForecasting.domain.ClimateType
import session10.solitarySociable.weatherForecasting.domain.ClimateType.SUNNY
import session10.solitarySociable.weatherForecasting.domain.Location
import session10.solitarySociable.weatherForecasting.service.WeatherCondition

fun buildWeatherCondition(
    location: Location = buildLocation(),
    climateType: ClimateType = SUNNY,
    temperatureInCelsius: Double = 0.0
): WeatherCondition {
    return WeatherCondition(
        location = location,
        climateType = climateType,
        temperatureInCelsius = temperatureInCelsius
    )
}

fun buildLocation(
    locationName: String = "",
    latitude: Double = 0.0,
    longitude: Double = 0.0
): Location {
    return Location(
        locationName = locationName,
        latitude = latitude,
        longitude = longitude
    )
}
