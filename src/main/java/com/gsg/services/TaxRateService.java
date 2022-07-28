package com.gsg.services;

import com.gsg.enums.Country;
import com.gsg.exceptions.InvalidRateException;

public interface TaxRateService {

    double getVAT(Country country) throws InvalidRateException;

}
