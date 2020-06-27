package main

import "fmt"

func main() {
	var t complex64

	t = 2.1 + 3.4i
	fmt.Println(t)

	/* 自动推导类型 */
	fmt.Printf("%T\n", t)

	t1 := 3.14 + 2.4i
	fmt.Printf("%T", t1)
}
