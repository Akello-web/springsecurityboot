package kz.akello.spring.securityboot.service;

import kz.akello.spring.securityboot.dto.CourseDTO;
import kz.akello.spring.securityboot.mapper.CourseMapper;
import kz.akello.spring.securityboot.model.Course;
import kz.akello.spring.securityboot.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;

    public List<CourseDTO> getCourses(){
        return courseMapper.toDtoList(courseRepository.findAll());
    }

//    public List<CourseDTO> getCourses(){
//        List<CourseDTO> courses = new ArrayList<>();
//        List<Course> courseList = courseRepository.findAll();
//        for (Course c : courseList){
//            courses.add(convertToDTO(c));
//        }
//
//        return courses;
//    }

    public CourseDTO addCourse(CourseDTO course){
        return courseMapper.toDTO(courseRepository.save(courseMapper.toModel(course)));
    }

    public CourseDTO getCourse(Long id){
        return courseMapper.toDTO(courseRepository.findById(id).orElse(new Course()));
    }

    public CourseDTO updateCourse(CourseDTO course){
        return courseMapper.toDTO(courseRepository.save(courseMapper.toModel(course)));
    }

    public void deleteCourse(Long id){
        courseRepository.deleteById(id);
    }

//    private CourseDTO convertToDTO(Course course){
//        CourseDTO courseDTO = new CourseDTO();
//        courseDTO.setId(course.getId());
//        courseDTO.setTitle(course.getName());
//        courseDTO.setDescription(course.getDescription());
//        courseDTO.setPrice(course.getPrice());
//        return courseDTO;
//    }

}
