package main

import "fmt"

func main(){

	var a = 10;
	fmt.Println(a)
	fmt.Printf("%T\n",a)
	fmt.Println()
	//常用的自推导类型
	b :=20
	fmt.Printf("%T",b)
}