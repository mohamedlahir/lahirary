package com.one.project.utils;

import java.util.UUID;

import org.springframework.stereotype.Service;

@Service
public class RandomIDGenerator {

	public int numberGenerator() {
		UUID idOne = UUID.randomUUID();
		String str = "" + idOne;
		int uid = str.hashCode();
		String filterStr = "" + uid;
		str = filterStr.replaceAll("-", "");

		int generatedNumber = Integer.parseInt(str);

		System.out.println("ID Generated : " + generatedNumber);

		return generatedNumber;
	}
}
