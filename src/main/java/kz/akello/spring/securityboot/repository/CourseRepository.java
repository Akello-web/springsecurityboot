package kz.akello.spring.securityboot.repository;

import jakarta.transaction.Transactional;
import kz.akello.spring.securityboot.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface CourseRepository extends JpaRepository<Course, Long> {

}
