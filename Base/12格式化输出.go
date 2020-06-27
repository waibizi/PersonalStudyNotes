package main

import "fmt"

func main() {
	a := 1
	b := "abc"
	c := 'a'
	d := 3.123456
	/* 打印变量的类型 */
	fmt.Printf("%T,%T,%T,%T", a, b, c, d)
}
