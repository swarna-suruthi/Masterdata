package net.apmoller.athena.microservices.CurrencyProject.repository;

import net.apmoller.athena.microservices.CurrencyProject.models.RoundOff;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoundOffRepository extends ReactiveMongoRepository<RoundOff,String>
{

}
