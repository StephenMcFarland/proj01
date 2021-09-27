

document.addEventListener('DOMContentLoaded', async()=>{
	

	const reimsResp = await fetch('http://localhost:8080/ReimbursementSystem/getEmp');
	const reims = await reimsResp.json();
	console.log(reims);

	//document.getElementById("keys").innerHTML = `<div class='reimbursement'><span class='reimId'>id</span><span class='owner'> Owner</span><span class='resolver'> Resolver</span><span class='reimAmount'> Amount</span><span class='status'> Status</span><span class='owner'>Count: ${reims.length}</span></div>`;

	//document.getElementById("keys").innerHTML = `<div class='reimbursement'><span class='reimId'>id</span>
	//<span class='owner'> Owner</span><span class='resolver'> Resolver</span><span class='reimAmount'> Amount</span>
	//<span class='status'> Status</span></div>`;
	
	var Container = document.getElementById("emps");
	reims.forEach(reim =>{
		var tr = document.createElement("tr");
		tr.classList.add('reimbursement');
		tr.innerHTML = `<td class='reimId'>${reim.userId}</td><td class='owner'> ${reim.empName} </td>
		<td class='resolver'>  ${reim.empPhone} </td><td class='empAddress'>${reim.empAddress}</td> 
			<td class='empEmail'>${reim.email}</td> 
		<td><form method='get' action='delete'><input type='submit' value='Delete Employee'>
		<input style='visibility: hidden;' name='id' value='${reim.userId}'/></td>`;
		Container.appendChild(tr);
})
	})
	