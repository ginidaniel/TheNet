package com.gsg.services;

import com.gsg.enums.Country;
import com.gsg.exceptions.InvalidRateException;

public interface NetCalculatorService {

    double calculateNetPrice(double grossPrice, Country countryIso) throws IllegalArgumentException, InvalidRateException;

}
