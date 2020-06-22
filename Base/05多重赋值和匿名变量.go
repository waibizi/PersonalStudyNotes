package main

import "fmt"
func test()(a, b, c int)  {
	return 1, 2, 3
}
func main() {
	a , b := 10,20
	fmt.Println(a,b)
	a , b = b ,a
	fmt.Println(a,b)

	//匿名变量,丢弃数据不处理
	/*
	var d, e ,f int
	d,e,f = test()
	*/

	c, d, _ := test()
	fmt.Println(c, d)
}
