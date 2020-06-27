package main

import "fmt"
func main(){
	fmt.Println(len("aaaa"))
	run()
	walk()
	/**
	函数语法
	func 函数名（参数列表） 返回值{
		函数体
	}
	 */
}
func run(){
	fmt.Println("跑")
}
func walk(){
	fmt.Println("走")
}
