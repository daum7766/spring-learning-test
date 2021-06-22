package nextstep.helloworld.jdbc.simpleinsert;

import java.util.HashMap;
import java.util.Map;
import nextstep.helloworld.jdbc.Customer;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class SimpleInsertDao {
    private final SimpleJdbcInsert insertActor;

    public SimpleInsertDao(DataSource dataSource) {
        this.insertActor = new SimpleJdbcInsert(dataSource)
                .withTableName("customers")
                .usingGeneratedKeyColumns("id");
    }

    /**
     * Map +
     * insertActor.executeAndReturnKey
     */
    public Customer insertWithMap(Customer customer) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("first_name", customer.getFirstName());
        parameters.put("last_name", customer.getLastName());
        Number number = insertActor.executeAndReturnKey(parameters);
        return new Customer(number.longValue(), customer.getFirstName(), customer.getLastName());
    }

    /**
     * SqlParameterSource +
     * insertActor.executeAndReturnKey
     */
    public Customer insertWithBeanPropertySqlParameterSource(Customer customer) {
        BeanPropertySqlParameterSource parameterSource = new BeanPropertySqlParameterSource(customer);
        long id = insertActor.executeAndReturnKey(parameterSource).longValue();
        return new Customer(id, customer.getFirstName(), customer.getLastName());
    }
}
