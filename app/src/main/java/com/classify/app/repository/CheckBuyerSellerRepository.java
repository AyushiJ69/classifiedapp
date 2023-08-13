package com.classify.app.repository;

import com.classify.app.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CheckBuyerSellerRepository extends JpaRepository<User , Long> {

    @Query(value = "select u from Users u , Role r  where u.user_id = ?1 and r.id = ?1 and r.name = 'ROLE_BUYER'")
    public User getIfBuyer(long userId);

    @Query(value = "select u from Users u , Role r  where u.user_id = ?1 and r.id = ?1 and r.name = 'ROLE_SELLER'")
    public User getIfSeller(long userId);

    @Query(value = "select u from Users u , Role r  where u.user_id = ?1 and r.id = ?1 and r.name = 'ROLE_ADMIN'")
    public User getIfAdmin(long userId);
}
