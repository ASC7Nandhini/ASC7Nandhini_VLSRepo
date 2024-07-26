package com.asc.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CourseModuleTest {
    private CourseModule courseModule;

    @BeforeEach
    void setup(){
        courseModule = new CourseModule(1, "Java", "James", Duration.ofHours(8), true);
    }
    @Test
    void testCourseCreation(){
        assertNotNull(courseModule);
    }
    @Test
    void testCourseId(){
        assertEquals(1,courseModule.getCourseId());
    }
    @Test
    void testCourseName(){
        assertEquals("Java",courseModule.getCourseName());
    }
    @Test
    void testAuthorName(){
        assertEquals("James",courseModule.getAuthorName());
    }
    @Test
    void testDurationInHours(){
        assertEquals(Duration.ofHours(8),courseModule.getDurationInHours());
    }
    @Test
    void testCourseIsAvailable(){
        assertTrue("true",courseModule.getIsAvailability());
    }


}
