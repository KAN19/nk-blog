package com.nguyenkietblog.nkblog.repository;

import com.nguyenkietblog.nkblog.entity.Erole;
import com.nguyenkietblog.nkblog.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(Erole name);
}
