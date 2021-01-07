package bobby;
import java.util.*;
import com.thinking.machines.webrock.annotations.*;
import com.thinking.machines.webrock.*;
import com.thinking.machines.webrock.model.*;
import com.thinking.machines.webrock.services.*;
@Path("DS")
public class DS
{
public static List<Department> list;
public static int code=0;
static {
list=new ArrayList<>();
Department d=new Department();
DS.code++;
d.setName("Managers");
d.setCode(DS.code);
list.add(d);

d=new Department();
DS.code++;
d.setName("Clerk");
d.setCode(DS.code);
list.add(d);


d=new Department();
DS.code++;
d.setName("Assistent");
d.setCode(DS.code);
list.add(d);

d=new Department();
DS.code++;
d.setName("Cook");
d.setCode(DS.code);
list.add(d);


} 
}