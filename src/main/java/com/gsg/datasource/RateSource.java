package com.gsg.datasource;

import com.gsg.enums.Country;
import com.gsg.exceptions.InvalidRateException;
import com.gsg.utils.RateMapper;

import java.util.Properties;

public class RateSource {

    public Properties mapper = RateMapper.getMapper();

    public double fetchRateByCountry(Country country) throws InvalidRateException {
        String rate =  mapper.getProperty(country.name());
        if (rate!=null)
            return Double.parseDouble(rate);
        throw new InvalidRateException(country.name());
    }

}
