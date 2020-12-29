package APIActivity

class Actvity1b
{
	public static void main(def args)
	{
		File file = new File("src/input.txt");
		file.createNewFile();
		
		def inputtext="A quick brown Fox jumped over the lazy Cow\nJohn Jimbo jingeled happily ever after\nTh1\$ 1\$ v3ry c0nfus1ng"
		file.write(inputtext)
		
		//Print the line that has Cow at the end of the line
			file.eachLine { line->
			if(line==~/^.*Cow$/)
			{
				println "Line that ends with 'Cow' is : $line"
			}
		}
		
		//Print the line that start with capital letter 'J'
		file.eachLine { line->
			if(line==~/^J.*/)
			{
				println "Line that start with 'J' is : $line"
			}
		}
			
		//Print the line that has two numbers one after the other
			file.eachLine { line->
				if(line==~/.*\d\d.*/)
				{
					println "Line that has two number : $line"
				}
			}
			
		//Print the string(s) that match the pattern '\S+er'
			println "\n"
			def match1=file.getText()=~/\S+er/
			println "String(s) match  '/\\S+er/' are: ${match1.findAll()}"

		//Print the string(s) that match the pattern '\S*\d\W'
			def match2=file.getText()=~/\S*\d\W/
			println "String(s) match  '/\\S*\\W/' are: ${match2.findAll()}"
			
			
	}
}
		
		
			

