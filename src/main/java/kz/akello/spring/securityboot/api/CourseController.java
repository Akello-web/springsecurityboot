package kz.akello.spring.securityboot.api;

import kz.akello.spring.securityboot.dto.CourseDTO;
import kz.akello.spring.securityboot.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/courses")
public class CourseController {

    private final CourseService courseService;

    @GetMapping(value = "/get-course-list")
    public List<CourseDTO> getCourses(){
        return courseService.getCourses();
    }

    @PostMapping(value = "/add-course")
    public CourseDTO addCourse(@RequestBody CourseDTO course){
        return courseService.addCourse(course);
    }

}
