package session10.solitarySociable.weatherForecasting.service

import session10.solitarySociable.weatherForecasting.domain.Location
import session10.solitarySociable.weatherForecasting.exception.InvalidLocationCoordinatesException

class LocationEngine {
    fun getLocationFromCoordinates(latitude: Double, longitude: Double): Location {
        if (latitude >= -180 && latitude <= 180) {
            return when {
                longitude >= -90 && longitude < 0 -> Location(
                    locationName = "southern_hemisphere_${latitude}_${longitude}",
                    latitude = latitude,
                    longitude = longitude
                )

                longitude >= 0 && longitude <= 90 -> Location(
                    locationName = "northern_hemisphere_${latitude}_${longitude}",
                    latitude = latitude,
                    longitude = longitude
                )

                else -> throw InvalidLocationCoordinatesException("Invalid value for longitude")
            }
        } else {
            throw InvalidLocationCoordinatesException("Invalid value for latitude")
        }
    }
}