package main

import "fmt"

func add(s1, s2 int) {
	sum := s1 + s2
	fmt.Println(sum)
}
func main() {
	a := 10
	b := 20
	//函数调用
	add(a, b)

}
