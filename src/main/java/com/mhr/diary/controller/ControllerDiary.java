package com.mhr.diary.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mhr.diary.model.Diary;
import com.mhr.diary.service.DiaryServiceImpl;

@RestController
@CrossOrigin
@RequestMapping(value = "/diary")
public class ControllerDiary {

	private DiaryServiceImpl serviceDiary;
	
	@Autowired
	public ControllerDiary(DiaryServiceImpl serviceDiary) {
		this.serviceDiary = serviceDiary;
	}
	
	@GetMapping(value = "/shows")
	public List<Diary> findAll(){
		return serviceDiary.findAll();
	}

	@GetMapping(value = "/show/{theId}")
	public Diary findOne(@PathVariable("theId") long theId) {
		Diary theDiary = serviceDiary.findById(theId);
		
		if(theDiary == null) {
			throw new RuntimeException("Diary id not found - " + theId);
		}
		
		return theDiary;
	}
	
	@PostMapping(value = "/add")
	public Diary registerDiary(@RequestBody Diary diary) {
		 diary.setId((long) 0);
		 serviceDiary.Save(diary);
		 return diary;
	}
	
	@PutMapping(value = "/update")
	public Diary updateDiary(@RequestBody Diary diary) {
		serviceDiary.Save(diary);
		return diary;
	}
	
	@DeleteMapping("/delete/{theId}")
	public String deleteDiary(@PathVariable long theId) {
		Diary theDiary = serviceDiary.findById(theId);
		
		if(theDiary == null) {
			throw new RuntimeException("Diary is not found "+theId);
		}
		
		serviceDiary.deleteById(theId);
		
		return "Delete diary id - " + theId;
	}
	
}
