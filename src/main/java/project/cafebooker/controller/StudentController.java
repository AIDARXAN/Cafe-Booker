package project.cafebooker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import project.cafebooker.entity.Course;
import project.cafebooker.service.StudentService;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/students/{studentId}/courses")
    public List<Course> retrieveCoursesForStudent(@PathVariable String studentId){
        return studentService.retrieveCourses(studentId);
    }
}
