package org.example.Repositories;

import org.example.MainClasses.Customers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customers, Long> {

    @Query("SELECT count(*) FROM Customers")
    long countJobData();
}
