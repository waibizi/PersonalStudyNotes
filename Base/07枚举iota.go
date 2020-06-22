package main

import "fmt"
func main(){

	const a = iota
	const b = iota
	fmt.Println(a)
	fmt.Println(b)
	/* iota遇到const就会重置为零 */
	const(
		c = iota
		d = iota
	)
	fmt.Println(c)
	fmt.Println(d)
	/* 同一个const当中，iota会自增 */
	const(
		e = iota
		f
		g
	)
	fmt.Println(e)
	fmt.Println(f)
	fmt.Println(g)
	/* 多重赋值,这样不会自增 */
	const a1,a2,a3 = iota,iota,iota
	fmt.Println(a1,a2,a3)

}
