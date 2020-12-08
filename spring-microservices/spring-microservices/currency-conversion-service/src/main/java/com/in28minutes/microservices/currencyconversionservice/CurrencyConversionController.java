package com.in28minutes.microservices.currencyconversionservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@RestController
public class CurrencyConversionController {

    @Autowired
    CurrencyExchangeServiceProxy currencyExchangeServiceProxy;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversionBeen convertCurrency(
            @PathVariable String from,
            @PathVariable String to,
            @PathVariable BigDecimal quantity
    ) {

        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("from", from);
        uriVariables.put("to", to);
        ResponseEntity<CurrencyConversionBeen> responseEntity = new RestTemplate().getForEntity(
                "http://localhost:8000/currency-exchange/from/{from}/to/{to}",
                CurrencyConversionBeen.class,
                uriVariables);
        CurrencyConversionBeen response = responseEntity.getBody();

        logger.info("{}", response);

        return new CurrencyConversionBeen(
                response.getId(),
                from,
                to,
                response.getConversionMultiple(),
                response.getConversionMultiple().multiply(quantity),
                response.getPort()
        );
    }

    @GetMapping("/currency-conversion-feign/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversionBeen convertCurrencyFeign(
            @PathVariable String from,
            @PathVariable String to,
            @PathVariable BigDecimal quantity
    ) {
        CurrencyConversionBeen response = currencyExchangeServiceProxy.retrieveExchangeValue(from, to);

        return new CurrencyConversionBeen(
                response.getId(),
                from,
                to,
                response.getConversionMultiple(),
                response.getConversionMultiple().multiply(quantity),
                response.getPort()
        );
    }
}
