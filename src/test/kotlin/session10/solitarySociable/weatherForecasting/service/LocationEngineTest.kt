package session10.solitarySociable.weatherForecasting.service

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import session10.solitarySociable.weatherForecasting.buildLocation
import session10.solitarySociable.weatherForecasting.exception.InvalidLocationCoordinatesException

class LocationEngineTest {
    @Test
    fun `should return valid northern hemisphere location value for latitude greater than minus 180 and less than plus 180`() {
        val locationEngine = LocationEngine()
        val expectedLocation = buildLocation(
            locationName = "northern_hemisphere_-50.12_34.12",
            latitude = -50.12,
            longitude = 34.12
        )

        val actualLocation = locationEngine.getLocationFromCoordinates(-50.12, 34.12)

        assertEquals(expectedLocation, actualLocation)
    }

    @Test
    fun `should return valid northern hemisphere location value for longitude greater than 0 and less than plus 90`() {
        val locationEngine = LocationEngine()
        val expectedLocation = buildLocation(
            locationName = "northern_hemisphere_23.12_34.12",
            latitude = 23.12,
            longitude = 34.12
        )

        val actualLocation = locationEngine.getLocationFromCoordinates(23.12, 34.12)

        assertEquals(expectedLocation, actualLocation)
    }

    @Test
    fun `should return valid southern hemisphere location value for longitude greater than minus 90 and less than 0`() {
        val locationEngine = LocationEngine()
        val expectedLocation = buildLocation(
            locationName = "southern_hemisphere_23.12_-34.12",
            latitude = 23.12,
            longitude = -34.12
        )

        val actualLocation = locationEngine.getLocationFromCoordinates(23.12, -34.12)

        assertEquals(expectedLocation, actualLocation)
    }

    @Test
    fun `should throw exception for invalid latitude coordinates`() {
        val locationEngine = LocationEngine()

        assertThrows<InvalidLocationCoordinatesException> {
            locationEngine.getLocationFromCoordinates(-230.45, 46.12)
        }.message contentEquals "Invalid value for latitude"
    }

    @Test
    fun `should throw exception for invalid longitude coordinates`() {
        val locationEngine = LocationEngine()

        assertThrows<InvalidLocationCoordinatesException> {
            locationEngine.getLocationFromCoordinates(-20.45, 456.12)
        }.message contentEquals "Invalid value for longitude"
    }
}