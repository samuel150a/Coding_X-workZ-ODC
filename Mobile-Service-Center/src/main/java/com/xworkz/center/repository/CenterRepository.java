package com.xworkz.center.repository;

import com.xworkz.center.dto.CenterDto;
import com.xworkz.center.entity.CenterEntity;

import java.util.List;

public interface CenterRepository {
    Boolean saveDetails(CenterEntity centerEntity);
    List<CenterEntity> getAllData();
    Boolean getDataById(Integer Id);
    Boolean UpdateById(CenterEntity centerEntity);


    CenterEntity getById(Integer id);

    Boolean deleteById(int ID);

}
