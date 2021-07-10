/**
 * 
 */
window.alert('hello world');
const reimbursement = (reims,root)=>{
root.innerHTML='';
reims.forEach(reim =>{
const r =document.createElement('li');
r.classList.add('list-item');
r.setAttribute('data-id',reim.id);
r.innerText=`${reim.description}---${riem.amount}`;
root.appendChild(r);
})
}

const noContent = (message, root) =>{
root.innerHTML = '';
const element = document.createElement('p');
p.classList.add('error','no-content');
p.innerHTML = message;
root.appendChild(p);
}
//
document.addEventListener('DOMContentLoaded', async()=>{
const listRoot = document.querySelector('#reimbursements');
const reimsResp = await fetch('http://localhost:8080/Proj01/getReims');
const reims = await reimsResp.json();
console.log(reims);
if(reims.length){
reimbursementsList(reims,listRoot);
}else{
	noContent('Employee has not submitted any reimbursements yet', listRoot);
	}
	})