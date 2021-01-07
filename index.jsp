<!DOCTYPE html>
<html lang="en">
<head>
<title>Java String indexOf() Method</title>
<meta charset="utf-8">
<script src='jquery/jquery.js'></script>

<script>
$(()=>{
$("#b1").click(function(){
var jsonString=JSON.stringify({"name":"Amit Sharma","code":123});
$.ajax({
        type: "POST",
        url: "/webrock/schoolService/Test1/getEmp",
        data: {jsonObject:jsonString,className:"bobby.bobby1.emp"},
        success: function(result) {
            window.console.log('Successful');
        }
    });


});


});
</script>

</head>
<body style='background:grey'>

<button type='button' id='b1'>POST Request to Test1 class</button>
</form>


<h6 style="font-size:40pt;position:absolute;left:600px">Index.jsp</h6>



</body>
</html>