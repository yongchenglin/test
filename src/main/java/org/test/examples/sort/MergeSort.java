package org.test.examples.sort;

import java.util.Arrays;

/**
 * Description：<br>
 * 归并算法
 * 
 * @author cheng
 * @date 2017年3月29日
 *
 */
public class MergeSort {
	static int number = 0;

	public static void main(String[] args) {
		int[] array = { 26, 5, 98, 108, 28, 99, 100, 56, 34, 1 };
		printArray("排序前：", array);
		mergeSort(array);
		printArray("排序后：", array);
	}

	private static void printArray(String pre, int[] array) {
		System.out.println(pre);
		for (int a : array) {
			System.out.print(a + "\t");
		}
		System.out.println();
	}

	private static void mergeSort(int[] array) {
		System.out.println("开始排序");
		mergesort_recursion(array, 0, array.length - 1);
		mergesort_iteration(array, 0, array.length - 1);
	}

	//  递归实现的归并排序(自顶向下)
	private static void mergesort_recursion(int[] array, int left, int right) {
		// 当待排序的序列长度为1时(left == right)，递归“开始回升”
		if (left >= right) {
			return;
		}
		int mid = (left + right) / 2;
		// 二路归并算法里面有两个sort，多路归并排序里面写多个sort就可以了
		mergesort_recursion(array, left, mid);
		mergesort_recursion(array, mid + 1, right);
		merge(array, left, mid, right);
	}

	// 非递归(迭代)实现的归并排序(自底向上)
	private static void mergesort_iteration(int A[], int left, int right)  // 非递归(迭代)实现的归并排序(自底向上)
	{
	    int low, middle, high;    // 子数组索引,前一个为A[low...middle],后一个子数组为A[middle+1...high]
	    for (int size = 1; size <= right - left; size *= 2) // 子数组的大小初始为1,每轮翻倍
	    {
	        low = left;
	        while (low + size - 1 <= right - 1 )// 后一个子数组存在(需要归并)
	        {
	            middle = low + size - 1;    
	            high = middle + size;        
	            if (high > right)// 后一个子数组大小不足size
	                high = right;
	            merge(A, low, middle, high);
	            low = high + 1;// 前一个子数组索引向后移动
	        }
	    }
	}

	private static void merge(int[] array, int left, int mid, int right) {
		int[] tmp = new int[array.length];
		int r1 = mid + 1;
		int tIndex = left;
		int cIndex = left;
		while (left <= mid && r1 <= right) {
			if (array[left] <= array[r1]) {
				tmp[tIndex++] = array[left++];
			} else {
				tmp[tIndex++] = array[r1++];
			}
		}
		// 将左边剩余的归并
		while (left <= mid) {
			tmp[tIndex++] = array[left++];
		}
		// 将右边剩余的归并
		while (r1 <= right) {
			tmp[tIndex++] = array[r1++];
		}
		System.out.println("第" + (++number) + "趟排序：\t");
		while (cIndex <= right) {
			array[cIndex] = tmp[cIndex];
			// 输出中间归并排序结果
			System.out.print(array[cIndex] + "\t");
			cIndex++;
		}
		System.out.println(Arrays.toString(array));
	}

}
