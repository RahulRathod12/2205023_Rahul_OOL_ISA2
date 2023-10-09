




import java.util.Scanner;

public class KthLargestElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();

        int[] nums = new int[size];

        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < size; i++) {
            nums[i] = scanner.nextInt();
        }

        System.out.print("Enter the value of K for the Kth largest element: ");
        int k = scanner.nextInt();

        int kthLargest = findKthLargest(nums, k);

        System.out.println("The " + k + "th largest element is: " + kthLargest);

        scanner.close();
    }

    public static int findKthLargest(int[] nums, int k) {
        // Sort the array in descending order
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] < nums[j]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }

        // Return the Kth largest element
        return nums[k - 1];
    }
}

