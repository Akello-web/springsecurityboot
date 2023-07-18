package kz.akello.spring.securityboot;

import kz.akello.spring.securityboot.dto.CourseDTO;
import kz.akello.spring.securityboot.mapper.CourseMapper;
import kz.akello.spring.securityboot.model.Course;
import kz.akello.spring.securityboot.repository.CourseRepository;
import kz.akello.spring.securityboot.service.CourseService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TestAPP {

	@Autowired
	private CourseMapper courseMapper;

	@Autowired
	private CourseService courseService;

	@Autowired
	private CourseRepository courseRepository;

	@Test
	void checkCourseDto(){
		Course course = new Course();
		course.setName("Test Course");
		course.setDescription("Test Course to Unit Tests");
		course.setPrice(777);
		course.setId(15L);

		CourseDTO courseDTO = courseMapper.toDTO(course);

		Assertions.assertEquals(course.getName(), courseDTO.getCourseName());
		Assertions.assertEquals(course.getDescription(), courseDTO.getDescription());
		Assertions.assertEquals(course.getPrice(), courseDTO.getPrice());
	}

	@Test
	void checkInsertIntoDB(){
		courseRepository.deleteAll();

		Course course = new Course();
		course.setName("Test Course");
		course.setDescription("Test Course to Unit Tests");
		course.setPrice(777);

		CourseDTO newCourse = courseService.addCourse(courseMapper.toDTO(course));

		Assertions.assertNotNull(newCourse);
		Assertions.assertNotNull(newCourse.getId());
		Assertions.assertEquals(course.getName(), newCourse.getCourseName());
		Assertions.assertEquals(course.getDescription(), newCourse.getDescription());
		Assertions.assertEquals(course.getPrice(), newCourse.getPrice());

		courseRepository.deleteAll();

	}
}
