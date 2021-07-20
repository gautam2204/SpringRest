package com.springrest.springrest.services;

import com.springrest.springrest.entities.Courses;

import java.util.List;

public interface CourseService {

    public List<Courses> getCourses();

     Courses getCourse(Long courseID);

    Courses addCourse(Courses courses);

    Courses updateCourse(Courses courses);

    void deleteCourse(long parseLong);
}
