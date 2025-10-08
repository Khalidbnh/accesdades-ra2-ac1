package accesdades.ra2.ac1.accesdades_ra2_ac1.controller;



import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api")
public class StudentController {

    @GetMapping("/students")
    public String getStudents() {
        return "Endpoint GET Students";
    }

    @PostMapping("/students/batch")
    public String addStudent() {
        return "Endpoint POST Students";
    }
}
