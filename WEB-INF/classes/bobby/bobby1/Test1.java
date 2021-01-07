package bobby.bobby1;
import com.thinking.machines.webrock.annotations.*;
import com.thinking.machines.webrock.*;
import com.thinking.machines.webrock.model.*;
@injectSessionScope
@injectApplicationScope
@POST
@Path("/Test1")
@Startup(priority=1)
public class Test1
{
public void securedAccessTesting()
{
System.out.println("secured Acess Testing done Sucessfully.......");
}
@AutoWired(name="xyz")
private int autoWiredTestingField;
public void setAutoWiredTestingField(int x)
{
this.autoWiredTestingField=x;
System.out.println("setAutoTestingField got called :-->"+this.autoWiredTestingField);
}
public int getAutoWiredTestingField()
{
return this.autoWiredTestingField;
}
@Path("/add")
public int add(int a,int b,int z)
{
return a+b+z;
}
@Path("/sub")
public String sub(int a,int b)
{
return "subtract method got called and subtration is : "+(b-a);
}
@Path("/mul")
public int mul(int a,int b,int c)
{
return a*b*c;
}
@JSON
@Path("/getEmp")
public String getEmp(emp e)
{
String qq="";
System.out.println("emp got called...");
qq+="Name :"+e.name+"\n";
qq+="Code :" +e.code+"\n";
return qq;
}
public static void main(String gg[])
{
System.out.println("Class test1 is executed with Prority:  1");
}
}//class eg1