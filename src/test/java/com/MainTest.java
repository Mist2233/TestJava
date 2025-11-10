package com;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MainTest {

	@Test
	void testAddPositiveNumbers() {
		// 测试正常情况：两个正数相加
		Main main = new Main();
		int result = main.add(1, 1);
		assertEquals(2, result);
	}

	@Test
	void testAddWithFirstNegative() {
		// 测试条件：a < 0
		Main main = new Main();
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
			main.add(-1, 5);
		});
		assertEquals("Both numbers must be non-negative.", exception.getMessage());
	}

	@Test
	void testAddWithSecondNegative() {
		// 测试条件：b < 0
		Main main = new Main();
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
			main.add(5, -1);
		});
		assertEquals("Both numbers must be non-negative.", exception.getMessage());
	}

	@Test
	void testAddWithBothNegative() {
		// 测试条件：a < 0 且 b < 0
		Main main = new Main();
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
			main.add(-1, -1);
		});
		assertEquals("Both numbers must be non-negative.", exception.getMessage());
	}

	@Test
	void testAddWithZero() {
		// 测试边界情况：a = 0 和 b = 0
		Main main = new Main();
		int result1 = main.add(0, 0);
		assertEquals(0, result1);
		
		int result2 = main.add(0, 5);
		assertEquals(5, result2);
		
		int result3 = main.add(5, 0);
		assertEquals(5, result3);
	}

	@Test
	void testAddWithOverflow() {
		// 测试条件：Integer.MAX_VALUE - a < b (溢出情况)
		Main main = new Main();
		ArithmeticException exception = assertThrows(ArithmeticException.class, () -> {
			main.add(Integer.MAX_VALUE, 1);
		});
		assertTrue(exception.getMessage().contains("Integer overflow"));
	}

	@Test
	void testAddWithMaxValueNoOverflow() {
		// 测试条件：Integer.MAX_VALUE - a < b 为 false (不溢出的边界情况)
		Main main = new Main();
		int result = main.add(Integer.MAX_VALUE - 1, 1);
		assertEquals(Integer.MAX_VALUE, result);
	}

	@Test
	void testAddLargeNumbers() {
		// 测试大数相加但不溢出
		Main main = new Main();
		int result = main.add(1000000, 2000000);
		assertEquals(3000000, result);
	}

}
