package com.techelevator.view;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

import com.techelevator.campground.model.Campground;
import com.techelevator.campground.model.Site;

public class Menu {

	private PrintWriter out;
	private Scanner in;

	public Menu(InputStream input, OutputStream output) {
		this.out = new PrintWriter(output);
		this.in = new Scanner(input);
	}

	public Object getChoiceFromOptions(Object[] options) {
		Object choice = null;
		while (choice == null) {
			displayMenuOptions(options);
			choice = getChoiceFromUserInput(options);
		}
		return choice;
	}

	private Object getChoiceFromUserInput(Object[] options) {
		Object choice = null;
		String userInput = in.nextLine();
		try {
			int selectedOption = Integer.valueOf(userInput);
			if (selectedOption > 0 && selectedOption <= options.length) {
				choice = options[selectedOption - 1];
			}
		} catch (NumberFormatException e) {
			// eat the exception, an error message will be displayed below since choice will
			// be null
		}
		if (choice == null) {
			out.println("\n*** " + userInput + " is not a valid option ***\n");
		}
		return choice;
	}

	private void displayMenuOptions(Object[] options) {
		out.println();
		for (int i = 0; i < options.length; i++) {
			int optionNum = i + 1;
			out.println(optionNum + ") " + options[i]);
		}
		out.print("\nPlease choose an option >>> ");
		out.flush();
	}

	public void displayCampgroundOptions(List<Campground> options) {

		out.println();
		int counter = 1;
		for (Campground campground : options) {
			System.out.println(counter + ") " + campground.getName());
			counter++;
		}
		out.print("\nPlease choose an option >>> ");
		out.flush();

	}
	public Campground getCampgroundChoice(List<Campground> options) {
		Campground choice = null;
		Campground[] options1 = options.toArray(new Campground[options.size()]);
		String userInput = in.nextLine();
		try {
			int selectedOption = Integer.valueOf(userInput);
			if (selectedOption > 0 && selectedOption <= options1.length) {
				choice = options1[selectedOption - 1];
			}
		} catch (NumberFormatException e) {
			// eat the exception, an error message will be displayed below since choice will
			// be null
		}
		if (choice == null) {
			out.println("\n*** " + userInput + " is not a valid option ***\n");
		}
		return choice;
	}
	
	public Site getSiteChoice(List<Site> options) {
		Site choice = null;
		Site[] options1 = options.toArray(new Site[options.size()]);
		String userInput = in.nextLine();
		try {
			int selectedOption = Integer.valueOf(userInput);
			if (selectedOption > 0 && selectedOption <= options1.length) {
				choice = options1[selectedOption - 1];
			}
		} catch (NumberFormatException e) {
			// eat the exception, an error message will be displayed below since choice will
			// be null
		}
		if (choice == null) {
			out.println("\n*** " + userInput + " is not a valid option ***\n");
		}
		return choice;
	}
	public void displaySiteOptions(List<Site> options, BigDecimal cost) {

		out.println();
		int counter = 1;
		for (Site site : options) {
			System.out.println(counter + ") 	" + site.getSiteNumber() + "		" + site.getMaxOccupancy() + "		" 
					+ site.isAccessible() + "		" + site.isUtilities() + "		" + site.getMaxRVSize() + "			" +
					cost.toString());
			counter++;
		}
		out.print("\nWhich site would you like to reserve? (enter 0 to cancel)");
		out.flush();

	}
}
