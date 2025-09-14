package org.amigoscode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectService {
    //private final SubjectRepository subjectRepository;

    //public SubjectService(SubjectRepository subjectRepository) {
      //  this.subjectRepository = subjectRepository;
    //}
    @Autowired
    SubjectRepository subjectRepository;

    public List<Subject> getSubjects(){

        List<Subject> subjects = subjectRepository.findAll();
        return subjects.stream()
                .filter(s-> s.getName()=="Java")
                .collect(java.util.stream.Collectors.toList());
    }

    public void addSubject(Subject subject){

        System.out.println("Adding subject: " + subject);
        subjectRepository.save(subject);
    }
    //for updating as subjects are immutable, we need to delete and add

    public Subject updateSubject(Integer id,Subject subject){
        Subject subjectInstance=subjectRepository.getById(id);
        subjectInstance.setName(subject.getName());
        subjectInstance.setDescription(subject.getDescription());
        subjectRepository.save(subjectInstance);
        return subjectInstance;
    }

    public void deleteSubject(Integer id){
        subjectRepository.deleteById(id);
    }

    public Subject getById(Integer id) {
        return subjectRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Subject with id " + id + " does not exist"));
    }
}
