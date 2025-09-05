package com.xworkz.center.service;

import com.xworkz.center.dto.CenterDto;
import com.xworkz.center.entity.CenterEntity;
import com.xworkz.center.repository.CenterRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class CenterServiceImplementation implements CenterService {
    @Autowired
    CenterRepository centerRepository;
    @Override
    public Boolean saveDetails(CenterDto centerDto) {
        System.out.println("Running in the saveDetails in service");
        CenterEntity centerEntity=new CenterEntity();
        BeanUtils.copyProperties(centerDto, centerEntity);
        return centerRepository.saveDetails(centerEntity);
    }

    @Override
    public List<CenterDto> getAllData() {

        List<CenterEntity> allData = centerRepository.getAllData();
        List<CenterDto> dtos=new ArrayList<>();
        for(CenterEntity entity:allData)
        {
            CenterDto centerDto=new CenterDto();
            BeanUtils.copyProperties(entity,centerDto);
            dtos.add(centerDto);
        }


        return dtos;
    }

    @Override
    public Boolean getDataById(Integer Id) {
        return null;
    }

    @Override
    public Boolean UpdateById(CenterDto centerDto) {
        System.out.println("Running in the UpdateById method");
        CenterEntity centerEntity=new CenterEntity();
        BeanUtils.copyProperties(centerDto,centerEntity);
        return  centerRepository.UpdateById(centerEntity);

    }

    @Override
    public CenterDto getById(Integer id) {
        CenterEntity centerEntity=centerRepository.getById(id);
        CenterDto centerDto=new CenterDto();
        BeanUtils.copyProperties(centerEntity,centerDto);
        return centerDto ;
    }

    @Override
    public Boolean deleteById(int ID) {
        System.out.println("Running in the deleteById in service");




         return centerRepository.deleteById(ID);





    }
}
