package com.assignment.userservice;

public class ExamQuestions {
	
	public static void main(String[] args){
		printTriangle(5, 5);
	}
	
	static void printTriangle(int num, int countdown) {
	    if (num > 0) {
	        System.out.print("*");
	        if (countdown > 1) {
	            printTriangle(num, countdown - 1);
	        } else {
	            System.out.println();
	            printTriangle(num - 1, num - 1);
	        }
	    }
	}

}
