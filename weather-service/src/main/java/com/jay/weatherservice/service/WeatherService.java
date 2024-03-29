package com.jay.weatherservice.service;

import java.util.List;

import com.jay.weatherservice.model.Coord;
import com.jay.weatherservice.model.Location;
import com.jay.weatherservice.model.WeatherResponse;

public interface WeatherService {
	List<Location> search(String city);

	WeatherResponse getWeather(Coord coord);
}
