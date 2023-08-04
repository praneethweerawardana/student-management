package com.studentmanagement.studentmanagement.service;

import com.studentmanagement.studentmanagement.dto.ProgramDto;
import com.studentmanagement.studentmanagement.dto.ResponseProgramDto;

import java.util.List;

public interface ProgramService {

    public void saveProgram(ProgramDto dto);
    public void updateProgram(Long id, ProgramDto dto);
    public void deleteProgram(Long id);
    public ResponseProgramDto findProgram(Long id);
    public List<ResponseProgramDto> findAllPrograms();
}
