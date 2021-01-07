package bobby;
import com.thinking.machines.webrock.annotations.*;
import com.thinking.machines.webrock.*;
import com.thinking.machines.webrock.model.*;
import com.thinking.machines.webrock.services.*;
@Path("/Student_s")
public class Student_s
{
public String name;
public int code;
@Path("/getName")
public String getName()
{
return this.name;
}
}