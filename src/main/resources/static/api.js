function createNode(element) {
    return document.createElement(element); // Create the type of element you pass in the parameters
}

function append(parent, el) {
    return parent.appendChild(el); // Append the second parameter(element) to the first one
}

function init(){
fetch('/getconnectioninfo')
    .then(response => response.text())
    .then(text => document.getElementById('connectioninfo').innerHTML = text);

}

const niol = document.getElementById('notinvoicedorlist');
const aut = document.getElementById('allusertables');
const acot = document.getElementById('allcolumsoftable');
const uqr = document.getElementById('userqueryresult');
const ur = document.getElementById('updatedrows');
const ic = document.getElementById('iscorrection');
const cr = document.getElementById('usercountqueryresult');


function getnotinvoicedor(){

niol.innerHTML = '';

    var ppe = document.getElementById("ppe").value;
    var data0 = document.getElementById("data0").value;
    var data1 = document.getElementById("data1").value;
    var iscorrectionchecked = ic.value;
    var link = "/getnotinvoicedor?name=" + ppe  + "&data0=" + data0 + "&data1=" + data1;

fetch(link)
    .then((resp) => resp.json()) // Transform the data into json
    .then(function (data) {
        let rates = data; // Get the results
        return rates.map(function (rate) { // Map through the results and for each run the code below
            let li = createNode('li'), //  Create the elements we need
            span = createNode('span');
            li.innerHTML = rate; // Make the HTML of our span to be the first and last name of our author
            append(li, span);
            append(niol, li);
        })
    });
}

function markorinvoiced(){

    var ppe = document.getElementById("ppe").value;
    var data0 = document.getElementById("data0").value;
    var data1 = document.getElementById("data1").value;
    var link = "/marknotinvoicedor?name=" + ppe  + "&data0=" + data0 + "&data1=" + data1;
    if (ic.checked){
    console.log("marked");
        link = link + "&iscorrection=true"
    } else {
        link = link + "&iscorrection=false"
    }
fetch(link)
  .then(response => response.json())
  .then(data => document.getElementById('markedorcount').innerHTML = data);


}
function getallusertables(){
fetch("/getallusertables")
    .then((resp) => resp.json()) // Transform the data into json
    .then(function (data) {
        let rates = data; // Get the results
        return rates.map(function (rate) { // Map through the results and for each run the code below
             let li = createNode('option'), //  Create the elements we need
             span = createNode('span');
             li.value = `${rate}`;
             li.innerHTML = `${rate}`; // Make the HTML of our span to be the first and last name of our author
             append(li, span);
             append(aut, li);
        })
    });
}

function getalltablecolums(){
var tablename = document.getElementById("allusertables").value;
var linktablecolums = "/getalltablecolums?tablename=" + tablename;

acot.innerHTML = '';
fetch(linktablecolums)
    .then((resp) => resp.json()) // Transform the data into json
    .then(function (data) {
        let rates = data; // Get the results
        return rates.map(function (rate) { // Map through the results and for each run the code below
             let li = createNode('option'), //  Create the elements we need
             span = createNode('span');
             li.value = `${rate}`;
             li.innerHTML = `${rate}`; // Make the HTML of our span to be the first and last name of our author
             append(li, span);
             append(acot, li);
        })
    });

}

function getdatafromuserselect(){
var tablename = document.getElementById("allusertables").value;
var columnname = document.getElementById("allcolumsoftable").value;
var columnvalue = document.getElementById("columnvalue").value;
var querylink = "/userqueryresult?tablename=" + tablename + "&columnname=" + columnname + "&columnvalue=" + columnvalue;

//var query = "SELECT * FROM " + tablename + " WHERE " + columnname + " LIKE '%" + columnvalue + "%'";
//console.log(query);
document.getElementById("userquery").innerHTML = "SELECT * FROM " + tablename + " WHERE " + columnname + " LIKE '%" + columnvalue + "%'";

uqr.innerHTML = '';
fetch(querylink)
    .then((resp) => resp.json()) // Transform the data into json
    .then(function (data) {
        let rates = data; // Get the results
        return rates.map(function (rate) { // Map through the results and for each run the code below
            let li = createNode('li'), //  Create the elements we need
            span = createNode('span');
            li.innerHTML = rate; // Make the HTML of our span to be the first and last name of our author
            append(li, span);
            append(uqr, li);
        })
    });

}
function updatedatafromuserselect(){
var tablename = document.getElementById("allusertables").value;
var columnname = document.getElementById("allcolumsoftable").value;
var oldcolumnvalue = document.getElementById("columnvalue").value;
var newcolumnvalue = document.getElementById("newcolumnvalue").value;
var updatequerylink = "/updateuserqueryresult?tablename=" + tablename + "&columnname=" + columnname + "&oldcolumnvalue="
 + oldcolumnvalue + "&newcolumnvalue=" + newcolumnvalue;

ur.innerHTML = '';
fetch(updatequerylink)
      .then(response => response.text())
      .then(data => ur.innerHTML = data);

}

function getcounteddatafromuserselect(){
var tablename = document.getElementById("allusertables").value;
var columnname = document.getElementById("allcolumsoftable").value;
var columnvalue = document.getElementById("columnvalue").value;
var querylink = "/getcounteddatafromuserselect?tablename=" + tablename + "&columnname=" + columnname + "&columnvalue=" + columnvalue;

//var query = "SELECT * FROM " + tablename + " WHERE " + columnname + " LIKE '%" + columnvalue + "%'";
//console.log(query);
//document.getElementById("userquery").innerHTML = "SELECT * FROM " + tablename + " WHERE " + columnname + " LIKE '%" + columnvalue + "%'";

fetch(querylink)
    .then(response => response.text())
    .then(text => cr.innerHTML = text);

}

