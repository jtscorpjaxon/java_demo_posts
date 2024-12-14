package uz.mohirdev.mohirdev.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import uz.mohirdev.mohirdev.entity.Employee;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository< Employee,Long> {

    @Query("select e from Employee e  where e.name=:name and e.lastName=:lastName")
    List<Employee> findAll(@Param("name") String name,@Param("lastName") String lastName);

    List<Employee> findAllByName(@Param("name") String name);

    @Query(value = "select * from employee e where e.name like :name%",nativeQuery = true)
    List<Employee> findAll(@Param("name") String name);


    List<Employee> findAllByNameLike( String name);
    //equal
    @Query("select e from Employee e  where e.name like :name")
    List<Employee> findAllByNameLikeJPQL(@Param("name") String name);

    List<Employee> findAllByNameStartingWith( String name);
    List<Employee> findAllByNameEndingWith( String name);
    List<Employee> findAllByNameEndingWithOrderByIdDesc( String name);

    @Query("select e from Employee e  where lower(e.name) like lower(concat(:name,'%') ) ")
    List<Employee> findAllByNameStartLikeJPQL(@Param("name") String name);

}
