<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<meta charset="utf-8">

    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Result</title>
    <link rel="stylesheet" type="text/css" href="bootstrap.min.css">
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<script type="text/javascript" src="jquery-3.2.1.js"></script>

</head>
<body>

<script src="bootstrap.js"></script>
	<script src="jquery-3.2.1.js"></script>

<div class="container">
  
  <br />
    <div class="row">
        <div class='col-sm-3'>
            <div class="form-group">
                <div class='input-group date' id='datetimepicker1'>
                    <input type='text' class="form-control" />
                    <span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span>
                    </span><div class="row">
    Date formats: yyyy-mm-dd, yyyymmdd, dd-mm-yyyy, dd/mm/yyyy, ddmmyyyyy
  </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript">
 $(function () {
   var bindDatePicker = function() {
		$(".date").datetimepicker({
        format:'YYYY-MM-DD',
			icons: {
				time: "fa fa-clock-o",
				date: "fa fa-calendar",
				up: "fa fa-arrow-up",
				down: "fa fa-arrow-down"
			}
		}).find('input:first').on("blur",function () {
			// check if the date is correct. We can accept dd-mm-yyyy and yyyy-mm-dd.
			// update the format if it's yyyy-mm-dd
			var date = parseDate($(this).val());

			if (! isValidDate(date)) {
				//create date based on momentjs (we have that)
				date = moment().format('YYYY-MM-DD');
			}

			$(this).val(date);
		});
	}
   
   var isValidDate = function(value, format) {
		format = format || false;
		// lets parse the date to the best of our knowledge
		if (format) {
			value = parseDate(value);
		}

		var timestamp = Date.parse(value);

		return isNaN(timestamp) == false;
   }
   
   var parseDate = function(value) {
		var m = value.match(/^(\d{1,2})(\/|-)?(\d{1,2})(\/|-)?(\d{4})$/);
		if (m)
			value = m[5] + '-' + ("00" + m[3]).slice(-2) + '-' + ("00" + m[1]).slice(-2);

		return value;
   }
   
   bindDatePicker();
 });
</script>
</body>
</html>


