package algorithms;

import java.util.BitSet;

public class BitManipulation {

	/*
	 * 如何利用bit-manipulation来处理大数据! 首先来阐述一下什么是Bit-Map: 详细看这个网站:
	 * http://blog.csdn.net/hguisu/article/details/7880288
	 */

	// 在main()中详细介绍一下怎么操作
	public static void main(String[] args) {

		int a = 5;

		// 先看一下a的binary数字
		System.out.println(Integer.toBinaryString(a));

		// 下面来介绍一下什么是移位 << >>, 分别是向左移动和向右移动
		// 注意<<后一定要赋值, <<或是>>右边紧接着的那个数字是所要移动的位数
		int b = a << 1;
		System.out.println(a + " " + b); // 可以发现左移一位相当于乘2.
		int c = a >> 1;
		System.out.println(a + " " + c); // 可以发现右移一位相当于除以二

		// 那么我想在a的基础上获得二进制为0111的数怎么办
		// 这里要用到还要用到OR运算, OR运算: 如果两个都是0那么就是0, 否则就是1;
		// 我们知道将 0001左移一位变成 0010, 然后再用这个位移后的数字和0101做
		// OR运算, 我们就可以得到所想要的数字了

		int d = 1 << 1;
		System.out.println(Integer.toBinaryString(d));

		a = a | d;
		System.out.println(Integer.toBinaryString(a));

		// 利用以上理论就可以实现Bit-Map了!

		// 如果想查某个数是不是之前已经出现过了, 那么就用下面的方法. 1左移n位和a做&运算
		// 因为对于1来说,除了第n+1位,区域的都是0. 所以做了这个运算之后, 如果bitcount是1
		// 的话说明&运算后有一个1. 说明在a的这一位上曾经就是一个1. 那么按照bit-Map理论,
		// 就是有这样的一个数.
		// 比方说, 你想查54是不是在Bit-Map中, 那么找到数组的54/32 = 1index, 然后让1左移
		// 54%32 = 22位, 然后bitcount. if(bitcount() == 0) 那么就是没有出现过, 否则就是
		// 之前已经出现过了, 这个方法很适合用来处理大数据的重复问题!
		System.out.println("**********");
		System.out.println("a的二进制数 " + Integer.toBinaryString(a));
		System.out.println(Integer.bitCount(((a & 1 << 2))));
	}

	/*
	 * With BitMap, it can complete this with very little space due to "bit" set
	 * And with O(n) runtime
	 */
	public static boolean containsDuplicates(int[] a) {

		// This function is how java use BitSet to manipulate big
		// file
		// For example, you want to check whether this file contains
		// duplicates

		BitSet bs = new BitSet(); // BitSet can resize itself
		for (Integer i : a) {
			if (bs.get(i))
				return true; // means this number is already in
			bs.set(i, true);
		}

		return false;
	}
}
