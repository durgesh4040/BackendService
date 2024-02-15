package com.allywheel.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.allywheel.Model.UserModel;

public interface UserRepository extends JpaRepository<UserModel,Integer> {
public List<UserModel> findAllByName(String name);
public Optional<UserModel>findByEmail(String name);
}
