package kz.akello.spring.securityboot.mapper;

import kz.akello.spring.securityboot.dto.CourseDTO;
import kz.akello.spring.securityboot.model.Course;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CourseMapper {

    @Mapping(source = "name", target = "courseName")
    CourseDTO toDTO(Course course);

    @Mapping(source = "courseName", target = "name")
    Course toModel(CourseDTO courseDTO);

    List<CourseDTO> toDtoList(List<Course> courseList);
    List<Course> toModelList(List<CourseDTO> coursesDTO);

}
