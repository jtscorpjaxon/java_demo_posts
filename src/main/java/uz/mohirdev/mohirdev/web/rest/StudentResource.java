package uz.mohirdev.mohirdev.web.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.mohirdev.mohirdev.model.Course;
import uz.mohirdev.mohirdev.model.Student;

import java.util.*;

@RestController
@RequestMapping("/api")
//@RequestBody
//@PathVariable
//@RequestParam
public class StudentResource {
    /*
    @GetMapping("/students")
        public String getStudents(){
            return "Hello Students";
        }
     */
    @GetMapping("/students")
    public ResponseEntity getStudents() {
        return ResponseEntity.ok("Students");
    }

    /*   @RequestMapping(value = "/students/",method= RequestMethod.GET)
       public String getStudents2(){
           return "Hello Students";
       }*/
    @PostMapping("/students")
    public ResponseEntity create(@RequestBody Student student) {
        return ResponseEntity.ok(student);
    }
    @PostMapping("/students/list")
    public ResponseEntity createAll(@RequestBody List<Student> studenta) {
        return ResponseEntity.ok(studenta);
    }

    @PutMapping("/students")
    public ResponseEntity update(@RequestBody Student student) {
        student.setLastname("nayni");
        return ResponseEntity.ok(student);
    }

    @PutMapping("/students/{id}")
    public ResponseEntity updateSecond(@PathVariable Long id, @RequestBody Student student) {
        student.setLastname("nayni");
        return ResponseEntity.ok(student);
    }

   /* @GetMapping("/students/{id}")
    public ResponseEntity getStudent(@PathVariable Long id) {
        Student student = new Student(1l,"22","4848",9,new Course());
        student.setId(id);
        return ResponseEntity.ok(student);
    }*/

    @GetMapping("/students/{id}")
    public ResponseEntity getAll(
            @RequestParam Long id,
            @RequestParam String name,
            @RequestParam String lastname,
            @RequestParam Integer age
    ) {
        List<Student> students = new ArrayList<>();
        students.add(new Student(id, name, lastname, age,new Course()));
        return ResponseEntity.ok(students);
    }


    @DeleteMapping("/students/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        return ResponseEntity.ok("Ketdi" + id);
    }

    @PatchMapping("/students/{id}")
    public ResponseEntity edit(@PathVariable Long id, @RequestBody Student student) {
        return ResponseEntity.ok(student);
    }
}
