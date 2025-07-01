package com.student.app.repo;

import com.student.app.entity.Student;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer> {

    @Query("SELECT DISTINCT s FROM Student s JOIN FETCH s.courses")
    List<Student> findAllWithCourses();

    @Query("SELECT s FROM Student s JOIN s.courses c")
    List<Student> getStudentsWithJoinOnly();

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("Select s from Student s where s.id = :id")
    Optional<Student> findByIdWithLock(@Param("id")Integer id);

}
