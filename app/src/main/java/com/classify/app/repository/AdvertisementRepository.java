package com.classify.app.repository;

import com.classify.app.model.Advertisement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AdvertisementRepository extends JpaRepository<Advertisement,Long> {

    @Query(value = "select a from advertisement a where a.user_id = ?1",nativeQuery = true)
    public List<Advertisement> findByUserId(long userId);

    public List<Advertisement> findByCategory(String categor);

}
