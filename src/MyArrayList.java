import java.util.Arrays;

public class MyArrayList<T> {
    private final int initCapacity = 4;
    private Object []array = new Object[initCapacity];
    private int currentSize = 0;

    public void add(T item){
        if(array.length - 1 == currentSize){
            resize(array.length * 2);
        }
        array[currentSize++] = item;
    }

    public T get(int index){
        return (T)array[index];
    }

    public void remove(int index){
        if (currentSize - index >= 0) System.arraycopy(array, index + 1, array, index, currentSize - index);
        array[currentSize] = null;
        currentSize--;
        if(currentSize < array.length/2 ){
            resize(array.length/2);
        }
    }

    private void resize(int newLength){
        Object []newArray = new Object[newLength];
        System.arraycopy(array, 0, newArray, 0, currentSize);
        array = newArray;
    }

    @Override
    public String toString() {
        return "MyArrayList{" +
                "initCapacity=" + initCapacity +
                ", array=" + Arrays.toString(array) +
                ", currentSize=" + currentSize +
                '}';
    }

    public static void main(String []args){
        MyArrayList<Integer> lst = new MyArrayList<>();
        lst.add(1);
        lst.add(2);
        lst.add(3);
        lst.add(4);

        System.out.println(lst);
        lst.remove(2);
        System.out.println(lst);

    }
}
