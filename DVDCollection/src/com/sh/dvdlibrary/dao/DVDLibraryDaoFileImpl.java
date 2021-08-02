package com.sh.dvdlibrary.dao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.sh.dvdlibrary.dto.DVD;

public class DVDLibraryDaoFileImpl implements DVDLibraryDao{

	private Map<String, DVD> collection = new HashMap<>();
	
	@Override
	public DVD addDVD(String dvdTitle, DVD dvd) {
		DVD prevDVD = collection.put(dvdTitle, dvd);
		return prevDVD;
	}

	@Override
	public List<DVD> getAllDVDs() {
		return new ArrayList<DVD>(collection.values());
	}

	@Override
	public DVD getDVD(String dvdTitle) {
		return collection.get(dvdTitle);
	}

	@Override
	public DVD removeDVD(String dvdTitle) {
		DVD removedDVD = collection.remove(dvdTitle);
		return removedDVD;
	}
	
	@Override
	public boolean searchCollection(String dvdTitle) {
		return collection.containsKey(dvdTitle);
	}
	
	@Override
	public boolean updateDVD(String dvdTitle, DVD oldDVD, DVD newDVD) {
		return collection.replace(dvdTitle, oldDVD, newDVD);
	}
	
	public void loadDVDs() {
		String path = "Outfile.txt";
		Scanner sc = null;
		try {
			sc = new Scanner(new BufferedReader(new FileReader(path)));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// go through the file line by line
		if (sc != null) {
			while (sc.hasNextLine()) {
				String[] currentLine = sc.nextLine().split("::");
				// process current line, assuming good input
				String title = currentLine[0];
				String releaseDate = currentLine[1];
				String mpaaRating = currentLine[2];
				String director = currentLine[3];
				String studio = currentLine[4];
				String userRating = currentLine[5];
				DVD addMe = new DVD(title, releaseDate, mpaaRating, director, studio, userRating);
				addDVD(title, addMe);
			}
		}
	}
	
	public void saveDVDs() {
		String path = "Outfile.txt";
		PrintWriter out = null;
		try {
			out = new PrintWriter(new FileWriter(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		List<DVD> allDVDs = getAllDVDs();
		if (out != null) {
			for (DVD d : allDVDs) {
				out.println(formatDVD(d));
			}
			out.flush();
			out.close();
		}
	}
	
	public String formatDVD(DVD formatMe) {
		String accum = "";
		accum += formatMe.getTitle() + "::";
		accum += formatMe.getReleaseDate() + "::";
		accum += formatMe.getMpaaRating() + "::";
		accum += formatMe.getDirectorName() + "::";
		accum += formatMe.getStudio() + "::";
		accum += formatMe.getUserRating();
		return accum;
	}
}
