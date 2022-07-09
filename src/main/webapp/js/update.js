document.addEventListener('DOMContentLoaded', async()=>{
	const reimsResp = await fetch('http://localhost:8080/ReimbursementSystem/getEmpUp');
	
	const reims = await reimsResp.json();
	console.log(reims);
	
	document.getElementById("fieldnames").innerHTML = ``;//<div class='reimbursement'><span class='reimId'>id</span><span class='owner'> Name</span><span class='reimAmount'> Phone</span><span class='status'> Address</span><span class='status'> Email</span></div>`;
	var Container = document.getElementById("empdetails");
	reims.forEach(emp =>{
		var div = document.createElement("div");
		div.classList.add('reimbursement');
		div.innerHTML = `	<form method="get" action="update">
		${emp.userId} <input name="id" value="${emp.userId}" style="visibility:hidden;"/> <br/> 
		Name: <input name="empName" size='30' value="${emp.empName}"/> <br/> 
		Phone: <input name="empPhone" size='15' value="${emp.empPhone}"/> <br/> 
		Address: <input name="empAddress" size='35' value="${emp.empAddress}"/> <br/> 
		Email: ${emp.email} <br/> 
		
		<input type="submit" value="Update">
	</form>`;
		Container.appendChild(div);
		//if( $('#div').is(':empty') ) {
			if( $.trim( $('#div').html() ).length ) {
		document.getElementById("sandbox").innerHTML = `${reims}${reimsResp} Must register in order to change employee details`;
	}
})
	})
	