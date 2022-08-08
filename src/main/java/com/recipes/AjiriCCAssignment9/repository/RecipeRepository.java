package com.recipes.AjiriCCAssignment9.repository;

import java.io.IOException;
import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recipes.AjiriCCAssignment9.domain.Recipe;
import com.recipes.AjiriCCAssignment9.service.RecipeService;

@Service
public class RecipeRepository 

{
	List<Recipe> recipes = new ArrayList<Recipe>();
	
	@Autowired
	private RecipeService recipeService;
	
	public List<Recipe> getRecipeList() throws IOException
	
	{
		recipes = recipeService.readRecipeFile();
		return recipes;
	}
}
