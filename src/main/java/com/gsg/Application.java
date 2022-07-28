package com.gsg;

import com.gsg.datasource.RateSource;
import com.gsg.enums.Country;
import com.gsg.services.NetCalculatorService;
import com.gsg.services.impl.NetCalculator;
import com.gsg.services.impl.TaxRateProvider;

public class Application {

    public static void main (String[] args) {
        NetCalculatorService service = new NetCalculator(new TaxRateProvider(new RateSource()));
        System.out.println(service.calculateNetPrice(Double.parseDouble(args[0]), Country.valueOf(args[1])));
    }

}
