package cs113;
import.java*.util;
public class TestArraysAndRecursion {
public static void main(String[] args) {
int[][] sales = {
{200, 350, 400},
{150, 375, 225}
};
int range = salesRange(sales);
System.out.println("Sales range: " + range);
Die[][] dice = {
{new Die(), new Die(), new Die()},
{new Die(), new Die(), new Die()}
};
int[] oddCounts = dieStats(dice);
System.out.print("Odd counts: ");
for (int count : oddCounts) {
System.out.print(count + " ");
}
System.out.println();
int num = 23147;
System.out.println("Digits of " + num + ":");
printDigits(num);
int[] a = {1, 3, 2, 5};
System.out.println("Product of all entries in a: " + prodArray(a,
a.length));
}
public static int salesRange(int[][] sales) {
int min = Integer.MAX_VALUE;
int max = Integer.MIN_VALUE;
for (int[] row : sales) {
for (int sale : row) {
min = Math.min(min, sale);
max = Math.max(max, sale);
}
}
return max - min;
}
public static int[] dieStats(Die[][] dice) {
int[] oddCounts = new int[dice.length];
for (int i = 0; i < dice.length; i++) {
for (int j = 0; j < dice[i].length; j++) {
int rollResult = dice[i][j].roll();
if (rollResult % 2 != 0) {
oddCounts[i]++;
}
}
}
return oddCounts;
}
public static void printDigits(int num) {
if (num < 10) {
System.out.println(num);
} else {
printDigits(num / 10);
System.out.println(num % 10);
}
}
public static int prodArray(int[] numArray, int count) {
if (count == 1) {
return numArray[0];
} else {
return numArray[count - 1] * prodArray(numArray, count - 1);
}
}
