function createNode(element) {
    return document.createElement(element); // Create the type of element you pass in the parameters
}

function append(parent, el) {
    return parent.appendChild(el); // Append the second parameter(element) to the first one
}


function validateurl(url) {
    var reg = new RegExp(/^(http:\/\/www\.|https:\/\/www\.|http:\/\/|https:\/\/)?[a-z0-9]+([\-\.]{1}[a-z0-9]+)*\.[a-z]{2,5}(:[0-9]{1,5})?(\/.*)?$/);
    if (!reg.test(url))
        return true;
    else
        return false;
}
function validateemail(email) {
    var reg = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;
    if(!reg.test(email))
        return false;
    else
        return true;
}

function getolxpriceaverage(){
const ol = document.getElementById('olxlink').value;
const opdr = document.getElementById('olxpricedetailsresult');
const opdr2 = document.getElementById('olxpricedetailsresult2');

if (validateurl(ol)){

    var querylink = '/getolxpricedetails?olxlink=' + ol;
    console.log(querylink);

fetch(querylink)
    .then(response => response.text())
    .then(text => opdr.innerHTML = text);

} else {
console.log('blad');
document.getElementById('olxlink').value.innerHTML = 'Please put right olx link';
}

}

