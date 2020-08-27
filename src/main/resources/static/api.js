function createNode(element) {
    return document.createElement(element); // Create the type of element you pass in the parameters
}

function append(parent, el) {
    return parent.appendChild(el); // Append the second parameter(element) to the first one
}


function getolxpriceaverage(){
const ol = document.getElementById('olxlink').value;
const oar = document.getElementById('olxpricedetailsresult');
    console.log(ol);
    var querylink = '/getolxpricedetails?olxlink=' + ol;
    console.log(querylink);

fetch(querylink)
      .then(response => response.text())
      .then(data => oar.innerHTML = data);

}
