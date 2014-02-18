object Trans{
	private var stringToTransform:String = "(* (+ (- 1 2) b) (- a (* 2 3)))";
	private var count:Int = 0
	def main(args: Array[String]){

	  	println("Enter your Lisp Expression:")
	  	stringToTransform = Console.readLine()
		println("String to Transform: " + stringToTransform)
		
		var s:String = stringToTransform.replaceAll(" ", "")
		if(!(s.charAt(0)=='('))
			println("String is not formatted correctly")
		else
			println("Result is: " + convert(getExpression(s)))
			
	}
	
	def convert(list:List[Any]):String = {
	  var result:String = ""
	    
	  result = list.toString().replaceAll("List","").replaceAll(",", "")
	  result = result.substring(1, result.length()-1)
	  
	  return result
	}
	
	def getExpression(value:String):List[Any] = {
	  var result:String=value
	  count+=1
	  var opr:String=value.charAt(count).toString()
	  var leftArg:Any = null
	  var rightArg:Any = null
	  count+=1
	  if(value(count) == '('){
	    leftArg = getExpression(value)
	    count+=1
	  }
	  else
		leftArg = value(count)
	  
	  
	  count+=1
	  if(value(count)=='('){
	  	rightArg = getExpression(value)
	    count+=1
	  }
	  else
		rightArg = value(count)
	  
	  
	  return List(leftArg, opr, rightArg)
	}
}


