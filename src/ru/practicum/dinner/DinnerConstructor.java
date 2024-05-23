package ru.practicum.dinner;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Random;

public class DinnerConstructor {
    HashMap<String, ArrayList<String>> mealList = new HashMap<>();

    void addMeal(String type, String name) {
        if (!mealList.containsKey(type)) {
            mealList.put(type, new ArrayList<>());
        }
        mealList.get(type).add(name);

    }

    void generatingCombos(Integer numberOfCombos, ArrayList<String> mealTypeForCombo) {
        boolean contains = false;
        for (int i = 0; i < mealTypeForCombo.size(); i++){
            if (mealList.containsKey(mealTypeForCombo.get(i))){
                contains = true;
            } else{
                contains = false;
                break;
            }
        }
        if (contains) {
            Random random = new Random();
            for (int j = 0; j < numberOfCombos; j++) {
                ArrayList<String> combine = new ArrayList<>();
                for (int i = 0; i < mealTypeForCombo.size(); i++) {
                    int nxt = random.nextInt(mealList.get(mealTypeForCombo.get(i)).size());
                    combine.add(mealList.get(mealTypeForCombo.get(i)).get(nxt));// Добавляем в список рандомное блюдо
                }
                System.out.println("Комбо" + " № " + (j + 1));
                System.out.println(combine);
            }
        } else {
            System.out.println("Некоторых типов блюд которые вы указали нет в списке ваших блюд, повторите попытку!");
        }

    }
}

