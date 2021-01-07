package bobby;
import com.thinking.machines.webrock.annotations.*;
import com.thinking.machines.webrock.*;
import com.thinking.machines.webrock.model.*;
import com.thinking.machines.webrock.services.*;
@GET
@Startup(priority=4)
@Path("/Test")
@injectSessionScope
public class Test
{
private SessionScope sessionScope;
public void setSessionScope(SessionScope sessionScope)
{
this.sessionScope=sessionScope;
System.out.println("set Session Scope method got called ");
}

@Forward("/index.jsp")
@Path("/add")
public int add(int a,int b)
{
return a+b;
}
@POST
@Path("/sub1")
@SecuredAccess(checkPost="bobby.bobby1.Test1",gaurd="securedAccessTesting")
//@Forward("/Test1/add/10/90/200")
public int sub1(@RequestParameter("aaa")int a,@RequestParameter("bbb")int b)
{
return a-b;
}
@POST
@Path("/sub")
public int sub(int a,int b)
{
return a-b;
}
@Forward("/Test1/add/10/90/200")
@Path("/mul")
public int mul(int a,int b)
{
return a*b;
}

@Path("/getStudent")
@JSON
public void getStudent(RequestScope rs,SessionScope ss,ApplicationScope as)
{
System.out.println("test_1 got called.....................");
//System.out.println(i.name);
//System.out.println(i.code);
System.out.println(rs);
System.out.println(ss);
System.out.println(as);
}




public static void main(String gg[])
{
System.out.println("Class test is executed with Prority:  4");
}

}//class eg1