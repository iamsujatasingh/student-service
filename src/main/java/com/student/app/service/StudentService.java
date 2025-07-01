package com.student.app.service;

import com.student.app.entity.Student;
import com.student.app.repo.StudentRepo;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class StudentService {

    private final StudentRepo studentRepo;
    @Async
    @Transactional
    public void updateStudentName(Integer id, String newName) {
        Student student = studentRepo.findByIdWithLock(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        student.setName(newName);
        // Simulate long-running transaction
        try {
            Thread.sleep(10000); // 10 seconds
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
