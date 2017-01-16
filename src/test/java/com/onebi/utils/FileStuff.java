package com.onebi.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * Klasa porównuje listę elementów zapisanych w pliku i porównuje
 * z podaną listą, tworzy listę nowych elementów (nieistniejących w pliku)
 * oraz listę elementów do usunięcia. Wprowadza zmiany w pliku i zwraca listę<String>
 * nowych elementów. W przypadku braku pliku jest on tworzony.
 * Ścieżka "./[listName].txt"
 * 
 * Nie podawać tej samej nazwy listy dla różnych danych.
 * 
 * @Example
 * new FileStuff().run("name", list)
 * 
 * @param listName
 * Nazwa pliku z zapisaną listą
 * 
 * @param givenElements
 * Lista elementów która będzie porównywana
 * 
 * @return newElements
 * Lista nowych elementów
 * 
 * 
 */


public class FileStuff {
	
	private List<String> elementsInFile;
	private List<String> givenElements;
	private List<String> newElements;
	private List<String> deletedElements;
	
	private String filePathString;
	
	private File file;
	
	
	public List<String> run(String listName, List<String> givenElements){ //static
		go("./"+listName+".txt",givenElements);
		return newElements;
	}
	
	private void go(String filePathString, List<String> given){
		this.givenElements=given;
		this.filePathString=filePathString;
		newElements = new ArrayList();
		deletedElements = new ArrayList();
		file = new File(filePathString);
		PrintWriter creator=null;
		
		if(!isFile()){			
			try {
				creator = new PrintWriter(this.filePathString, "UTF-8");				
				creator.close();
			} catch (Exception e) {
				e.printStackTrace();
			}			
		}		
		
		fillElementsInFileList();		
		compareLists();
		
		if(!deletedElements.isEmpty()){
			elementsInFile.removeAll(deletedElements);
		}
		
		if(!newElements.isEmpty()){
			elementsInFile.addAll(newElements);

		}
		
		try{
		FileWriter writer = new FileWriter(this.filePathString); 
		for(String str: elementsInFile) {
		  writer.write(str+";");
		}
		writer.close();
		}catch(Exception e){}
		
	}
	
	private void fillElementsInFileList(){
		Scanner s;
		try {
			s = new Scanner(new File(filePathString)).useDelimiter(";");
			elementsInFile = new ArrayList<String>();
			
			while (s.hasNext()){
				elementsInFile.add(s.next());
			}
			s.close();
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}

	private void compareLists(){
		int tmp=0;		
			
			for(String s : givenElements){
				if(!elementsInFile.contains(s)){
					newElements.add(s);
				}
			}
			for(String s : elementsInFile){
				if(!givenElements.contains(s)){
					deletedElements.add(s);
				}
			}
			
	}
	
	private boolean isFile(){
		
		if(file.exists() && !file.isDirectory()) { 
		    return true;
		}
		
		return false;
	}
}