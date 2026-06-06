public class Main {
    public static void main(String[] args) {

        int[] numbers = {10, 22, 35, 47, 51, 63, 75, 86, 92, 100}; //
        int target = 47;

        int index = binarySearch(numbers, target);

        if (index != -1) {
            System.out.println("Element " + target + " found at index " + index);
        } else {
            System.out.println("Element " + target + " not found ");
        }
    }

    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid;
            }

            else if (arr[mid] < target) {
                left = mid + 1;
            }

            else {
                right = mid - 1;
            }
        }
        return -1;
    }
}