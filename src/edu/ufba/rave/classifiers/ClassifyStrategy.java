package edu.ufba.rave.classifiers;

import edu.ufba.rave.model.Category;
import edu.ufba.rave.model.Item;

public abstract class ClassifyStrategy {

  public abstract Category classify(Item item);

}

