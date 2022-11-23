package session10.solitarySociable.weatherForecasting.service

import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Test
import session10.solitarySociable.weatherForecasting.annotation.Sociable
import session10.solitarySociable.weatherForecasting.buildLocation
import session10.solitarySociable.weatherForecasting.buildWeatherCondition
import session10.solitarySociable.weatherForecasting.domain.ClimateType
import kotlin.test.assertEquals

// 90% Solitary & 10% Sociable Unit Tests
class WeatherForecastTestV3 {
    @Test
    fun `should return SUNNY weather condition for location with latitude greater than minus90 and less than minus45`() {
        val locationEngine = mockk<LocationEngine>()
        val weatherForecast = WeatherForecast(locationEngine)
        val expectedLocation = buildLocation(
            locationName = "location_name_-50.2_25.8",
            latitude = -50.2,
            longitude = 25.8
        )
        val expectedWeatherCondition = buildWeatherCondition(
            location = expectedLocation,
            climateType = ClimateType.SUNNY,
            temperatureInCelsius = 35.7
        )
        every { locationEngine.getLocationFromCoordinates(any(), any()) } returns expectedLocation

        val actualWeatherCondition = weatherForecast.getWeatherConditionFromCoordinates(-50.2, 25.8)

        assertEquals(expectedWeatherCondition, actualWeatherCondition)
    }

    @Test
    fun `should return WARM weather condition for location with latitude greater than minus45 and less than 0`() {
        val locationEngine = mockk<LocationEngine>()
        val weatherForecast = WeatherForecast(locationEngine)
        val expectedLocation = buildLocation(
            locationName = "location_name_-10.2_25.8",
            latitude = -10.2,
            longitude = 25.8
        )
        val expectedWeatherCondition = buildWeatherCondition(
            location = expectedLocation,
            climateType = ClimateType.WARM,
            temperatureInCelsius = 35.7
        )
        every { locationEngine.getLocationFromCoordinates(any(), any()) } returns expectedLocation

        val actualWeatherCondition = weatherForecast.getWeatherConditionFromCoordinates(-10.2, 25.8)

        assertEquals(expectedWeatherCondition, actualWeatherCondition)
    }

    @Test
    fun `should return COOL weather condition for location with latitude greater than 0 and less than plus45`() {
        val locationEngine = mockk<LocationEngine>()
        val weatherForecast = WeatherForecast(locationEngine)
        val expectedLocation = buildLocation(
            locationName = "location_name_10.2_25.8",
            latitude = 10.2,
            longitude = 25.8
        )
        val expectedWeatherCondition = buildWeatherCondition(
            location = expectedLocation,
            climateType = ClimateType.COOL,
            temperatureInCelsius = 35.7
        )
        every { locationEngine.getLocationFromCoordinates(any(), any()) } returns expectedLocation

        val actualWeatherCondition = weatherForecast.getWeatherConditionFromCoordinates(10.2, 25.8)

        assertEquals(expectedWeatherCondition, actualWeatherCondition)
    }

    @Test
    fun `should return COLD weather condition for location with latitude greater than plus45 and less than plus90`() {
        val locationEngine = mockk<LocationEngine>()
        val weatherForecast = WeatherForecast(locationEngine)
        val expectedLocation = buildLocation(
            locationName = "location_name_50.2_25.8",
            latitude = 50.2,
            longitude = 25.8
        )
        val expectedWeatherCondition = buildWeatherCondition(
            location = expectedLocation,
            climateType = ClimateType.COLD,
            temperatureInCelsius = 35.7
        )
        every { locationEngine.getLocationFromCoordinates(any(), any()) } returns expectedLocation

        val actualWeatherCondition = weatherForecast.getWeatherConditionFromCoordinates(50.2, 25.8)

        assertEquals(expectedWeatherCondition, actualWeatherCondition)
    }

    @Test
    @Sociable
    fun `should return weather condition for given location coordinates`() {
        val locationEngine = LocationEngine()
        val location = buildLocation(
            locationName = "northern_hemisphere_10.2_25.8",
            latitude = 10.2,
            longitude = 25.8
        )
        val weatherForecast = WeatherForecast(locationEngine)
        val expectedWeatherCondition = buildWeatherCondition(
            location = location,
            climateType = ClimateType.COOL,
            temperatureInCelsius = 35.7
        )

        val actualWeatherCondition = weatherForecast.getWeatherConditionFromCoordinates(10.2, 25.8)

        assertEquals(expectedWeatherCondition, actualWeatherCondition)
    }
}