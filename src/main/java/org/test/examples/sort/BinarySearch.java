package org.test.examples.sort;

/**
 * Description：<br>
 * 折半查找<br>
 * 时间复杂度O(logn)。
 * 
 * <pre>
 * 二分算法步骤描述
 * 	① 首先确定整个查找区间的中间位置 mid = (left + right)/ 2
 * 	② 用待查关键字值与中间位置的关键字值进行比较；
 * 		若相等，则查找成功
 * 		若大于，则在后（右）半个区域继续进行折半查找
 * 		若小于，则在前（左）半个区域继续进行折半查找
 * 	③ 对确定的缩小区域再按折半公式，重复上述步骤。<br>
 * 
 * 二分查找算法讨论：
 * 	优点：ASL≤log2n，即每经过一次比较,查找范围就缩小一半。经log2n 次计较就可以完成查找过程。
 * 	缺点：因要求有序，所以要求查找数列必须有序，而对所有数据元素按大小排序是非常费时的操作。另外，顺序存储结构的插入、删除操作不便利。
 * 	考虑：能否通过一次比较抛弃更多的部分（即经过一次比较，使查找范围缩得更小），以达到提高效率的目的。……？
 * 	可以考虑把两种方法（顺序查找和折半查找）结合起来，即取顺序查找简单和折半查找高效之所长，来达到提高效率的目的？实际上这就是分块查找的算法思想。
 * </pre>
 * 
 * @author cheng
 * @date 2017年3月30日
 *
 */
public class BinarySearch {

	/**
	 * Description：<br>
	 * 迭代查找
	 * 
	 * @author cheng
	 * @date 2017年3月30日
	 *
	 * @param array
	 *            有序数组
	 * @param key
	 *            查找元素
	 * @param left
	 *            区域中数组最左边下标
	 * @param right
	 *            区域中数组最右边下标
	 * @return key的数组下标，没找到返回-1
	 */
	public static int search(int[] array, int key, int left, int right) {
		int mid;
		while (left <= right) {
			mid = (left + right) / 2;
			if (array[mid] == key) {
				return mid;
			} else if (array[mid] > key) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return -1;
	}

	/**
	 * Description：<br>
	 * 递归查找
	 * 
	 * @author cheng
	 * @date 2017年3月30日
	 *
	 * @param array
	 *            有序数组
	 * @param key
	 *            查找元素
	 * @param left
	 *            区域中数组最左边下标
	 * @param right
	 *            区域中数组最右边下标
	 * @return key的数组下标，没找到返回-1
	 */
	public static int search2(int[] array, int key, int left, int right) {
		if (left > right) {
			return -1;
		}
		int mid = (left + right) / 2;
		if (array[mid] == key) {
			return mid;
		} else if (array[mid] > key) {
			return search2(array, key, left, mid - 1);
		} else {
			return search2(array, key, mid + 1, right);
		}
	}

	public static void main(String[] args) {
		int[] array = { 1, 3, 4, 6, 7 };
		System.out.println(search(array, 5, 0, array.length));
		System.out.println(search(array, 3, 0, array.length));
		System.out.println(search(array, 1, 0, array.length));
		System.out.println(search(array, 7, 0, array.length));
		System.out.println(search2(array, 5, 0, array.length));
		System.out.println(search2(array, 3, 0, array.length));
		System.out.println(search2(array, 1, 0, array.length));
		System.out.println(search2(array, 7, 0, array.length));
	}
}
