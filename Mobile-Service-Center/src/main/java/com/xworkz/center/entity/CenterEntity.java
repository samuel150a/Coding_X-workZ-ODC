package com.xworkz.center.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@Table(name="center_details")
@NamedQuery(name="getAllData",query="SELECT a FROM CenterEntity a")
@NamedQuery(name="getDataById",query="SELECT  i FROM CenterEntity i WHERE i.ID=:ID")
@NamedQuery(name="deleteDataById",query="DELETE  FROM CenterEntity c WHERE c.ID=:ID")

@NamedQuery(name="getById",query="SELECT  i FROM CenterEntity i WHERE i.ID=:ID")

@NamedQuery(
        name = "updateById",
        query ="update CenterEntity m set m.centerName=:centerName,"
                        + "m.mobileBrand=:mobileBrand,"
                        + "m.modelNumber=:modelNumber,"
                        + "m.defectType=:defectType,"
                        + "m.custumberName=:custumberName,"
                        + "m.warrentry=:warrentry "
                        + "where m.ID=:ID")





public class CenterEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private Integer ID;

    @Column(name="centerName")
    private String centerName;

    @Column(name="mobileBrand")
    private String mobileBrand;

    @Column(name="modelNumber")
    private Integer modelNumber;

    @Column(name="defectType")
    private String defectType;

    @Column(name="custumberName")
    private String custumberName;

    @Column(name="warrentry")
    private String warrentry;




}
