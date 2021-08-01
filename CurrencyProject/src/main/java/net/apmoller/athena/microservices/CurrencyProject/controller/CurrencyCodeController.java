package net.apmoller.athena.microservices.CurrencyProject.controller;

import net.apmoller.athena.microservices.CurrencyProject.dto.CurrencyCodeDto;
import net.apmoller.athena.microservices.CurrencyProject.services.CurrencyCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/currencycode")
public class CurrencyCodeController
{
    @Autowired
    private CurrencyCodeService currencyCodeService;

    //GET ALL CURRENCY CODE DATAS
    @GetMapping
    public Flux<CurrencyCodeDto> getAllCodeDatas()
    {
        return currencyCodeService.getAllCurrencyCodeDatas();
    }

    //INSERT CURRENCY CODE DATA
    @PostMapping
    public Mono<CurrencyCodeDto> saveCodeData(@RequestBody Mono<CurrencyCodeDto> currencyCodeDtoMono)
    {
        return currencyCodeService.saveCurrencyCodeData(currencyCodeDtoMono);
    }

    //GET CURRENCY CODE DATA BY ID
    @GetMapping("/{id}")
    public Mono<CurrencyCodeDto> getCodeDataByCode(@PathVariable String id)
    {
        return currencyCodeService.getCurrencyCodeDataByCode(id);
    }

    //DELETE CURRENCY CODE DATA BY ID
    @DeleteMapping("/delete/{id}")
    public Mono<Void> deleteCodeData(@PathVariable String id)
    {
        return currencyCodeService.deleteCurrencyCodeData(id);
    }

    //UPDATE CURRENCY CODE DATA BY ID
    @PutMapping("/update/{id}")
    public Mono<CurrencyCodeDto> updateData(@RequestBody Mono<CurrencyCodeDto> currencyCodeDtoMono, @PathVariable String id)
    {
        return currencyCodeService.updateCurrencyCodeData(currencyCodeDtoMono,id);
    }



}
