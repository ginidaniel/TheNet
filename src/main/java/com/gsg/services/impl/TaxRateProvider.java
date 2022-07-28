package com.gsg.services.impl;

import com.gsg.datasource.RateSource;
import com.gsg.enums.Country;
import com.gsg.exceptions.InvalidRateException;
import com.gsg.services.TaxRateService;

public class TaxRateProvider implements TaxRateService {

    RateSource rateSource;

    public TaxRateProvider(RateSource rateSource) {
        this.rateSource = rateSource;
    }

    @Override
    public double getVAT(Country country) throws InvalidRateException {
        return rateSource.fetchRateByCountry(country);
    }

}
