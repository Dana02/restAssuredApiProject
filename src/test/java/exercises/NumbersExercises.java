package exercises;

public class NumbersExercises {
    static int c = 23;

    public static void main(String[] args) {

        //_______________________________________
        char c = 'A';
        System.out.println(c + 23); //88 !!!!!!!!!!!!!!
        //_______________________________________

        int nums[] = {3, 2, 3, 2, 3};
        System.out.println(element(nums));

        //_______________________________________
        getHowManyStepsTillZero(14);

        int a = 5;
        int b = 4;
        a = a + b; //a = 9
        b = a - b; //b = 4
        a = a - b; //a = 5

        //_______________________________________
        //JAVA is always pass by value !!!!!!!!!!!!!!
        int a1 = 5;
        System.out.println("a before " + a1); //5
        change(a1);
        System.out.println("a after " + a1); //5

        //_______________________________________
        swipeTwoNumbers(12, 33);

        //_______________________________________
        isNumberPrime(9);

        //_______________________________________
        reverseNumber(1234);

        //_______________________________________
        getSumOfAllNumber(432454); //щоб видалити останню цифру з числа треба поділити його на 10, а щоб взяти останню потрібно взяти number % 10

        //_______________________________________
        int num = 10;
        //boxing
        Integer refInt = num;
        //unboxing
        int num2 = refInt;

        //_______________________________________
        int b1 = 7;
        int c1 = 2;
        System.out.println(7 / 2); //b and c are int type. a/b will also be an int type. So the result 3.5 will become 3.

        //find multiplication without operator;
        int sum = multiplyNumbers(5, 10);
        System.out.print(sum);
        //_______________________________________

        int a3 = 5;
        //double a2 = a; //float also works
        double a2 = (float) a3; //also works
        System.out.println(a2); //5.0
        //_______________________________________
        int a13 = 5;
        float a4 = a13;
        //_______________________________________
        char c2 = 0x000A;
        System.out.println(c2); //print nothing

        //_______________________________________
        getPyramidPattern(5);

        //_______________________________________
        getFibonacciNumbers(7);

        //_______________________________________
        System.out.println(0.1 + 0.2); //0.30000000000000004
        System.out.println(0.3 + 0.2); //0.5
        System.out.println(0.0 / 0.0); //NaN
        System.out.println(9 / 0.0); //Infinity
        System.out.println(9 / 0); //ArithmeticalException - /by zero

    }

    private static void getFibonacciNumbers(int number) {
        // 0, 1, 1, 2, 3, 5, 8, 13
        int firstNum = 0;
        int secondNum = 1;
        int sum = 0;
        int counter = 1;
        while (counter <= number) {
            sum = firstNum + secondNum;
            System.out.println(sum + " ");

            firstNum = secondNum;
            secondNum = sum;
            counter++;
        }
    }

    private static void getPyramidPattern(int number) {
        for (int i = 1; i < number; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
                System.out.print("\t");
            }
            System.out.println();
        }
    }

    private static void isNumberPrime(int number) {
        //число бульше за 1, яке має рівно два різні натуральні дільники (лише 1 і саме число)
        boolean flag = false;
        for (int i = 2; i < number / 2; i++) {
            if (number % 2 == 0) {
                flag = true;
                break;
            }
        }
        if (flag) {
            System.out.println("not prime");
        } else {
            System.out.println("prime");
        }
    }

    private static void swipeTwoNumbers(int firstNumber, int secondNumber) {
        int thirdNumber = firstNumber; //12
        firstNumber = secondNumber; //33
        secondNumber = thirdNumber;//12
        System.out.println(firstNumber + " " + secondNumber);
    }

    private static void getSumOfAllNumber(int number) {
        int sum = 0;

        while (number != 0) {
            //get last digit of number
            int lastDigit = number % 10;
            //add last digit to sum
            sum = sum + lastDigit;
            //remove last digit from input number
            number = number / 10;
        }
        System.out.println("Sum Of All Digits In " + number + " = " + sum);
    }

    private static void reverseNumber(int number) {
        int reverse = 0;
        int remainder = 0;
        do {
            remainder = number % 10;
            reverse = reverse * 10 + remainder;
            number = number / 10;

        } while (number > 0);

        System.out.println(number);
    }

    private static int multiplyNumbers(int i, int j) {
        int sum = 0;
        int iterator = 1;

        while (iterator <= j) {
            sum = sum + i;
            iterator++;
        }

        return sum;
    }

    private static int element(int nums[]) {
        int countOfElements = nums.length / 2;

        for (int num : nums) {
            int count = 0;
            for (int elem : nums) {
                if (elem == num) {
                    count += 1;
                }
            }
            if (count > countOfElements) {
                return num;
            }
        }
        return -1;
    }

    private static void getHowManyStepsTillZero(int number) {
        int step = 0;
        while (number != 0) {
            if (number % 2 == 0) {
                number = number / 2;
                step = step + 1;
            } else {
                number = number - 1;
                step = step + 1;
            }
        }
        System.out.println(step);
    }

    private static void change(int a) { //in primitive type we get value
        a++;
    }

}
