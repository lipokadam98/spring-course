package com.luv2code.springboot.cruddemo.dao;

import com.luv2code.springboot.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

//@RepositoryRestResource(path = "members")
/*
A HATEOAS (Hypermedia as the Engine of Application State)
 egy REST (Representational State Transfer) architektúra alapkövetelménye,
  amely azt jelenti, hogy a szerver válasza nem csak az adatokat,
   hanem a következő lehetséges lépéseket és hivatkozásokat is tartalmazza,
    így a kliens maga "navigálhat" az API-n keresztül, anélkül,
     hogy előre ismernie kellene az összes végpontot (endpoint).
Ezáltal az API dinamikusabb, rugalmasabb és jobban "önleíró",
hasonlóan egy weboldalhoz, ahol a linkek és gombok határozzák meg a továbblépést.
 */
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
