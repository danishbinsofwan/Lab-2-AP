
	 
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Inter {
	
	HashMap <String , Object> myTab = new HashMap<String , Object>();
	String[] TempS;
	String sCurrentLine;
	int count = 0;
	BufferedReader br = null;
	
	
	Inter()
	{
		
	}
	
	public void StartInterpreting(String FileName)
	{
	try {
		br = new BufferedReader(new FileReader(FileName));
	 
		while ((sCurrentLine = br.readLine()) != null) {
			count++;
			TempS = sCurrentLine.split(" ");
			myVar obj = new myVar();
			myVar obj1 = new myVar();
				
			if(TempS[0].compareTo("Let") == 0)
			{	
				if( TempS.length > 4 )
				{
					System.out.println("Error at line" + " " + count);
					System.exit(0);
				}
				if( TempS.length <= 2 )
				{
					System.out.println("Error at line" + " " + count);
					System.exit(0);
				}
				if(TempS[2].compareTo("=") == 0  )
				{
					if( TempS.length <= 3 )
					{
						System.out.println("Error at line" + " " + count);
						System.exit(0);
					}
					obj.Name = TempS[1];
					if( myTab.containsKey(TempS[3]))
					{
						myVar t = new myVar();
						t =  (myVar) myTab.get(TempS[3]);
						obj.Value =  t.Value;
						myTab.put(TempS[1], obj);
					}
					else
					{
						try {
							obj.Value =  Integer.parseInt(TempS[3]);
							myTab.put(TempS[1], obj);
							}
							catch ( NumberFormatException e ) {
							   System.out.println( "Error at line " + count );
							}
					}
				}
					else
						System.out.println("Error at line" + count);
					
					
				}
				else if(TempS[0].compareTo("Print") == 0)
				{
					if(myTab.containsKey(TempS[1]))
					{
						obj = (myVar) myTab.get(TempS[1]);
						//System.out.println(obj.Name);
						System.out.println(obj.Value);
					}
					else
						System.out.println("Error at line " + count);
				}
				else if(myTab.containsKey(TempS[0]))
				{
					obj = (myVar) myTab.get(TempS[0]);
					if(TempS[1].compareTo("=") == 0)
					{
						if(myTab.containsKey(TempS[2]))
						{
							if(TempS[3].compareTo("+") == 0)
							{
								if(myTab.containsKey(TempS[4]))
								{
									obj1 = (myVar) myTab.get(TempS[4]);
								}
								else
									obj1.Value = Integer.parseInt(TempS[4]);
								
								obj.Value = obj.Value + obj1.Value;
								myTab.put(obj.Name, obj);
							}
							if(TempS[3].compareTo("-") == 0)
							{
								if(myTab.containsKey(TempS[4]))
								{
									obj1 = (myVar) myTab.get(TempS[4]);
								}
								else
									obj1.Value = Integer.parseInt(TempS[4]);
								
								obj.Value = obj.Value - obj1.Value;
								myTab.put(obj.Name, obj);
							}
							if(TempS[3].compareTo("*") == 0)
							{
								if(myTab.containsKey(TempS[4]))
								{
									obj1 = (myVar) myTab.get(TempS[4]);
								}
								else
									obj1.Value = Integer.parseInt(TempS[4]);
								
								obj.Value = obj.Value * obj1.Value;
								myTab.put(obj.Name, obj);
							}
							if(TempS[3].compareTo("/") == 0)
							{
								if(myTab.containsKey(TempS[4]))
								{
									obj1 = (myVar) myTab.get(TempS[4]);
								}
								else
									obj1.Value = Integer.parseInt(TempS[4]);
								
								obj.Value = obj.Value / obj1.Value;
								myTab.put(obj.Name, obj);
							}
						}
						
					}
					else
						System.out.println("Error");
				}
				else
					System.out.println("xx Error at line " + count);
				
			}
			} catch (IOException e) {
			e.printStackTrace();
			} 
	}
	}




