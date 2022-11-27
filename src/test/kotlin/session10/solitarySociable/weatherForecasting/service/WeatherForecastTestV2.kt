package session10.solitarySociable.weatherForecasting.service

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import session10.solitarySociable.weatherForecasting.buildLocation
import session10.solitarySociable.weatherForecasting.buildWeatherCondition
import session10.solitarySociable.weatherForecasting.domain.ClimateType
import session10.solitarySociable.weatherForecasting.domain.ClimateType.*
import session10.solitarySociable.weatherForecasting.exception.InvalidLocationCoordinatesException
import kotlin.test.assertEquals

// Sociable Unit Tests (Classist Approach)
class WeatherForecastTestV2 {
    @Test
    fun `should return SUNNY weather condition for location with latitude greater than minus 90 and less than minus 45`() {
        val locationEngine = LocationEngine()
        val weatherForecast = WeatherForecast(locationEngine)
        val expectedLocation = buildLocation(
            locationName = "northern_hemisphere_-50.2_25.8",
            latitude = -50.2,
            longitude = 25.8
        )
        val expectedWeatherCondition = buildWeatherCondition(
            location = expectedLocation,
            climateType = SUNNY,
            temperatureInCelsius = 35.7
        )

        val actualWeatherCondition = weatherForecast.getWeatherConditionFromCoordinates(-50.2, 25.8)

        assertEquals(expectedWeatherCondition, actualWeatherCondition)
    }

    @Test
    fun `should return WARM weather condition for location with latitude greater than minus 45 and less than 0`() {
        val locationEngine = LocationEngine()
        val weatherForecast = WeatherForecast(locationEngine)
        val expectedLocation = buildLocation(
            locationName = "northern_hemisphere_-10.2_25.8",
            latitude = -10.2,
            longitude = 25.8
        )
        val expectedWeatherCondition = buildWeatherCondition(
            location = expectedLocation,
            climateType = WARM,
            temperatureInCelsius = 35.7
        )

        val actualWeatherCondition = weatherForecast.getWeatherConditionFromCoordinates(-10.2, 25.8)

        assertEquals(expectedWeatherCondition, actualWeatherCondition)
    }

    @Test
    fun `should return COOL weather condition for location with latitude greater than 0 and less than plus 45`() {
        val locationEngine = LocationEngine()
        val weatherForecast = WeatherForecast(locationEngine)
        val expectedLocation = buildLocation(
            locationName = "northern_hemisphere_10.2_25.8",
            latitude = 10.2,
            longitude = 25.8
        )
        val expectedWeatherCondition = buildWeatherCondition(
            location = expectedLocation,
            climateType = COOL,
            temperatureInCelsius = 35.7
        )

        val actualWeatherCondition = weatherForecast.getWeatherConditionFromCoordinates(10.2, 25.8)

        assertEquals(expectedWeatherCondition, actualWeatherCondition)
    }

    @Test
    fun `should return COLD weather condition for location with latitude greater than plus 45 and less than plus 90`() {
        val locationEngine = LocationEngine()
        val weatherForecast = WeatherForecast(locationEngine)
        val expectedLocation = buildLocation(
            locationName = "northern_hemisphere_50.2_25.8",
            latitude = 50.2,
            longitude = 25.8
        )
        val expectedWeatherCondition = buildWeatherCondition(
            location = expectedLocation,
            climateType = COLD,
            temperatureInCelsius = 35.7
        )

        val actualWeatherCondition = weatherForecast.getWeatherConditionFromCoordinates(50.2, 25.8)

        assertEquals(expectedWeatherCondition, actualWeatherCondition)
    }
}