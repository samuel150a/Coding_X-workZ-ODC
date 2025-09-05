package com.xworkz.center.repository;

import com.xworkz.center.dto.CenterDto;
import com.xworkz.center.entity.CenterEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Repository
public class CenterRepositoryImplementation implements CenterRepository {
    public CenterRepositoryImplementation() {
        System.out.println("Running in the CenterRepositoryImplementation constructor ");
    }

    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("x-workz");

    @Override
    public Boolean saveDetails(CenterEntity centerEntity) {
        System.out.println("Running in the saveDetails in repository");
        EntityManager em = null;
        EntityTransaction et = null;
        try {
            em = emf.createEntityManager();
            et = em.getTransaction();
            et.begin();
            em.persist(centerEntity);
            et.commit();
            System.out.println("Hello try block is getting excecuting");
            return true;
        } catch (PersistenceException e) {
            System.out.println("Exception ==");
            System.out.println(e.getMessage());
        } finally {

            if (em != null) {
                em.close();
            }


        }
        return false;
    }

    @Override
    public List<CenterEntity> getAllData() {
        System.out.println("Running in the getAllData in repository");
        EntityManager em = null;
        EntityTransaction et = null;
        List<CenterEntity> det=null;
        try{
            em = emf.createEntityManager();
            det=em.createNamedQuery("getAllData").getResultList();
            return det;
        }
        catch (PersistenceException e) {
            System.out.println(e.getMessage());
        } finally {

            if (em != null) {
                em.close();
            }


        }

        return det;
    }

    @Override
    public Boolean getDataById(Integer Id) {
        return null;
    }

    @Override
    public Boolean UpdateById(CenterEntity centerEntity) {
        System.out.println("Running in the UpdateById in repository... ");
        EntityManager entityManager=null;
        EntityTransaction entityTransaction=null;
        try{
            entityManager= emf.createEntityManager();
            entityTransaction=entityManager.getTransaction();
            entityTransaction.begin();

            entityManager.createNamedQuery("updateById")
                    .setParameter("ID", centerEntity.getID())
                    .setParameter("centerName", centerEntity.getCenterName())
                    .setParameter("mobileBrand", centerEntity.getMobileBrand())
                    .setParameter("modelNumber", centerEntity.getModelNumber())
                    .setParameter("defectType", centerEntity.getDefectType())
                    .setParameter("custumberName", centerEntity.getCustumberName())
                    .setParameter("warrentry", centerEntity.getWarrentry())
                    .executeUpdate();


            // entityManager.merge(centerEntity);


            entityTransaction.commit();
            return  true;

        }
        catch (PersistenceException e) {
            System.out.println(e.getMessage());
        } finally {

            if (entityManager != null) {
                entityManager.close();
            }


        }

        return false ;
    }

    @Override
    public CenterEntity getById(Integer id) {
        System.out.println("getById Method");
        EntityManager entityManager=null;
        try{
            CenterEntity singleResult = emf.createEntityManager().createNamedQuery("getById", CenterEntity.class)
                    .setParameter("ID", id).getSingleResult();
            return  singleResult;
        }
        catch (PersistenceException e) {
            System.out.println(e.getMessage());
        } finally {

            if (entityManager != null) {
                entityManager.close();
            }


        }

        return null ;
    }

    @Override
    public Boolean deleteById(int ID) {
        System.out.println("Running in the deleteById in repo");
        EntityManager entityManager=null;

        try {
             entityManager = emf.createEntityManager();
            EntityTransaction entityTransaction = entityManager.getTransaction();
            System.out.println(entityManager+"&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&7");
            entityTransaction.begin();

            CenterEntity centerEntity = entityManager.find(CenterEntity.class, ID);
            entityManager.remove(centerEntity);
           // Query data =entityManager.createNamedQuery("deleteDataById").setParameter("ID",ID);
          //  data.executeUpdate();
            entityTransaction.commit();
            return true;
        }

        catch (PersistenceException e) {
        System.out.println(e.getMessage());
    } finally {

        if (entityManager != null) {
            entityManager.close();
        }


    }

        return false ;
}


    public void closeFactory() {
        if (emf != null && emf.isOpen()) {
            emf.close();
        }
    }
}
