function validateForm() {
  let firstname = document.forms["myForm"]["fname"].value;
  if (firstname == "" || firstname <= 15) {
    alert("first name must be filled out");
    return false;
  }
   let lastname = document.forms["myForm"]["lname"].value;
  if (lastname == "" || lastname <= 15) {
    alert("last name must be filled out");
    return false;
  }
   let email = document.forms["myForm"]["email"].value;
  if (email == ""|| email.indexOf("@")<1){
    alert("please enter a valid email");
    return false;
  }

   let mobile = document.forms["myForm"]["mobile"].value;
  if (mobile == "" || mobile.length !=10) {
    alert("mobile number must be equals to 10 numbers");
    return false;
  }
     let address= document.forms["myForm"]["address"].value;
	if(address== " "){
		alert("please enter your full address.");
		return false;
	}
      let department = document.forms["myForm"]["sector"].value;
	if(department== " "){
		alert("pleas enter your department");
		return false;
	}
      let designation = document.forms["myForm"]["role"].value;
	if(designation== " "){
		alert("please enter your  designation");
		return false;
	}
      let manager = document.forms["myForm"]["manager"].value;
	if(manager== " "){
		alert("please enter your manager name");
		return false;
	}
      let location = document.forms["myForm"]["location"].value;
	if(location== " "){
		alert("please enter your location");
		return false;
	}
}
