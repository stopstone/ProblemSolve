fun main(args: Array<String>) {
	val input = readLine()!!.toInt()
	
	for(i in 1..input) {
		for(j in 1..i) {
			print('*')
		}
		println()
	}
}