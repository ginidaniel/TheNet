package com.gsg.services.impl;

import com.gsg.enums.Country;
import com.gsg.exceptions.InvalidRateException;
import com.gsg.services.NetCalculatorService;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class NetCalculator implements NetCalculatorService {

    TaxRateProvider taxRateProvider;

    public NetCalculator(TaxRateProvider taxRateProvider) {
        this.taxRateProvider = taxRateProvider;
    }

    @Override
    public double calculateNetPrice(double grossPrice, Country countryIso) throws IllegalArgumentException, InvalidRateException {
        if (grossPrice<0) throw new IllegalArgumentException("The Gross Amount can not be negative.");
        return BigDecimal
                .valueOf(grossPrice - grossPrice * taxRateProvider.getVAT(countryIso))
                .setScale(1, RoundingMode.HALF_UP)
                .doubleValue();
    }

}
