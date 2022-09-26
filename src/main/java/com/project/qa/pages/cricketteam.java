package com.project.qa.pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedHashSet;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class cricketteam {
	
	@Test
	public void team() throws EncryptedDocumentException, IOException {
		
		FileInputStream file = new FileInputStream("C:\\Users\\real\\eclipse-workspace\\com.project.qa\\src\\main\\java\\com\\project\\qa\\testdata\\Data.xlsx");
		for(int i=0; i<=11; i++) {
			String name=WorkbookFactory.create(file).getSheet("PlayerData").getRow(i).getCell(0).getStringCellValue();
			String country=WorkbookFactory.create(file).getSheet("PlayerData").getRow(i).getCell(1).getStringCellValue();
			String role=WorkbookFactory.create(file).getSheet("PlayerData").getRow(i).getCell(2).getStringCellValue();
			
			int wicketkeeper=0;
			int foreignplayer=0;
			LinkedHashSet<String> teamBanglore = new LinkedHashSet<String>();
			
			if(wicketkeeper<1 && (role.equalsIgnoreCase("Wicket Keeper") || role.equalsIgnoreCase("All Rounder"))) {
				wicketkeeper = wicketkeeper+1;
				teamBanglore.add(name);
				if(country!="India") {
					foreignplayer = foreignplayer+1;
				}
			}else
				if(foreignplayer<3 && role!="Wicket Keeper" && country!="India") {
					foreignplayer=foreignplayer+1;
					teamBanglore.add(name);
				}else
					if(role!="Wicket Keeper") {
						teamBanglore.add(name);
					}
			
			System.out.println("Team Banglore : "+teamBanglore);
			System.out.println("Wicket Keeper Count : "+wicketkeeper);
			System.out.println("ForeignPlayer Count : "+foreignplayer);
			
		}
	}

}
