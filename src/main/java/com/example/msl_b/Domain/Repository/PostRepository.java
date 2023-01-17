package com.example.msl_b.Domain.Repository;

import com.example.msl_b.Domain.Entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface PostRepository extends JpaRepository<PostEntity, BigInteger> {
}
