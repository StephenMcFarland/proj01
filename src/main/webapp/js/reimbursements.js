document.addEventListener('DOMContentLoaded', async()=>{
	const reimsResp = await fetch('http://localhost:8080/ReimbursementSystem/getReims');
	const reims = await reimsResp.json();
	console.log(reims);
	document.getElementById("keys").innerHTML = `<div class='reimbursement'><span class='reimId'>id</span><span class='owner'> Owner</span><span class='resolver'> Resolver</span><span class='reimAmount'> Amount</span><span class='status'> Status</span></div>`;
	var Container = document.getElementById("reims");
	reims.forEach(reim =>{
		var div = document.createElement("div");
		div.classList.add('reimbursement');
		Container.appendChild(div);
})
	})
	