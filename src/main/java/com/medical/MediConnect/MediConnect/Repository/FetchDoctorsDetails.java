package com.medical.MediConnect.MediConnect.Repository;

import com.medical.MediConnect.MediConnect.Model.LoginEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FetchDoctorsDetails extends JpaRepository<LoginEntity, String> {

//    @Query(value = "select * from doctor_details where username=:username", nativeQuery = true)
//    List<LoginEntity> isUsernamePresent(@Param("username") String username);

    List<LoginEntity> findByUsername(String username);
}
