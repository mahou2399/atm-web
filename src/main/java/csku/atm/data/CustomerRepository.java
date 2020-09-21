package csku.atm.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import csku.atm.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
