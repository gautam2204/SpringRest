package com.springrest.springrest.services;

import com.springrest.springrest.entities.Courses;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService{

    List<Courses> coursesList;

    public CourseServiceImpl() {
        coursesList=new ArrayList<>();
        coursesList.add(new Courses(00001,"This is 1 Course","Physics"));
        coursesList.add(new Courses(00002,"This is 2 Course","Chem"));
        coursesList.add(new Courses(00003,"This is 3 Course","Maths"));
        coursesList.add(new Courses(00004,"This is 3 Course","Bio"));

    }

    @Override
    public List<Courses> getCourses() {
        return coursesList;
    }

    @Override
    public Courses getCourse(Long courseID) {
        Courses c =null;
        for (Courses courses:coursesList ) {
            if(courses.getId()==courseID)
            {
                c=courses;
                break;
            }
        }
        return c;
    }

    @Override
    public Courses addCourse(Courses courses) {
         coursesList.add(courses);
        return courses;
    }

    @Override
    public Courses updateCourse(Courses courses) {

       /* for (Courses course:coursesList ) {
            if (course.getId()==courses.getId())
            {
                course.setTitle(courses.getTitle());
                course.setDescription(courses.getDescription());
            }


        }*/

        coursesList.forEach(e->{
            if(e.getId()==courses.getId())
            {
                e.setTitle(courses.getTitle());
                e.setDescription(courses.getDescription());
            }
        });

        return courses;
    }

    @Override
    public void deleteCourse(long id) {
        coursesList=coursesList.stream().filter(e->e.getId()!=id).collect(Collectors.toList());


    }


}
