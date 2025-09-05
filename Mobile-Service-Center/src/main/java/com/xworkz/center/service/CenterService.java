package com.xworkz.center.service;

import com.xworkz.center.dto.CenterDto;

import java.util.List;

public interface CenterService {
    Boolean saveDetails(CenterDto centerDto);


    List<CenterDto> getAllData();
    Boolean getDataById(Integer Id);
    Boolean UpdateById(CenterDto centerDto);


    CenterDto getById(Integer id);

    Boolean deleteById(int ID);
}
