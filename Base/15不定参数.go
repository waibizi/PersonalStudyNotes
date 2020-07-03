package main

import "fmt"

/* 函数定义（定参） */
func sum(a,b int){
	sum:=a+b
	fmt.Println(sum)
}
func sum2(args ...int){
	fmt.Println(args)
	fmt.Println(args[3])
}
func main(){
	//函数调用
	sum(14,16)
	sum2(1,2)
}
