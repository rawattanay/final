import com.thinking.machines.webrock.pojo.*;
import com.thinking.machines.webrock.annotations.*;
import com.thinking.machines.webrock.model.*;
import com.thinking.machines.webrock.services.*;
import java.net.*;
import java.io.*;
import java.util.*;
import java.util.Map.Entry.*;
import java.lang.reflect.*;
import java.io.File;
import java.lang.annotation.*; 
import java.lang.annotation.RetentionPolicy; 
import com.itextpdf.kernel.pdf.*;
import com.itextpdf.layout.element.*;
import com.itextpdf.layout.Document;
import com.itextpdf.io.font.constants.*;
import com.itextpdf.kernel.font.*;
import com.itextpdf.layout.property.*;
import com.itextpdf.io.image.*;
import com.itextpdf.layout.borders.*;


class PClass
{
public Class clas;
public int priority;
}



public class ServicesDoc 
{
public static void main(String gg[])
{
System.out.println("--------------------------------hello world------------------------------");
try
{
String packagePath=gg[0];
String pdfPackage=gg[1];
boolean newPage=true;

File f3=new File(packagePath);
File f4=new File(pdfPackage);


File f= new File(System.getProperty("user.dir"));
String filePath=f.getPath();
String pdfFilePath=f.getPath();
System.out.println("1");
if(!f3.isAbsolute())filePath=filePath+File.separator+packagePath;
else filePath=packagePath;

if(!f4.isAbsolute())pdfFilePath=pdfFilePath+File.separator+pdfPackage;
else pdfFilePath=pdfPackage;


System.out.println(filePath+"----");
System.out.println(packagePath);
System.out.println(pdfPackage);

String fullPathOfDirectory=filePath;
File file=new File(fullPathOfDirectory);
File file3=new File(pdfFilePath+File.separator+"Services_Doc.pdf");

String []c1=file.list();


java.util.List<String> tmp=new ArrayList<>();
File[] files=file.listFiles();
java.util.List<File> tmpfiles=new ArrayList<>();
java.util.List<File> directory=new ArrayList<>();
for(File f1:files)
{
if(f1.isDirectory()) directory.add(f1);
else tmpfiles.add(f1);
}
files=null;
//System.out.println(tmpfiles);
while(!(directory.size()==0))
{
//System.out.println(directory.size()+"size");
file=(directory.get(0));
for(File ff:file.listFiles())
{
if(ff.isDirectory()) directory.add(ff);
else tmpfiles.add(ff);
}
//System.out.println(file);
directory.remove(0);
//System.out.println(directory.size());
}




java.util.List<String> mainFiles=new ArrayList<>();
String[] array=null;
for(File s1:tmpfiles) mainFiles.add(s1.getPath());
//for(String s2:mainFiles)System.out.println(s2);
java.util.List<String> mainFiles1=new ArrayList<>();
int q=0;
String zz=null;
//System.out.println(main);
for(int z=0;z<mainFiles.size();z++)
{
q=0;
zz=mainFiles.get(z);
//System.out.println(zz+"------------"+z);
array=null;
if(zz.endsWith(".class"))
{
array=zz.split("\\\\");
//System.out.println("Splited");

for(q=0;q<array.length;q++)
{
if(array[q].equalsIgnoreCase("classes")) break; 
}//for array
//System.out.println(array[q]);
q++;
zz="";
for(int i=q;i<array.length;i++)
{
if(array[i].endsWith(".class"))
{
zz=zz+array[i].substring(0,array[i].length()-6);
break;
}
zz=zz+array[i]+".";
}
array=null;
//System.out.println(zz+"     __");
mainFiles1.add(zz);
}//if .class
}


System.out.println("???????????????????");
System.out.println("????????????????????");

System.out.println("          --List Of Classes Found for the given path--                    ");

java.util.List<Class> classList=new ArrayList<>();

for(String s3:mainFiles1)
{
System.out.println(s3);

}


for(String s3:mainFiles1)
{
//System.out.println(s3);
classList.add(Class.forName(s3));
}
for(Class c5:classList) System.out.println(c5);






//pdf-------------------------
//File file3=new File(pdfFilePath); 
PdfWriter pdfWriter=new PdfWriter(file3);
PdfDocument pdfDocument=new PdfDocument(pdfWriter);
int pageSize=5;
int pageNumber=1;
Document document=new Document(pdfDocument);
//document.setPageSize(pageSize);
//PdfFont boldFont=PdfFontFactory.createFont(StandardFonts.TIMES_BOLD,"12f");
PdfFont font=PdfFontFactory.createFont(StandardFonts.TIMES_ROMAN);
int srNo=1;
String title="Designation";
float columnWidths[]={4,6};
Table table=new Table(UnitValue.createPercentArray(columnWidths));
table.setWidth(UnitValue.createPercentValue(100));
Paragraph cellPara;
Cell cell;
int r=0;
int cellCount=0;
//int xx=0;
//pdf---------------------------------------








WebRockModel modelObject=new WebRockModel();
Path pathOnType;
Path pathOnMethod;
Method methods[];
String fPath;
Service service=null;
Forward forwardOnType;
Forward forwardOnMethod;
GET getOnType;
GET getOnMethod;
POST postOnType;
POST postOnMethod;
injectApplicationScope ias;
injectSessionScope iss;
injectRequestScope irs;
injectApplicationDirectory iad;
JSON jom;
Startup startupOnType;
java.util.List<Integer> priorityQueue=new ArrayList<>();
java.util.List<PClass> priorityClass=new ArrayList<>();
PClass pClass;
RequestParameter rpOnMethod=null;
Parameter[] parameters;
int pflag=0;
int scopeFlag=0;
System.out.println("");
System.out.println("");
for(Class c:classList)
{
System.out.println("");
System.out.println("Class-Name");
System.out.println("----------------");
System.out.println(c+" |");
System.out.println("----------------");

System.out.println("");
System.out.println("Annotations Applied..");
pflag=0;
pathOnType=(Path)c.getAnnotation(Path.class);
//
getOnType=(GET)c.getAnnotation(GET.class);
postOnType=(POST)c.getAnnotation(POST.class);
ias=(injectApplicationScope)c.getAnnotation(injectApplicationScope.class);
iss=(injectSessionScope)c.getAnnotation(injectSessionScope.class);
irs=(injectRequestScope)c.getAnnotation(injectRequestScope.class);
iad=(injectApplicationDirectory)c.getAnnotation(injectApplicationDirectory.class);
startupOnType=(Startup)c.getAnnotation(Startup.class);
System.out.println("@PATH     :"+pathOnType.value());
System.out.println("@GET   :"+getOnType);
System.out.println("@POST   :"+postOnType);
System.out.println("@InjectApplicationScope   :"+ias);
System.out.println("@InjectSessionScope   :"+iss);
System.out.println("@InjectRequestScope   :"+irs);
System.out.println("@InjectApplicationDirectory   :"+iad);
System.out.println("@StartUp   :"+startupOnType);


if(pathOnType==null) continue;
methods=c.getDeclaredMethods();

System.out.println("----Methods-----");
for(Method method:methods)
{
System.out.println("Method Name : "+method.getName());
pathOnMethod=(Path)method.getAnnotation(Path.class);
//
getOnMethod=(GET)method.getAnnotation(GET.class);
postOnMethod=(POST)method.getAnnotation(POST.class);
forwardOnMethod=(Forward)method.getAnnotation(Forward.class);
jom=(JSON)method.getAnnotation(JSON.class);
parameters=method.getParameters();
scopeFlag=0;
System.out.println("    Annotations appplied on Method");
System.out.println("@GET   :"+getOnMethod);
System.out.println("@POST   :"+postOnMethod);
System.out.println("@Forward   :"+forwardOnMethod);

System.out.println("Parameters--------------------------------------------");

for(Parameter p:parameters)
{
rpOnMethod=(RequestParameter)p.getAnnotation(RequestParameter.class);
System.out.println(p);
System.out.println("Annotations applied on parameters");
System.out.println("@RequestParameter    :"+rpOnMethod);
System.out.println();
if(p.getType()==SessionScope.class) scopeFlag=1;
if(p.getType()==RequestScope.class) scopeFlag=1;
if(p.getType()==ApplicationScope.class) scopeFlag=1;
}


if(pathOnMethod==null) continue;
fPath=pathOnType.value()+pathOnMethod.value();

//setting up all the services in pojo

service=new Service();
service.setServiceClass(c);
service.setPath(pathOnMethod.value());
service.setService(method);
if(ias==null)service.setInjectApplicationScope(false);
else service.setInjectApplicationScope(true);
if(iss==null)service.setInjectSessionScope(false);
else service.setInjectSessionScope(true);
if(irs==null)service.setInjectRequestScope(false);
else service.setInjectRequestScope(true);
if(iad==null)service.setInjectApplicationDirectory(false);
else service.setInjectApplicationDirectory(true);
if(jom==null) service.setJsonRequest(false);
else service.setJsonRequest(true);

if(rpOnMethod!=null)
{
service.setRequestParameter(true);
System.out.println("@requestParameter : YES");
}
else
{
service.setRequestParameter(false);
System.out.println("@requestParameter : NO");
}
if(scopeFlag==1) service.setRequestParameter(true);



if(startupOnType==null)
{
service.setRunOnStartup(false);
service.setPriority(-1);
}
else 
{
service.setRunOnStartup(true);
service.setPriority(startupOnType.priority());
if(pflag==0)
{
priorityQueue.add(startupOnType.priority());
pClass=new PClass();
pClass.priority=startupOnType.priority();
pClass.clas=c;
priorityClass.add(pClass);
}
pflag=1;
}
if(forwardOnMethod!=null)service.setForward(forwardOnMethod.value());
else service.setForward("null");
modelObject.model.put(fPath,service);
}//for methods
}//for classes





//table.addHeaderCell(new Cell().add(new Paragraph("Excutable Path")).setFont(font).setFontSize(12));

String qq=null;
System.out.println(modelObject.model.size());
Service ss=null;
Class pClassName=null;
Method[] pMethods=null;
Method pMethod=null;
Parameter[] pParameters=null;
Parameter pParameter=null;
int xxx=0;








for(Map.Entry<String,Service> entry: modelObject.model.entrySet())
{
if(xxx==0)
{
Paragraph p1=new Paragraph("Service Doc");
p1.setTextAlignment(TextAlignment.CENTER);
document.add(p1);

p1=new Paragraph("List Of classes analysed for the given Path :----");
document .add(p1);

for(Class c5:classList) 
{
p1=new Paragraph(c5.getName()).setFont(font).setFontSize(8);
document.add(p1);

}





p1=new Paragraph("                    Table Regarding Class,Methods with respect to their executables paths         ");
p1.setTextAlignment(TextAlignment.CENTER);
document.add(p1);

table.addHeaderCell(new Cell().add(new Paragraph("Name(Names)")));
table.addHeaderCell(new Cell().add(new Paragraph("value")).setFont(font).setFontSize(12));
}
xxx++;




ss=entry.getValue();
pClassName=ss.getServiceClass();

cellPara=new Paragraph("Path").setFont(font).setFontSize(10);
cell=new Cell();
cell.add(cellPara);
cell.setBorder(Border.NO_BORDER);
table.addCell(cell);


cellPara=new Paragraph(entry.getKey()).setFont(font).setFontSize(10);
cell=new Cell();
cell.add(cellPara);
cell.setBorder(Border.NO_BORDER);
table.addCell(cell);

xxx++;


cellPara=new Paragraph("Class-Name").setFont(font).setFontSize(10);
cell=new Cell();
cell.add(cellPara);
cell.setBorder(Border.NO_BORDER);
table.addCell(cell);

qq="";
qq=ss.getServiceClass().getName()+"\n";
if(ss.getServiceClass().getAnnotation(injectSessionScope.class)!=null) qq+="  @injectSessionScope:YES\n";
else qq+="  @injectSessionScope:No\n";
if(ss.getServiceClass().getAnnotation(injectApplicationScope.class)!=null) qq+="  @injectApplicationScope:YES\n";
else qq+="  @injectApplicationScope:No\n";
if(ss.getServiceClass().getAnnotation(injectRequestScope.class)!=null) qq+="  @injectRequestScope:YES\n";
qq+="  @injectRequestScope:No\n";

cellPara=new Paragraph(qq).setFont(font).setFontSize(10);
cell=new Cell();
cell.add(cellPara);
cell.setBorder(Border.NO_BORDER);
table.addCell(cell);
xxx++;

pMethod=ss.getService();

cellPara=new Paragraph("Method-Name").setFont(font).setFontSize(10);
cell=new Cell();
cell.add(cellPara);
cell.setBorder(Border.NO_BORDER);
table.addCell(cell);

cellPara=new Paragraph(pMethod.getName()).setFont(font).setFontSize(10);
cell=new Cell();
cell.add(cellPara);
cell.setBorder(Border.NO_BORDER);
table.addCell(cell);
xxx++;



cellPara=new Paragraph("Parameters :").setFont(font).setFontSize(10);
cell=new Cell();
cell.add(cellPara);
cell.setBorder(Border.NO_BORDER);
table.addCell(cell);


qq="";
pParameters=pMethod.getParameters();

if(pParameters.length==0) qq="None";
for(Parameter pp1:pParameters) 
{
qq+=pp1.getType();
if(pp1.getAnnotation(RequestParameter.class)!=null) qq+="   RequestParameter:YES\n";
else qq+="     RequestParameter:NO\n";
}

cellPara=new Paragraph(qq).setFont(font).setFontSize(10);
cell=new Cell();
cell.add(cellPara);
cell.setBorder(Border.NO_BORDER);
table.addCell(cell);

xxx++;



cellPara=new Paragraph("Return-Type").setFont(font).setFontSize(10);
cell=new Cell();
cell.add(cellPara);
cell.setBorder(Border.NO_BORDER);
table.addCell(cell);

qq="";
qq=pMethod.getReturnType().toString();
cellPara=new Paragraph(qq).setFont(font).setFontSize(10);
cell=new Cell();
cell.add(cellPara);
cell.setBorder(Border.NO_BORDER);
table.addCell(cell);
xxx++;






cellPara=new Paragraph("----------------------------------------").setFont(font).setFontSize(10);
cell=new Cell();
cell.add(cellPara);
cell.setBorder(Border.NO_BORDER);
table.addCell(cell);
cellPara=new Paragraph("----------------------------------------").setFont(font).setFontSize(10);
cell=new Cell();
cell.add(cellPara);
cell.setBorder(Border.NO_BORDER);
table.addCell(cell);

xxx++;

/*if(xxx>=30) 
{
document.add(table);
document.add(new AreaBreak(AreaBreakType.NEXT_PAGE));
table=new Table(UnitValue.createPercentArray(columnWidths));
table.setWidth(UnitValue.createPercentValue(100));
table.addHeaderCell(new Cell().add(new Paragraph("Name(Names)")));
table.addHeaderCell(new Cell().add(new Paragraph("value")).setFont(font).setFontSize(12));

xxx=-1;
}*/

}

document.add(table);

System.out.println("*2");
//context.setAttribute("model",modelObject.model);
//context.setAttribute("classList",classList);
System.out.println(modelObject.model.size()+"    2");

Collections.sort(priorityQueue);
System.out.println(priorityQueue);

document.close();
System.out.println("Document closed");

}catch(Exception e)
{
System.out.println(e);
}


System.out.println("--------------------------------hello world------------------------------");

}






}