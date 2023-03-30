package com.NikSoftelevation.springbootreactjsfullstack.repository;

import com.NikSoftelevation.springbootreactjsfullstack.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
