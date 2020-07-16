package main

import "fmt"

func main() {
	var num int
	num = 9
	/* 匿名函数 */
	func() {
		num++
		fmt.Println(num)
	}()
	fmt.Println(num)
	f := func() {
		num++
	}
	f()
	fmt.Println(num)

	x, y := func(i, j int) (max, min int) {
		if i > j {
			max = i
			min = j
		} else {
			max = j
			min = i
		}
		return
	}(18, 20)

	fmt.Println(x, y)

}
