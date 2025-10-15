package accesdades.ra2.ac1.accesdades_ra2_ac1.controller;



import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import accesdades.ra2.ac1.accesdades_ra2_ac1.model.Student;
import accesdades.ra2.ac1.accesdades_ra2_ac1.model.repository.StudentRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


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

    
}
