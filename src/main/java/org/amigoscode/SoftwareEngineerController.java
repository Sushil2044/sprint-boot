package org.amigoscode;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/software-engineers")
public class SoftwareEngineerController {

    private final SoftwareEngineerService softwareEngineerService;

    public SoftwareEngineerController(SoftwareEngineerService softwareEngineerService) {
        this.softwareEngineerService = softwareEngineerService;
    }

    @GetMapping
    public List<SoftwareEngineer> getEngineers(){
        return softwareEngineerService.getEngineers();
    }
    @GetMapping("{id}")
    public SoftwareEngineer getEngineersById(@PathVariable Integer id){
        return softwareEngineerService.getEngineersById(id);
    }

    @PostMapping
    public void addEngineer(@RequestBody SoftwareEngineer softwareEngineer){
        softwareEngineerService.addEngineer(softwareEngineer);
    }
}
