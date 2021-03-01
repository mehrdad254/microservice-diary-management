package com.mhr.diary.service;

import java.util.List;

import com.mhr.diary.model.Diary;

public interface DiaryService {

	void Save(Diary diary);

	List<Diary> findAll();

	void deleteById(long theId);

	Diary findById(long theId);


}
