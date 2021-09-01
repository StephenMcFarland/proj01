document.addEventListener('DOMContentLoaded', async()=>{
	const reimsResp = await fetch('http://localhost:8080/ReimbursementSystem/getEmpUp');
	const reims = await reimsResp.json();
	console.log(reims);
	document.getElementById("fieldnames").innerHTML = `<div class='reimbursement'><span class='reimId'>id</span><span class='owner'> Name</span><span class='reimAmount'> Phone</span><span class='status'> Address</span><span class='status'> Email</span></div>`;
	var Container = document.getElementById("empdetails");
	reims.forEach(emp =>{
		var div = document.createElement("div");
		div.classList.add('reimbursement');
		div.innerHTML = `<span class='reimId'>${emp.userId}</span><span class='resolver'>  ${emp.empName} </span><span class=''>${emp.empPhone}</span> <span class=''> ${emp.empAddress}</span><span class=''> ${emp.email}</span>`;
		Container.appendChild(div);
})
	})
	