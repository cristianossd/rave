package edu.ufba.rave.instances;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import edu.ufba.rave.model.Category;

public class CategoriesCtrl {

  private static CategoriesCtrl instance;
  private HashMap<String, Category> categories;

  public static CategoriesCtrl getInstance() {
    if (instance == null)
      instance = new CategoriesCtrl();

    return instance;
  }

  private CategoriesCtrl() {
    this.categories = new HashMap<String, Category>();
  }

  public void add(Category category) {
    this.categories.put(category.getName(), category);
  }

  public void remove(String categoryName) {
    this.categories.remove(categoryName);
  }

  public ArrayList<Category> getAll() {
    ArrayList<Category> allCategories = new ArrayList<Category>();

    for (Entry<String, Category> entry:categories.entrySet()) {
      allCategories.add(entry.getValue());
    }

    return allCategories;
  }

}

