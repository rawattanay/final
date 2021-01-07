<doctype html>
<html lang='en'>
<head>
<meta charset='utf-8'>
<title>jquery examples</title>
<script src='jquery/jquery.js'></script>

<script src='getJsFile?name=abcd.js'></script>

<style>
#result
{
position:absolute;
top:150px;
left:170px;
}
#div_1
{
position:absolute;
width:500px;
height:400px;
top:100px;
left:500px;
margin-left:20px;
border:2px solid black;
border-radius:4px 4px 20px;
}

#div_1 input
{
position:absolute;
top:180px;
left:150px;
}
#div_1 button
{
position:absolute;
top:220px;
left:170px;
font-weight:bold;
font-family:verdana;
}
#div_1 h1
{
position:absolute;
top:40px;
left:120px;
}

</style>


<script>
$(()=>{

$("#addButton").click(function(){
let department=new Department();
department.setName($("#name").val());
let dep=new DepartmentService();
var prm=dep.addDepartment(department)
prm.then(function(result){
$("#result").text(result).css("color","green");
},function(error){
$("#result").text(error).css("color","red");
});//prm.then
alert("3");
});





});//anonymous

</script>
</head>
<body>
<a href='index.html'>Home</a>

<div id='div_1'>
<h1>Add Department</h1>
<span id='result'></span>
<input type='text' id='name'><br>
<button type='buttton' id='addButton'> add Department</button>


</div>


</body>
</html>