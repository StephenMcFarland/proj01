document.addEventListener('DOMContentLoaded', async()=>{
	const reimsResp = await fetch('http://localhost:8080/ReimbursementSystem/getReims');
	const reims = await reimsResp.json();
	console.log(reims);
	document.getElementById("keys").innerHTML = `<div class='reimbursement'><span class='reimId'>id</span><span class='owner'> Owner</span><span class='resolver'> Resolver</span><span class='reimAmount'> Amount</span><span class='status'> Status</span><span>Reimbursements: ${reims.length}</span></div>`;
	var Container = document.getElementById("reims");
	reims.forEach(reim =>{
		var div = document.createElement("div");
		div.classList.add('reimbursement');
		div.innerHTML = `<span class='reimId'>${reim.reimId}</span><span class='owner'> ${reim.reimOwner} </span><span class='resolver'>  ${reim.reimResolver} </span><span class='reimAmount'>$${reim.reimAmount}</span> <span class='status'> ${reim.reimStatus}</span>	
		<form method='get' action='updateReim'>
<select name='status' id='status'>
  <option value='pending'>pending</option>
  <option value='approved'>approved</option>
  <option value='denied'>denied</option>
  <option value='resolved'>resolved</option>
</select>
		<input type='submit' value='Update Reimbursement'>
		<input name='id' value='${reim.reimId}' style='visibility:hidden;'/>
	</form>`;
		Container.appendChild(div);
})
	})
	