package exercises;

import java.util.*;

public class ArraysTest {
    public static void main(String[] args) {

//______________SORTNING________________________
        int arr[] = {67, 8, 90, 1, 4, 51, 7};
        sortArrAsc(arr);
        sortArrDesc(arr);
        System.out.println("_____________________");

        int[] arrDesc = Arrays.stream(arr).boxed()
                .sorted(Collections.reverseOrder())
                .mapToInt(Integer::intValue)
                .toArray();
        System.out.println(Arrays.toString(arrDesc));
        System.out.println("java8");

        int[] array = {1, 2, 3, -1, -2, 4};
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));
        System.out.println("Arrays.sort");

        int[] array2 = {1, 2, 3, -1, 55, 4};
        Collections.reverse(List.of(array2));
        System.out.println(Arrays.toString(array2));
        System.out.println("Collection.reverse");
        //_______________________________________

        //Write Java program that checks if two arrays contain the same elements.
        Integer[] array11 = {1, 2, 3, -1, -2, 4};
        Integer[] array12 = {1, 2, 3, -1, -2, 4};
        System.out.println(sameElements(array11, array12));

        //Ex-15
        int[] array3 = {1, 7, 55, 4, 33};
        int[] array4 = {1, 7, 55, 9, 33};
        System.out.println(checkIfTwoArraysAreEqual(array3, array4));

        String[] s1 = {"java", "swings", "j2ee", "struts", "jsp", "hibernate"};
        String[] s2 = {"java", "struts", "j2ee", "hibernate", "swings", "jsp"};
        Arrays.sort(s1);
        Arrays.sort(s2);
        System.out.println(Arrays.equals(s1, s2));

        //create new arr based on 2 arrays similar indexes -> new arr should have {4, 7}
        int a[] = {1, 4, 5, 7};
        int b[] = {5, 4, 9, 7};

        compareIndexesOfTwoArrays(a, b);

        //find max difference between any adjacent(суміжні) index in array
        int arr[] = {1, 4, 8, 15, 17};
        System.out.println(findMamDiffBetweenAdjacentIndexes(arr));

        //Ex-19
        Integer[] myArray = {1, 3, 5, 7, 9, 2, 1, 3};
        removeDuplicatesFromArray(myArray); //recreate

        //Ex-18
        Integer[] myArray5 = {1, 3, 5, 7, 9};
        System.out.println("Original Array:" + Arrays.asList(myArray5));
        reverseArray(myArray5);


        //Ex-8
        int[] array6 = {1, 2, 3, -1, -2, 4};
        getSumOfIntegerArray(array6); //попробувати самій написати

        //Ex-9
        int[] array7 = {1, 7, 55, 4, -2, 33};
        System.out.println(getSecondLargestNumber(array7));

        //JAVA is always pass by value
        //!!!!!!!!!!!!!!
        int a1 = 5;
        System.out.println("a before " + a1); //5
        change(a1);
        System.out.println("a after " + a1); //5

        //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        int[] myArray4 = {1, 2, 3, 4, 5};
        changeArr(myArray4);
        System.out.println(Arrays.toString(myArray4));// [99, 2, 3, 4, 5]


        int[] arr6 = new int[9]; //arr [0,0,0,0,0,0,0,0,0]
        System.out.println(arr6[0]); //0


        int num[] = new int[9];
        for (int i = 0; i < num.length; i++) {
            num[i] = i + 5;
        }
        System.out.println(num[7]); //12!!!!!


        int[] myArray7 = {1, 3, 5, 2, 8, 9, 5, 0};
        int x = myArray7[0];
        for (int i = 0; i < myArray7.length; i++) {
            if (myArray7[i] < x) {
                x = myArray7[i];
            }
        }
        System.out.println(x); //0
    }


    private static void sortArrAsc(int[] arr) {
        int temp;

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    //swap
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        for (int j : arr) {
            System.out.println(j);
        }
    }

    private static void sortArrDesc(int[] arr) {
        int temp;
        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = i - 1; j >= 0; j--) {
                if (arr[i] > arr[j]) {
                    //swap
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        for (int j : arr) {
            System.out.println(j);
        }
    }

    private static boolean sameElements(Object[] array1, Object[] array2) {
        Set<Object> uniqueElements1 = new HashSet<>(Arrays.asList(array1));
        Set<Object> uniqueElements2 = new HashSet<>(Arrays.asList(array2));

        if (uniqueElements1.size() != uniqueElements2.size()) {
            return false;
        }
        for (Object obj : uniqueElements1) {
            if (!uniqueElements2.contains(obj)) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkIfTwoArraysAreEqual(int[] array, int[] array2) {
        boolean isEqual = true;
        if (array.length == array2.length) {
            for (int i = 0; i < array.length; i++) {
                if (array[i] != array2[i]) {
                    isEqual = false;
                }
            }
        }
        return isEqual;
    }

    private static void compareIndexesOfTwoArrays(int[] a, int[] b) {
        ArrayList<Integer> newList = new ArrayList<>();

        for (int i = 0; i < a.length; i++) {
            if (a[i] == b[i]) {
                newList.add(a[i]);
            }
        }

        //create new arr from list and print it
        Object[] arr = newList.toArray();
        for (Object o : arr) {
            System.out.println(o);
        }
    }

    private static int findMamDiffBetweenAdjacentIndexes(int[] arr) {
        int diff = 0;

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i + 1] - arr[i] > diff) {
                diff = arr[i + 1] - arr[i];
            }
        }

        return diff;
    }

    private static void removeDuplicatesFromArray(Object[] arrayWithDuplicates) {
        //1 example
//        Set<Object> newArray = new HashSet<>(Arrays.asList(myArray));
//        System.out.println(newArray);

        //Assuming all elements in input array are unique

        int numberOfUniqueElements = arrayWithDuplicates.length;

        for (int i = 0; i < numberOfUniqueElements; i++) {
            for (int j = i + 1; j < numberOfUniqueElements; j++) {
                //If any two elements are found equal
                if (arrayWithDuplicates[i] == arrayWithDuplicates[j]) {
                    //Replace duplicate element with last unique element
                    arrayWithDuplicates[j] = arrayWithDuplicates[numberOfUniqueElements - 1];
                    //Decrementing numberOfUniqueElements
                    numberOfUniqueElements--;
                    //Decrementing j
                    j--;
                }
            }
        }

        //Copying only unique elements of arrayWithDuplicates into arrayWithoutDuplicates
        Object[] arrayWithoutDuplicates = Arrays.copyOf(arrayWithDuplicates, numberOfUniqueElements);

        for (int i = 0; i < arrayWithoutDuplicates.length; i++) {
            System.out.print(arrayWithoutDuplicates[i] + "\t");
        }
    }

    private static void reverseArray(Integer[] array) {
        //1 example
//        for (int i = array.length - 1; i >= 0; i--) {
//            System.out.print(array[i]);
//        }

        //2 example
        Collections.reverse(Arrays.asList(array));
        System.out.println("Reversed Array:" + Arrays.asList(array));
    }

    private static int getSecondLargestNumber(int[] array) {
        int highest = Integer.MIN_VALUE;
        int secondHighest = Integer.MIN_VALUE;

        for (int i : array) {
            if (i > highest) {
                secondHighest = highest;
                highest = i;
            } else if (i > secondHighest) {
                secondHighest = i;
            }

        }
        return secondHighest;
    }

    private static void getSumOfIntegerArray(int[] array) {
        int sum = 0;
        for (Integer arr : array) {
            sum += arr;
        }
        System.out.println(sum);
    }

    private static void change(int a) { //in primitive type we get value
        a++;
    }

    private static void changeArr(int[] oldArr) {//we get reference by value
//      int temp = arr[arr.length - 1];
//      oldArr[0] = temp;

        // oldArr[0] = 99; //will change oldArr[0]
        int[] newArr = oldArr; // we created new array and = it to OldArr
        newArr[0] = 99; //and this will change OldArr
    }
}
