package com.mhr.diary.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mhr.diary.date.PersianDateTime;
import com.mhr.diary.model.Diary;
import com.mhr.diary.repository.DiaryRepository;

@Service
public class DiaryServiceImpl implements DiaryService {

	
	private DiaryRepository diaryRepository;
	
	@Autowired
	public DiaryServiceImpl(DiaryRepository diaryRepository) {
		this.diaryRepository = diaryRepository;
	}
	
	@Override
	public void Save(Diary diary) {
		PersianDateTime Date = new PersianDateTime();
		
		diary.setCreateDateAt(Date.webDate());
		diary.setCreateTimeAt(Date.webTime());
		diary.setUpdateDateAt(Date.webDate());
		diary.setUpdateTimeAt(Date.webTime());
		
		diaryRepository.save(diary);
	}
	
	@Override
	public Diary findById(long theId) {
		Optional<Diary> result = diaryRepository.findById(theId);
		
		Diary theDiary = null;
		
		if(result.isPresent()) {
			theDiary = result.get();
		}else {
			throw new RuntimeException("Did Not found Diary id : " + theId);
		}
		
		return theDiary;
	}
	
	@Override
	public List<Diary> findAll(){
		return diaryRepository.findAll();
	}
	
	@Override
	public void deleteById(long theId) {
		diaryRepository.deleteById(theId);
	}
	
	
}
