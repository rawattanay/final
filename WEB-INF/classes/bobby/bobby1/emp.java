package bobby.bobby1;
import com.thinking.machines.webrock.annotations.*;
import com.thinking.machines.webrock.*;
import com.thinking.machines.webrock.model.*;
import com.thinking.machines.webrock.services.*;
@Path("/emp")
public class emp
{
public String name;
public int code;
@Path("/getName")
public String getName()
{
return this.name;
}
}