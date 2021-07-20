package com.springrest.springrest.controller;

import com.springrest.springrest.entities.Courses;
import com.springrest.springrest.services.CourseService;
import com.springrest.springrest.services.CourseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MyController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/home")
    public String home()
    {
        return "This is home string from /home";
    }

    //Get the courses
    @GetMapping("/courses")
    public List<Courses> getCourses()
    {
       // return new CourseServiceImpl().getCourses();
        return courseService.getCourses();
    }

    @GetMapping("/courses/{courseID}")
    public Courses getCourse(@PathVariable String courseID)
    {
        return courseService.getCourse(Long.parseLong(courseID));
    }

    @PostMapping(path = "/courses",consumes = "application/json")
    public Courses addCourse(@RequestBody Courses courses)
    {
        return courseService.addCourse(courses);
    }

    @PutMapping(path = "/courses/{id}",consumes = "application/json")
    public Courses updateCourse(@RequestBody Courses courses)
    {
        return courseService.updateCourse(courses);
    }

    @DeleteMapping("/courses/{courseID}")
    public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String courseID)
    {
        try{


            courseService.deleteCourse(Long.parseLong(courseID));
            return new ResponseEntity<>(HttpStatus.OK)
                    ;
    }catch (Exception e)
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        }
}
