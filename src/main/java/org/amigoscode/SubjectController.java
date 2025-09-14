package org.amigoscode;

import org.springframework.util.PathMatcher;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subjects")
public class SubjectController {
    private final SubjectService subjectService;
    private final PathMatcher mvcPathMatcher;

    public SubjectController(SubjectService subjectService, PathMatcher mvcPathMatcher){
        this.subjectService=subjectService;
        this.mvcPathMatcher = mvcPathMatcher;
    }
    @GetMapping
    public List<Subject> getAllSubjects(){
        return subjectService.getSubjects();
    }

    @GetMapping("/{id}")
    public Subject getSubjectById(@PathVariable Integer id){
        return subjectService.getById(id);
    }
    @PostMapping
    public void addSubject(@RequestBody Subject subject){
        subjectService.addSubject(subject);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id){
        subjectService.deleteSubject(id);
        return "Subject deleted";
    }

    @PutMapping("/{id}")
    public Subject update(@PathVariable Integer id,@RequestBody Subject subject){
        return subjectService.updateSubject(id,subject);
    }


}
