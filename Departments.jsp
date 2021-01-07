<doctype html>
<html lang='en'>
<head>
<meta charset='utf-8'>
<title>jquery examples</title>
<script src='jquery/jquery.js'></script>
<script src='Department.js'></script>
<style>
#departmentTable
{
border:1px solid Black;
}
#departmentTable th
{
border:1px solid Black;
}
#departmentTable td
{
border:1px solid Black;
}
</style>

<script>
$(()=>{

let dep=new DepartmentService();
var prm=dep.getDepartments();
prm.then(function(result){

$("#departmentTable td").remove();
var data=JSON.parse(result);
alert(data);
var x=0;
while(x<data.length)
{
$("#departmentTable tbody").append("<tr><td>"+(x+1)+"</td><td>"+data[x].name+"</td><td>"+data[x].code+"</td></tr>");
x++;
}
},
function(error)
{
alert(error);
}
);


});//anonymous









</script>

</head>
<body>
<a href='index.html'>home</a>
<table id='departmentTable'>
<thead>
<tr>
<th>Sr.No</th>
<th>Name Of Department</th>
<th>Department Code</th>
</tr>
</thead>
<tbody>
</tbody>

</table>



</body>
</html>