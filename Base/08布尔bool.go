package main

import "fmt"
/* 长度为1,默认值为false */
func main()  {
	var a  bool
	fmt.Println(a)

	a = true
	fmt.Println(a)

	var b = true
	fmt.Println(b)

	c := false
	fmt.Println(c)

	d := (1==2)
	fmt.Printf("%T",d)
}
