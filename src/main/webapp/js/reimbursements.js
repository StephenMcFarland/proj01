document.addEventListener('DOMContentLoaded', async()=>{
	const reimsResp = await fetch('http://localhost:8080/ReimbursementSystem/getReims');
	const reims = await reimsResp.json();
	console.log(reims);

	//document.getElementById("keys").innerHTML = `<div class='reimbursement'><span class='reimId'>id</span><span class='owner'> Owner</span><span class='resolver'> Resolver</span><span class='reimAmount'> Amount</span><span class='status'> Status</span><span class='owner'>Count: ${reims.length}</span></div>`;

	//document.getElementById("keys").innerHTML = `<div class='reimbursement'><span class='reimId'>id</span>
	//<span class='owner'> Owner</span><span class='resolver'> Resolver</span><span class='reimAmount'> Amount</span>
	//<span class='status'> Status</span></div>`;

	var Container = document.getElementById("reims");
	reims.forEach(reim =>{
		var tr = document.createElement("tr");
		tr.classList.add('reimbursement');
		tr.innerHTML = `<td class='reimId'>${reim.reimId}</td><td class='owner'> ${reim.reimOwner} </td>
		<td class='resolver'>  ${reim.reimResolver} </td><td class='reimAmount'>$${reim.reimAmount}</td> 
		<td data-status='${reim.reimStatus}' class='status'></td>	
		<td><form method='get' action='updateReim'>
<select name='status' id='status'>
  <option value='pending'>pending</option>
  <option value='approved'>approved</option>
  <option value='denied'>denied</option>
  <option value='resolved'>resolved</option>
</select>
		<input type='submit' value='Update Reimbursement'>
		<input name='id' value='${reim.reimId}' style='visibility:hidden;'/>
	</form></td>`;
		Container.appendChild(tr);
})
	})
	