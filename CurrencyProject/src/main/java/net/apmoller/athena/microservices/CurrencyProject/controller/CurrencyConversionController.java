package net.apmoller.athena.microservices.CurrencyProject.controller;


import net.apmoller.athena.microservices.CurrencyProject.dto.CurrencyCodeDto;
import net.apmoller.athena.microservices.CurrencyProject.dto.CurrencyConversionDto;
import net.apmoller.athena.microservices.CurrencyProject.services.CurrencyConversionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/currencyconversion")
public class CurrencyConversionController
{
    @Autowired
    private CurrencyConversionService currencyConversionService;

    //GET ALL CURRENCY CONVERSION DATAS
    @GetMapping
    public Flux<CurrencyConversionDto> getAllDatas()
    {
        return currencyConversionService.getAllCurrencyDatas();
    }

    //INSERT CURRENCY CONVERSION DATA
    @PostMapping
    public Mono<CurrencyConversionDto> saveData(@RequestBody Mono<CurrencyConversionDto> currencyConversionDtoMono)
    {
        return currencyConversionService.saveCurrencyData(currencyConversionDtoMono);
    }

    //GET CURRENCY CONVERSION DATA BY ID
    @GetMapping("/{id}")
    public Mono<CurrencyConversionDto> getDataByCode(@PathVariable String id)
    {
        return currencyConversionService.getCurrencyDataByCode(id);
    }

    //DELETE CURRENCY CONVERSION DATA BY ID
    @DeleteMapping("/delete/{id}")
    public Mono<Void> deleteData(@PathVariable String id)
    {
        return currencyConversionService.deleteCurrencyData(id);
    }

    //UPDATE CURRENCY CONVERSION DATA BY ID
    @PutMapping("/update/{id}")
    public Mono<CurrencyConversionDto> updateData(@RequestBody Mono<CurrencyConversionDto> currencyConversionDtoMono, @PathVariable String id)
    {
        return currencyConversionService.updateCurrencyData(currencyConversionDtoMono,id);
    }

}
