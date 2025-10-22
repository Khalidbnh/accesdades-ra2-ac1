package accesdades.ra2.ac1.accesdades_ra2_ac1.controller;



import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import accesdades.ra2.ac1.accesdades_ra2_ac1.model.Student;
import accesdades.ra2.ac1.accesdades_ra2_ac1.model.repository.StudentRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/api")
public class StudentController {

    @Autowired
    StudentRepository studentRepository;

    @GetMapping("/students")
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    @PostMapping("/students/batch")
    public String addStudent() {
        int numReg = studentRepository.save();
        return "You added " + numReg + " student(s)";
    }

    @GetMapping("/students/{student_id}")
    public String getStudentById(@PathVariable Long id) {
        return "Student id: " + id;
    }  


    @PatchMapping("/students")
    public String updateStudent(@RequestParam String name, @RequestParam int age) {
        return "Updated student name: " + name + " with age: " + age;
    }

    @PostMapping("/students")
    public String addStudents(@RequestBody Student students) {
        return "Added student name: " + students.getName() + " with age: " + students.getAge();
    }


   @PostMapping("/students2")
    public ResponseEntity<String> addStudents2(@RequestBody Student students) {
        String msg= "Added student name: " + students.getName() + " with age: " + students.getAge();
        return ResponseEntity.status(HttpStatus.CREATED).body(msg);
    }

}
