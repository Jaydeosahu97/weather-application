package com.jay.wishlistservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "cities")
@IdClass(CityId.class)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class City {
	private String city;
	private String country;
	@Id
	private double lat;
	@Id
	private double lon;
	@Id
	private String username;
}
