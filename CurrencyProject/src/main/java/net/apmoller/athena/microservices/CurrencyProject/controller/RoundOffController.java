package net.apmoller.athena.microservices.CurrencyProject.controller;

import net.apmoller.athena.microservices.CurrencyProject.dto.RoundOffDto;
import net.apmoller.athena.microservices.CurrencyProject.services.RoundOffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/roundoff")
public class RoundOffController
{
    @Autowired
    private RoundOffService roundOffService;

    //GET ALL ROUND OFF DATAS
    @GetMapping
    public Flux<RoundOffDto> getAllRoundDatas()
    {
        return roundOffService.getAllRoundOffDatas();
    }

    //INSERT ROUND OFF DATA
    @PostMapping
    public Mono<RoundOffDto> saveRoundData(@RequestBody Mono<RoundOffDto> roundOffDtoMono)
    {
        return roundOffService.saveRoundOffData(roundOffDtoMono);
    }

    //GET ROUND OFF DATA BY ID
    @GetMapping("/{id}")
    public Mono<RoundOffDto> getRoundDataByCode(@PathVariable String id)
    {
        return roundOffService.getRoundOffDataByCode(id);
    }

    //DELETE ROUND OFF DATA BY ID
    @DeleteMapping("/delete/{id}")
    public Mono<Void> deleteRoundData(@PathVariable String id)
    {
        return roundOffService.deleteRoundOffData(id);
    }

    //UPDATE ROUND OFF DATA BY ID
    @PutMapping("/update/{id}")
    public Mono<RoundOffDto> updateRoundData(@RequestBody Mono<RoundOffDto> roundOffDtoMono, @PathVariable String id)
    {
        return roundOffService.updateRoundOffData(roundOffDtoMono,id);
    }

}
