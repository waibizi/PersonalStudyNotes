package main

import "fmt"

func main() {
	a := 1
	b := "abc"
	c := 'a'
	d := 3.123456
	/* 打印变量的类型 */
	fmt.Printf("%T,%T,%T,%T", a, b, c, d)

	/**
	%d 整型格式
	%s 字符串格式输出
	%c 字符格式
	%f 浮点型格式
	 */
	fmt.Println()
	fmt.Printf("%d,%s,%c,%f",a,b,c,d)

	/* %v自动格式 */
}
