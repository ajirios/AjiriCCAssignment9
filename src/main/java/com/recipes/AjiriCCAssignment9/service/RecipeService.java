package com.recipes.AjiriCCAssignment9.service;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;
import com.recipes.AjiriCCAssignment9.domain.Recipe;

@Service
public class RecipeService 

{
	List<Recipe> list = new ArrayList<Recipe>();
	
	public List<Recipe> readRecipeFile() throws IOException
	
	{
		Reader in = new FileReader("recipes.txt");
		Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreSurroundingSpaces().withEscape('\\').withQuote('"').parse(in);
		
		for (CSVRecord record : records)
		{
			Recipe recipe = new Recipe();
			recipe.setCookingMinutes(Integer.parseInt(record.get(0)));
			recipe.setDairyFree(Boolean.parseBoolean(record.get(1)));
			recipe.setGlutenFree(Boolean.parseBoolean(record.get(2)));
			recipe.setInstructions(record.get(3));
			recipe.setPreparationMinutes(Double.parseDouble(record.get(4)));
			recipe.setPricePerServing(Double.parseDouble(record.get(5)));
			recipe.setReadyInMinutes(Integer.parseInt(record.get(6)));
			recipe.setServings(Integer.parseInt(record.get(7)));
			recipe.setSpoonacularScore(Double.parseDouble(record.get(8)));
			recipe.setTitle(record.get(9));
			recipe.setVegan(Boolean.parseBoolean(record.get(10)));
			recipe.setVegetarian(Boolean.parseBoolean(record.get(11)));
			list.add(recipe);
		}
		return list;
	}
}
