package kz.akello.spring.securityboot.api;

import kz.akello.spring.securityboot.dto.CourseDTO;
import kz.akello.spring.securityboot.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/courses")
@RequiredArgsConstructor
public class CourseRestController {

    private final CourseService courseService;

    @GetMapping
    public List<CourseDTO> courseList(){
        return courseService.getCourses();
    }

    @GetMapping(value = "{id}")
    public CourseDTO getCourse(@PathVariable("id") Long id){
        return courseService.getCourse(id);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @PostMapping
    public CourseDTO addCourse(@RequestBody CourseDTO course){
        return courseService.addCourse(course);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")

    @PutMapping
    public CourseDTO updateCourse(@RequestBody CourseDTO course){
        return courseService.updateCourse(course);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")

    @DeleteMapping(value = "{id}")
    public void deleteCourse(@PathVariable(name = "id") Long id){
        courseService.deleteCourse(id);
    }

}
