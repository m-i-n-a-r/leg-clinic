package it.leg.facade;

import java.util.List;

import it.leg.model.ExaminationType;

public class TemporaryMain {

	public static void main(String[] args) {
		ExaminationTypeFacade exam = new ExaminationTypeFacade();
		
		exam.createExaminationType("Sangue", "Esame del sangue", 6.0f);
		exam.createExaminationType("Urine", "Esame delle urine", 6.0f);
		exam.createExaminationType("Glicemia", "Curva glicemica", 6.0f);
		List<ExaminationType> exams = exam.findAll();
		
		for (ExaminationType esame : exams)
			System.out.println("Esame: " + esame);
		
//		ExaminationType exam1 = exam.findByPrimaryKey(1L);
//		ExaminationType exam2 = exam.findByPrimaryKey(2L);
//		ExaminationType exam3 = exam.findByPrimaryKey(3L);
//		
//		System.out.println("Esame: " + exam1);
//		System.out.println("Esame: " + exam2);
//		System.out.println("Esame: " + exam3);
	}
}
