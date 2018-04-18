package may.i.jhq;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 *  @author    May
 *  @date      2018/4/17 13:21
 *  @version   1.0
 */
public interface CustomerRepository extends MongoRepository<Customer, String> {


}
