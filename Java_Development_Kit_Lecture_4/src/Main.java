import java.util.*;

public class Main {
    public static void main(String[] args) {
        //Начальная емкость по умолчанию - 16, коэффициент загрузки - 0,75
        HashSet defaultContructor = new HashSet();
        //Конструктор с заданной начальной емкосью. Коэффициент загрузки - 0,75
        HashSet constructorWithCapacity = new HashSet(32);
        //Конструктор с заданными начальной емкостью и коэффициентом загрузки
        HashSet constructorWithCapacityFactor = new HashSet(32,0.6f);
        //Конструктор, добавляющий элементы из другой коллекции
        HashSet fromCollection = new HashSet(defaultContructor);
    }
}