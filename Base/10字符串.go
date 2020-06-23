package main

import "fmt"

func main()  {
	str := "歪鼻子学习编程"
	/* 中文占据三个字节的长度 */
	fmt.Println(len(str))
	/* 英文字符占据一个字节的长度*/
	str1 := "abc"
	fmt.Println(len(str1))

}
