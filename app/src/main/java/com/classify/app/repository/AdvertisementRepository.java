package com.classify.app.repository;

import com.classify.app.model.Advertisement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AdvertisementRepository extends JpaRepository<Advertisement,Long> {

    @Query(value="select a from Advertisement a where ?1 in(select u.id from Users u where ) ")
    public List<Advertisement> getAdvertisement(long userId);
}
