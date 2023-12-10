import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Описать собственную коллекцию - список на основе массива. Коллекция должна иметь
 * возможность хранить любые типы данных, иметь методы добавления и удаления элементов
 *
 * @param <T>
 */

public class MyCollection<T>  {
    List<T> array;

    public MyCollection() {
        this.array = new ArrayList<T>();
        array.iterator();
    }

    private void add(T element) {
        array.add(element);
    }

    private void remove(T element) {
        array.remove(element);
    }


}
