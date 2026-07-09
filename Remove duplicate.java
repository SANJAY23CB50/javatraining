class Solution {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 2, 4, 1};
        for (int i = 0; i < arr.length; i++) {
            boolean flag = false;
            for (int j = 0; j < i; j++) {
                if (arr[i] == arr[j]) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                System.out.print(arr[i] + " ");
            }
        }
    }
}
