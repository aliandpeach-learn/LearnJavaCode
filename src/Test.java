import java.util.Arrays;

public class Test {
	private static int n = 0;

	public static void main(String[] args) throws InterruptedException {
		Integer i1 =  new Integer(1);
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 10000; i++) {
					synchronized(Test.class) {
						n++;
					}
				}
			}
		});
		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 10000; i++) {
					synchronized(Test.class) {
						n--;
					}
				}
			}
		});
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		System.out.println(n);
	}

	public void perm(int[] nums, int start, int len) {
		// 判断递归出口，当start == len - 1时，也就是要做的全排列只有一个值 ，那么就可以输出了
		if (start == len - 1) {
			System.out.println(Arrays.toString(nums));
		} else {
			/*
			 * 没有到递归出口时，这一段代码是关键 for循环模拟的是： { r1, perm(p1) } + { r2, perm(p2) } + {r3,
			 * perm(p3) } + …… + {rn, perm(pn) } 从r1, r2, r3 一直到 rn 作为第一位，求剩下的全排列
			 */
			for (int i = start; i < len; i++) {
				swap(nums, start, i);// 通过交换，依次将每个数放在第一位
				perm(nums, start + 1, len);// 递归调用
				swap(nums, start, i);// 交换回来，保证原数组不会变，以进行下一轮全排列
			}
		}
	}

	// 交换数组中的两个值
	public void swap(int[] nums, int i, int j) {
		int tem = nums[i];
		nums[i] = nums[j];
		nums[j] = tem;
	}

	// kadane
	public int maxSub(int[] nums) {
		if (nums.length < 1) {
			return 0;
		}
		int max = nums[0];
		int maxCur = nums[0];
		for (int i = 0; i < nums.length; i++) {
			maxCur = Math.max(maxCur + nums[i], nums[i]);
			max = Math.max(max, maxCur);
		}
		return max;
	}
}
