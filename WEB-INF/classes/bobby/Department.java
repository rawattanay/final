package bobby;
import com.thinking.machines.webrock.annotations.*;
import com.thinking.machines.webrock.*;
import com.thinking.machines.webrock.model.*;
import com.thinking.machines.webrock.services.*;
@Path("/Department")
public class Department implements java.io.Serializable
{
private int code;
private String name;
@Path("/setName")
public void setName(String name)
{
this.name=name;
}
@Path("/setCode")
public void setCode(int code)
{
this.code=code;
}
@Path("/getName")
public String getName()
{
return this.name;
}
@Path("/getCode")
public int getCode()
{
return this.code;
}



}