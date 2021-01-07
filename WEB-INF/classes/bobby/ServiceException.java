package bobby;
import com.thinking.machines.webrock.annotations.*;
import com.thinking.machines.webrock.*;
import com.thinking.machines.webrock.model.*;
import com.thinking.machines.webrock.services.*;
@Path("/ServiceException")
public class ServiceException extends Exception
{
public ServiceException(String message)
{
super(message);
}
}