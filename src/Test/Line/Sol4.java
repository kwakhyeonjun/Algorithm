package Test.Line;

public class Sol4 {
    /**
     * div & con?
     * @param n
     * @return
     */
    public int[] solution(int n) {
        int[] answer = new int[n+1];
        for(int i = 1; i <= n; i++) answer[i] = i;
        div(answer, 1, 12);
        return answer;
    }

    public void div(int[] arr, int start, int end){
        int length = end - start + 1;
        for(int p = 2; p <= Math.sqrt(length); p++){
            if(length/p == 0){
                //conquer
                int[] conArr = new int[length/p];
                int conIdx = 0;
                for(int i = 0; i < p; i++){
                    for(int j = start; j <= end; j += p){
                        conArr[conIdx++] = arr[j];

                    }
                }
                break;
            }
        }
    }


    public void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
