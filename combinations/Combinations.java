import java.util.Arrays;
import java.util.ArrayList;

class Combinations {
  static ArrayList<String> getCombinations(ArrayList<String> inputList) {
    if(inputList.size() == 0) {
      return new ArrayList<String>();
    }

    String firstElement = inputList.remove(0);
    ArrayList<String> combinations = getCombinations((ArrayList<String>)inputList.clone());
    ArrayList<String> combinationsWithFirstElement = new ArrayList<String>();
    
    for(String item: combinations) {
      combinationsWithFirstElement.add(firstElement + item);
    }

    combinations.add(0, firstElement);
    combinations.addAll(combinationsWithFirstElement);

    return combinations;
  }

  static void testCombinations(String inputString) {
    String[] inputArray = inputString.split("");
    ArrayList<String> inputList = new ArrayList<String>(Arrays.asList(inputArray));
    ArrayList<String> combinations = getCombinations(inputList);
    String[] combinationsArray = combinations.toArray(new String[0]);
    System.out.println("Combination(" + inputString + ") => " + Arrays.toString(combinationsArray));
  }

  public static void main(String[]args) {
    Combinations.testCombinations("");
    Combinations.testCombinations("a");
    Combinations.testCombinations("ab");
    Combinations.testCombinations("abc");
    Combinations.testCombinations("test");
  }
}
