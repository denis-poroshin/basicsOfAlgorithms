import java.util.Arrays;

public class StringListIml implements StringList{
    private int arrayLength;

    private final String [] arrayOriginal;
    private static int total;

    public StringListIml() {
        arrayOriginal = new String[10];
    }

    public StringListIml(int arrayLength) {
        this.arrayLength = arrayLength;
        this.arrayOriginal = new String[this.arrayLength];

    }


    @Override
    public String add(String item) {

        arrayOriginal[size()] = item;
        total++;
        return arrayOriginal[size() - 1];

    }

    @Override
    public String add(int index, String item) {
        validateSize();
        validateItem(item);
        validateIndex(index);
        if (arrayOriginal[index] == null){
            arrayOriginal[index] = item;
            total++;
            return arrayOriginal[total - 1];
        }
//        String [] arrayCopy = new String[arrayOriginal.length];
//        for (int i = 0; i < arrayOriginal.length + 1; i++) {
//            if (index >= i){
//                arrayCopy[i] = arrayOriginal[i];
////                arrayOriginal[i] = null;
//
//            }
//        }
//        arrayOriginal[index] = item;
//
//        for (int i = index + 1; i < arrayOriginal.length ; i++) {
//            arrayOriginal[i] = arrayCopy[i - 2];
//
//        }
//        total++;
//        return arrayOriginal[index];
        System.arraycopy(arrayOriginal, index, arrayOriginal, index + 1, total - index);
        arrayOriginal[index] = item;
        total++;
        return item;

    }

    @Override
    public String set(int index, String item) {
        arrayOriginal[index] = item;
        return arrayOriginal[index];
    }

    @Override
    public String remove(String item) {
        validateItem(item);
        int index = indexOf(item);
        if (index == -1){
            throw new ValueMissingException("Значение отсутсвует в массиве");
        }

//        for (int i = 0; i < arrayOriginal.length; i++) {
//            if (arrayOriginal[i].equals(item)){
//                arrayOriginal[i] = null;
//                return arrayOriginal[i];
//            }
//
//        }
        if (index != total){
            System.arraycopy(arrayOriginal, index + 1, arrayOriginal, index, total - index);
        }
        total--;
        return item;
    }

    @Override
    public String remove(int index) {
//        if (index > arrayOriginal.length - 1){
//            throw new ValueMissingException("Значение отсутсвует в массиве");
//        }
//        arrayOriginal[index] = null;
//        return arrayOriginal[index];
        validateIndex(index);
        String item = arrayOriginal[index];
        if (index != total){
            System.arraycopy(arrayOriginal, index + 1, arrayOriginal, index, total - index);
        }
        total--;
        return item;

    }

    @Override
    public boolean contains(String item) {
        try {
            for (String s : arrayOriginal) {
                if (s.equals(item)) {
                    return true;
                }
            }
        }catch (NullPointerException e){
            return false;
        }
        return false;

    }

    @Override
    public int indexOf(String item) {
        try {
            for (int i = 0; i < arrayOriginal.length; i++) {
                if (arrayOriginal[i].equals(item)){
                    return i;
                }

            }
        }catch (NullPointerException e){
            return -1;
        }
        return -1;

    }

    @Override
    public int lastIndexOf(String item) {
        int ind = 0;
        try {
            for (int i = 0; i < arrayOriginal.length; i++) {
                ind++;
                if (arrayOriginal[i].equals(item)){

                    return total - ind;
                }
            }
        }catch (NullPointerException e){
            return -1;
        }
        return -1;

    }

    @Override
    public String get(int index) {
        return arrayOriginal[index];
    }

    @Override
    public boolean equals(StringList otherList) {
        boolean flag = true;
        for (int i = 0; i < arrayOriginal.length; i++) {
            if (!arrayOriginal[i].equals(otherList.get(i))){
                flag = false;
            }
        }
        return flag;
    }

    @Override
    public int size() {
        return total;
    }

    @Override
    public boolean isEmpty() {
        boolean flag = false;
        for (int i = 0; i < arrayOriginal.length; i++) {
            if (arrayOriginal[i] != null){
                flag = true;
                break;
            }
        }
        return !flag;

    }

    @Override
    public void clear() {
        for (int i = 0; i < total; i++) {
            arrayOriginal[i] = null;

        }

    }

    @Override
    public String[] toArray() {
        return Arrays.copyOf(arrayOriginal, total);
    }
    private void validateItem(String item){
        if (item == null){
            throw new NullPointerException();
        }
    }
    private void validateSize(){
        if (total == arrayOriginal.length){
            throw new StorageIsException();
        }
    }
    private void validateIndex(int index){
        if (index < 0 || index >= arrayLength){
            throw new IvalidIndexException();
        }
    }
}
