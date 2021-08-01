package net.apmoller.athena.microservices.CurrencyProject.repository;

import net.apmoller.athena.microservices.CurrencyProject.models.CurrencyConversion;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyConversionRepository extends ReactiveMongoRepository<CurrencyConversion,String>
{

}

