package com.studentmanagement.studentmanagement.api;

import com.studentmanagement.studentmanagement.dto.ProgramDto;
import com.studentmanagement.studentmanagement.service.ProgramService;
import com.studentmanagement.studentmanagement.util.ResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/program")
public class ProgramController {

    private final ProgramService programService;

    @Autowired
    public ProgramController(ProgramService programService) {
        this.programService = programService;
    }

     @PostMapping
    public ResponseEntity<ResponseDto> saveProgram(@RequestBody ProgramDto dto){
        programService.saveProgram(dto);
        return new ResponseEntity<>(
                new ResponseDto(dto,"Saved!",201),
                HttpStatus.CREATED
        );
    }
    @PutMapping
    public ResponseEntity<ResponseDto> updateProgram(@RequestBody ProgramDto dto, @RequestParam Long id){
        programService.updateProgram(id,dto);
        return new ResponseEntity<>(
                new ResponseDto(dto,"Updated!",201),
                HttpStatus.CREATED
        );
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDto> deleteProgram(@PathVariable Long id){
        programService.deleteProgram(id);
        return new ResponseEntity<>(
                new ResponseDto(id,"Deleted!",204),
                HttpStatus.NO_CONTENT
        );
    }
    @GetMapping("/{id}")
    public ResponseEntity<ResponseDto> findProgram(Long id){

        return new ResponseEntity<>(
                new ResponseDto(programService.findProgram(id),"Data!",200),
                HttpStatus.OK
        );

    }

    @GetMapping("/list")
    public ResponseEntity<ResponseDto> findAllProgram(){
        return new ResponseEntity<>(
                new ResponseDto(programService.findAllPrograms(),"Data!",200),
                HttpStatus.OK);
    }
}
