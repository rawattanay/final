package bobby;
import java.util.*;
import com.thinking.machines.webrock.annotations.*;
import com.thinking.machines.webrock.*;
import com.thinking.machines.webrock.model.*;
import com.thinking.machines.webrock.services.*;
@Path("/DepartmentService")
public class DepartmentService implements java.io.Serializable
{
@Path("/addDepartment")
@JSON
public void add(Department department) throws ServiceException
{
try{
System.out.println("--------------------------add Department");
System.out.println(department.getName());
if(department.getName().equalsIgnoreCase("Sales")) throw new ServiceException("name of department cannot be 'Sale' ");
DS.code+=DS.code;
department.setCode(DS.code);
DS.list.add(department);
}catch(Exception e){
System.out.println(e);
throw new ServiceException(e.getMessage());}
}
@Path("/getDepartment")
public List<Department> getDepartment()
{
List<Department> list=DS.list;
System.out.println(list);
return list;
}



}