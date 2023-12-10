/**
 * Создать свой Java Maven проект;
 * Добавьте зависимость commons-math3 (предназначена для решения математических задач) и изучить интерфейс библиотеки.
 * Воспользоваться пакетом org.apache.commons.math3.stat и классом DescriptiveStatistics.
 * Создать коллекцию из числовых элементов.
 * С помощью объекта DescriptiveStatistics вычислить минимальное и максимальное значение, сумму и среднее арифметическое.
 * Воспользоваться пакетом org.apache.commons.math3.util. С помощью класса ArithmeticUtils найти :
 * факториал числа N.
 * Наименьшее общее частное двух чисел
 * Наибольший общий делитель двух чисел
 * Проверить что число N это степень двойки
 */

package org.example;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
import org.apache.commons.math3.util.ArithmeticUtils;

public class Main {
    public static void main(String[] args) {
        double[] doubleArray = new double[]{3.1, 3.2, 3.14};
        DescriptiveStatistics ds = new DescriptiveStatistics(doubleArray);
        System.out.println("ds.getMin() = " + ds.getMin() +
                "\nds.getMax() = " + ds.getMax() +
                "\nds.getSum() = " + ds.getSum() +
                "\nds.getMean() = " + ds.getMean());

        System.out.println(ArithmeticUtils.factorial(3));
        System.out.println(ArithmeticUtils.lcm(4,2)); // Наименьшее общее частное двух чисел
        System.out.println(ArithmeticUtils.gcd(4,2)); //Наибольший общий делитель двух чисел
        System.out.println(ArithmeticUtils.isPowerOfTwo(3)); //Проверить что число N это степень двойки
    }
}