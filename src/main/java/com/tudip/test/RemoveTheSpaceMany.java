package com.tudip.test;

public class RemoveTheSpaceMany {

	public static void main(String[] args) {

		String str = "Write a program         to remove all the     extra spaces         from a        paragraph/string     ";

		String replaceAll = str.replaceAll("\\s+", " ");

		System.out.println(replaceAll);
	}
}
