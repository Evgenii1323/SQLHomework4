package com.example.sqlhomework4;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface CustomizedJpaRepository extends JpaRepository<Person, String> {
    List<Person> findByCityOfLiving(String city);

    @Query(value = "SELECT * FROM PERSON WHERE age < ?1 ORDER BY age ASC", nativeQuery = true)
    List<Person> findByAge(int age);

    Optional<Person> findByNameAndSurname(String name, String surname);
}