package com.philips.alerttocare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.philips.alerttocare.entity.Bed;

@Repository
public interface BedRepository extends JpaRepository<Bed, Integer> {
	
	@Query(value = "select b.bedStatus from Bed b where b.bedId=:bedId")
	public Bed findByBedStatus(Integer bedId);
}
