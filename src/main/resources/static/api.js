function createNode(element) {
    return document.createElement(element); // Create the type of element you pass in the parameters
}

function append(parent, el) {
    return parent.appendChild(el); // Append the second parameter(element) to the first one
}


function getolxpriceaverage(){
const ol = document.getElementById('olxlink').value;
const opdr = document.getElementById('olxpricedetailsresult');
const opdr2 = document.getElementById('olxpricedetailsresult2');
    console.log(ol);
    var querylink = '/getolxpricedetails?olxlink=' + ol;
    console.log(querylink);

fetch(querylink)
    .then(response => response.text())
    .then(text => opdr.innerHTML = text);

//fetch(querylink)
//    .then((resp) => resp.json()) // Transform the data into json
//    .then(function (data) {
//        let rates = data; // Get the results
//        return rates.map(function (rate) { // Map through the results and for each run the code below
//            let li = createNode('li'), //  Create the elements we need
//            span = createNode('span');
//            li.innerHTML = rate; // Make the HTML of our span to be the first and last name of our author
//            append(li, span);
//            append(opdr2, li);
//        })
//    });

}
