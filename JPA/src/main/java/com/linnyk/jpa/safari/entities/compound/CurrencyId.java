package com.linnyk.jpa.safari.entities.compound;

import java.io.Serializable;

public class CurrencyId implements Serializable {

	private String name;
	private String countryName;

	public CurrencyId(){

	}

	public CurrencyId(String name, String countryName) {
		this.name = name;
		this.countryName = countryName;
	}

	public final String getName() {
		return name;
	}

	public final String getCountryName() {
		return countryName;
	}

}
