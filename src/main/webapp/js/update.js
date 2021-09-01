document.addEventListener('DOMContentLoaded', async()=>{
	const reimsResp = await fetch('http://localhost:8080/ReimbursementSystem/getEmpUp');
	const reims = await reimsResp.json();
	console.log(reims);
	document.getElementById("fieldnames").innerHTML = `<div>test</div>`;//<div class='reimbursement'><span class='reimId'>id</span><span class='owner'> Owner</span><span class='resolver'> Resolver</span><span class='reimAmount'> Amount</span><span class='status'> Status</span></div>`;
	var Container = document.getElementById("empdetails");
	reims.forEach(emp =>{
		var div = document.createElement("div");
		div.classList.add('reimbursement');
		div.innerHTML = `<span class='reimId'>${emp.userId}</span><span class='resolver'>  ${emp.empName} </span><span class=''>${emp.empPhone}</span> <span class=''> ${emp.empAddress}</span><span class=''> ${emp.email}</span>`;
		Container.appendChild(div);
})
	})
	