package com.revature.screens;

import java.io.BufferedReader;
import java.io.IOException;

public class DepositScreen implements Screen {

	@Override
	public Screen start(BufferedReader br) {
		
		
		
		
		System.out.println("\n");
		System.out.println("Lets deposit some money shall we... \n");
		
		try {
			System.out.println("Enter amount you would like to deposit: ");
			String depositAmount = br.readLine();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

}
