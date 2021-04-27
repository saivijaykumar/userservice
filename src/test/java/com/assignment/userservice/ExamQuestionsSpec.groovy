package com.assignment.userservice

import spock.lang.Specification

class ExamQuestionsSpec extends Specification{

	def 'check the recursive pattern'(){
		when:'recursive pattern called'
		 ExamQuestions.printTriangle(5, 5)
		then: 'no exceptions '
		 
	}
}
