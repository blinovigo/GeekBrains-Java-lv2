package Lesson3.Part1;

import java.util.*;

public class MainLesson3Part1 {
    public static void main(String[] args) {
        String input_string = "в летнее время оленям в тайге жарко а в горах даже в июле холодн олень как бы" +
                " создан для северных просторов жёсткого ветра длинных морозных ночей олень легко бежит вперёд";
        String[] strings = input_string.split(" ");
        ArrayList<String> stringArrayList = stringToArrayList(strings);
        System.out.println("Список слов по алфавиту без повторов: " + stringsWordList(stringArrayList));
        HashMap<String, Integer> wordCountList = wordCountList(stringArrayList);
        System.out.println("Список слов с подсчетом повторов: " + wordCountList);
    }

    private static TreeSet<String> stringsWordList(ArrayList<String> stringArrayList) {
        TreeSet<String> stringTreeSet = new TreeSet<>();
        stringTreeSet.addAll(stringArrayList);
        return stringTreeSet;
    }

    private static HashMap<String, Integer> wordCountList(ArrayList<String> stringArrayList) {
        HashMap<String, Integer> wordCountList = new HashMap<>();
        Collections.sort(stringArrayList);
        for (int i = 0; i < stringArrayList.size(); i++) {
            Integer count = 1;
            if (i < stringArrayList.size()-1) {
                while (stringArrayList.get(i).equals(stringArrayList.get(i+1))) {
                    count++;
                    i++;
                }
                wordCountList.put(stringArrayList.get(i), count);
            }
        }

        return wordCountList;
    }

    private static ArrayList<String> stringToArrayList(String[] strings) {
        ArrayList<String> stringArrayList = new ArrayList<>();
        for (int i = 0; i < strings.length; i++) {
            stringArrayList.add(strings[i]);
        }
        return stringArrayList;
    }

}
