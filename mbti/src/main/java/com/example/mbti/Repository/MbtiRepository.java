package com.example.mbti.Repository;

import com.example.mbti.Domain.Mbti;
import com.example.mbti.Res.MbtiRes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MbtiRepository extends JpaRepository<Mbti, Long> {

    List<Mbti> findAllByMbtiw(String mbti);
}
