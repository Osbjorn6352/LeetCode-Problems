class OptimizedTwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        valAndIndex = createNPIArray(nums);
        mergeSort(valAndIndex);
        //TODO: IMPLEMENT A BINARY SEARCH TO COMPLETE THE FUNCTION OF OptimizedTwoSum
    }
    
    static void mergeSort(NumberPlusIndex[] a){
        NumberPlusIndex[] temp = new NumPlusIndex[a.length];
        msAux(a, 0, a.length-1, temp);
    }
    
    static void mergeArr(NumberPlusIndex[] a, int st, int mid, int end, NumberPlusIndex[] temp){
        for (int i = st; i <= end; i++){
            temp[i] = a[i];
        }
        int i = st;
        int j = mid + 1;
        for (int k = st; k <= end; k++){
            if (i > mid){
                a[k] = temp[j++];
            }
            else if (j > end){
                a[k] = temp[i++];
            }
            else if (temp[i].value <= temp[j].value){
                a[k] = temp[i++];
            }
            else {
                a[k] = temp[j++];
            }
        }
    }
    
    //POSTCONDITION: a[st..end] should is sorted
    static void msAux(NumberPlusIndex[] a, int st, int end, NumberPlusIndex[] temp){
        if (st >= end) return; //the portion of the array to be sorted is of size 1 or 0
        int mid = (st + end)/2; //ensures the function keeps recurring rather than making the same call over and over
        msAux(a, st, mid, temp);
        msAux(a, mid + 1, end, temp);
        if (a[mid + 1].value < a[mid].value){
            mergeArr(a, st, mid, end, temp); //merge the two sorted portions
        }
    }
}
