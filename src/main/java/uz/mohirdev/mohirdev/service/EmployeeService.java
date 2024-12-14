package uz.mohirdev.mohirdev.service;

import org.springframework.stereotype.Service;
import uz.mohirdev.mohirdev.entity.Employee;
import uz.mohirdev.mohirdev.repository.EmployeeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee save(Employee employee){
        return employeeRepository.save(employee);
    }

    public Employee findById(Long id){
        Optional <Employee> optional =employeeRepository.findById(id);
        if (optional.isPresent()){
            return optional.get();
        }
        return null;
    }

    public List<Employee> findAll(String name){
        List<Employee> employees= employeeRepository.findAll(name);
        return employees;
    }

    public List<Employee> findByQueryParameters(String name){
        return employeeRepository.findAllByNameStartLikeJPQL(name);
    }

    public void delete(Long id){
        employeeRepository.deleteById(id);
    }
}
