package com.student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.List;
@Controller
@RequestMapping("/")
public class CourseController {
    @Autowired
    public CourseRepository courseRepository;
    @Autowired
    public StudentRepository studentRepository;
    @RequestMapping("/")
    public String index(){
        return "index";
    }
    @RequestMapping("/insert")
    public String insert(){
        return "insert";
    }
    @RequestMapping(value="/insert",method= RequestMethod.POST)
    public String addCourse(Course course){
        courseRepository.save(course);
        return "courseAdded";
    }
    @RequestMapping("/display")
    public String displayAll(Model model){
        List<Course> courseList = courseRepository.findAll();
        model.addAttribute("courseList",courseList);
        return "display";
    }
    @RequestMapping("/detail/{name}")
    public String detail(@PathVariable("name")String name, Model model){
        List<Course> courseList=courseRepository.findByName(name);
        model.addAttribute("courseList",courseList);
        return "detail";
    }
    @RequestMapping("/student")
    public String studentData(){
        /*Course course=new Course();
        course.setName("Scala");
        course.setDuration(7);
        course.setDescription("Nothing");
        Student student=new Student();
        student.setName("Mejo");
        student.setPlace("Thrissur");
        student.setCourse(course);
        studentRepository.save(student);*/
        return "student";
    }
}
