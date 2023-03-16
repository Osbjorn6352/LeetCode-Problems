public class OptimizedTwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        NumberPlusIndex[] valAndIndex = createNPIArray(nums);
        mergeSort(valAndIndex);
        for (int i = 0; i < nums.length; i++) {
            int res = target - valAndIndex[i].value;
            int resIndex = valAndIndex[i].index;
            int res2 = binarySrch(res, valAndIndex);
            if (res2 != -1) {
                ans[0] = resIndex;
                ans[1] = res2;
            }
        }
        return ans;
    }

	// precondition: array a[] is sorted
	public static int binarySrch(int key, NumberPlusIndex[] a) {
		return binaryHelper (key, a, 0, a.length - 1);
	}

    // A recursive auxillary function for binarySrch
	public static int binaryHelper(int key, NumberPlusIndex[] a, int lo, int hi) {
		// key is in a[lo..hi] or not present.
		if (lo > hi) return -1;
		int mid = lo + (hi - lo) / 2;
		if      (key < a[mid].value) return binaryHelper (key, a, lo, mid - 1);
		else if (key > a[mid].value) return binaryHelper (key, a, mid + 1, hi);
		else return mid;
	}
    
    //Convert our int array to a new class in order to store index after sorting
    private NumberPlusIndex[] createNPIArray(int[] a) {
        NumberPlusIndex[] b = new NumberPlusIndex[a.length];
        for (int i = 0; i < a.length; i++)
          b[i] = new NumberPlusIndex(a[i], i);
        return b;
    }

    //Sort the array in order to use a binary search
    static void mergeSort(NumberPlusIndex[] a){
        NumberPlusIndex[] temp = new NumberPlusIndex[a.length];
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
