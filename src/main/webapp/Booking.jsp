<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="bootstrap.min.css">
<script src="bootstrap.min.js"></script>
<script src="jquery.min.js"></script>

<title>baby registration</title>
<style type="text/css">
h1 {
	background-color: floralwhite;
}
</style>
<script>
	var val1 = $("#sel1").val();
	if (val1 == '' || val1 == 0) {
		$(document).ready(function() {
			$('#sel1').val("---select---");
		});
	}
</script>
</head>

<body>
	<form action="BookingController" method="post" name="rform">
		<center>
			<h1>Vaccination Management System</h1>
		</center>
		<div class="container">
			<input type="hidden" name="babyId" value="${babyId}">
			<h2>Booking Doctor Appointment</h2>

			<div class="col-xs-4">
				<div>
					<label>Hospital Name<span style="color: red">*</span></label><br>
					<div class="form-group">
						<select class="form-control" name="hospitalName" id="sel1"
							value="Don Bosco Baby Care Hospital">
							<option value="Don Bosco Baby Care Hospital">Don Bosco
								Baby Care Hospital</option>
						</select>
					</div>
				</div>
				<div>
					<label>Doctor Name<span style="color: red">*</span></label><br>
					<div class="form-group">
						<select class="form-control" name="doctorName" id="sel1"
							value="${details.gender}">
							<option value="" hidden>---select---</option>
							<option value="Dr. Kumaran">Dr.Kumaran</option>
							<option value="Dr.Indumathi">Dr.Indumathi</option>
						</select>
					</div>
				</div>
				<label>Appointment Date<span style="color: red">*</span></label><br>
				<input id="date" class="form-control" type="date" path="date"
					class="date" name="date" pattern="dd-MM-yyyy" /> 
				<br> <label>Vaccination Type<span style="color: red">*</span></label>
				<div class="form-group">
					<select class="form-control" name="vaccinationType" id="sel2">
						<option value="" hidden>---select---</option>
						<option value="BCG, Hep B1, OPV">BCG, Hep B1, OPV</option>
						<option value="DTwP /DTaP1, Hib-1, IPV-1, Hep B2, PCV 1,Rota-1">DTwP /DTaP1, Hib-1, IPV-1, Hep B2, PCV 1,Rota-1</option>
						<option value="DTwP /DTaP2, Hib-2, IPV-2, Hep B3, PCV 2, Rota-2">DTwP /DTaP2, Hib-2, IPV-2, Hep B3, PCV 2, Rota-2</option>
						<option value="DTwP /DTaP3, Hib-3, IPV-3, Hep B4, PCV 3, Rota-3*">DTwP /DTaP3, Hib-3, IPV-3, Hep B4, PCV 3, Rota-3*</option>
						<option value="Influenza-1">Influenza-1</option>
						<option value="Influenza -2">Influenza -2</option>
						<option value="Typhoid Conjugate Vaccine">Typhoid Conjugate Vaccine</option>
						<option value="MMR 1 (Mumps, measles, Rubella)">MMR 1 (Mumps, measles, Rubella)</option>
						<option value="Hepatitis A- 1">Hepatitis A- 1</option>
						<option value="PCV Booster">PCV Booster</option>
						<option value="MMR 2, Varicella">MMR 2, Varicella</option>
						<option value="DTwP /DTaP, Hib, IPV">DTwP /DTaP, Hib, IPV</option>
						<option value="Hepatitis A- 2**, Varicella 2">Hepatitis A- 2**, Varicella 2</option>
						<option value="DTwP /DTaP, IPV, MMR 3">DTwP /DTaP, IPV, MMR 3</option>
						<option value="HPV (2 doses)">HPV (2 doses)</option>
						<option value="Tdap/ Td">Tdap/ Td</option>
						<option value="Annual Influenza Vaccine">Annual Influenza Vaccine</option>
					</select>
				</div>

				<div class="col-xs-5">
					<input class="btn btn-info" type="submit" name="submit"
						value="Book An Appointment"></input>
				</div>
				<button class="btn btn-info" type="reset"
					style="position: relative; left: 40px">Reset</button>
				<button class="btn btn-info" style="position: relative; left: 50px"
					type="submit" value="Cancel" name="submit">Cancel</button>
			</div>
		</div>
		</div>
	</form>
</body>
</html>