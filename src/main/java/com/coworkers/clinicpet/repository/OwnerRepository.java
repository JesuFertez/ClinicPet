package com.coworkers.clinicpet.repository;import com.coworkers.clinicpet.model.entities.Owner;import org.springframework.data.jpa.repository.JpaRepository;import org.springframework.stereotype.Repository;@Repositorypublic interface OwnerRepository extends JpaRepository<Owner,Long> {////    @Query(value = "", nativeQuery = true)//    List<Owner> findAll(int size, int page);}