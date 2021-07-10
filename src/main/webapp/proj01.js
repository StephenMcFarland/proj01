class Pastry {
  constructor(id, name, price) {
    this._id = id;
    this._price = price;
    this._name = name;
  }

  get id() {
    return this._id;
  }

  set id(id) {
    this._id = id;
  }

  get price() {
    return this._price;
  }

  set price(price) {
    this._price = price;
  }

  get name() {
    return this._name;
  }

  set name(name) {
    this._name = name;
  }
}

class Donut extends Pastry {
  constructor(name, price, doughType, specialty) {
    // you have to call super() in the child class constructor
    super(name, price);
    this._doughType = doughType;
    this._specialty = specialty;
  }

  toJSON() {
    return {
      id: this._id,
      name: this._name,
      price: this._price,
      doughType: this._doughType,
      specialty: this._specialty,
    };
  }
}

const glazedDonut = new Donut('glaze', 0.99, 'donut', false);
// console.log(glazedDonut);

let donutSelection = [];
// console.log(donutSelection);

// donutSelection.forEach((d) => console.log(d));
// const newSelection = donutSelection.filter((d) => d._name !== 'glaze');
// console.log(newSelection);

// // function addDonut(d) {
// //   donutSelection.push(d);
// // }
// // const addDonut = function (d) {
// //   donutSelection.push(d);
// // };
// const addDonut = (d) => donutSelection.push(d);

// addDonut(new Donut('maple-bacon', 2.0, 'donut', true));
// console.log(donutSelection);

const appRoot = document.querySelector('#app');
const donutContainer = appRoot.querySelector('#employee-container');
const saveButton = document.querySelector('#save-donut');

saveButton.addEventListener('click', () => {
  const donutName = document.querySelector('#donut-name').value;
  if (donutName) {
    const newDonut = new Donut(0, donutName, 0, '', false);
    fetch('http://localhost:3000/donuts', {
      method: 'Post',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(newDonut),
    })
      .then((resp) => resp.json())
      .then((donut) => {
        donutSelection.push(donut);
        renderDonutList();
        document.querySelector('#donut-name').value = '';
      });
  }
});

const newDonutElement = (donut) => {
  // create the root donut element
  const donutRoot = document.createElement('div');
  const donutNameP = document.createElement('p');
  donutRoot.classList.add('donut');
  donutRoot.setAttribute('data-id', donut.id);
  donutNameP.innerText = donut.name;
  donutNameP.classList.add('donut-name');

  // append name element to the root element
  donutRoot.append(donutNameP);
  return donutRoot;
};

const renderDonutList = () => {
  donutContainer.innerHTML = '';
  donutSelection.forEach((d) => {
    const donutRoot = newDonutElement(d);
    // append the root element to the donut container
    donutContainer.append(donutRoot);

    // add delete functionality
    donutRoot.addEventListener('click', (e) => {
      const id = parseInt(e.target.getAttribute('data-id'));
      fetch(`http://localhost:3000/donuts/${id}`, {
        method: 'Delete',
      }).then((resp) => {
        if (resp.status === 200) {
          donutSelection = donutSelection.filter((d) => d.id !== id);
          renderDonutList();
        } else if (resp.status >= 400 && resp.status <= 599) {
          alert('Something broke');
        }
      });
    });
  });
};

document.addEventListener('DOMContentLoaded', () => {
  fetch('http://localhost:8080/Proj01/getEmp')
    .then((resp) => resp.json())
    .then((donuts) => {
      donutSelection = donuts;
      renderDonutList();
    });
});
