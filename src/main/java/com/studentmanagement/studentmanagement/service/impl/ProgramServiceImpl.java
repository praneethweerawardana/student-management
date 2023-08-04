package com.studentmanagement.studentmanagement.service.impl;

import com.studentmanagement.studentmanagement.dto.ProgramDto;
import com.studentmanagement.studentmanagement.dto.ResponseProgramDto;
import com.studentmanagement.studentmanagement.entity.Program;
import com.studentmanagement.studentmanagement.repo.ProgramRepo;
import com.studentmanagement.studentmanagement.service.ProgramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Optionals;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProgramServiceImpl implements ProgramService {

    private final ProgramRepo programRepo;

    @Autowired
    public ProgramServiceImpl(ProgramRepo programRepo) {
        this.programRepo = programRepo;
    }

    @Override
    public void saveProgram(ProgramDto dto) {
        Program program = new Program();
        program.setTitle(dto.getTitle());
        program.setDescription(dto.getDescription());
        program.setCost(dto.getCost());
        programRepo.save(program);
    }

    @Override
    public void updateProgram(Long id, ProgramDto dto) {
        Optional<Program> selectedData =  programRepo.findById(id);
        if(selectedData.isPresent()){
            throw new RuntimeException();
        }
        selectedData.get().setTitle(dto.getTitle());
        selectedData.get().setDescription(dto.getDescription());
        selectedData.get().setCost(dto.getCost());
        programRepo.save(selectedData.get());
    }

    @Override
    public void deleteProgram(Long id) {
        programRepo.deleteById(id);
    }

    @Override
    public ResponseProgramDto findProgram(Long id) {
        Optional<Program> selectedData =  programRepo.findById(id);
        if(selectedData.isPresent()){
            throw new RuntimeException();
        }

        ResponseProgramDto dto = new ResponseProgramDto(
                selectedData.get().getId(), selectedData.get().getTitle(),
                selectedData.get().getDescription(),selectedData.get().getCost()
        );

        return dto;
    }

    @Override
    public List<ResponseProgramDto> findAllPrograms() {
        List<Program> allData = programRepo.findAll();
        List<ResponseProgramDto> dtos = new ArrayList<>();
        for(Program p: allData){
            dtos.add(new ResponseProgramDto(
                    p.getId(), p.getTitle(), p.getDescription(), p.getCost()
            ));
        }
        return dtos;
    }
}
