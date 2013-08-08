package findarray;

public class MyFindArray implements FindArray {

    public int findArray(int[] array, int[] subArray) {

        if (array == null || subArray == null) {
            return -1;
        } else if (array.length == 0 || subArray.length == 0) {
            return -1;
        } else if (array.length < subArray.length) {
            return -1;
        }

        int i = -1;
        while (i + subArray.length < array.length) {
            i++;
            if (array[i] == subArray[0]) {
                int j = 0;
                // TODO find a nicer way for subArray of length 1
                // maybe going from the end to the beginning with i
                while (j < subArray.length) {
                    if (array[i + j] != subArray[j]) {
                        continue;
                    }
                    j++;
                }
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};

        System.out.println(new MyFindArray().findArray(a, new int[]{1}) + " * 0");
        System.out.println(new MyFindArray().findArray(a, new int[]{2}) + " * 1");
        System.out.println(new MyFindArray().findArray(a, new int[]{3}) + " * 2");
        System.out.println(new MyFindArray().findArray(a, new int[]{4}) + " * 3");
        System.out.println(new MyFindArray().findArray(a, new int[]{5}) + " * 4");
        System.out.println(new MyFindArray().findArray(a, new int[]{1, 2, 3}) + " * 0");
        System.out.println(new MyFindArray().findArray(a, new int[]{1, 2}) + " * 0");
        System.out.println(new MyFindArray().findArray(a, new int[]{}) + " * -1");
        System.out.println(new MyFindArray().findArray(a, new int[]{1, 2, 3, 4, 5}) + " * 0");
        System.out.println(new MyFindArray().findArray(a, new int[]{1, 2, 3, 4, 5, 6}) + " * -1");
        System.out.println("--------------------------------------------------");
        System.out.println(new MyFindArray().findArray(a, new int[]{2, 3}) + " * 1");
        System.out.println(new MyFindArray().findArray(a, new int[]{3}) + " * 2");
        System.out.println(new MyFindArray().findArray(a, new int[]{4}) + " * 3");
        System.out.println("--------------------------------------------------");
        System.out.println(new MyFindArray().findArray(new int[]{4, 9, 3, 7, 8}, new int[]{3, 7}) + " * 2"); // 2
        System.out.println(new MyFindArray().findArray(new int[]{1, 3, 5}, new int[]{1}) + " * 0"); // 0
        System.out.println(new MyFindArray().findArray(new int[]{7, 8, 9}, new int[]{8, 9, 10}) + " * -1"); // -1
        System.out.println("--------------------------------------------------");
        System.out.println(new MyFindArray().findArray(a, null) + " * -1");
        System.out.println(new MyFindArray().findArray(a, new int[]{1, 2, 4}) + " * -1");
        System.out.println(new MyFindArray().findArray(a, new int[]{1, 4}) + " * -1");
    }

}
