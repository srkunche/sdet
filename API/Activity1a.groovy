package APIActivity

class Activity1a {
	public static void main(def args) {
		def inputList= [11,2,"Mango",19,5,"Apple","WaterMelon"]
		
		def strList=inputList.minus([11,2,19,5])
		def intList=inputList.minus(["Mango","Apple","WaterMelon"])
		
		println strList.sort()
		println intList.sort()
		
	
		
	}
	
}

