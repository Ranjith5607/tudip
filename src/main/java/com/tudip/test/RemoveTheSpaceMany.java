package com.tudip.test;

public class RemoveTheSpaceMany {

	public static void main(String[] args) {

		String str = "I      am      a      james      bond     .";
		
		

//		String str = "Write a program         to remove all the     extra spaces         from a        paragraph/string     ";

		String replaceAll = str.replaceAll("\\s+", " ");
//		String replaceAll2 = replaceAll.replace(, 0)


//		System.out.println(replaceAll2);
	}
}
