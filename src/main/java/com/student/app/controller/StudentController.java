package com.student.app.controller;

import com.student.app.entity.Course;
import com.student.app.entity.Student;
import com.student.app.repo.StudentRepo;
import com.student.app.service.StudentService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class StudentController {

    private final StudentRepo repo;

    private final StudentService service;

    @GetMapping("/join")
    public List<Student> getStudentsWithJoinOnly(){
        List<Student> students = repo.getStudentsWithJoinOnly();
        //Triggering lazy loading manually
        for(Student s: students){
            for(Course c :s.getCourses()){
                System.out.println(s.getName() +" : "+ c.getName());
            }
        }
         return students;
    }

    @GetMapping("/join-fetch")
    public List<Student> findAllWithCourses(){
        List<Student> students = repo.findAllWithCourses();
        //Already loaded course , no extra query
        for(Student s: students){
            for(Course c :s.getCourses()){
                System.out.println(s.getName() +" : "+ c.getName());
            }
        }
        return students;
    }

    @GetMapping("/lock/test1")
    public ResponseEntity<String> updateStudentName(){
        service.updateStudentName(1, "Thread 1");
        return ResponseEntity.ok("Thread 1 started");
    }

    @GetMapping("/lock/test2")
    public ResponseEntity<String> updateStudentName2(){
        service.updateStudentName(1, "Thread 2");
        return ResponseEntity.ok("Thread 2 started");
    }

    @GetMapping("/health")
    public String healthCheck() {
        return "Student Service is running!";
    }

}
