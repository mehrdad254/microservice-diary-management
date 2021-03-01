package com.mhr.diary.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mhr.diary.model.Diary;

@Repository
public interface DiaryRepository extends JpaRepository<Diary,Long>{

}
