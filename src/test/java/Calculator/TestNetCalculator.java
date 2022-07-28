package Calculator;

import com.gsg.datasource.RateSource;
import com.gsg.exceptions.InvalidRateException;
import com.gsg.services.impl.NetCalculator;
import com.gsg.services.impl.TaxRateProvider;
import com.gsg.enums.Country;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test   ;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class TestNetCalculator {

    NetCalculator calculator;

    @BeforeEach
    public void init() {
        calculator = new NetCalculator(new TaxRateProvider(new RateSource()));
    }

    @Test
    public void testCalculateNetDE () {
        assertEquals(81, calculator.calculateNetPrice(100, Country.DE));
    }

    @Test
    public void testCalculateNetFR () {
        assertEquals(1.6, calculator.calculateNetPrice(1.99, Country.FR));
    }

    @Test
    public void testCalculate0 () {
        assertEquals(0, calculator.calculateNetPrice(0, Country.FR));
    }

    @Test
    public void testCalculateNegative () {
        assertThrows(IllegalArgumentException.class, () -> calculator.calculateNetPrice(-10, Country.FR), "The Gross Amount can not be negative");
    }

    @Test
    public void testCalculateNetES () {
        assertThrows(InvalidRateException.class, () -> calculator.calculateNetPrice(10, Country.ES), "Invalid or unmapped country: ES");
    }

}
